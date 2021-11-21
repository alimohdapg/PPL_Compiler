package launguage;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types> {

    private final Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private final Map<String, Types> local_vars = new HashMap<>();
    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog) {
        visit(prog);    // Discards the dummy return value.
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
            if (!global_funcs.containsKey(id.Idfr().getText())) {
                global_funcs.put(id.Idfr().getText(), dec);
            } else {
                throw new TypeException().duplicatedFuncError(ctx, id, Types.toType(type));
            }
            if (id.Idfr().getText().equals("main")) {
                if (Types.toType(type) != Types.INT) {
                    throw new TypeException().mainFuncError(ctx, dec, Types.toType(type));
                } else if (dec.params.size() != 0) {
                    throw new TypeException().mainFuncError(dec, dec.typed_idfr(0), Types.toType(dec.typed_idfr(0).type()));
                }
                found_main = true;
            }
            visitDec(dec);
        }
        if (!found_main) {
            throw new TypeException().noMainFuncError();
        }
        return Types.UNKNOWN;   // This is just a dummy return value.
    }

    @Override
    public Types visitDec(SExpressionsParser.DecContext ctx) {
        for (int i = 0; i < ctx.params.size(); i++) {
            SExpressionsParser.Typed_idfrContext currentParam = ctx.params.get(i);
            String name = currentParam.identifier().getText();
            Types type = Types.toType(currentParam.type());
            if (!local_vars.containsKey(name)) {
                if (type == Types.UNIT) {
                    throw new TypeException().unitVarError(ctx, currentParam.identifier(), type);
                } else {
                    local_vars.put(name, type);
                }
            } else {
                throw new TypeException().duplicatedVarError(ctx, currentParam.identifier(), type);
            }
        }
        current_dec = ctx;
        SExpressionsParser.BlockContext decBlock = ctx.block();
        decBlock.t = visit(decBlock);
        if (decBlock.t != Types.toType(ctx.type())) {
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
        for (int i = 0; i < ctx.exprs.size(); i++) {
            if (i == ctx.exprs.size() - 1) {
                return visit(ctx.expr(i));
            }
            visit(ctx.expr(i));
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
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
        if (thenBlock.t != elseBlock.t) {
            SExpressionsParser.ExprContext lastThenBlockExpr = thenBlock.expr(thenBlock.exprs.size() - 1);
            SExpressionsParser.ExprContext lastElseBlockExpr = elseBlock.expr(elseBlock.exprs.size() - 1);
            throw new TypeException().branchMismatchError(ctx, lastThenBlockExpr, thenBlock.t, lastElseBlockExpr, elseBlock.t);
        }
        return thenBlock.t;
    }

    @Override
    public Types visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        operand1.t = visit(operand1);
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        operand2.t = visit(operand2);
        return switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {
            case SExpressionsParser.Eq, SExpressionsParser.LessEq, SExpressionsParser.GtrEq, SExpressionsParser.Gtr, SExpressionsParser.Less -> {
                if (operand1.t == Types.INT && operand2.t == Types.INT) {
                    yield Types.BOOL;
                } else {
                    throw new TypeException().comparisonError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
            }
            case SExpressionsParser.Plus, SExpressionsParser.Minus, SExpressionsParser.Times, SExpressionsParser.Div -> {
                if (operand1.t == Types.INT && operand2.t == Types.INT) {
                    yield Types.INT;
                } else {
                    throw new TypeException().arithmeticError(ctx, operand1, operand1.t, operand2, operand2.t);
                }
            }
            case SExpressionsParser.And, SExpressionsParser.Or, SExpressionsParser.Xor -> {
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
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
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
        if (conditionExpr.t != Types.BOOL) {
            throw new TypeException().conditionError(ctx, conditionExpr, conditionExpr.t);
        }
        if (repeatBlock.t != Types.UNIT) {
            SExpressionsParser.ExprContext lastRepeatBlockExpr = repeatBlock.expr(repeatBlock.exprs.size() - 1);
            throw new TypeException().loopBodyError(ctx, lastRepeatBlockExpr, repeatBlock.t);
        }
        return Types.UNIT;
    }

    @Override
    public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx) {
        SExpressionsParser.ExprContext asgmtExprExpr = ctx.expr();
        asgmtExprExpr.t = visit(asgmtExprExpr);
        if (local_vars.get(ctx.identifier().getText()) != asgmtExprExpr.t) {
            throw new TypeException().assignmentError(ctx, ctx.identifier(), local_vars.get(ctx.identifier().getText()), asgmtExprExpr, asgmtExprExpr.t);
        }
        return Types.UNIT;
    }

    @Override
    public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        SExpressionsParser.IdentifierContext id = ctx.identifier();
        SExpressionsParser.BlockContext block = ctx.block();
        if (!global_funcs.containsKey(id.Idfr().getText())) {
            throw new TypeException().undeclaredFuncError(current_dec, id, Types.UNKNOWN);
        }
        List<SExpressionsParser.Typed_idfrContext> funcParamList = global_funcs.get(id.Idfr().getText()).params;
        if (block.expr().size() != funcParamList.size()) {
            throw new TypeException().argumentNumberError(ctx, block, Types.UNKNOWN);
        }
        for (int i = 0; i < global_funcs.get(id.Idfr().getText()).params.size(); i++) {
            block.expr(i).t = visit(block.expr(i));
            if (block.expr(i).t != Types.toType(funcParamList.get(i).type())) {
                throw new TypeException().argumentError(ctx, block.expr(i), block.expr(i).t);
            }
        }
        visitBlock(ctx.block());
        return Types.toType(global_funcs.get(id.Idfr().getText()).type());
    }

    @Override
    public Types visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        return visitBlock(ctx.block());
    }

    @Override
    public Types visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        String name = ctx.identifier().getText();
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
