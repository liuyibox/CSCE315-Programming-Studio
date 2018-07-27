/**
 * QueryPlan for the EXIT command.
 */

// exit-cmd ::= EXIT
public class ExitCmd extends QueryPlan {

    /**
     * Exits the program.
     */
    @Override public void execute(){
        Project3.db.exit();
    }
}
