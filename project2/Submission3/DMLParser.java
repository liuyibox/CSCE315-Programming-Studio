// Generated from DML.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, VARCHAR=5, INTEGER=6, TABLE=7, OPEN=8, 
		CLOSE=9, WRITE=10, EXIT=11, SHOW=12, CREATE=13, UPDATE=14, INSERTINTO=15, 
		DELETEFROM=16, VALUESFROM=17, RELATION=18, SET=19, WHERE=20, PRIMARYKEY=21, 
		PLUS=22, ASSIGN=23, MINUS=24, MULTIPLY=25, AND=26, LPAREN=27, RPAREN=28, 
		COMMA=29, QUOTE=30, BOOLAND=31, BOOLOR=32, EQUALS=33, NOTEQUAL=34, GREATER=35, 
		LESS=36, GREATEROREQ=37, LESSOREQ=38, ALPHA=39, DIGIT=40, DOUBLE=41, WHITESPACE=42;
	public static final int
		RULE_program = 0, RULE_query = 1, RULE_expr = 2, RULE_selection = 3, RULE_condition = 4, 
		RULE_conjunction = 5, RULE_comparison = 6, RULE_op = 7, RULE_operand = 8, 
		RULE_projection = 9, RULE_renaming = 10, RULE_attrlist = 11, RULE_union = 12, 
		RULE_difference = 13, RULE_product = 14, RULE_natjoin = 15, RULE_atomexpr = 16, 
		RULE_attrname = 17, RULE_relname = 18, RULE_identifier = 19, RULE_literal = 20, 
		RULE_command = 21, RULE_opencmd = 22, RULE_closecmd = 23, RULE_writecmd = 24, 
		RULE_exitcmd = 25, RULE_showcmd = 26, RULE_createcmd = 27, RULE_updatecmd = 28, 
		RULE_insertcmd = 29, RULE_deletecmd = 30, RULE_typedAttributeList = 31, 
		RULE_type = 32;
	public static final String[] ruleNames = {
		"program", "query", "expr", "selection", "condition", "conjunction", "comparison", 
		"op", "operand", "projection", "renaming", "attrlist", "union", "difference", 
		"product", "natjoin", "atomexpr", "attrname", "relname", "identifier", 
		"literal", "command", "opencmd", "closecmd", "writecmd", "exitcmd", "showcmd", 
		"createcmd", "updatecmd", "insertcmd", "deletecmd", "typedAttributeList", 
		"type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'select'", "'project'", "'rename'", "'VARCHAR'", "'INTEGER'", 
		"'TABLE'", "'OPEN'", "'CLOSE'", "'WRITE'", "'EXIT'", "'SHOW'", "'CREATE'", 
		"'UPDATE'", "'INSERT INTO'", "'DELETE FROM'", "'VALUES FROM'", "'RELATION'", 
		"'SET'", "'WHERE'", "'PRIMARY KEY'", "'+'", "'<-'", "'-'", "'*'", "'&'", 
		"'('", "')'", "','", "'\"'", "'&&'", "'||'", "'=='", "'!='", "'>'", "'<'", 
		"'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "VARCHAR", "INTEGER", "TABLE", "OPEN", "CLOSE", 
		"WRITE", "EXIT", "SHOW", "CREATE", "UPDATE", "INSERTINTO", "DELETEFROM", 
		"VALUESFROM", "RELATION", "SET", "WHERE", "PRIMARYKEY", "PLUS", "ASSIGN", 
		"MINUS", "MULTIPLY", "AND", "LPAREN", "RPAREN", "COMMA", "QUOTE", "BOOLAND", 
		"BOOLOR", "EQUALS", "NOTEQUAL", "GREATER", "LESS", "GREATEROREQ", "LESSOREQ", 
		"ALPHA", "DIGIT", "DOUBLE", "WHITESPACE"
	};
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
	public String getGrammarFileName() { return "DML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << CLOSE) | (1L << WRITE) | (1L << EXIT) | (1L << SHOW) | (1L << CREATE) | (1L << UPDATE) | (1L << INSERTINTO) | (1L << DELETEFROM) | (1L << ALPHA))) != 0)) {
				{
				setState(68);
				switch (_input.LA(1)) {
				case OPEN:
				case CLOSE:
				case WRITE:
				case EXIT:
				case SHOW:
				case CREATE:
				case UPDATE:
				case INSERTINTO:
				case DELETEFROM:
					{
					setState(66);
					command();
					}
					break;
				case ALPHA:
					{
					setState(67);
					query();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class QueryContext extends ParserRuleContext {
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(DMLParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			relname();
			setState(74);
			match(ASSIGN);
			setState(75);
			expr();
			setState(76);
			match(T__0);
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

	public static class ExprContext extends ParserRuleContext {
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public NatjoinContext natjoin() {
			return getRuleContext(NatjoinContext.class,0);
		}
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				selection();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				projection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				renaming();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				union();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				difference();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				product();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				natjoin();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				atomexpr();
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__1);
			setState(89);
			match(LPAREN);
			setState(90);
			condition();
			setState(91);
			match(RPAREN);
			setState(92);
			atomexpr();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> BOOLOR() { return getTokens(DMLParser.BOOLOR); }
		public TerminalNode BOOLOR(int i) {
			return getToken(DMLParser.BOOLOR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			conjunction();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BOOLOR) {
				{
				{
				setState(95);
				match(BOOLOR);
				setState(96);
				conjunction();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public List<TerminalNode> BOOLAND() { return getTokens(DMLParser.BOOLAND); }
		public TerminalNode BOOLAND(int i) {
			return getToken(DMLParser.BOOLAND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			comparison();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BOOLAND) {
				{
				{
				setState(103);
				match(BOOLAND);
				setState(104);
				comparison();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comparison);
		try {
			setState(118);
			switch (_input.LA(1)) {
			case QUOTE:
			case EQUALS:
			case NOTEQUAL:
			case GREATER:
			case LESS:
			case GREATEROREQ:
			case LESSOREQ:
			case ALPHA:
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				operand();
				setState(111);
				op();
				setState(112);
				operand();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(LPAREN);
				setState(115);
				condition();
				setState(116);
				match(RPAREN);
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

	public static class OpContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(DMLParser.EQUALS, 0); }
		public TerminalNode NOTEQUAL() { return getToken(DMLParser.NOTEQUAL, 0); }
		public TerminalNode LESS() { return getToken(DMLParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(DMLParser.GREATER, 0); }
		public TerminalNode LESSOREQ() { return getToken(DMLParser.LESSOREQ, 0); }
		public TerminalNode GREATEROREQ() { return getToken(DMLParser.GREATEROREQ, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << NOTEQUAL) | (1L << GREATER) | (1L << LESS) | (1L << GREATEROREQ) | (1L << LESSOREQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class OperandContext extends ParserRuleContext {
		public AttrnameContext attrname() {
			return getRuleContext(AttrnameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operand);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				attrname();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				literal();
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

	public static class ProjectionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__2);
			setState(127);
			match(LPAREN);
			setState(128);
			attrlist();
			setState(129);
			match(RPAREN);
			setState(130);
			atomexpr();
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

	public static class RenamingContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__3);
			setState(133);
			match(LPAREN);
			setState(134);
			attrlist();
			setState(135);
			match(RPAREN);
			setState(136);
			atomexpr();
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

	public static class AttrlistContext extends ParserRuleContext {
		public List<AttrnameContext> attrname() {
			return getRuleContexts(AttrnameContext.class);
		}
		public AttrnameContext attrname(int i) {
			return getRuleContext(AttrnameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DMLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DMLParser.COMMA, i);
		}
		public AttrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitAttrlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrlistContext attrlist() throws RecognitionException {
		AttrlistContext _localctx = new AttrlistContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attrlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			attrname();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139);
				match(COMMA);
				setState(140);
				attrname();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class UnionContext extends ParserRuleContext {
		public List<AtomexprContext> atomexpr() {
			return getRuleContexts(AtomexprContext.class);
		}
		public AtomexprContext atomexpr(int i) {
			return getRuleContext(AtomexprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(DMLParser.PLUS, 0); }
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			atomexpr();
			setState(147);
			match(PLUS);
			setState(148);
			atomexpr();
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

	public static class DifferenceContext extends ParserRuleContext {
		public List<AtomexprContext> atomexpr() {
			return getRuleContexts(AtomexprContext.class);
		}
		public AtomexprContext atomexpr(int i) {
			return getRuleContext(AtomexprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(DMLParser.MINUS, 0); }
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			atomexpr();
			setState(151);
			match(MINUS);
			setState(152);
			atomexpr();
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

	public static class ProductContext extends ParserRuleContext {
		public List<AtomexprContext> atomexpr() {
			return getRuleContexts(AtomexprContext.class);
		}
		public AtomexprContext atomexpr(int i) {
			return getRuleContext(AtomexprContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(DMLParser.MULTIPLY, 0); }
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			atomexpr();
			setState(155);
			match(MULTIPLY);
			setState(156);
			atomexpr();
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

	public static class NatjoinContext extends ParserRuleContext {
		public List<AtomexprContext> atomexpr() {
			return getRuleContexts(AtomexprContext.class);
		}
		public AtomexprContext atomexpr(int i) {
			return getRuleContext(AtomexprContext.class,i);
		}
		public TerminalNode AND() { return getToken(DMLParser.AND, 0); }
		public NatjoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natjoin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitNatjoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NatjoinContext natjoin() throws RecognitionException {
		NatjoinContext _localctx = new NatjoinContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_natjoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			atomexpr();
			setState(159);
			match(AND);
			setState(160);
			atomexpr();
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

	public static class AtomexprContext extends ParserRuleContext {
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public AtomexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitAtomexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomexprContext atomexpr() throws RecognitionException {
		AtomexprContext _localctx = new AtomexprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atomexpr);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case ALPHA:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				relname();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(LPAREN);
				setState(164);
				expr();
				setState(165);
				match(RPAREN);
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

	public static class AttrnameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttrnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitAttrname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrnameContext attrname() throws RecognitionException {
		AttrnameContext _localctx = new AttrnameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_attrname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			identifier();
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

	public static class RelnameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public RelnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitRelname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelnameContext relname() throws RecognitionException {
		RelnameContext _localctx = new RelnameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_relname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			identifier();
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> ALPHA() { return getTokens(DMLParser.ALPHA); }
		public TerminalNode ALPHA(int i) {
			return getToken(DMLParser.ALPHA, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(DMLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(DMLParser.DIGIT, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ALPHA);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALPHA || _la==DIGIT) {
				{
				{
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==ALPHA || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class LiteralContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE() { return getTokens(DMLParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(DMLParser.QUOTE, i);
		}
		public List<TerminalNode> ALPHA() { return getTokens(DMLParser.ALPHA); }
		public TerminalNode ALPHA(int i) {
			return getToken(DMLParser.ALPHA, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(DMLParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(DMLParser.DIGIT, i);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(180);
				match(QUOTE);
				}
				break;
			}
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ALPHA) {
					{
					{
					setState(183);
					match(ALPHA);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DIGIT) {
					{
					{
					setState(189);
					match(DIGIT);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(198);
			_la = _input.LA(1);
			if (_la==QUOTE) {
				{
				setState(197);
				match(QUOTE);
				}
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

	public static class CommandContext extends ParserRuleContext {
		public OpencmdContext opencmd() {
			return getRuleContext(OpencmdContext.class,0);
		}
		public ClosecmdContext closecmd() {
			return getRuleContext(ClosecmdContext.class,0);
		}
		public WritecmdContext writecmd() {
			return getRuleContext(WritecmdContext.class,0);
		}
		public ExitcmdContext exitcmd() {
			return getRuleContext(ExitcmdContext.class,0);
		}
		public ShowcmdContext showcmd() {
			return getRuleContext(ShowcmdContext.class,0);
		}
		public CreatecmdContext createcmd() {
			return getRuleContext(CreatecmdContext.class,0);
		}
		public UpdatecmdContext updatecmd() {
			return getRuleContext(UpdatecmdContext.class,0);
		}
		public InsertcmdContext insertcmd() {
			return getRuleContext(InsertcmdContext.class,0);
		}
		public DeletecmdContext deletecmd() {
			return getRuleContext(DeletecmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(200);
				opencmd();
				}
				break;
			case CLOSE:
				{
				setState(201);
				closecmd();
				}
				break;
			case WRITE:
				{
				setState(202);
				writecmd();
				}
				break;
			case EXIT:
				{
				setState(203);
				exitcmd();
				}
				break;
			case SHOW:
				{
				setState(204);
				showcmd();
				}
				break;
			case CREATE:
				{
				setState(205);
				createcmd();
				}
				break;
			case UPDATE:
				{
				setState(206);
				updatecmd();
				}
				break;
			case INSERTINTO:
				{
				setState(207);
				insertcmd();
				}
				break;
			case DELETEFROM:
				{
				setState(208);
				deletecmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(211);
			match(T__0);
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

	public static class OpencmdContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(DMLParser.OPEN, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public OpencmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opencmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitOpencmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpencmdContext opencmd() throws RecognitionException {
		OpencmdContext _localctx = new OpencmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_opencmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(OPEN);
			setState(214);
			relname();
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

	public static class ClosecmdContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(DMLParser.CLOSE, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public ClosecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitClosecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosecmdContext closecmd() throws RecognitionException {
		ClosecmdContext _localctx = new ClosecmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_closecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(CLOSE);
			setState(217);
			relname();
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

	public static class WritecmdContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(DMLParser.WRITE, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public WritecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitWritecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritecmdContext writecmd() throws RecognitionException {
		WritecmdContext _localctx = new WritecmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_writecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(WRITE);
			setState(220);
			relname();
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

	public static class ExitcmdContext extends ParserRuleContext {
		public TerminalNode EXIT() { return getToken(DMLParser.EXIT, 0); }
		public ExitcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitExitcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitcmdContext exitcmd() throws RecognitionException {
		ExitcmdContext _localctx = new ExitcmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exitcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(EXIT);
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

	public static class ShowcmdContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(DMLParser.SHOW, 0); }
		public AtomexprContext atomexpr() {
			return getRuleContext(AtomexprContext.class,0);
		}
		public ShowcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitShowcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowcmdContext showcmd() throws RecognitionException {
		ShowcmdContext _localctx = new ShowcmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_showcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(SHOW);
			setState(225);
			atomexpr();
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

	public static class CreatecmdContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(DMLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(DMLParser.TABLE, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(DMLParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(DMLParser.LPAREN, i);
		}
		public TypedAttributeListContext typedAttributeList() {
			return getRuleContext(TypedAttributeListContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(DMLParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(DMLParser.RPAREN, i);
		}
		public TerminalNode PRIMARYKEY() { return getToken(DMLParser.PRIMARYKEY, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public CreatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitCreatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatecmdContext createcmd() throws RecognitionException {
		CreatecmdContext _localctx = new CreatecmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_createcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(CREATE);
			setState(228);
			match(TABLE);
			setState(229);
			relname();
			setState(230);
			match(LPAREN);
			setState(231);
			typedAttributeList();
			setState(232);
			match(RPAREN);
			setState(233);
			match(PRIMARYKEY);
			setState(234);
			match(LPAREN);
			setState(235);
			attrlist();
			setState(236);
			match(RPAREN);
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

	public static class UpdatecmdContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(DMLParser.UPDATE, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public TerminalNode SET() { return getToken(DMLParser.SET, 0); }
		public List<AttrnameContext> attrname() {
			return getRuleContexts(AttrnameContext.class);
		}
		public AttrnameContext attrname(int i) {
			return getRuleContext(AttrnameContext.class,i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(DMLParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(DMLParser.EQUALS, i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(DMLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(DMLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DMLParser.COMMA, i);
		}
		public UpdatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updatecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitUpdatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdatecmdContext updatecmd() throws RecognitionException {
		UpdatecmdContext _localctx = new UpdatecmdContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_updatecmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(UPDATE);
			setState(239);
			relname();
			setState(240);
			match(SET);
			setState(241);
			attrname();
			setState(242);
			match(EQUALS);
			setState(243);
			literal();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(244);
				match(COMMA);
				setState(245);
				attrname();
				setState(246);
				match(EQUALS);
				setState(247);
				literal();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			match(WHERE);
			setState(255);
			condition();
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

	public static class InsertcmdContext extends ParserRuleContext {
		public TerminalNode INSERTINTO() { return getToken(DMLParser.INSERTINTO, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public TerminalNode VALUESFROM() { return getToken(DMLParser.VALUESFROM, 0); }
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DMLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DMLParser.COMMA, i);
		}
		public TerminalNode RELATION() { return getToken(DMLParser.RELATION, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsertcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitInsertcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertcmdContext insertcmd() throws RecognitionException {
		InsertcmdContext _localctx = new InsertcmdContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_insertcmd);
		int _la;
		try {
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(INSERTINTO);
				setState(258);
				relname();
				setState(259);
				match(VALUESFROM);
				setState(260);
				match(LPAREN);
				setState(261);
				literal();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(262);
					match(COMMA);
					setState(263);
					literal();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(269);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				match(INSERTINTO);
				setState(272);
				relname();
				setState(273);
				match(VALUESFROM);
				setState(274);
				match(RELATION);
				setState(275);
				expr();
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

	public static class DeletecmdContext extends ParserRuleContext {
		public TerminalNode DELETEFROM() { return getToken(DMLParser.DELETEFROM, 0); }
		public RelnameContext relname() {
			return getRuleContext(RelnameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(DMLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeletecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deletecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitDeletecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeletecmdContext deletecmd() throws RecognitionException {
		DeletecmdContext _localctx = new DeletecmdContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_deletecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(DELETEFROM);
			setState(280);
			relname();
			setState(281);
			match(WHERE);
			setState(282);
			condition();
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

	public static class TypedAttributeListContext extends ParserRuleContext {
		public List<AttrnameContext> attrname() {
			return getRuleContexts(AttrnameContext.class);
		}
		public AttrnameContext attrname(int i) {
			return getRuleContext(AttrnameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DMLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DMLParser.COMMA, i);
		}
		public TypedAttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedAttributeList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitTypedAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedAttributeListContext typedAttributeList() throws RecognitionException {
		TypedAttributeListContext _localctx = new TypedAttributeListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_typedAttributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			attrname();
			setState(285);
			type();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(286);
				match(COMMA);
				setState(287);
				attrname();
				setState(288);
				type();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public TerminalNode VARCHAR() { return getToken(DMLParser.VARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(DMLParser.LPAREN, 0); }
		public TerminalNode DIGIT() { return getToken(DMLParser.DIGIT, 0); }
		public TerminalNode RPAREN() { return getToken(DMLParser.RPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(DMLParser.INTEGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DMLVisitor ) return ((DMLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(300);
			switch (_input.LA(1)) {
			case VARCHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(VARCHAR);
				setState(296);
				match(LPAREN);
				setState(297);
				match(DIGIT);
				setState(298);
				match(RPAREN);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(INTEGER);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u0131\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\7\6d\n\6\f\6\16\6g\13\6\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\by\n\b\3\t\3\t\3\n\3\n\5\n\177\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0090\n\r"+
		"\f\r\16\r\u0093\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00aa\n\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\7\25\u00b2\n\25\f\25\16\25\u00b5\13\25"+
		"\3\26\5\26\u00b8\n\26\3\26\7\26\u00bb\n\26\f\26\16\26\u00be\13\26\3\26"+
		"\7\26\u00c1\n\26\f\26\16\26\u00c4\13\26\5\26\u00c6\n\26\3\26\5\26\u00c9"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00d4\n\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u00fc\n\36\f\36\16"+
		"\36\u00ff\13\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u010b\n\37\f\37\16\37\u010e\13\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u0118\n\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\7!\u0125\n!\f!"+
		"\16!\u0128\13!\3\"\3\"\3\"\3\"\3\"\5\"\u012f\n\"\3\"\2\2#\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\4\3\2#(\3\2)"+
		"*\u0131\2H\3\2\2\2\4K\3\2\2\2\6X\3\2\2\2\bZ\3\2\2\2\n`\3\2\2\2\fh\3\2"+
		"\2\2\16x\3\2\2\2\20z\3\2\2\2\22~\3\2\2\2\24\u0080\3\2\2\2\26\u0086\3\2"+
		"\2\2\30\u008c\3\2\2\2\32\u0094\3\2\2\2\34\u0098\3\2\2\2\36\u009c\3\2\2"+
		"\2 \u00a0\3\2\2\2\"\u00a9\3\2\2\2$\u00ab\3\2\2\2&\u00ad\3\2\2\2(\u00af"+
		"\3\2\2\2*\u00b7\3\2\2\2,\u00d3\3\2\2\2.\u00d7\3\2\2\2\60\u00da\3\2\2\2"+
		"\62\u00dd\3\2\2\2\64\u00e0\3\2\2\2\66\u00e2\3\2\2\28\u00e5\3\2\2\2:\u00f0"+
		"\3\2\2\2<\u0117\3\2\2\2>\u0119\3\2\2\2@\u011e\3\2\2\2B\u012e\3\2\2\2D"+
		"G\5,\27\2EG\5\4\3\2FD\3\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2"+
		"I\3\3\2\2\2JH\3\2\2\2KL\5&\24\2LM\7\31\2\2MN\5\6\4\2NO\7\3\2\2O\5\3\2"+
		"\2\2PY\5\b\5\2QY\5\24\13\2RY\5\26\f\2SY\5\32\16\2TY\5\34\17\2UY\5\36\20"+
		"\2VY\5 \21\2WY\5\"\22\2XP\3\2\2\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2XT\3\2"+
		"\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\7\3\2\2\2Z[\7\4\2\2[\\\7\35\2\2\\"+
		"]\5\n\6\2]^\7\36\2\2^_\5\"\22\2_\t\3\2\2\2`e\5\f\7\2ab\7\"\2\2bd\5\f\7"+
		"\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\13\3\2\2\2ge\3\2\2\2hm\5\16"+
		"\b\2ij\7!\2\2jl\5\16\b\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\r\3"+
		"\2\2\2om\3\2\2\2pq\5\22\n\2qr\5\20\t\2rs\5\22\n\2sy\3\2\2\2tu\7\35\2\2"+
		"uv\5\n\6\2vw\7\36\2\2wy\3\2\2\2xp\3\2\2\2xt\3\2\2\2y\17\3\2\2\2z{\t\2"+
		"\2\2{\21\3\2\2\2|\177\5$\23\2}\177\5*\26\2~|\3\2\2\2~}\3\2\2\2\177\23"+
		"\3\2\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7\35\2\2\u0082\u0083\5\30\r\2"+
		"\u0083\u0084\7\36\2\2\u0084\u0085\5\"\22\2\u0085\25\3\2\2\2\u0086\u0087"+
		"\7\6\2\2\u0087\u0088\7\35\2\2\u0088\u0089\5\30\r\2\u0089\u008a\7\36\2"+
		"\2\u008a\u008b\5\"\22\2\u008b\27\3\2\2\2\u008c\u0091\5$\23\2\u008d\u008e"+
		"\7\37\2\2\u008e\u0090\5$\23\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2"+
		"\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\31\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0094\u0095\5\"\22\2\u0095\u0096\7\30\2\2\u0096\u0097\5\"\22"+
		"\2\u0097\33\3\2\2\2\u0098\u0099\5\"\22\2\u0099\u009a\7\32\2\2\u009a\u009b"+
		"\5\"\22\2\u009b\35\3\2\2\2\u009c\u009d\5\"\22\2\u009d\u009e\7\33\2\2\u009e"+
		"\u009f\5\"\22\2\u009f\37\3\2\2\2\u00a0\u00a1\5\"\22\2\u00a1\u00a2\7\34"+
		"\2\2\u00a2\u00a3\5\"\22\2\u00a3!\3\2\2\2\u00a4\u00aa\5&\24\2\u00a5\u00a6"+
		"\7\35\2\2\u00a6\u00a7\5\6\4\2\u00a7\u00a8\7\36\2\2\u00a8\u00aa\3\2\2\2"+
		"\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa#\3\2\2\2\u00ab\u00ac\5"+
		"(\25\2\u00ac%\3\2\2\2\u00ad\u00ae\5(\25\2\u00ae\'\3\2\2\2\u00af\u00b3"+
		"\7)\2\2\u00b0\u00b2\t\3\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4)\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b6\u00b8\7 \2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00c5"+
		"\3\2\2\2\u00b9\u00bb\7)\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c6\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00c1\7*\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00bc\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c9\7 \2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9+\3\2\2\2\u00ca"+
		"\u00d4\5.\30\2\u00cb\u00d4\5\60\31\2\u00cc\u00d4\5\62\32\2\u00cd\u00d4"+
		"\5\64\33\2\u00ce\u00d4\5\66\34\2\u00cf\u00d4\58\35\2\u00d0\u00d4\5:\36"+
		"\2\u00d1\u00d4\5<\37\2\u00d2\u00d4\5> \2\u00d3\u00ca\3\2\2\2\u00d3\u00cb"+
		"\3\2\2\2\u00d3\u00cc\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3"+
		"\u00cf\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\3\2\2\u00d6-\3\2\2\2\u00d7\u00d8"+
		"\7\n\2\2\u00d8\u00d9\5&\24\2\u00d9/\3\2\2\2\u00da\u00db\7\13\2\2\u00db"+
		"\u00dc\5&\24\2\u00dc\61\3\2\2\2\u00dd\u00de\7\f\2\2\u00de\u00df\5&\24"+
		"\2\u00df\63\3\2\2\2\u00e0\u00e1\7\r\2\2\u00e1\65\3\2\2\2\u00e2\u00e3\7"+
		"\16\2\2\u00e3\u00e4\5\"\22\2\u00e4\67\3\2\2\2\u00e5\u00e6\7\17\2\2\u00e6"+
		"\u00e7\7\t\2\2\u00e7\u00e8\5&\24\2\u00e8\u00e9\7\35\2\2\u00e9\u00ea\5"+
		"@!\2\u00ea\u00eb\7\36\2\2\u00eb\u00ec\7\27\2\2\u00ec\u00ed\7\35\2\2\u00ed"+
		"\u00ee\5\30\r\2\u00ee\u00ef\7\36\2\2\u00ef9\3\2\2\2\u00f0\u00f1\7\20\2"+
		"\2\u00f1\u00f2\5&\24\2\u00f2\u00f3\7\25\2\2\u00f3\u00f4\5$\23\2\u00f4"+
		"\u00f5\7#\2\2\u00f5\u00fd\5*\26\2\u00f6\u00f7\7\37\2\2\u00f7\u00f8\5$"+
		"\23\2\u00f8\u00f9\7#\2\2\u00f9\u00fa\5*\26\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f6\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7\26\2\2\u0101"+
		"\u0102\5\n\6\2\u0102;\3\2\2\2\u0103\u0104\7\21\2\2\u0104\u0105\5&\24\2"+
		"\u0105\u0106\7\23\2\2\u0106\u0107\7\35\2\2\u0107\u010c\5*\26\2\u0108\u0109"+
		"\7\37\2\2\u0109\u010b\5*\26\2\u010a\u0108\3\2\2\2\u010b\u010e\3\2\2\2"+
		"\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010f\u0110\7\36\2\2\u0110\u0118\3\2\2\2\u0111\u0112\7\21\2\2"+
		"\u0112\u0113\5&\24\2\u0113\u0114\7\23\2\2\u0114\u0115\7\24\2\2\u0115\u0116"+
		"\5\6\4\2\u0116\u0118\3\2\2\2\u0117\u0103\3\2\2\2\u0117\u0111\3\2\2\2\u0118"+
		"=\3\2\2\2\u0119\u011a\7\22\2\2\u011a\u011b\5&\24\2\u011b\u011c\7\26\2"+
		"\2\u011c\u011d\5\n\6\2\u011d?\3\2\2\2\u011e\u011f\5$\23\2\u011f\u0126"+
		"\5B\"\2\u0120\u0121\7\37\2\2\u0121\u0122\5$\23\2\u0122\u0123\5B\"\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0120\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127A\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a"+
		"\7\7\2\2\u012a\u012b\7\35\2\2\u012b\u012c\7*\2\2\u012c\u012f\7\36\2\2"+
		"\u012d\u012f\7\b\2\2\u012e\u0129\3\2\2\2\u012e\u012d\3\2\2\2\u012fC\3"+
		"\2\2\2\27FHXemx~\u0091\u00a9\u00b3\u00b7\u00bc\u00c2\u00c5\u00c8\u00d3"+
		"\u00fd\u010c\u0117\u0126\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}