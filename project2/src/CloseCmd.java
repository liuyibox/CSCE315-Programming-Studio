/**
 * Query plan for CLOSE command.
 */

// close-cmd ::= CLOSE relation-name
public class CloseCmd extends QueryPlan {
    /**
     * The name of the table to close.
     */
    private String table_name = "";

    /**
     * Sets the table name.
     * @param _name The name of the table.
     */
    public void setTableName(String _name){table_name=_name;}

    /**
     * Executes the CLOSE command for the given table.
     */
    @Override public void execute(){
        System.out.println("Executing a close command");
        Project3.db.close(table_name);

    }
}
