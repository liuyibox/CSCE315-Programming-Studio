import java.util.*;

/**
 * QueryPlan for the Projection Query.
 */

// project ( attribute-list ) atomic-expr
public class ProjectionQuery extends QueryPlan {
    /**
     * The attributes to be projected.
     */
    private Vector<String> attributes = new Vector<>();
    /**
     * The Atomic Query with the relation name to project.
     */
    private AtomicQuery atom_expr = new AtomicQuery();

    /**
     * Sets the atomic query.
     * @param _atom The atomic query with a relationName.
     */
    public void setAtomicQuery(AtomicQuery _atom){atom_expr = _atom;}

    /**
     * Adds attributes to the vector.
     * @param attr Attribute to be added.
     */
    public void addAttribute(String attr){attributes.add(attr);}

    /**
     * Executes the Projection Query.
     */
    @Override public void execute(){
        String name = getNewTableName();
        Project3.db.project(name, attributes, atom_expr.getRelationName());
        Project3.db.show(name);
    }

}
