/**
 * QueryPlan for visiting contexts.
 */
import java.lang.*;

public class QueryPlan {
    //public Database db;
    /**
     * The name of the table (if needed)
     */
    private String table_name = "";


    /**
     * Sets the name of the table if needed.
     * @param new_name Name of the table.
     */
    public void setNewTableName(String new_name){table_name = new_name;}

    /**
     * Returns the name of the table if needed.
     * @return Name of the table.
     */
    public String getNewTableName(){return table_name;}
    //public Database getDatabase(){return db;}

    /**
     * Executes the plan for the QueryPlan.
     * Intended to be overwritten.
     */
    public void execute(){System.out.println("Executing");}
}
