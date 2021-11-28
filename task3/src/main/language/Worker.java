package language;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class Worker extends SExpressionsBaseVisitor<String> {

    private final Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private final Map<String, String> local_vars = new HashMap<>();
    int labelNum = 0;
    StringBuilder output = new StringBuilder();

    public Worker(SExpressionsParser.ProgContext prog){
        visitProg(prog);
    }

    public String getOutputString() {
        output.append("\nlw                 a0, 4(sp)");
        return """
                .macro PushImm($number)
                	li                  t1, $number
                	sw                  t1, (sp)
                    addi        sp, sp, -4
                .end_macro
                
                .macro True()
                    li                  t1, 1
                    sw                  t1, (sp)
                    addi        sp, sp, -4
                .end_macro
                
                .macro False()
                    li                  t1, 0
                    sw                  t1, (sp)
                    addi        sp, sp, -4
                .end_macro
                
                .macro CompGt()
                    lw                  t1, 4(sp)
                	addi        sp, sp, 4
                	lw                  t2, 4(sp)
                	addi        sp, sp, 4
                	bgt                 t1, t2, true
                	b                   false
                	true:
                	    True()
                	false:
                	    False()
                .end_macro
                            	
                .macro Plus()
                	lw                  t1, 4(sp)
                	addi        sp, sp, 4
                	lw                  t2, 4(sp)
                	addi        sp, sp, 4
                	add                 t2, t2, t1
                	sw                  t2, (sp)
                	addi        sp, sp, -4
                .end_macro
                
                .macro Minus()
                	lw                  t1, 4(sp)
                	addi        sp, sp, 4
                	lw                  t2, 4(sp)
                	addi        sp, sp, 4
                	sub                 t2, t2, t1
                	sw                  t2, (sp)
                	addi        sp, sp, -4
                .end_macro
                            	
                .macro Times()
                	lw                  t1, 4(sp)
                	addi        sp, sp, 4
                	lw                  t2, 4(sp)
                	addi        sp, sp, 4
                	mul                 t2, t2, t1
                	sw                  t2, (sp)
                	addi        sp, sp, -4
                .end_macro
                            	
                .macro Divide()
                	lw                  t1, 4(sp)
                	addi        sp, sp, 4
                	lw                  t2, 4(sp)
                	addi        sp, sp, 4
                	div                 t2, t2, t1
                	sw                  t2, (sp)
                	addi        sp, sp, -4
                .end_macro
                
                .macro Exit()
                    li                  a7, 10
                    ecall
                .end_macro
                """ + output;
    }

    public String newLabel(){
        labelNum++;
        return "label" + labelNum;
    }

    @Override
    public String visitProg(SExpressionsParser.ProgContext ctx) {
        output.append("\n.text\n\n");
        for (int i = 0; i < ctx.decs.size(); i++) {
            visitDec(ctx.dec(i));
        }
        return null;
    }

    @Override
    public String visitDec(SExpressionsParser.DecContext ctx) {
        return null;
    }

    @Override
    public String visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx) {
        return super.visitTyped_idfr(ctx);
    }

    @Override
    public String visitType(SExpressionsParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public String visitBlock(SExpressionsParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public String visitIfExpr(SExpressionsParser.IfExprContext ctx) {
        return super.visitIfExpr(ctx);
    }

    @Override
    public String visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {
            case SExpressionsParser.Eq, SExpressionsParser.LessEq, SExpressionsParser.GtrEq, SExpressionsParser.Gtr, SExpressionsParser.Less -> {

            }
            case SExpressionsParser.Plus, SExpressionsParser.Minus, SExpressionsParser.Times, SExpressionsParser.Div -> {

            }
            case SExpressionsParser.And, SExpressionsParser.Or, SExpressionsParser.Xor -> {

            }
            default -> throw new RuntimeException("Shouldn't be here - wrong binary operator.");
        };
        return null;
    }

    @Override
    public String visitWhileExpr(SExpressionsParser.WhileExprContext ctx) {
        return super.visitWhileExpr(ctx);
    }

    @Override
    public String visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx) {
        return super.visitRepeatExpr(ctx);
    }

    @Override
    public String visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx) {
        return super.visitAsgmtExpr(ctx);
    }

    @Override
    public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        return super.visitFunInvocExpr(ctx);
    }

    @Override
    public String visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public String visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        String name = ctx.identifier().getText();
        output.append("\nPushAbs  ");
        output.append(local_vars.get(name));
        output.append("\n");
        return null;
    }

    @Override
    public String visitIntExpr(SExpressionsParser.IntExprContext ctx) {
        output.append("\nPushImm    ");
        output.append(ctx.getText());
        output.append("\n");
        return null;
    }

    @Override
    public String visitSkipExpr(SExpressionsParser.SkipExprContext ctx) {
        return null;
    }

    @Override
    public String visitIdentifier(SExpressionsParser.IdentifierContext ctx) {
        return null;
    }

    @Override
    public String visitInteger(SExpressionsParser.IntegerContext ctx) {
        return null;
    }

    @Override
    public String visitBinop(SExpressionsParser.BinopContext ctx) {
        return null;
    }
}
