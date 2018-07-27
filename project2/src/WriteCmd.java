/**
 * QueryPlan for the WRITE command.
 */

// write-cmd ::= WRITE relation-name
public class WriteCmd extends QueryPlan {

    /**
     * Name of the table being written to disk.
     */
    private String table_name = "";

    /**
     * Sets the name of the table to be written.
     * @param _name Table
     */
    public void setTableName(String _name){table_name=_name;}

    /**
     * Writes to file.
     */
    @Override public void execute(){
        System.out.println("Executing a write command");
        Project3.db.write(table_name);
    }
}
