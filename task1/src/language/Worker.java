package language;

import java.util.ArrayList;

public class Worker extends LanguageBaseVisitor<Object> {

    private static final ArrayList<Object> parsedString = new ArrayList<>();

    public String getValue() {
        return parsedString.toString();
    }

    @Override
    public Object visitDecOnly(LanguageParser.DecOnlyContext ctx) {
        visit(ctx.dec());
        return null;
    }

    @Override
    public Object visitDecProg(LanguageParser.DecProgContext ctx) {
        visitDec(ctx.dec());
        visit(ctx.prog());
        return null;
    }

    @Override
    public Object visitDec(LanguageParser.DecContext ctx) {
        ArrayList<Object> decList = new ArrayList<>();
        decList.add("FuncDecl");
        decList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        decList.add(visit(ctx.type()));
        decList.add(visit(ctx.vardec()));
        decList.add(visitBlock(ctx.block()));
        parsedString.add(decList);
        return null;
    }

    @Override
    public Object visitNoParam(LanguageParser.NoParamContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public Object visitYesParam(LanguageParser.YesParamContext ctx) {
        ArrayList<Object> yesParamList = new ArrayList<>();
        yesParamList.add(visit(ctx.vardecne()));
        return yesParamList;
    }

    @Override
    public Object visitParam(LanguageParser.ParamContext ctx) {
        ArrayList<Object> paramList = new ArrayList<>();
        paramList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        paramList.add(visit(ctx.type()));
        return paramList;
    }

    @Override
    public Object visitAnotherParam(LanguageParser.AnotherParamContext ctx) {
        ArrayList<Object> anotherParamList = new ArrayList<>();
        anotherParamList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        anotherParamList.add(visit(ctx.type()));
        return visit(ctx.vardecne()) + "," + anotherParamList;
    }

    @Override
    public Object visitBlock(LanguageParser.BlockContext ctx) {
        ArrayList<Object> blockList = new ArrayList<>();
        blockList.add(visit(ctx.ene()));
        return blockList;
    }

    @Override
    public Object visitOneExp(LanguageParser.OneExpContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Object visitAnotherExp(LanguageParser.AnotherExpContext ctx) {
        ArrayList<Object> anotherExpList = new ArrayList<>();
        anotherExpList.add(visit(ctx.exp()));
        anotherExpList.add(visit(ctx.ene()));
        return anotherExpList;
    }

    @Override
    public Object visitIdentifier(LanguageParser.IdentifierContext ctx) {
        return "Idfr(\"" + ctx.Idfr().getText() + "\")";
    }

    @Override
    public Object visitIntLiteral(LanguageParser.IntLiteralContext ctx) {
        return "IntLit(" + ctx.IntLit().getText() + ")";
    }

    @Override
    public Object visitAssign(LanguageParser.AssignContext ctx) {
        ArrayList<Object> assignList = new ArrayList<>();
        assignList.add("Asgmt");
        assignList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        assignList.add(visit(ctx.exp()));
        return assignList;
    }

    @Override
    public Object visitAddMinTimDiv(LanguageParser.AddMinTimDivContext ctx) {
        ArrayList<Object> addMinTimDivList = new ArrayList<>();
        addMinTimDivList.add("BinOpExpr");
        addMinTimDivList.add(visit(ctx.binop()));
        addMinTimDivList.add(visit(ctx.exp(0)));
        addMinTimDivList.add(visit(ctx.exp(1)));
        return addMinTimDivList;
    }

    @Override
    public Object visitFuncCall(LanguageParser.FuncCallContext ctx) {
        ArrayList<Object> funcCallList = new ArrayList<>();
        funcCallList.add("FunInvoc");
        funcCallList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        ArrayList<Object> argsList = new ArrayList<>();
        argsList.add(visit(ctx.args()));
        funcCallList.add(argsList);
        return funcCallList;
    }

    @Override
    public Object visitAnotherBlock(LanguageParser.AnotherBlockContext ctx) {
        return visitBlock(ctx.block());
    }

    @Override
    public Object visitIfElse(LanguageParser.IfElseContext ctx) {
        ArrayList<Object> ifElseList = new ArrayList<>();
        ifElseList.add("IfStmt");
        ifElseList.add(visit(ctx.exp()));
        if (ctx.getChildCount() > 2) {
            ifElseList.add(visitBlock(ctx.block(0)));
            ifElseList.add(visitBlock(ctx.block(1)));
        } else {
            ifElseList.add(ctx.block(0));
        }
        return ifElseList;
    }

    @Override
    public Object visitWhileLoop(LanguageParser.WhileLoopContext ctx) {
        ArrayList<Object> whileLoopList = new ArrayList<>();
        whileLoopList.add("WhileLoop");
        whileLoopList.add(visit(ctx.exp()));
        whileLoopList.add(visitBlock(ctx.block()));
        return whileLoopList;
    }

    @Override
    public Object visitRepeatLoop(LanguageParser.RepeatLooopContext ctx) {
        ArrayList<Object> repeatLoopList = new ArrayList<>();
        repeatLoopList.add("RepeatLoop");
        repeatLoopList.add(visit(ctx.exp()));
        repeatLoopList.add(visitBlock(ctx.block()));
        return repeatLoopList;
    }

    @Override
    public Object visitSkip(LanguageParser.SkipContext ctx) {
        return null;
    }

    @Override
    public Object visitNoArg(LanguageParser.NoArgContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public Object visitYesArg(LanguageParser.YesArgContext ctx) {
        return visit(ctx.argsne());
    }

    @Override
    public Object visitArgAnotherExp(LanguageParser.ArgAnotherExpContext ctx) {
        return visit(ctx.argsne()) + ", " + visit(ctx.exp());
    }

    @Override
    public Object visitExpArg(LanguageParser.ExpArgContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Object visitBinop(LanguageParser.BinopContext ctx) {
        return switch (ctx.getText()) {
            case "==" -> "Eq";
            case "<" -> "Less";
            case ">" -> "Gtr";
            case "<=" -> "LessEq";
            case ">=" -> "GtrEq";
            case "+" -> "Plus";
            case "-" -> "Minus";
            case "*" -> "Times";
            case "/" -> "Div";
            case "&&" -> "And";
            case "||" -> "Or";
            case "^^" -> "Xor";
            default -> null;
        };
    }

    @Override
    public Object visitType(LanguageParser.TypeContext ctx) {
        return switch (ctx.getText()) {
            case "int" -> "IntType";
            case "bool" -> "BoolType";
            case "unit" -> "UnitType";
            default -> null;
        };
    }
}



