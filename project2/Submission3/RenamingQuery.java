import java.util.ArrayList;
import java.util.*;

/**
 * QueryPlan for the Renaming Query.
 */

// renaming ::= rename ( attribute-list ) atomic expr
public class RenamingQuery extends QueryPlan {

    /**
     * Attributes for the rename query.
     */
    private Vector<String> attributes = new Vector<>();

    /**
     * Expression to be renamed.
     */
    private AtomicQuery atom_expr = new AtomicQuery();

    /**
     * Sets the expression to be renamed.
     * @param _atom The expression.
     */
    public void setAtomicQuery(AtomicQuery _atom){atom_expr = _atom;}

    /**
     * Sets the new attribute.
     * @param attr The new attribute.
     */
    public void addAttribute(String attr){attributes.add(attr);}

    /**
     * Executes the Rename Query.
     */
    @Override public void execute(){
        String name = getNewTableName();
        Project3.db.rename(name, attributes, atom_expr.getRelationName());
    }
}
