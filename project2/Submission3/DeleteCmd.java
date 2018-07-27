import java.util.Vector;

/**
 * QueryPlan for the DELETE command.
 */

// delete-cmd ::= DELETE FROM relation-name WHERE condition
public class DeleteCmd extends QueryPlan {
    /**
     * The name of the table to be deleted.
     */
    private String table_name = "";

    /**
     * The conditions to check.
     */
    private Condition conditions = new Condition();

    /**
     * Table name setter.
     * @param name Name of the table.
     */
    public void setTableName(String name){table_name = name;}

    /**
     * Condition setter
     * @param _cond The condition.
     */
    public void setCondition(Condition _cond){conditions = _cond;}

    /**
     * Executes the DELETE command.
     */
    public void execute(){
        Project3.db.delete(table_name, conditions);
    }
}
