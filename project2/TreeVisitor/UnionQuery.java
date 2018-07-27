import java.util.ArrayList;

/**
 * Created by ellie on 6/28/2017.
 */

// union ::= atomic-expr + atomic-expr
public class UnionQuery extends QueryPlan {
    private ArrayList<QueryPlan> atom_exprs;

    public UnionQuery(){
        atom_exprs = new ArrayList<QueryPlan>();
    }

    public void addAtomExpr(QueryPlan atom_expr){atom_exprs.add(atom_expr);}

    @Override public void execute(){
        System.out.println("Executing an union query");
    }

}
