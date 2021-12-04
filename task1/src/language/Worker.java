package language;

import java.util.ArrayList;

public class Worker extends LanguageBaseVisitor<Object> {

    // the main and outermost arraylist
    private static final ArrayList<Object> parsedString = new ArrayList<>();

    // returns the string version of the parsedString arraylist
    public String getValue() {
        return parsedString.toString();
    }

    @Override
    public Object visitWholeprog(LanguageParser.WholeprogContext ctx) {
        visit(ctx.prog());
        return null;
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
        // decList represents the second layer of arraylists following parsedString
        ArrayList<Object> decList = new ArrayList<>();
        decList.add("FunDecl");
        decList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        decList.add(visit(ctx.type()));
        decList.add(visit(ctx.vardec()));
        decList.add(visitBlock(ctx.block()));
        // add decList to the parsedString arraylist
        parsedString.add(decList);
        return null;
    }

    @Override
    public Object visitNoParam(LanguageParser.NoParamContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public Object visitYesParam(LanguageParser.YesParamContext ctx) {
        // yesParamList is the outer arraylist for the inner pair arraylists
        ArrayList<Object> yesParamList = new ArrayList<>();
        yesParamList.add(visit(ctx.vardecne()));
        return yesParamList;
    }

    @Override
    public Object visitParam(LanguageParser.ParamContext ctx) {
        // paramList is a pair-like arraylist with the parameter's name and its type
        ArrayList<Object> paramList = new ArrayList<>();
        paramList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        paramList.add(visit(ctx.type()));
        return paramList;
    }

    @Override
    public Object visitAnotherParam(LanguageParser.AnotherParamContext ctx) {
        // anotherParamList is a pair-like arraylist with the parameter's name and its type
        ArrayList<Object> anotherParamList = new ArrayList<>();
        anotherParamList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        anotherParamList.add(visit(ctx.type()));
        // go through the other parameters recursively and join their arraylists with a comma
        return visit(ctx.vardecne()) + "," + anotherParamList;
    }

    @Override
    public Object visitBlock(LanguageParser.BlockContext ctx) {
        // blockList is an arraylist containing the expressions in the given block
        ArrayList<Object> blockList =  new ArrayList<>();
        blockList.add(visit(ctx.ene()));
        return blockList;
    }

    @Override
    public Object visitOneExp(LanguageParser.OneExpContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Object visitAnotherExp(LanguageParser.AnotherExpContext ctx) {
        return visit(ctx.exp()) + ", " + visit(ctx.ene());
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
        // assignList is an arraylist for assignment expressions
        ArrayList<Object> assignList = new ArrayList<>();
        assignList.add("Asgmt");
        assignList.add("Idfr(\"" + ctx.Idfr().getText() + "\")");
        assignList.add(visit(ctx.exp()));
        return assignList;
    }

    @Override
    public Object visitAddMinTimDiv(LanguageParser.AddMinTimDivContext ctx) {
        // addMinTimDivList is an arraylist for binary operator expressions
        ArrayList<Object> addMinTimDivList = new ArrayList<>();
        addMinTimDivList.add("BinOpExpr");
        addMinTimDivList.add(visit(ctx.binop()));
        addMinTimDivList.add(visit(ctx.exp(0)));
        addMinTimDivList.add(visit(ctx.exp(1)));
        return addMinTimDivList;
    }

    @Override
    public Object visitFuncCall(LanguageParser.FuncCallContext ctx) {
        // funcCallList is an arraylist for function invocations
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
        // ifElseList is an arraylist for if statements, with the "IfStmt" identifier, an expression,
        // the then body, and the else body
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
        // whileLoopList is an arraylist for while-loops, with the "WhileLoop" identifier, an expression,
        // and the while-loop's body
        ArrayList<Object> whileLoopList = new ArrayList<>();
        whileLoopList.add("WhileLoop");
        whileLoopList.add(visit(ctx.exp()));
        whileLoopList.add(visitBlock(ctx.block()));
        return whileLoopList;
    }

    @Override
    public Object visitRepeatLoop(LanguageParser.RepeatLoopContext ctx) {
        // repeatLoopList is an arraylist for repeat-loops, with the "RepeatLoop" identifier, an expression,
        // and the repeat-loop's body
        ArrayList<Object> repeatLoopList = new ArrayList<>();
        repeatLoopList.add("RepeatLoop");
        repeatLoopList.add(visit(ctx.exp()));
        repeatLoopList.add(visitBlock(ctx.block()));
        return repeatLoopList;
    }

    @Override
    public Object visitSkip(LanguageParser.SkipContext ctx) {
        return "Skip";
    }

    @Override
    public Object visitNoArg(LanguageParser.NoArgContext ctx) {
        return "";
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
        // returns a word version of the operator
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
        // returns different labels for the types in the program
        return switch (ctx.getText()) {
            case "int" -> "IntType";
            case "bool" -> "BoolType";
            case "unit" -> "UnitType";
            default -> null;
        };
    }
}



