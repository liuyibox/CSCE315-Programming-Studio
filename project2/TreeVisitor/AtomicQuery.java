/**
 * Created by ellie on 6/27/2017.
 */
public class AtomicQuery extends QueryPlan {
    private String relation_name;
    private QueryPlan expr;

    public AtomicQuery(){
        relation_name = "";
        expr = new QueryPlan();
    }

    public void setRelationName(String _name){relation_name = _name;}
    public void setExpr(QueryPlan _expr){expr = _expr;}

    @Override public void execute(){
        System.out.println("Executing an atomic query");
    }

}
