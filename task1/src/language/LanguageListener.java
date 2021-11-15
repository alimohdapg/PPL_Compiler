// Generated from C:/Users/alimo/IdeaProjects/230936_C&CA_Coursework/task1/src\Language.g4 by ANTLR 4.9.2

    package language;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code DecOnly}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterDecOnly(LanguageParser.DecOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecOnly}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitDecOnly(LanguageParser.DecOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecProg}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterDecProg(LanguageParser.DecProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecProg}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitDecProg(LanguageParser.DecProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(LanguageParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(LanguageParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterNoParam(LanguageParser.NoParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitNoParam(LanguageParser.NoParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code YesParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterYesParam(LanguageParser.YesParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code YesParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitYesParam(LanguageParser.YesParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Param}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void enterParam(LanguageParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Param}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void exitParam(LanguageParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnotherParam}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void enterAnotherParam(LanguageParser.AnotherParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnotherParam}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void exitAnotherParam(LanguageParser.AnotherParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OneExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void enterOneExp(LanguageParser.OneExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OneExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void exitOneExp(LanguageParser.OneExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnotherExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void enterAnotherExp(LanguageParser.AnotherExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnotherExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 */
	void exitAnotherExp(LanguageParser.AnotherExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(LanguageParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(LanguageParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LanguageParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddMinTimDiv}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAddMinTimDiv(LanguageParser.AddMinTimDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddMinTimDiv}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAddMinTimDiv(LanguageParser.AddMinTimDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnotherBlock}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAnotherBlock(LanguageParser.AnotherBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnotherBlock}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAnotherBlock(LanguageParser.AnotherBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(LanguageParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(LanguageParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatLooop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRepeatLooop(LanguageParser.RepeatLooopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatLooop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRepeatLooop(LanguageParser.RepeatLooopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSkip(LanguageParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSkip(LanguageParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterNoArg(LanguageParser.NoArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitNoArg(LanguageParser.NoArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code YesArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterYesArg(LanguageParser.YesArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code YesArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitYesArg(LanguageParser.YesArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgAnotherExp}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void enterArgAnotherExp(LanguageParser.ArgAnotherExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgAnotherExp}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void exitArgAnotherExp(LanguageParser.ArgAnotherExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpArg}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void enterExpArg(LanguageParser.ExpArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpArg}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 */
	void exitExpArg(LanguageParser.ExpArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(LanguageParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(LanguageParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LanguageParser.TypeContext ctx);
}