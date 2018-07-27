import java.util.ArrayList;

/**
 * The QueryPlan for the Natural Join command.
 */

// natural-join ::= atomic-expr & atomic-expr
public class NatjoinQuery extends QueryPlan {

    /**
     * The expressions to be joined.
     */
    private ArrayList<AtomicQuery> atom_exprs = new ArrayList<>();

    /**
     * Adds the atomic expressions to be joined.
     * @param atom_expr
     */
    public void addAtomExpr(AtomicQuery atom_expr){
        try {
            if(atom_exprs.size() == 2)
                throw new Exception("Error. Too many natural join arguments!");
            atom_exprs.add(atom_expr);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * Executes the natural join query.
     */
    @Override public void execute(){
        String name = getNewTableName();
        // natural-join = relation-name & relation-name
        atom_exprs.get(0).execute();
        atom_exprs.get(1).execute();
        Project3.db.naturalJoin(name, atom_exprs.get(0).getRelationName(), atom_exprs.get(1).getRelationName());
    }
}
