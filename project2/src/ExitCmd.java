/**
 * QueryPlan for the EXIT command.
 */

// exit-cmd ::= EXIT
public class ExitCmd extends QueryPlan {

    /**
     * Exits the program.
     */
    @Override public void execute(){
        System.out.println("Executing an exit command");
        Project3.db.exit();
    }
}
