package language;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class Worker extends SExpressionsBaseVisitor<String> {

    //  local_vars stores the variable's name with its position in the function's parameter list,
    // starting from 1 to n
    private Map<String, Integer> local_vars = new HashMap<>();
    int labelNum = 0;
    StringBuilder output = new StringBuilder();

    public Worker(SExpressionsParser.ProgContext prog) {
        visitProg(prog);
    }

    public String getOutput() {
        output.append("\nlw                  a0, 4(sp)");
        output.append("\nFinalExit()");
        return """
                       .macro PushImm($number)
                       	li                  t1, $number
                       	sw                  t1, (sp)
                        addi        sp, sp, -4
                       .end_macro
                       
                       .macro PushAbs($offset)
                        lw                  t1, $offset(fp)
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
                                       
                       .macro CompEq()
                        lw                  t1, 4(sp)
                       	addi        sp, sp, 4
                       	lw                  t2, 4(sp)
                       	addi        sp, sp, 4
                       	beq                 t1, t2, true
                       	false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                       
                       .macro CompLt()
                        lw                  t1, 4(sp)
                       	addi        sp, sp, 4
                       	lw                  t2, 4(sp)
                       	addi        sp, sp, 4
                       	blt                 t1, t2, true
                       	false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                       
                       .macro CompGt()
                        lw                  t1, 4(sp)
                       	addi        sp, sp, 4
                       	lw                  t2, 4(sp)
                       	addi        sp, sp, 4
                       	bgt                 t1, t2, true
                       	false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                       
                       .macro CompLe()
                        lw                  t1, 4(sp)
                       	addi        sp, sp, 4
                       	lw                  t2, 4(sp)
                       	addi        sp, sp, 4
                       	ble                 t1, t2, true
                       	false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                       
                       .macro CompGe()
                        lw                  t1, 4(sp)
                       	addi        sp, sp, 4
                       	lw                  t2, 4(sp)
                       	addi        sp, sp, 4
                       	bge                 t1, t2, true
                       	false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
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
                                              
                       .macro BoolAnd()
                        Plus()
                        lw                  t1, 4(sp)
                        addi        sp, sp, 4
                        li                  t2, 2
                        beq                 t1, t2, true
                        false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                              
                       .macro BoolOr()
                        Plus()
                        lw                  t1, 4(sp)
                        addi        sp, sp, 4
                        bne                 t1, x0, true
                        false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                              
                       .macro BoolXor()
                        Plus()
                        lw                  t1, 4(sp)
                        addi        sp, sp, 4
                        li                  t2, 1
                        beq                 t1, t2, true
                        false:
                       	    False()
                       	    b                   exit
                       	true:
                       	    True()
                       	exit:
                       .end_macro
                                       
                       .macro FinalExit()
                           li                  a7, 10
                           ecall
                       .end_macro
                       """ + output;
    }

    public String newLabel() {
        labelNum++;
        return "label" + labelNum;
    }

    @Override
    public String visitProg(SExpressionsParser.ProgContext ctx) {
        output.append("\n.text\n");
        for (int i = 0; i < ctx.decs.size(); i++) {
            visitDec(ctx.dec(i));
        }
        return null;
    }

    @Override
    public String visitDec(SExpressionsParser.DecContext ctx) {
        int numOfParams = ctx.params.size();
        int arSize = (2 + numOfParams) * 4;
        System.out.println(arSize);
        local_vars = new HashMap<>();
        for (int i = 1; i < numOfParams + 1; i++) {
            local_vars.put(ctx.params.get(i - 1).identifier().Idfr().getText(), i);
        }
        String id = ctx.identifier().Idfr().getText();
        output.append("\n").append(id).append("Enter:");
        output.append("\nmv                  fp, sp");
        output.append("\nsw                  ra, 0(sp)");
        output.append("\naddi        sp, sp, -4");
        visit(ctx.block());
        output.append("\nlw                  ra, ").append(arSize).append("(sp)");
        output.append("\naddi        sp, sp, ").append(arSize);
        output.append("\nlw                  fp, 0(sp)");
        output.append("\njr                  ra");
        return null;
    }

    @Override
    public String visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx) {
        String offset = String.valueOf(4 * local_vars.get(ctx.identifier().Idfr().getText()));
        output.append("\nlw                  a0, ").append(offset).append("(fp)");
        return null;
    }

    @Override
    public String visitType(SExpressionsParser.TypeContext ctx) {
        return null;
    }

    @Override
    public String visitBlock(SExpressionsParser.BlockContext ctx) {
        for (int i = 0; i < ctx.expr().size(); i++) {
            visit(ctx.expr(i));
        }
        return null;
    }

    @Override
    public String visitIfExpr(SExpressionsParser.IfExprContext ctx) {
        visit(ctx.expr());
        String thenBlock = newLabel();
        String elseBlock = newLabel();
        String exit = newLabel();
        output.append("\nli                  t2, 1");
        output.append("\nbeq                 t1, t2, ").append(thenBlock);
        output.append("\n").append(elseBlock).append(":");
        visit(ctx.block(1));
        output.append("\nb                   ").append(thenBlock);
        output.append("\n").append(thenBlock).append(":");
        visit(ctx.block(0));
        output.append("\n").append(exit).append(":");
        return null;
    }

    @Override
    public String visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {
            case SExpressionsParser.Eq -> output.append("\nCompEq()");
            case SExpressionsParser.Less -> output.append("\nCompLt()");
            case SExpressionsParser.Gtr -> output.append("\nCompGt()");
            case SExpressionsParser.LessEq -> output.append("\nCompLe()");
            case SExpressionsParser.GtrEq -> output.append("\nCompGe()");
            case SExpressionsParser.Plus -> output.append("\nPlus()");
            case SExpressionsParser.Minus -> output.append("\nMinus()");
            case SExpressionsParser.Times -> output.append("\nTimes()");
            case SExpressionsParser.Div -> output.append("\nDivide()");
            case SExpressionsParser.And -> output.append("\nBoolAnd()");
            case SExpressionsParser.Or -> output.append("\nBoolOr()");
            case SExpressionsParser.Xor -> output.append("\nBoolXor()");
        }
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
        String offset = String.valueOf(4 * local_vars.get(ctx.identifier().Idfr().getText()));
        visit(ctx.expr());
        output.append("\nsw                  a0, ").append(offset).append("(fp)");
        return null;
    }

    @Override
    public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        output.append("\nsw                  fp, 0(sp)");
        output.append("\naddi        sp, sp, -4");
        for (int i = ctx.block().expr().size() - 1; i >= 0; i--) {
            visit(ctx.block().expr(i));
            output.append("\nsw                  t1, 0(sp)");
            output.append("\naddi        sp, sp, -4");
        }
        output.append("\njal                 ").append(ctx.identifier().Idfr().getText()).append("Enter");
        return null;
    }

    @Override
    public String visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public String visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        String name = ctx.identifier().Idfr().getText();
        String offset = String.valueOf(4 * local_vars.get(name) + 4);
        output.append("\nPushAbs    ").append(offset);
        return null;
    }

    @Override
    public String visitIntExpr(SExpressionsParser.IntExprContext ctx) {
        output.append("\nPushImm    ").append(ctx.integer().IntLit().getText());
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
