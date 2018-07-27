import java.util.ArrayList;

/**
 * QueryPlan for the Product query.
 */

// product ::= atomic-expr * atomic-expr
public class ProductQuery extends QueryPlan {
    /**
     * The atomic expressions to join.
     */
    private ArrayList<AtomicQuery> atom_exprs = new ArrayList<>();

    /**
     * Adds an atomic expression to the list.
     * @param atom_expr
     */
    public void addAtomExpr(AtomicQuery atom_expr) {
        try {
            if(atom_exprs.size() == 2)
                throw new Exception("Product Query: More than 2 expressions");
            atom_exprs.add(atom_expr);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * Executes the Product Query.
     */
    @Override public void execute(){
        System.out.println("Executing a product query");
        String name = getNewTableName();
        // product = relation-name * relation-name
        Project3.db.product(name, atom_exprs.get(0).getRelationName(), atom_exprs.get(1).getRelationName());
        Project3.db.show(name);
    }
}
