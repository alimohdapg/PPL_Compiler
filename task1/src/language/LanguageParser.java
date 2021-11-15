// Generated from C:/Users/alimo/IdeaProjects/230936_C&CA_Coursework/task1/src\Language.g4 by ANTLR 4.9.2

    package language;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		RULE_prog = 0, RULE_dec = 1, RULE_vardec = 2, RULE_vardecne = 3, RULE_block = 4, 
		RULE_ene = 5, RULE_exp = 6, RULE_args = 7, RULE_argsne = 8, RULE_binop = 9, 
		RULE_type = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "vardec", "vardecne", "block", "ene", "exp", "args", "argsne", 
			"binop", "type"
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
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new DecOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				dec();
				}
				break;
			case 2:
				_localctx = new DecProgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				dec();
				setState(24);
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
		enterRule(_localctx, 2, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			type();
			setState(29);
			match(Idfr);
			setState(30);
			match(LParen);
			setState(31);
			vardec();
			setState(32);
			match(RParen);
			setState(33);
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
		enterRule(_localctx, 4, RULE_vardec);
		try {
			setState(37);
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
				setState(36);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_vardecne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ParamContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(40);
			type();
			setState(41);
			match(Idfr);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
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
					setState(43);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(44);
					match(Comma);
					setState(45);
					type();
					setState(46);
					match(Idfr);
					}
					} 
				}
				setState(52);
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
		enterRule(_localctx, 8, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LBrace);
			setState(54);
			ene();
			setState(55);
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
		enterRule(_localctx, 10, RULE_ene);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new OneExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				exp();
				}
				break;
			case 2:
				_localctx = new AnotherExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				exp();
				setState(59);
				match(Semicolon);
				setState(60);
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
	public static class RepeatLooopContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(LanguageParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(LanguageParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatLooopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterRepeatLooop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitRepeatLooop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitRepeatLoop(this);
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
		enterRule(_localctx, 12, RULE_exp);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(Idfr);
				}
				break;
			case 2:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(IntLit);
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(Idfr);
				setState(67);
				match(Assign);
				setState(68);
				exp();
				}
				break;
			case 4:
				_localctx = new AddMinTimDivContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(LParen);
				setState(70);
				exp();
				setState(71);
				binop();
				setState(72);
				exp();
				setState(73);
				match(RParen);
				}
				break;
			case 5:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(Idfr);
				setState(76);
				match(LParen);
				setState(77);
				args();
				setState(78);
				match(RParen);
				}
				break;
			case 6:
				_localctx = new AnotherBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				block();
				}
				break;
			case 7:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				match(If);
				setState(82);
				exp();
				setState(83);
				match(Then);
				setState(84);
				block();
				setState(85);
				match(Else);
				setState(86);
				block();
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				match(While);
				setState(89);
				exp();
				setState(90);
				match(Do);
				setState(91);
				block();
				}
				break;
			case 9:
				_localctx = new RepeatLooopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(93);
				match(Repeat);
				setState(94);
				block();
				setState(95);
				match(Until);
				setState(96);
				exp();
				}
				break;
			case 10:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(98);
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
		enterRule(_localctx, 14, RULE_args);
		try {
			setState(103);
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
				setState(102);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_argsne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpArgContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(106);
			exp();
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
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
					setState(108);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(109);
					match(Comma);
					setState(110);
					exp();
					}
					} 
				}
				setState(115);
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
		enterRule(_localctx, 18, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
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
		case 3:
			return vardecne_sempred((VardecneContext)_localctx, predIndex);
		case 8:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#{\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\5"+
		"\4(\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\63\n\5\f\5\16\5\66\13"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7A\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bf\n\b\3\t\3\t\5\t"+
		"j\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nr\n\n\f\n\16\nu\13\n\3\13\3\13\3\f\3"+
		"\f\3\f\2\4\b\22\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\27\"\3\2\13\r\2~"+
		"\2\34\3\2\2\2\4\36\3\2\2\2\6\'\3\2\2\2\b)\3\2\2\2\n\67\3\2\2\2\f@\3\2"+
		"\2\2\16e\3\2\2\2\20i\3\2\2\2\22k\3\2\2\2\24v\3\2\2\2\26x\3\2\2\2\30\35"+
		"\5\4\3\2\31\32\5\4\3\2\32\33\5\2\2\2\33\35\3\2\2\2\34\30\3\2\2\2\34\31"+
		"\3\2\2\2\35\3\3\2\2\2\36\37\5\26\f\2\37 \7\16\2\2 !\7\20\2\2!\"\5\6\4"+
		"\2\"#\7\22\2\2#$\5\n\6\2$\5\3\2\2\2%(\3\2\2\2&(\5\b\5\2\'%\3\2\2\2\'&"+
		"\3\2\2\2(\7\3\2\2\2)*\b\5\1\2*+\5\26\f\2+,\7\16\2\2,\64\3\2\2\2-.\f\3"+
		"\2\2./\7\21\2\2/\60\5\26\f\2\60\61\7\16\2\2\61\63\3\2\2\2\62-\3\2\2\2"+
		"\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\t\3\2\2\2\66\64\3\2\2\2"+
		"\678\7\23\2\289\5\f\7\29:\7\25\2\2:\13\3\2\2\2;A\5\16\b\2<=\5\16\b\2="+
		">\7\24\2\2>?\5\f\7\2?A\3\2\2\2@;\3\2\2\2@<\3\2\2\2A\r\3\2\2\2Bf\7\16\2"+
		"\2Cf\7\17\2\2DE\7\16\2\2EF\7\26\2\2Ff\5\16\b\2GH\7\20\2\2HI\5\16\b\2I"+
		"J\5\24\13\2JK\5\16\b\2KL\7\22\2\2Lf\3\2\2\2MN\7\16\2\2NO\7\20\2\2OP\5"+
		"\20\t\2PQ\7\22\2\2Qf\3\2\2\2Rf\5\n\6\2ST\7\6\2\2TU\5\16\b\2UV\7\7\2\2"+
		"VW\5\n\6\2WX\7\b\2\2XY\5\n\6\2Yf\3\2\2\2Z[\7\4\2\2[\\\5\16\b\2\\]\7\5"+
		"\2\2]^\5\n\6\2^f\3\2\2\2_`\7\t\2\2`a\5\n\6\2ab\7\n\2\2bc\5\16\b\2cf\3"+
		"\2\2\2df\7\3\2\2eB\3\2\2\2eC\3\2\2\2eD\3\2\2\2eG\3\2\2\2eM\3\2\2\2eR\3"+
		"\2\2\2eS\3\2\2\2eZ\3\2\2\2e_\3\2\2\2ed\3\2\2\2f\17\3\2\2\2gj\3\2\2\2h"+
		"j\5\22\n\2ig\3\2\2\2ih\3\2\2\2j\21\3\2\2\2kl\b\n\1\2lm\5\16\b\2ms\3\2"+
		"\2\2no\f\3\2\2op\7\21\2\2pr\5\16\b\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2t\23\3\2\2\2us\3\2\2\2vw\t\2\2\2w\25\3\2\2\2xy\t\3\2\2y\27\3\2\2"+
		"\2\t\34\'\64@eis";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}