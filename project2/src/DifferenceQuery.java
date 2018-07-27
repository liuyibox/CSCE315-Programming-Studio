import java.util.ArrayList;

/**
 * QueryPlan for the Difference Query.
 */

// difference ::= atomic-expr - atomic-expr
public class DifferenceQuery extends QueryPlan {
    /**
     * The Atomic Expressions of the difference query.
     */
    private ArrayList<AtomicQuery> atom_exprs = new ArrayList<>();

    /**
     * Adds atomic expression to the plan.
     * @param atom_expr The expression to be added.
     */
    public void addAtomExpr(AtomicQuery atom_expr){atom_exprs.add(atom_expr);}

    /**
     * The execution of the difference query.
     */
    @Override public void execute(){
        System.out.println("Executing a difference query");
        String name = getNewTableName();
        // difference = relation-name - relation-name
        Project3.db.difference(name, atom_exprs.get(0).getRelationName(), atom_exprs.get(1).getRelationName());
        Project3.db.show(name);
    }
}
