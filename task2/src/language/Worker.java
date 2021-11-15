package language;

import java.util.Stack;

public class Worker extends CalculatorBaseVisitor<Void> {

    private static final Stack<Integer> stack = new Stack<>();

    public Integer getValue() {

        return stack.peek();

    }

    @Override
    public Void visitMulDiv(CalculatorParser.MulDivContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        int right = stack.pop();
        int left = stack.pop();
        int result;
        if (ctx.op.getType() == CalculatorParser.MUL) {
            result = left * right;
        } else {
            result = left / right;
        }
        stack.push(result);
        return null;
    }

    @Override
    public Void visitAddSub(CalculatorParser.AddSubContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        int right = stack.pop();
        int left = stack.pop();
        int result;
        if (ctx.op.getType() == CalculatorParser.ADD) {
            result = left + right;
        } else {
            result = left - right;
        }
        stack.push(result);
        return null;
    }

    @Override
    public Void visitParens(CalculatorParser.ParensContext ctx) {
        visit(ctx.expr());
        return null;
    }

    @Override
    public Void visitInt(CalculatorParser.IntContext ctx) {
        stack.push(Integer.valueOf(ctx.INT().getText()));
        return null;
    }

}
