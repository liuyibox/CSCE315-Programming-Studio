import java.util.ArrayList;

/**
 * Created by ellie on 6/28/2017.
 */

// natural-join ::= atomic-expr & atomic-expr
public class NatjoinQuery extends QueryPlan {
    private ArrayList<QueryPlan> atom_exprs;

    public NatjoinQuery(){
        atom_exprs = new ArrayList<QueryPlan>();
    }

    public void addAtomExpr(QueryPlan atom_expr){atom_exprs.add(atom_expr);}

    @Override public void execute(){
        System.out.println("Executing a natural join query");
    }
}
