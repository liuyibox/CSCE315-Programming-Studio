import java.util.*;

/**
 * QueryPlan for the CREATE command.
 */

// create-cmd ::= CREATE TABLE relation-name ( typed-attributelist ) PRIMARY KEY ( attribute-list )
public class CreateCmd extends QueryPlan {
    /**
     * Name of table to be created.
     */
    private String table_name = "";

    /**
     * List of attributes for the new table.
     */
    private Vector<String> attributes = new Vector<>();

    /**
     * List of primary keys for the new table.
     */
    private Vector<String> primary_keys = new Vector<>();

    /**
     * Table name setter.
     * @param name Table name.
     */
    public void setTableName(String name){table_name = name;}

    /**
     * Adds attributes to the attribute list.
     * @param attr Attribute to be added.
     */
    public void addAttribute(String attr){attributes.add(attr);}

    /**
     * Adds primary key to the primary key list.
     * @param key The key to be added.
     */
    public void addPrimaryKey(String key){primary_keys.add(key);}

    /**
     * Executes the CLOSE command.
     */
    public void execute(){
        System.out.println("Executing a create command");
        String[] attr_array = attributes.toArray(new String[attributes.size()]);
        String[] primkey_array = primary_keys.toArray(new String[primary_keys.size()]);
        Project3.db.create(table_name, attr_array, primkey_array);
    }


}
