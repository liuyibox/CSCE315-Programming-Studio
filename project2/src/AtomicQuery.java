/**
 * Plan to handle Atomic Queries.
 */
public class AtomicQuery extends QueryPlan {
    /**
     * The relation name of the query.
     */
    private String relation_name = "";

    /**
     * The expression of the query.
     */
    private QueryPlan expr = new QueryPlan();

    /**
     * Sets the relation name.
     * @param _name The relation name.
     */
    public void setRelationName(String _name){relation_name = _name;}

    /**
     * Sets the expression.
     * @param _expr The expression.
     */
    public void setExpr(QueryPlan _expr){expr = _expr;}

    /**
     * Returns the relation name.
     * @return
     */
    public String getRelationName(){return relation_name;}

    /**
     * Executes the QueryPlan.
     * @Override
     */
    public void execute(){
        System.out.println("Executing an atomic query");
        expr.execute();
    }

}
