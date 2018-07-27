/**
 * QueryPlan for the OPEN command.
 */

// open-cmd ::= OPEN relation-name
public class OpenCmd extends QueryPlan {
    /**
     * Name of the .db to open.
     */
    private String table_name = "";

    /**
     * Sets the table name.
     * @param _name The name of the table.
     */
    public void setTableName(String _name){table_name=_name;}

    /**
     * Executes the open command.
     * @Override
     */
    public void execute(){
        System.out.println("Executing an open command");
        Project3.db.open(table_name);

    }
}
