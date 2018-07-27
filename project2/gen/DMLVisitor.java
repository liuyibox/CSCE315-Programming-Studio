// Generated from C:/IdeaProjects/Project3/src\DML.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DMLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DMLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(DMLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DMLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(DMLParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(DMLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(DMLParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(DMLParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(DMLParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(DMLParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(DMLParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(DMLParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrlist(DMLParser.AttrlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(DMLParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(DMLParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(DMLParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#natjoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatjoin(DMLParser.NatjoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#atomexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomexpr(DMLParser.AtomexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#attrname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrname(DMLParser.AttrnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#relname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelname(DMLParser.RelnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(DMLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DMLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(DMLParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#opencmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpencmd(DMLParser.OpencmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#closecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosecmd(DMLParser.ClosecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#writecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritecmd(DMLParser.WritecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#exitcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitcmd(DMLParser.ExitcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#showcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowcmd(DMLParser.ShowcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#createcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatecmd(DMLParser.CreatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#updatecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatecmd(DMLParser.UpdatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#insertcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertcmd(DMLParser.InsertcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#deletecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletecmd(DMLParser.DeletecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#typedAttributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedAttributeList(DMLParser.TypedAttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DMLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DMLParser.TypeContext ctx);
}