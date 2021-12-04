package language;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types> {

    private final Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private Map<String, Types> local_vars = new HashMap<>();
    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog) {
        // Discards the dummy return value.
        visit(prog);
        // At this point, we know for sure that there is at least a 'main' function.
        int index_main = 0;
        for (int i = 0; i < prog.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = prog.decs.get(i);
            if (dec.identifier().Idfr().getText().equals("main")) {
                index_main = i;
            }
        }
        SExpressionsParser.DecContext main = prog.decs.get(index_main);
        prog.decs.set(index_main, prog.decs.get(0));
        prog.decs.set(0, main);
        return toStrConverter.visitHighlight(prog, prog).replaceAll("\u001B\\[[;\\d]*m", "");   // Removes ANSI colours.
    }

    @Override
    public Types visitProg(SExpressionsParser.ProgContext ctx) {
        boolean found_main = false;
        for (int i = 0; i < ctx.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            SExpressionsParser.IdentifierContext id = dec.identifier();
            SExpressionsParser.TypeContext type = dec.type();
            // add the function's name to the global_funcs hashmap if it's a new entry, otherwise throw a
            // duplicatedFuncError exception
            if (!global_funcs.containsKey(id.Idfr().getText())) {
                global_funcs.put(id.Idfr().getText(), dec);
            } else {
                throw new TypeException().duplicatedFuncError(ctx, id, Types.toType(type));
            }
            if (id.Idfr().getText().equals("main")) {
                // the main function must return an int
                if (Types.toType(type) != Types.INT) {
                    throw new TypeException().mainFuncError(ctx, dec, Types.toType(type));
                // the main function must have 0 parameters
                } else if (dec.params.size() != 0) {
                    throw new TypeException().mainFuncError(dec, dec.typed_idfr(0), Types.toType(dec.typed_idfr(0).type()));
                }
                found_main = true;
            }
        }
        // visit each function declaration
        for (int i = 0; i < ctx.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            visit(dec);
        }
        // if there wasn't a function named main, an exception is thrown
        if (!found_main) {
            throw new TypeException().noMainFuncError();
        }
        return Types.UNKNOWN;   // This is just a dummy return value.
    }

    @Override
    public Types visitDec(SExpressionsParser.DecContext ctx) {
        // a new hashmap is created for each function
        local_vars = new HashMap<>();
        for (int i = 0; i < ctx.params.size(); i++) {
            SExpressionsParser.Typed_idfrContext currentParam = ctx.params.get(i);
            String name = currentParam.identifier().getText();
            Types type = Types.toType(currentParam.type());
            // add the parameter's name to the local_vars hashmap if it's a new entry, otherwise throw a
            // duplicatedVarError exception
            if (!local_vars.containsKey(name)) {
                // if the parameter is of type unit, an exception is thrown
                if (type == Types.UNIT) {
                    throw new TypeException().unitVarError(ctx, currentParam.identifier(), type);
                } else {
                    local_vars.put(name, type);
                }
            } else {
                throw new TypeException().duplicatedVarError(ctx, currentParam.identifier(), type);
            }
        }
        // store the current function in current_dec
        current_dec = ctx;
        SExpressionsParser.BlockContext decBlock = ctx.block();
        decBlock.t = visit(decBlock);
        // if the last block in the function's body isn't of the same type as the function's type an
        // exception is thrown
        if (Types.toType(current_dec.type()) != decBlock.t) {
            SExpressionsParser.ExprContext lastDecBlockExpr = decBlock.expr(decBlock.exprs.size() - 1);
            throw new TypeException().functionBodyError(ctx, lastDecBlockExpr, decBlock.t);
        }
        return Types.UNKNOWN;
    }

    @Override
    public Types visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Types visitType(SExpressionsParser.TypeContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Types visitBlock(SExpressionsParser.BlockContext ctx) {
        // visit each expression in the block, assigning the type of each expression to the expression's field t
        for (int i = 0; i < ctx.exprs.size(); i++) {
            // if this is the last expression return it as the block's type
            if (i == ctx.exprs.size() - 1) {
                ctx.exprs.get(i).t = visit(ctx.expr(i));
                return ctx.exprs.get(i).t;
            }
            ctx.exprs.get(i).t = visit(ctx.expr(i));
        }
        return Types.UNKNOWN;
    }

    @Override
    public Types visitIfExpr(SExpressionsParser.IfExprContext ctx) {
        SExpressionsParser.ExprContext conditionExpr = ctx.expr();
        conditionExpr.t = visit(conditionExpr);
        SExpressionsParser.BlockContext thenBlock = ctx.block(0);
        thenBlock.t = visit(thenBlock);
        SExpressionsParser.BlockContext elseBlock = ctx.block(1);
        elseBlock.t = visit(elseBlock);
        // if the if-statement's condition doesn't evaluate to a boolean, throw an exception
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
        // if the two blocks of the if-statement don't have the same type, throw an exception
        if (thenBlock.t != elseBlock.t) {
            SExpressionsParser.ExprContext lastThenBlockExpr = thenBlock.expr(thenBlock.exprs.size() - 1);
            SExpressionsParser.ExprContext lastElseBlockExpr = elseBlock.expr(elseBlock.exprs.size() - 1);
            throw new TypeException().branchMismatchError(ctx, lastThenBlockExpr, thenBlock.t, lastElseBlockExpr, elseBlock.t);
        }
        // both blocks (thenBlock and elseBlock) have the same type
        return elseBlock.t;
    }

    @Override
    public Types visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        operand1.t = visit(operand1);
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        operand2.t = visit(operand2);
        // a switch statement to determine if the two given expressions evaluate to the correct types
        // required by the operator in use
        return switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {
            case SExpressionsParser.Eq, SExpressionsParser.LessEq, SExpressionsParser.GtrEq, SExpressionsParser.Gtr, SExpressionsParser.Less -> {
                // expressions in a comparison expression must have type int
                if (operand1.t == Types.INT && operand2.t == Types.INT) {
                    yield Types.BOOL;
                } else {
                    throw new TypeException().comparisonError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
            }
            case SExpressionsParser.Plus, SExpressionsParser.Minus, SExpressionsParser.Times, SExpressionsParser.Div -> {
                // expressions in a numerical expression must have type int
                if (operand1.t == Types.INT && operand2.t == Types.INT) {
                    yield Types.INT;
                } else {
                    throw new TypeException().arithmeticError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
            }
            case SExpressionsParser.And, SExpressionsParser.Or, SExpressionsParser.Xor -> {
                // expressions in a boolean expression must have type bool
                if (operand1.t == Types.BOOL && operand2.t == Types.BOOL) {
                    yield Types.BOOL;
                } else {
                    throw new TypeException().logicalError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
            }
            default -> throw new RuntimeException("Shouldn't be here - wrong binary operator.");
        };
    }

    @Override
    public Types visitWhileExpr(SExpressionsParser.WhileExprContext ctx) {
        SExpressionsParser.ExprContext conditionExpr = ctx.expr();
        conditionExpr.t = visit(conditionExpr);
        SExpressionsParser.BlockContext whileBlock = ctx.block();
        whileBlock.t = visit(whileBlock);
        // throw an exception if the while-loop's condition doesn't evaluate to boolean
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
        // throw an exception if the while-loop's block doesn't evaluate to unit
        if (whileBlock.t != Types.UNIT) {
            SExpressionsParser.ExprContext lastWhileBlockExpr = whileBlock.expr(whileBlock.exprs.size() - 1);
            throw new TypeException().loopBodyError(ctx, lastWhileBlockExpr, whileBlock.t);
        }
        return Types.UNIT;
    }

    @Override
    public Types visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx) {
        SExpressionsParser.ExprContext conditionExpr = ctx.expr();
        conditionExpr.t = visit(conditionExpr);
        SExpressionsParser.BlockContext repeatBlock = ctx.block();
        repeatBlock.t = visit(repeatBlock);
        // throw an exception if the repeat-loop's block doesn't evaluate to unit
        if (repeatBlock.t != Types.UNIT) {
            SExpressionsParser.ExprContext lastRepeatBlockExpr = repeatBlock.expr(repeatBlock.exprs.size() - 1);
            throw new TypeException().loopBodyError(ctx, lastRepeatBlockExpr, repeatBlock.t);
        }
        // throw an exception if the repeat-loop's condition doesn't evaluate to boolean
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
        return Types.UNIT;
    }

    @Override
    public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx) {
        SExpressionsParser.ExprContext asgmtExprExpr = ctx.expr();
        asgmtExprExpr.t = visit(asgmtExprExpr);
        // throw an exception if the variable that should be assigned to isn't in the local_vars hashmap
        if (local_vars.get(ctx.identifier().getText()) != asgmtExprExpr.t) {
            throw new TypeException().assignmentError(ctx, ctx.identifier(), local_vars.get(ctx.identifier().getText()), asgmtExprExpr, asgmtExprExpr.t);
        }
        return Types.UNIT;
    }

    @Override
    public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        SExpressionsParser.IdentifierContext id = ctx.identifier();
        SExpressionsParser.BlockContext block = ctx.block();
        // throw an exception if the function that should be invoked isn't in the global_funcs hashmap
        if (!global_funcs.containsKey(id.Idfr().getText())) {
            throw new TypeException().undeclaredFuncError(current_dec, id, Types.UNKNOWN);
        }
        SExpressionsParser.DecContext funcDec = global_funcs.get(id.Idfr().getText());
        List<SExpressionsParser.Typed_idfrContext> funcParamList = funcDec.params;
        // throw an exception if the invocation doesn't have the same number of arguments as the number of parameters
        // of the called function
        if (block.expr().size() != funcParamList.size()) {
            throw new TypeException().argumentNumberError(ctx, block, Types.UNKNOWN);
        }
        for (int i = 0; i < funcDec.params.size(); i++) {
            block.expr(i).t = visit(block.expr(i));
            // throw an exception if the types of the passed argument and the parameter in the function's declaration
            // are different
            if (block.expr(i).t != Types.toType(funcParamList.get(i).type())) {
                throw new TypeException().argumentError(ctx, block.expr(i), block.expr(i).t);
            }
        }
        return Types.toType(funcDec.type());
    }

    @Override
    public Types visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        return visitBlock(ctx.block());
    }

    @Override
    public Types visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        String name = ctx.identifier().getText();
        // throw an exception if the variable isn't found in the local_vars hashmap
        if (!local_vars.containsKey(name)) {
            throw new TypeException().undeclaredVarError(current_dec, ctx.identifier(), ctx.t);
        }
        return local_vars.get(name);
    }

    @Override
    public Types visitIntExpr(SExpressionsParser.IntExprContext ctx) {
        return Types.INT;
    }

    @Override
    public Types visitSkipExpr(SExpressionsParser.SkipExprContext ctx) {
        return Types.UNIT;
    }

    @Override
    public Types visitIdentifier(SExpressionsParser.IdentifierContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Types visitInteger(SExpressionsParser.IntegerContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Types visitBinop(SExpressionsParser.BinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
}
