import java.util.Vector;

/**
 * Created by ellie on 7/2/2017.
 */

// update-cmd ::= UPDATE relation-name SET attribute-name = literal { , attribute-name = literal } WHERE condition

/**
 * QueryPlan for the UPDATE command.
 */
public class UpdateCmd extends QueryPlan {

    /**
     * Name of the table to update.
     */
    private String table_name = "";

    /**
     * The attributes to update with.
     */
    private Vector<String> attributes = new Vector<>();

    /**
     * The literals that will be updated.
     */
    private Vector<String> literals = new Vector<>();

    /**
     * Conditions to be checked against for updating.
     */
    private Condition conditions = new Condition();

    /**
     * Sets the table name to execute on.
     * @param name The table name.
     */
    public void setTableName(String name){table_name = name;}

    /**
     * Adds the attributes to add.
     * @param attr The attributes.
     */
    public void addAttribute(String attr){attributes.add(attr);}

    //public void addLiteral(String lit){literals.add(lit);} //TODO: unused

    /**
     * Sets the condition for the command.
     * @param _cond
     */
    public void setCondition(Condition _cond){conditions = _cond;}

    /**
     * Executes the UPDATE Command.
     */
    @Override public void execute(){
        //System.out.println("Executing an update command");
        String[] attr_array = attributes.toArray(new String[attributes.size()]);
        String[] lit_array = literals.toArray(new String[literals.size()]);
        Project3.db.update(table_name, attr_array, lit_array, conditions);
        //Project3.db.show(table_name);
    }
}
