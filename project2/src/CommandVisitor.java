/**
 * QueryPlan for visiting commands.
 */
public class CommandVisitor extends QueryPlan {
    private QueryPlan cmd = new QueryPlan();

    public void setCmd(QueryPlan _cmd){cmd = _cmd;}

    @Override public void execute(){
        System.out.println("Executing a command");
        cmd.execute();
    }
}
