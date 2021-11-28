// Generated from C:/Users/alimo/IdeaProjects/230936_C&CA_Coursework/task1/src\Language.g4 by ANTLR 4.9.2

    package language;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Skip=1, While=2, Do=3, If=4, Then=5, Else=6, Repeat=7, Until=8, IntType=9, 
		BoolType=10, UnitType=11, Idfr=12, IntLit=13, LParen=14, Comma=15, RParen=16, 
		LBrace=17, Semicolon=18, RBrace=19, Assign=20, Less=21, LessEq=22, Plus=23, 
		Minus=24, And=25, Xor=26, Eq=27, Gtr=28, GtrEq=29, Times=30, Div=31, Or=32, 
		WS=33;
	public static final int
		RULE_wholeprog = 0, RULE_prog = 1, RULE_dec = 2, RULE_vardec = 3, RULE_vardecne = 4, 
		RULE_block = 5, RULE_ene = 6, RULE_exp = 7, RULE_args = 8, RULE_argsne = 9, 
		RULE_binop = 10, RULE_type = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"wholeprog", "prog", "dec", "vardec", "vardecne", "block", "ene", "exp", 
			"args", "argsne", "binop", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'skip'", "'while'", "'do'", "'if'", "'then'", "'else'", "'repeat'", 
			"'until'", "'int'", "'bool'", "'unit'", null, null, "'('", "','", "')'", 
			"'{'", "';'", "'}'", "':='", "'<'", "'<='", "'+'", "'-'", "'&&'", "'^^'", 
			"'=='", "'>'", "'>='", "'*'", "'/'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Skip", "While", "Do", "If", "Then", "Else", "Repeat", "Until", 
			"IntType", "BoolType", "UnitType", "Idfr", "IntLit", "LParen", "Comma", 
			"RParen", "LBrace", "Semicolon", "RBrace", "Assign", "Less", "LessEq", 
			"Plus", "Minus", "And", "Xor", "Eq", "Gtr", "GtrEq", "Times", "Div", 
			"Or", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class WholeprogContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public WholeprogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wholeprog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterWholeprog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitWholeprog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitWholeprog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WholeprogContext wholeprog() throws RecognitionException {
		WholeprogContext _localctx = new WholeprogContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_wholeprog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			prog();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecProgContext extends ProgContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public DecProgContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDecProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDecProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDecProg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecOnlyContext extends ProgContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public DecOnlyContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDecOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDecOnly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDecOnly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new DecOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				dec();
				}
				break;
			case 2:
				_localctx = new DecProgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				dec();
				setState(29);
				prog();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			type();
			setState(34);
			match(Idfr);
			setState(35);
			match(LParen);
			setState(36);
			vardec();
			setState(37);
			match(RParen);
			setState(38);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecContext extends ParserRuleContext {
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
	 
		public VardecContext() { }
		public void copyFrom(VardecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class YesParamContext extends VardecContext {
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public YesParamContext(VardecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterYesParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitYesParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitYesParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoParamContext extends VardecContext {
		public NoParamContext(VardecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterNoParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitNoParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitNoParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardec);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RParen:
				_localctx = new NoParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IntType:
			case BoolType:
			case UnitType:
				_localctx = new YesParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				vardecne(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecneContext extends ParserRuleContext {
		public VardecneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecne; }
	 
		public VardecneContext() { }
		public void copyFrom(VardecneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamContext extends VardecneContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public ParamContext(VardecneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnotherParamContext extends VardecneContext {
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public AnotherParamContext(VardecneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAnotherParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAnotherParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAnotherParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecneContext vardecne() throws RecognitionException {
		return vardecne(0);
	}

	private VardecneContext vardecne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VardecneContext _localctx = new VardecneContext(_ctx, _parentState);
		VardecneContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_vardecne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ParamContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(45);
			type();
			setState(46);
			match(Idfr);
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AnotherParamContext(new VardecneContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_vardecne);
					setState(48);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(49);
					match(Comma);
					setState(50);
					type();
					setState(51);
					match(Idfr);
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(LanguageParser.LBrace, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(LanguageParser.RBrace, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LBrace);
			setState(59);
			ene();
			setState(60);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EneContext extends ParserRuleContext {
		public EneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ene; }
	 
		public EneContext() { }
		public void copyFrom(EneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnotherExpContext extends EneContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(LanguageParser.Semicolon, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public AnotherExpContext(EneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAnotherExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAnotherExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAnotherExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneExpContext extends EneContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public OneExpContext(EneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterOneExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitOneExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitOneExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EneContext ene() throws RecognitionException {
		EneContext _localctx = new EneContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ene);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new OneExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				exp();
				}
				break;
			case 2:
				_localctx = new AnotherExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				exp();
				setState(64);
				match(Semicolon);
				setState(65);
				ene();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncCallContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public FuncCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public IdentifierContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatLoopContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(LanguageParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(LanguageParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterRepeatLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitRepeatLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitRepeatLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends ExpContext {
		public TerminalNode If() { return getToken(LanguageParser.If, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Then() { return getToken(LanguageParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(LanguageParser.Else, 0); }
		public IfElseContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends ExpContext {
		public TerminalNode Skip() { return getToken(LanguageParser.Skip, 0); }
		public SkipContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends ExpContext {
		public TerminalNode IntLit() { return getToken(LanguageParser.IntLit, 0); }
		public IntLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(LanguageParser.Idfr, 0); }
		public TerminalNode Assign() { return getToken(LanguageParser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddMinTimDivContext extends ExpContext {
		public TerminalNode LParen() { return getToken(LanguageParser.LParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode RParen() { return getToken(LanguageParser.RParen, 0); }
		public AddMinTimDivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAddMinTimDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAddMinTimDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAddMinTimDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopContext extends ExpContext {
		public TerminalNode While() { return getToken(LanguageParser.While, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Do() { return getToken(LanguageParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnotherBlockContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AnotherBlockContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAnotherBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAnotherBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAnotherBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(Idfr);
				}
				break;
			case 2:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(IntLit);
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(Idfr);
				setState(72);
				match(Assign);
				setState(73);
				exp();
				}
				break;
			case 4:
				_localctx = new AddMinTimDivContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(LParen);
				setState(75);
				exp();
				setState(76);
				binop();
				setState(77);
				exp();
				setState(78);
				match(RParen);
				}
				break;
			case 5:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(Idfr);
				setState(81);
				match(LParen);
				setState(82);
				args();
				setState(83);
				match(RParen);
				}
				break;
			case 6:
				_localctx = new AnotherBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				block();
				}
				break;
			case 7:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				match(If);
				setState(87);
				exp();
				setState(88);
				match(Then);
				setState(89);
				block();
				setState(90);
				match(Else);
				setState(91);
				block();
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(While);
				setState(94);
				exp();
				setState(95);
				match(Do);
				setState(96);
				block();
				}
				break;
			case 9:
				_localctx = new RepeatLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(98);
				match(Repeat);
				setState(99);
				block();
				setState(100);
				match(Until);
				setState(101);
				exp();
				}
				break;
			case 10:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(103);
				match(Skip);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	 
		public ArgsContext() { }
		public void copyFrom(ArgsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoArgContext extends ArgsContext {
		public NoArgContext(ArgsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterNoArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitNoArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitNoArg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class YesArgContext extends ArgsContext {
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public YesArgContext(ArgsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterYesArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitYesArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitYesArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RParen:
				_localctx = new NoArgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case Skip:
			case While:
			case If:
			case Repeat:
			case Idfr:
			case IntLit:
			case LParen:
			case LBrace:
				_localctx = new YesArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				argsne(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsneContext extends ParserRuleContext {
		public ArgsneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsne; }
	 
		public ArgsneContext() { }
		public void copyFrom(ArgsneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArgAnotherExpContext extends ArgsneContext {
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(LanguageParser.Comma, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ArgAnotherExpContext(ArgsneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterArgAnotherExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitArgAnotherExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitArgAnotherExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpArgContext extends ArgsneContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpArgContext(ArgsneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExpArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExpArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExpArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsneContext argsne() throws RecognitionException {
		return argsne(0);
	}

	private ArgsneContext argsne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsneContext _localctx = new ArgsneContext(_ctx, _parentState);
		ArgsneContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_argsne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpArgContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(111);
			exp();
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgAnotherExpContext(new ArgsneContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_argsne);
					setState(113);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(114);
					match(Comma);
					setState(115);
					exp();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(LanguageParser.Eq, 0); }
		public TerminalNode Less() { return getToken(LanguageParser.Less, 0); }
		public TerminalNode Gtr() { return getToken(LanguageParser.Gtr, 0); }
		public TerminalNode LessEq() { return getToken(LanguageParser.LessEq, 0); }
		public TerminalNode GtrEq() { return getToken(LanguageParser.GtrEq, 0); }
		public TerminalNode Plus() { return getToken(LanguageParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(LanguageParser.Minus, 0); }
		public TerminalNode Times() { return getToken(LanguageParser.Times, 0); }
		public TerminalNode Div() { return getToken(LanguageParser.Div, 0); }
		public TerminalNode And() { return getToken(LanguageParser.And, 0); }
		public TerminalNode Or() { return getToken(LanguageParser.Or, 0); }
		public TerminalNode Xor() { return getToken(LanguageParser.Xor, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEq) | (1L << Plus) | (1L << Minus) | (1L << And) | (1L << Xor) | (1L << Eq) | (1L << Gtr) | (1L << GtrEq) | (1L << Times) | (1L << Div) | (1L << Or))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(LanguageParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(LanguageParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(LanguageParser.UnitType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return vardecne_sempred((VardecneContext)_localctx, predIndex);
		case 9:
			return argsne_sempred((ArgsneContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean vardecne_sempred(VardecneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argsne_sempred(ArgsneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0080\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\68\n\6\f\6\16\6;\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bF\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\tk\n\t\3\n\3\n\5\no\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13w\n\13\f"+
		"\13\16\13z\13\13\3\f\3\f\3\r\3\r\3\r\2\4\n\24\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\4\3\2\27\"\3\2\13\r\2\u0082\2\32\3\2\2\2\4!\3\2\2\2\6#\3\2"+
		"\2\2\b,\3\2\2\2\n.\3\2\2\2\f<\3\2\2\2\16E\3\2\2\2\20j\3\2\2\2\22n\3\2"+
		"\2\2\24p\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34"+
		"\3\3\2\2\2\35\"\5\6\4\2\36\37\5\6\4\2\37 \5\4\3\2 \"\3\2\2\2!\35\3\2\2"+
		"\2!\36\3\2\2\2\"\5\3\2\2\2#$\5\30\r\2$%\7\16\2\2%&\7\20\2\2&\'\5\b\5\2"+
		"\'(\7\22\2\2()\5\f\7\2)\7\3\2\2\2*-\3\2\2\2+-\5\n\6\2,*\3\2\2\2,+\3\2"+
		"\2\2-\t\3\2\2\2./\b\6\1\2/\60\5\30\r\2\60\61\7\16\2\2\619\3\2\2\2\62\63"+
		"\f\3\2\2\63\64\7\21\2\2\64\65\5\30\r\2\65\66\7\16\2\2\668\3\2\2\2\67\62"+
		"\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\13\3\2\2\2;9\3\2\2\2<=\7\23"+
		"\2\2=>\5\16\b\2>?\7\25\2\2?\r\3\2\2\2@F\5\20\t\2AB\5\20\t\2BC\7\24\2\2"+
		"CD\5\16\b\2DF\3\2\2\2E@\3\2\2\2EA\3\2\2\2F\17\3\2\2\2Gk\7\16\2\2Hk\7\17"+
		"\2\2IJ\7\16\2\2JK\7\26\2\2Kk\5\20\t\2LM\7\20\2\2MN\5\20\t\2NO\5\26\f\2"+
		"OP\5\20\t\2PQ\7\22\2\2Qk\3\2\2\2RS\7\16\2\2ST\7\20\2\2TU\5\22\n\2UV\7"+
		"\22\2\2Vk\3\2\2\2Wk\5\f\7\2XY\7\6\2\2YZ\5\20\t\2Z[\7\7\2\2[\\\5\f\7\2"+
		"\\]\7\b\2\2]^\5\f\7\2^k\3\2\2\2_`\7\4\2\2`a\5\20\t\2ab\7\5\2\2bc\5\f\7"+
		"\2ck\3\2\2\2de\7\t\2\2ef\5\f\7\2fg\7\n\2\2gh\5\20\t\2hk\3\2\2\2ik\7\3"+
		"\2\2jG\3\2\2\2jH\3\2\2\2jI\3\2\2\2jL\3\2\2\2jR\3\2\2\2jW\3\2\2\2jX\3\2"+
		"\2\2j_\3\2\2\2jd\3\2\2\2ji\3\2\2\2k\21\3\2\2\2lo\3\2\2\2mo\5\24\13\2n"+
		"l\3\2\2\2nm\3\2\2\2o\23\3\2\2\2pq\b\13\1\2qr\5\20\t\2rx\3\2\2\2st\f\3"+
		"\2\2tu\7\21\2\2uw\5\20\t\2vs\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\25"+
		"\3\2\2\2zx\3\2\2\2{|\t\2\2\2|\27\3\2\2\2}~\t\3\2\2~\31\3\2\2\2\t!,9Ej"+
		"nx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}