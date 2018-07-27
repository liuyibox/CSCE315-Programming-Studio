/**
 * QueryPlan for visiting commands.
 */
public class CommandVisitor extends QueryPlan {

    /**
     * The QueryPlan for a command.
     */
    private QueryPlan cmd = new QueryPlan();


    /**
     * Sets the command.
     * @param _cmd the command
     */
    public void setCmd(QueryPlan _cmd){cmd = _cmd;}

    /**
     * Executes the command.
     */
    @Override public void execute(){
        //System.out.println("Executing a command");
        cmd.execute();
    }
}
