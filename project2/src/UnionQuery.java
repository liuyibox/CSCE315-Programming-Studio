import java.util.ArrayList;

/**
 * QueryPlan for the Union Query.
 */

// union ::= atomic-expr + atomic-expr
public class UnionQuery extends QueryPlan {

    /**
     * The tables to be union.
     */
    private ArrayList<AtomicQuery> atom_exprs = new ArrayList<>();

    /**
     * Adds tables to be union.
     * @param atom_expr The tables to union.
     */
    public void addAtomExpr(AtomicQuery atom_expr){atom_exprs.add(atom_expr);}

    /**
     * Executes the Union query.
     */
    @Override public void execute(){
        System.out.println("Executing an union query");
        String name = getNewTableName();
        // union = relation-name + relation-name
        Project3.db.union(name, atom_exprs.get(0).getRelationName(), atom_exprs.get(1).getRelationName());
        Project3.db.show(name);
    }

}
