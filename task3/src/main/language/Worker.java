package language;

import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class Worker extends SExpressionsBaseVisitor<String> {

    //  local_vars stores the variable's name with its position in the function's parameter list, starting from 1 to n
    private Map<String, Integer> local_vars = new HashMap<>();
    int labelNum = 0;
    StringBuilder output = new StringBuilder();

    // constructs a worker instance and starts the ParseTree's traversal with visit(prog)
    public Worker(SExpressionsParser.ProgContext prog) {
        visitProg(prog);
    }

    // generates a new label each time it gets called
    public String newLabel() {
        labelNum++;
        return "label" + labelNum;
    }

    // returns a string with the predefined macros and the program's risc-v assembly code
    public String getOutput() {
        return """
                       .macro CompEq()
                        lw                  t1, 4(sp)
                        addi         sp, sp, 4
                        mv                  t3, t2
                        beq                 t1, a0, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                       
                       .macro CompLt()
                        lw                  t1, 4(sp)
                        addi         sp, sp, 4
                        mv                  t3, t2
                        blt                 t1, a0, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                       
                       .macro CompGt()
                        lw                  t1, 4(sp)
                        addi         sp, sp, 4
                        mv                  t3, t2
                        bgt                 t1, a0, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                       
                       .macro CompLe()
                        lw                  t1, 4(sp)
                        addi         sp, sp, 4
                        mv                  t3, t2
                        ble                 t1, a0, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                       
                       .macro CompGe()
                        lw                  t1, 4(sp)
                        addi         sp, sp, 4
                        mv                  t3, t2
                        bge                 t1, a0, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                   	
                       .macro Plus()
                        lw                  t1, 4(sp)
                        add                 a0, t1, a0
                        addi         sp, sp, 4
                       .end_macro
                                       
                       .macro Minus()
                        lw                  t1, 4(sp)
                        sub                 a0, t1, a0
                        addi         sp, sp, 4
                       .end_macro
                                   	
                       .macro Times()
                        lw                  t1, 4(sp)
                        mul                 a0, t1, a0
                        addi         sp, sp, 4
                       .end_macro
                                   	
                       .macro Divide()
                        lw                  t1, 4(sp)
                        div                 a0, t1, a0
                        addi         sp, sp, 4
                       .end_macro
                                              
                       .macro BoolAnd()
                        addi         sp, sp, 4
                        li                  t1, 1
                        bne                 t2, t1, false
                        bne                 t3, t1, false
                        b                   true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                              
                       .macro BoolOr()
                        addi         sp, sp, 4
                        li                  t1, 1
                        beq                 t2, t1, true
                        beq                 t3, t1, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                              
                       .macro BoolXor()
                        addi         sp, sp, 4
                        bne                 t2, t3, true
                        false:
                            li                  t2, 0
                            b                   exit
                        true:
                            li                  t2, 1
                        exit:
                       .end_macro
                                       
                       .macro FinalExit()
                        li                  a7, 10
                        ecall
                       .end_macro
                       """ + output;
    }

    @Override
    public String visitProg(SExpressionsParser.ProgContext ctx) {
        // adds the .text directive to signal that the following instructions will be stored in a Text segment at the
        // next available address
        output.append("\n\n.text\n");
        // visits each function declaration
        for (int i = 0; i < ctx.decs.size(); i++) {
            visitDec(ctx.dec(i));
        }
        return null;
    }

    @Override
    public String visitDec(SExpressionsParser.DecContext ctx) {
        int numOfParams = ctx.params.size();
        // size of activation record calculated through 4 * (num of parameters + 2)
        // the extra 2 is added to account for the frame pointer and return address
        int arSize = (2 + numOfParams) * 4;
        // refreshes the local_vars hashmap for each function
        local_vars = new HashMap<>();
        // stores the place of each parameter in the function's parameter list into the local_vars hashmap
        for (int i = 1; i < numOfParams + 1; i++) {
            local_vars.put(ctx.params.get(i - 1).identifier().Idfr().getText(), i);
        }
        String id = ctx.identifier().Idfr().getText();
        output.append("\n").append(id).append("Enter:");
        output.append("\n\tmv                  fp, sp");
        output.append("\n\tsw                  ra, 0(sp)");
        output.append("\n\taddi        sp, sp, -4");
        visit(ctx.block());
        // when the execution of the main function is done, the program is exited
        // otherwise, the function returns to where it was called from through the ra (return address) register
        if(id.equals("main")){
            output.append("\n\tFinalExit()");
        } else {
            output.append("\n\tlw                  ra, ").append("4").append("(sp)");
            // restores the stack pointer's location by using the activation record's size
            output.append("\n\taddi        sp, sp, ").append(arSize);
            output.append("\n\tlw                  fp, 0(sp)");
            output.append("\n\tjr                  ra");
        }
        return null;
    }

    @Override
    public String visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx) {
        // the parameter's location in an activation record is calculated by getting its offset from the frame
        // pointer, the offset is calculated through (4 * the stored position of the parameter in local_vars)
        String offset = String.valueOf(4 * local_vars.get(ctx.identifier().Idfr().getText()));
        output.append("\n\tlw                  a0, ").append(offset).append("(fp)");
        return null;
    }

    @Override
    public String visitType(SExpressionsParser.TypeContext ctx) {
        return null;
    }

    @Override
    public String visitBlock(SExpressionsParser.BlockContext ctx) {
        // visits each expression in the block
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
        // if the evaluated expression doesn't return 0 (representing false), branch to the then block
        // otherwise, the else block is evaluated
        output.append("\n\tbne                 t2, x0, ").append(thenBlock);
        output.append("\n").append(elseBlock).append(":");
        visit(ctx.block(1));
        // skip the else block and exit the if else statement/expression
        output.append("\n\tb                   ").append(exit);
        output.append("\n").append(thenBlock).append(":");
        visit(ctx.block(0));
        output.append("\n").append(exit).append(":");
        return null;
    }

    @Override
    public String visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        visit(ctx.expr(0));
        // store the lhs of the expression in the effective memory addresses at sp (the stack pointer)
        output.append("\n\tsw                  a0, 0(sp)");
        output.append("\n\taddi        sp, sp, -4");
        visit(ctx.expr(1));
        // chose the appropriate macro to use depending on the expression's operator
        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {
            case SExpressionsParser.Eq -> output.append("\n\tCompEq()");
            case SExpressionsParser.Less -> output.append("\n\tCompLt()");
            case SExpressionsParser.Gtr -> output.append("\n\tCompGt()");
            case SExpressionsParser.LessEq -> output.append("\n\tCompLe()");
            case SExpressionsParser.GtrEq -> output.append("\n\tCompGe()");
            case SExpressionsParser.Plus -> output.append("\n\tPlus()");
            case SExpressionsParser.Minus -> output.append("\n\tMinus()");
            case SExpressionsParser.Times -> output.append("\n\tTimes()");
            case SExpressionsParser.Div -> output.append("\n\tDivide()");
            case SExpressionsParser.And -> output.append("\n\tBoolAnd()");
            case SExpressionsParser.Or -> output.append("\n\tBoolOr()");
            case SExpressionsParser.Xor -> output.append("\n\tBoolXor()");
        }
        return null;
    }

    @Override
    public String visitWhileExpr(SExpressionsParser.WhileExprContext ctx) {
        String loop = newLabel();
        String exit = newLabel();
        output.append("\n").append(loop).append(":");
        visit(ctx.expr());
        // exit the while loop if the expression evaluates to 0 (false), done before the body's execution
        output.append("\n\tbeq                 t2, x0, ").append(exit);
        visit(ctx.block());
        output.append("\n\tb                   ").append(loop);
        output.append("\n").append(exit).append(":");
        return null;
    }

    @Override
    public String visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx) {
        String loop = newLabel();
        String exit = newLabel();
        output.append("\n").append(loop).append(":");
        visit(ctx.block());
        visit(ctx.expr());
        // exit the repeat loop if the expression evaluates to 1 (true), done after the body's execution
        output.append("\n\tbne                 t2, x0, ").append(exit);
        output.append("\n\tb                   ").append(loop);
        output.append("\n").append(exit).append(":");
        return null;
    }

    @Override
    public String visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx) {
        // assign the expression's value to the parameter stored at the specified offset
        String offset = String.valueOf(4 * local_vars.get(ctx.identifier().Idfr().getText()));
        visit(ctx.expr());
        output.append("\n\tsw                  a0, ").append(offset).append("(fp)");
        return null;
    }

    @Override
    public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        // start the activation record with the frame pointer
        output.append("\n\tsw                  fp, 0(sp)");
        output.append("\n\taddi        sp, sp, -4");
        // add parameters to the activation record in reverse order to make access and assignment easier
        for (int i = ctx.block().expr().size() - 1; i >= 0; i--) {
            visit(ctx.block().expr(i));
            output.append("\n\tsw                  a0, 0(sp)");
            output.append("\n\taddi        sp, sp, -4");
        }
        // jump to the function's label and store the appropriate return address in ra
        output.append("\n\tjal                 ").append(ctx.identifier().Idfr().getText()).append("Enter");
        return null;
    }

    @Override
    public String visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public String visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        // retrieve the parameters value by accessing it through its offset from the frame pointer
        String offset = String.valueOf(4 * local_vars.get(ctx.identifier().Idfr().getText()));
        output.append("\n\tlw                  a0,").append(offset).append("(fp)");
        return null;
    }

    @Override
    public String visitIntExpr(SExpressionsParser.IntExprContext ctx) {
        // load the given integer into a0
        output.append("\n\tli                  a0, ").append(ctx.integer().IntLit().getText());
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
