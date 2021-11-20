package launguage;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types>
{

    private Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private Map<String, Types> local_vars = new HashMap<>();

    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog)
    {
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

    @Override public Types visitProg(SExpressionsParser.ProgContext ctx)
    {

        // TODO: modify and complete this method.

        Boolean found_main = false;

        for (int i = 0; i < ctx.decs.size(); ++i) {

            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            SExpressionsParser.IdentifierContext id = dec.identifier();
            SExpressionsParser.TypeContext type = dec.type();

            if (id.Idfr().getText().equals("main")) {
                found_main = true;
            }
        }


        if (!found_main) {
            throw new TypeException().noMainFuncError();
        }

        return Types.UNKNOWN;   // This is just a dummy return value.

    }

    @Override public Types visitDec(SExpressionsParser.DecContext ctx)
    {
        // TODO: modify and complete this method.
        
        return Types.UNKNOWN;
    }

    @Override public Types visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitType(SExpressionsParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBlock(SExpressionsParser.BlockContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitIfExpr(SExpressionsParser.IfExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitBinExpr(SExpressionsParser.BinExprContext ctx)
    {

        // TODO: modify and complete this method.

        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        operand1.t = visit(operand1);

        Types t = switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case SExpressionsParser.Eq -> {

                yield Types.UNKNOWN;

            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        };

        return t;
    }

    @Override public Types visitWhileExpr(SExpressionsParser.WhileExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitBlockExpr(SExpressionsParser.BlockExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitIdExpr(SExpressionsParser.IdExprContext ctx)
    {
        // TODO: modify and complete this method.

        return Types.UNKNOWN;
    }

    @Override public Types visitIntExpr(SExpressionsParser.IntExprContext ctx)
    {
        return Types.INT;
    }

    @Override public Types visitSkipExpr(SExpressionsParser.SkipExprContext ctx)
    {
        return Types.UNIT;
    }

    @Override public Types visitIdentifier(SExpressionsParser.IdentifierContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitInteger(SExpressionsParser.IntegerContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBinop(SExpressionsParser.BinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
