import java.util.Vector;

/**
 * QueryPlan for the INSERT INTO command.
 */

// insert-cmd ::= INSERT INTO relation-name VALUES FROM ( literal { ,  literal } ) | INSERT INTO relation-name VALUES FROM RELATION expr
public class InsertCmd extends QueryPlan {
    /**
     * The name of the table to insert into.
     */
    private String table_name = "";

    /**
     * The attributes for the tuple you are inserting.
     */
    private Vector<String> attributes = new Vector<>();

    /**
     * Sets the name of the table to be inserted into.
     * @param name The Table.
     */
    public void setTableName(String name){table_name = name;}

    /**
     * Adds the attributes for the tuple(s) to the plan.
     * @param attr The attributes.
     */
    public void addAttribute(String attr){attributes.add(attr);}

    /**
     * Executes the INSERT function.
     */
    public void execute(){
        System.out.println("Executing an insert command");
        String[] attr_array = attributes.toArray(new String[attributes.size()]);
        Project3.db.insert(table_name, attr_array);
        Project3.db.show(table_name);
    }
}
