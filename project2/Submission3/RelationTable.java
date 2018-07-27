import java.util.Arrays;
import java.util.Vector;

/**
 * The RelationTable holds the data for each relation table.
 */
public class RelationTable {

    /**
     * The identifier of the RelationTable
     */
    private String relationName = "";

    /**
     * The names of the attributes.
     */
    private Vector<String> attributeNames = new Vector<>();

    /**
     * If each attribute is VARCHAR or INT.
     */
    private Vector<String> attributeTypes = new Vector<>();

    /**
     * The tuples of the relation table.
     */
    private Vector<Vector<String>> tuples = new Vector<>();

    /**
     * Which keys are primary keys.
     */
    private Vector<String> primaryKeys = new Vector<>();

    /**
     * Empty constructor.
     */
    public RelationTable(){}

    /**
     * Initializes identifier.
     * @param relationName The identifier for the table.
     */
    public RelationTable(String relationName){
        this.relationName = relationName;
    }

    /**
     * Initializes the identifier, attributes, and primary keys.
     * @param relationName The identifier.
     * @param attributes The attributes.
     * @param primaryKeys The primary key.
     */
    public RelationTable(String relationName, String[] attributes, String[] primaryKeys){
        this.tuples = new Vector<>();
        this.primaryKeys = new Vector<>();
        this.attributeNames = new Vector<>();
        this.attributeTypes = new Vector<>();

        this.relationName = relationName;
        this.primaryKeys.addAll(Arrays.asList(primaryKeys));

        //split the attribute elements by the space, set the first term to name
        //and the second element to type
        //if attributes[n] = "name VARCHAR(10)"
        // then attributeNames[n] = "name" and attributeTypes[n] = "VARCHAR(10)"
        try {
            for (String attribute : attributes) {
                String[] attributeArray = attribute.split(" ");
                attributeNames.add(attributeArray[0]);
                attributeTypes.add(attributeArray[1]);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Initializes the identifier, attributes, and primary keys.
     * @param relationName The identifier.
     * @param primaryKeys The primary key.
     * @param attributeNames The names of the attributes.
     * @param attributeTypes The types of the attributes.
     * @param primaryKeys The primary keys.
     */
    public RelationTable(String relationName, Vector<String> attributeNames, Vector<String> attributeTypes, String[] primaryKeys){
        this.tuples = new Vector<>();
        this.primaryKeys = new Vector<>();
        this.attributeNames = new Vector<>();
        this.attributeTypes = new Vector<>();

        this.relationName = relationName;
        this.primaryKeys.addAll(Arrays.asList(primaryKeys));
        this.attributeNames = attributeNames;
        this.attributeTypes = attributeTypes;
    }

    /**
     * Copies a RelationTable
     * @param other
     */
    public RelationTable(RelationTable other){
        this.relationName = other.getRelationName();
        this.attributeNames = other.getAttributeNames();
        this.tuples = other.getTuples();
        this.primaryKeys = other.getPrimaryKeys();
        this.attributeTypes = other.getAttributeTypes();
    }


    /**
     * Returns the number of tuples (entries) in the table
     */
    public int size(){
        return tuples.size();
    }

    /**
     * Inserts a tuple
     * @param tuple Tuple to be added.
     */
    public void insertTuple(Vector<String> tuple){
        tuples.add(tuple);
    }

    /**
     * Removes a tuple
     * @param tuple Tuple to be removed.
     */
    public void deleteTuple(Vector<String> tuple){
        tuples.remove(tuple);
    }

    //Getters and Setters

    /**
     * Gets the identifier for the table
     * @return The identifier.
     */
    public String getRelationName() { return relationName; }

    /**
     * Gets the tuples from the table.
     * @return The tuples.
     */
    public Vector<Vector<String>> getTuples() { return tuples; }

    /**
     * Gets the attribute name from the table.
     * @return The attribute names.
     */
    public Vector<String> getAttributeNames() { return attributeNames; }

    /**
     * Gets the primary keys from the table.
     * @return The primary keys.
     */
    public Vector<String> getPrimaryKeys() { return primaryKeys; }

    /**
     * Gets the attribute types from the table.
     * @return The attribute types.
     */
    public Vector<String> getAttributeTypes() { return attributeTypes; }

    /**
     * Sets the identifier for the table.
     * @param newName The new identifier.
     */
    public void setTableName(String newName) {relationName = newName;}

    /**
     * Sets the names for the columns.
     * @param attr_names The attribute names.
     */
    public void setAttributeNames(Vector<String> attr_names) {attributeNames = attr_names;}

    /**
     * Sets the primary keys for the table.
     * @param prim_keys The primary keys.
     */
    public void setPrimaryKeys(Vector<String> prim_keys) {primaryKeys = prim_keys;}

    /**
     * TODO: Sanitize size of attributeTypes?
     * Sets the attribute types for the table.
     * @param attributeTypes The new attribute types.
     */
    public void setAttributeTypes(Vector<String> attributeTypes) { this.attributeTypes = attributeTypes; }

    /**
     * Sets the new tuples for the table.
     * @param tuples The new tuples.
     */
    public void setTuples(Vector<Vector<String>> tuples) { this.tuples = tuples; }

    /**
     * Sets attribute name at an index
     * @param attribute The new attribute name.
     * @param loc Index of the attribute name.
     */
    public void setParticularAttribute(String attribute, int loc) {attributeNames.set(loc, attribute);}
}