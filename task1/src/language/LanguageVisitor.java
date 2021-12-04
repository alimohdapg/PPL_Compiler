// Generated from C:/Users/alimo/IdeaProjects/230936_C&CA_Coursework/task1/src\Language.g4 by ANTLR 4.9.2

package language;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#wholeprog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWholeprog(LanguageParser.WholeprogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecOnly}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecOnly(LanguageParser.DecOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecProg}
	 * labeled alternative in {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecProg(LanguageParser.DecProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(LanguageParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoParam(LanguageParser.NoParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code YesParam}
	 * labeled alternative in {@link LanguageParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesParam(LanguageParser.YesParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Param}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(LanguageParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnotherParam}
	 * labeled alternative in {@link LanguageParser#vardecne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnotherParam(LanguageParser.AnotherParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OneExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneExp(LanguageParser.OneExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnotherExp}
	 * labeled alternative in {@link LanguageParser#ene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnotherExp(LanguageParser.AnotherExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(LanguageParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddMinTimDiv}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMinTimDiv(LanguageParser.AddMinTimDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnotherBlock}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnotherBlock(LanguageParser.AnotherBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(LanguageParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(LanguageParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatLoop(LanguageParser.RepeatLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link LanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(LanguageParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArg(LanguageParser.NoArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code YesArg}
	 * labeled alternative in {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesArg(LanguageParser.YesArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgAnotherExp}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgAnotherExp(LanguageParser.ArgAnotherExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpArg}
	 * labeled alternative in {@link LanguageParser#argsne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpArg(LanguageParser.ExpArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(LanguageParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LanguageParser.TypeContext ctx);
}