/**
 * Created by Russell on 6/28/2017.
 */
import java.util.Arrays;
import java.util.Vector;

public class RelationTable {

    private String relationName;
    private Vector<String> attributeNames;
    private Vector<String> attributeTypes;
    private Vector<Vector<String>> tuples;
    private Vector<String> primaryKeys;

    public RelationTable(){
        this.relationName = "";
        this.attributeNames = new Vector<>();
        tuples = new Vector<>();
        this.primaryKeys = new Vector<>();
        this.attributeTypes = new Vector<>();
    }

    public RelationTable(String relationName){
        this.relationName = relationName;
        this.attributeNames = new Vector<>();
        tuples = new Vector<>();
        this.primaryKeys = new Vector<>();
        this.attributeTypes = new Vector<>();
    }

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

    // copy constructor
    public RelationTable(RelationTable other){
        this.relationName = other.getRelationName();
        this.attributeNames = other.getAttributeNames();
        this.tuples = other.getTuples();
        this.primaryKeys = other.getPrimaryKeys();
        this.attributeTypes = other.getAttributeTypes();
    }

    //TODO: ad a destructor and do soemthing useful with it

    //returns the number of tuples (entries) in the table
    public int size(){
        return tuples.size();
    }

    public void insertTuple(Vector<String> tuple){
        tuples.add(tuple);
    }

    public void deleteTuple(Vector<String> tuple){
        tuples.remove(tuple);
    }

    //Getters and Setters
    public String getRelationName() { return relationName; }
    public Vector<Vector<String>> getTuples() { return tuples; }
    public Vector<String> getAttributeNames() { return attributeNames; }
    public Vector<String> getPrimaryKeys() { return primaryKeys; }
    public Vector<String> getAttributeTypes() { return attributeTypes; }


    public void setTableName(String newName) {relationName = newName;}
    public void setAttributeNames(Vector<String> attr_names) {attributeNames = attr_names;}
    public void setPrimaryKeys(Vector<String> prim_keys) {primaryKeys = prim_keys;}
    public void setAttributeTypes(Vector<String> attributeTypes) { this.attributeTypes = attributeTypes; }
    public void setTuples(Vector<Vector<String>> tuples) { this.tuples = tuples; }
    public void setParticularAttribute(String attribute, int loc) {attributeNames.set(loc, attribute);}
}
