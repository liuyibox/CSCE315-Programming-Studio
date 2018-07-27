/**
 * Executes the SHOW command.
 */

// show-cmd ::= SHOW atomic-expr
public class ShowCmd extends QueryPlan {

    /**
     * Table to be shown.
     */
    private AtomicQuery atom_expr = new AtomicQuery();

    /**
     * Sets the table to be shown.
     * @param _atom_expr Table to be shown.
     */
    public void setAtomExpr(AtomicQuery _atom_expr){atom_expr = _atom_expr;}

    /**
     * Executes the show command.
     */
    @Override public void execute(){
        System.out.println("Executing a show command");
        Project3.db.show(atom_expr.getRelationName());
    }
}
