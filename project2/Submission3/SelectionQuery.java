/**
 * QueryPlan for the Selection Query.
 */

// selection ::= select ( condition ) atomic-expr
public class SelectionQuery extends QueryPlan{
    /**
     * Condition for the selection.
     */
    private Condition conditions = new Condition();

    /**
     * The table for the selection.
     */
    private AtomicQuery atom_expr = new AtomicQuery();

    /**
     * Sets the table for selection.
     * @param _atom The table.
     */
    public void setAtomicQuery(AtomicQuery _atom){atom_expr = _atom;}

    /**
     * Sets the condition for the selection.
     * @param _cond The condition.
     */
    public void setCondition(Condition _cond){conditions=_cond;}

    /**
     * Executes the Selection Query.
     */
    @Override public void execute(){
        System.out.println("Executing a selection query");
        String name = getNewTableName();
        Project3.db.select(name, conditions, atom_expr.getRelationName());
        Project3.db.show(name);
    }
}
