/**
 * Created by Russell Pier on 6/28/2017.
 */
import javax.management.relation.RelationType;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.*;
import java.lang.*;

//TODO: update to support multiple primary key look-up
public class Database {

    private Hashtable<String,RelationTable> memory;

    Database(){
        memory = new Hashtable<>();
    }

    public Hashtable<String,RelationTable> getMemory() {
        return memory;
    }

    //Common function used by many command functions
    private RelationTable findRelationIndex(String relationName){
        return memory.get(relationName);
    }

    //TODO: update so that it can look up multiple keys and check against all keys
    //common function to find the index of the first instance of a particular entry to a particular table
//    private int findFirstEntryIndex(String relationName, String primaryKey){
//        int entryIndex = -1;
//        int relationIndex = findRelationIndex(relationName);
//
//        try {
//            if (relationIndex == -1) {
//                throw new Exception("The relation '" + relationName + "' Does Not Exist In The Memory.");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        RelationTable relation = memory.get(relationIndex);
//        for(int i=1;i<relation.size(); ++i){
//            if (relation.get(i).get(0) == primaryKey) {
//                entryIndex = i;
//            }
//        }
//
//        return entryIndex;
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 COMMAND FUNCTIONS                                              //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //load a relation table into memory
    public void open(String relationName){
        String fileName = "db\\" + relationName + ".db";

        try(BufferedReader br = new BufferedReader(new FileReader((fileName)))){
            File file = new File(fileName);
            if(!file.exists() || file.isDirectory()) {
                throw new Exception("In 'open': The Relation '" + relationName + "' Does Not Exist Or Is Empty. To Create It, Run Create");
            }

            String line;

            //first line goes into attributeNames
            line = br.readLine();
            Vector<String> attributeNames = new Vector<String>(Arrays.asList(line.split(",")));

            //second line goes into
            line = br.readLine();
            Vector<String> attributeTypes = new Vector<String>(Arrays.asList(line.split(",")));

            //Third line are primary keys
            line = br.readLine();
            String[] primaryKeys = line.split(",");

            //create relation table
            RelationTable relation = new RelationTable(relationName, attributeNames, attributeTypes, primaryKeys);
            String[] lineArray;

            while((line = br.readLine()) != null){
                lineArray = line.split(",");
                Vector<String> tuple = new Vector<>();

                tuple.addAll(Arrays.asList(lineArray));
                relation.insertTuple(tuple);
            }
            memory.put(relationName,relation);
        } catch (Exception e) {
            System.out.println("Open: " + relationName+ " -> " + e);
        }
    }




    //delete a relation table from memory
    public void close(String relationName){
        try {
            memory.remove(relationName);
        } catch(Exception e){
            System.out.println(e);
        }
    }




    //write a relation table from memory to a db file
    public void write(String relationName){
        try{
            System.out.println("Attempting to write: " + relationName);
            RelationTable relation = findRelationIndex(relationName);
            if(relation == null) {
                throw new Exception("Relation does not exist.");
            }
            String fileName = "db\\" + relationName + ".db";
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName), false));

            String text = "";

            //write attribute names
            for(String name : relation.getAttributeNames()){
                text += name + ",";
            }
            text = text.substring(0, text.length()-1);
            text += "\n";

            //write attribute names
            for(String type : relation.getAttributeTypes()){
                text += type + ",";
            }
            text = text.substring(0, text.length()-1);
            text += "\n";

            //write primaryKeys
            for(String key : relation.getPrimaryKeys()){
                text += key + ",";
            }
            text = text.substring(0, text.length()-1);
            text += "\n";

            //write tuples
            for(Vector<String> tuple : relation.getTuples()){
                for(String cell : tuple){
                    text += cell + ",";
                }
                text = text.substring(0, text.length()-1);
                text += "\n";
            }
            text = text.substring(0, text.length()-1);


            writer.println(text);
            writer.close();

        } catch(Exception e){
            System.out.println(e);
        }

    }




    public void exit(){
        System.out.println("Exiting database...");
        System.exit(0);
    }




    //Print a relation to the console
    public void show(String relationName){
        try {
            RelationTable table = findRelationIndex(relationName);

            System.out.println("\n");
            System.out.println("Relation Name:\t" + table.getRelationName());
            System.out.println("Primary Keys:\t" + table.getPrimaryKeys());
            System.out.println("Attribute Names:" + table.getAttributeNames());
            System.out.println("Attribute Types:" + table.getAttributeTypes());
            for(Vector<String> tuple : table.getTuples()){
                System.out.print("\t\t\t\t");
                System.out.println(tuple);
            }
            System.out.println("\n");

        } catch(Exception e){
            System.out.println("Show: " + relationName + " -> " + e);
        }
    }




    //check to see if relation table all ready exists, if not, create one in the 'memory'
    //TODO: check for a relation in memory, but not the database
    public void create(String relationName, String[] attributes, String[] primaryKeys) {
        String fileName = "db\\" + relationName + ".db";
        File file = new File(fileName);

        try{
            if (file.exists()){
                throw new IOException("Relation '" +  relationName + "' Already Exists. To Load Call Open");
            }
            RelationTable relation = new RelationTable(relationName, attributes, primaryKeys);
            memory.put(relationName, relation);
        } catch (IOException e) {
            System.out.println("Create: " + relationName + " -> " + e);
        }
    }

    // TODO uncomment evalCondition when available
    //update a particular attribute of a particular tuple of a particular relation
    public void update(String table_name, String[] attr_names, String[] new_literals, String[] conditions){
        RelationTable current = findRelationIndex(table_name);

        // grab indices of tuples where condition is satisfied for update to occur
        Integer[] indices = new Integer[]{0,2,4};
        // indices = evalConditions(current, conditions);
        
        // add attribute indices for where in the tuple each attribute is located
        Vector<Integer> attr_indices = new Vector<Integer>();
        for(int i=0; i<current.getAttributeNames().size(); ++i){
            for(int j=0; j<attr_names.length; ++j) {
                if (current.getAttributeNames().get(i).equals(attr_names[j])) {
                    attr_indices.add(i);
                }
            }
        }
        
        // iterate through all tuples to find indices where update will occur
        Vector<Vector<String>> current_tuples = current.getTuples();
        for(int i=0; i<current_tuples.size(); ++i){
            Vector<String> single = current_tuples.get(i);

            for(int j=0; j<indices.length; ++j){
                if(i == indices[j]){
                    for(int k=0; k<attr_names.length; ++k){
                        single.setElementAt(new_literals[k], attr_indices.get(k));
                    }
                }
            }
        }

    }


    //inset an entry into a particular relation
    //check to make sure the relation you are inserting into exists
    //check to make  sure the fields match
    public void insert(String relationName, String... attributes){
        try{
            RelationTable table = findRelationIndex(relationName);
            if(table.getAttributeNames().size() != attributes.length)
                throw new Exception("Fields do not match");
            Vector<String> newTuple = new Vector<>();
            newTuple.addAll(Arrays.asList(attributes));
            table.insertTuple(newTuple);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }



    //TODO: add exception checking
    //delete a particular tuple of a particular relation
    public void delete(String relationName, int[] indicies /*, String[] condition*/){

        //int[] indicies = evaluateCondition(table, condition);

        for(int index : indicies){
            memory.get(relationName).getTuples().remove(index);
        }
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 QUERY FUNCTIONS                                               //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // TODO uncomment evalCondition when available
    // select will create a new table based on which tuples satisfy a particular condition
    public void select(String new_table_name, String[] conditions, String current_table_name){
        RelationTable new_table = new RelationTable(new_table_name);
        RelationTable current = findRelationIndex(current_table_name);

        // old attributes, attribute types, and primary keys are all the same
        new_table.setAttributeNames(current.getAttributeNames());
        new_table.setAttributeTypes(current.getAttributeTypes());
        new_table.setPrimaryKeys(current.getPrimaryKeys());

        // iterate through old table and pull out satisfactory tuples
        Integer[] indices = new Integer[]{0,2,4};
        // indices = evalCondition(current, conditions);
        Vector<Vector<String>> new_tuples = new Vector<Vector<String>>();
        Vector<Vector<String>> curr_tuples = current.getTuples();

        for(int i=0; i<curr_tuples.size(); ++i){
            for(int j=0; j<indices.length; ++j){
                if(i == indices[j]){
                    new_tuples.add(curr_tuples.get(i));
                }
            }
        }

        new_table.setTuples(new_tuples);

        memory.put(new_table_name, new_table);

    }

   // project will grab columns of attribute names and return new table
    public void project(String new_table_name, Vector<String> attributes, String table_name){
        RelationTable new_table = new RelationTable(new_table_name);
        RelationTable current = findRelationIndex(table_name);

        // assume primary keys don't change from passed table to new table
        new_table.setPrimaryKeys(current.getPrimaryKeys());

        Vector<String> current_attrs = current.getAttributeNames();
        Vector<String> current_attr_types = current.getAttributeTypes();
        Vector<String> attr_types = new Vector<String>(attributes.size());
        Vector<Integer> indices = new Vector<Integer>(attributes.size());

        // for loop to compare attributes of current table with
        // projection attributes and grab types for attr_types vector
        for(int i=0; i<current_attrs.size(); ++i){
            for(int j=0; j<attributes.size(); ++j){
                if(current_attrs.get(i).equals(attributes.get(j))){
                    attr_types.add(current_attr_types.get(i));
                    indices.add(i);
                }
            }
        }

        // grab desired components from the tuples of current table
        Vector<Vector<String>> new_tuples = new Vector<Vector<String>>();
        Vector<Vector<String>> current_tuples = current.getTuples();
        for(int i=0; i<current_tuples.size(); ++i){
            Vector<String> new_single_tuple = new Vector<String>();
            for(int j=0; j<current_tuples.get(i).size(); ++j){
                for(int k=0; k<indices.size(); ++k){
                    if(j == indices.get(k)){
                        new_single_tuple.add(current_tuples.get(i).get(j));
                    }
                }
            }
            new_tuples.add(new_single_tuple);
        }


        new_table.setAttributeNames(attributes);
        new_table.setTuples(new_tuples);
        new_table.setAttributeTypes(attr_types);

        memory.put(new_table_name, new_table);
    }

    // rename table's current attribute names with those provided
    public void rename(String table_name, Vector<String> updated_names){
        RelationTable current = findRelationIndex(table_name);
        current.setAttributeNames(updated_names);
    }

    // unions two tables together and saves in memory under new_table_name
    public void union(String new_table_name, String _table1, String _table2){
        RelationTable new_table = new RelationTable();
        RelationTable table1 = findRelationIndex(_table1);
        RelationTable table2 = findRelationIndex(_table2);

        // verifying tables have same number of attributes
        int attr1 = table1.getAttributeNames().size();
        int attr2 = table2.getAttributeNames().size();
        if (attr1 != attr2){
            System.out.println("Cannot perform union: varying amounts of attributes.");
            return;
        }

        // verifying the attributes are listed in the same order
        Vector<String> table1_attr_names = table1.getAttributeNames();
        Vector<String> table2_attr_names = table2.getAttributeNames();
        Vector<String> table1_attr_types = table1.getAttributeTypes();
        Vector<String> table2_attr_types = table2.getAttributeTypes();
        for(int i=0; i<attr1; ++i){
            if(!(table1_attr_names.get(i).equals(table2_attr_names.get(i))) ||
                    !(table1_attr_types.get(i).equals(table2_attr_types.get(i)))){
                System.out.println("Cannot perform union: attribute orders do not match");
                return;
            }
        }

        // adding common attributes to new_table
        new_table.setAttributeNames(table1_attr_names);
        new_table.setAttributeTypes(table1_attr_types);
        //new_table.setAttributeTypes(table1.getAttributeTypes());

        // assuming that the left hand table has priority,
        // assign new_table to have table1 primary keys
        new_table.setPrimaryKeys(table1.getPrimaryKeys());
        
        // completing the union by adding all of table1 to new table
        // then adding the elements of table2 that don't overlap
        Vector<Vector<String>> table1_tuples = table1.getTuples();
        Vector<Vector<String>> table2_tuples = table2.getTuples();
        for(int i=0; i<table1_tuples.size(); ++i){
            new_table.insertTuple(table1_tuples.get(i));
        }

        // compare elements from table2 to elements in new_table before adding
        Vector<Vector<String>> new_table_tuples = new_table.getTuples();
        for(int i=0; i<table2_tuples.size(); ++i){
            Vector<String> curr_tuple = table2_tuples.get(i);
            boolean alreadyAdded = false;

            for(int j=0; j<new_table_tuples.size(); ++j){
                if(curr_tuple == new_table_tuples.get(i)){
                    alreadyAdded = true;
                    break;
                }
            }

            if(alreadyAdded == false) { // current tuple is not in the new_table
                new_table.insertTuple(curr_tuple);
            }
        }

        new_table.setTableName(new_table_name);

        memory.put(new_table_name, new_table);
    }

    // difference removes tuples from table1 that are in table2
    public void difference(String new_table_name, String _table1, String _table2){
        // set new_table to be table1 then delete tuples as
        // they match tuples in table2
        RelationTable table1 = findRelationIndex(_table1);
        RelationTable new_table = new RelationTable(table1);
        new_table.setTableName(new_table_name);
        RelationTable table2 = findRelationIndex(_table2);

        // verifying tables have same number of attributes
        int attr1 = table1.getAttributeNames().size();
        int attr2 = table2.getAttributeNames().size();
        if (attr1 != attr2){
            System.out.println("Cannot perform difference: varying amounts of attributes.");
            return;
        }

        // verifying the attributes are listed in the same order
        Vector<String> table1_attrs = table1.getAttributeNames();
        Vector<String> table2_attrs = table2.getAttributeNames();
        for(int i=0; i<attr1; ++i){
            if(!(table1_attrs.get(i).equals(table2_attrs.get(i)))){
                System.out.println("Cannot perform difference: attribute orders do not match");
                return;
            }
        }

        // delete tuples from new_table when they match tuples in table2
        Vector<Vector<String>> table2_tuples = table2.getTuples();

        // assume table1 has been correctly input as the larger table
        for(int i=0; i<table2_tuples.size(); ++i){
            for(int j=0; j<new_table.getTuples().size(); ++j){
                if(table2_tuples.get(i) == new_table.getTuples().get(j)){
                    new_table.deleteTuple(new_table.getTuples().get(j));
                }
            }
        }

        memory.put(new_table_name, new_table);
    }

    // product will calculate Cartesian product of two tables
    public void product(String new_table_name, String _table1, String _table2) {
        RelationTable new_table = new RelationTable();
        RelationTable table1 = findRelationIndex(_table1);
        RelationTable table2 = findRelationIndex(_table2);

        // verifying the attributes are different in each table
        // and renaming if necessary
        Vector<String> table1_attrs = table1.getAttributeNames();
        Vector<String> table2_attrs = table2.getAttributeNames();

        for (int i = 0; i<table1_attrs.size(); ++i) {
            for(int j=0; j<table2_attrs.size(); ++j) {
                if (table1_attrs.get(i).equals(table2_attrs.get(j))) {
                    table1.setParticularAttribute(table1.getRelationName() + "_" + table1_attrs.get(i), i);
                    table2.setParticularAttribute(table2.getRelationName() + "_" + table2_attrs.get(j), j);
                }
            }
        }

        // assuming that the left hand table has priority,
        // assign new_table to have table1 primary keys
        new_table.setPrimaryKeys(table1.getPrimaryKeys());

        // combining attribute names and attribute types to one table
        Vector<String> new_attributes = new Vector<String>();
        Vector<String> new_attr_types = new Vector<String>();

        new_attributes.addAll(table1.getAttributeNames());
        new_attributes.addAll(table2.getAttributeNames());
        new_attr_types.addAll(table1.getAttributeTypes());
        new_attr_types.addAll(table2.getAttributeTypes());

        new_table.setAttributeNames(new_attributes);
        new_table.setAttributeTypes(new_attr_types);

        // actually calculating Cartesian product between two tables
        Vector<Vector<String>> new_tuples = new Vector<Vector<String>>();
        Vector<Vector<String>> table1_tuples = table1.getTuples();
        Vector<Vector<String>> table2_tuples = table2.getTuples();
        for(int i=0; i<table1_tuples.size(); ++i){
            for(int j=0; j<table2_tuples.size(); ++j){
                Vector<String> new_single_tuple = new Vector<String>();
                new_single_tuple.addAll(table1_tuples.get(i));
                new_single_tuple.addAll(table2_tuples.get(j));
                new_tuples.add(new_single_tuple);
            }
        }

        new_table.setTuples(new_tuples);
        new_table.setTableName(new_table_name);

        memory.put(new_table_name, new_table);

    }

    //TODO IF TIME PERMITS
    public void naturalJoin(){}


     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                    MAIN                                                       //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        //create new database
        Database db1 = new Database();

        //Open the relation. If it does not exist, then will throw an exception
        db1.open("animals");
        db1.open("people");
        db1.show("animals");

        //Test the create. Should throw exception if relation already exists.
        db1.create("species", new String[]{"kind VARCHAR"}, new String[]{"kind"});
        db1.create("animals", new String[]{"name VARCHAR", "kind VARCHAR", "years INT"}, new String[]{"name"});
        db1.show("species");
        db1.show("animals");

        //Test the insert, should throw exception if relation does not exist, or if fields do not match
        db1.insert("species", "dog");
        db1.insert("animals", "Joe", "cat", "4", "black");
        db1.insert("animals", "Benny", "dog", "5");
        db1.show("species");
        db1.show("animals");

        //Test the delete
        db1.delete("animals", new int[]{6,7});

        //Test the write. Should throw exception if relation does not exist
        db1.write("animals");
        db1.write("people");

        //Test the close, if does not exist, should throw exception
        db1.close("animals");
        db1.close("people");

        //Test the union. Should combine cats and dogs
        db1.create("cats",new String[]{"name VARCHAR","kind VARCHAR"},new String[]{"name"});
        db1.create("dogs",new String[]{"name VARCHAR","kind VARCHAR"},new String[]{"name"});
        db1.insert("cats", "Jack","cat");
        db1.insert("cats", "Buttons","cat");
        db1.insert("dogs","Hamilton","dog");
        db1.insert("dogs", "Buttons","dog");
        db1.insert("dogs", "Charles","dog");
        db1.show("cats");
        db1.show("dogs");
        db1.union("cats_or_dogs", "cats", "dogs");
        db1.show("cats_or_dogs");

        //Test the rename. Should rename attributes name and kind to aname and akind
        db1.rename("cats", new Vector<String>(Arrays.asList("aname","akind")));
        db1.show("cats");
        db1.rename("cats", new Vector<String>(Arrays.asList("name","kind")));
        db1.show("cats");

        //Test the projection. New table of dogs should only have name, not kind
        db1.project("dog_names",new Vector<String>(Arrays.asList("name")),"dogs");
        db1.show("dog_names");

        //Further projection testing. New table outputs only name and kind of the zoo animals
        db1.create("zoo",new String[]{"name VARCHAR","age INTEGER","kind VARCHAR"},new String[]{"name"});
        db1.insert("zoo","Wally","5","Kangaroo");
        db1.insert("zoo","Jack","15","Elephant");
        db1.insert("zoo","Julia","7","Lioness");
        db1.project("name_and_kind",new Vector<String>(Arrays.asList("name","kind")),"zoo");
        db1.show("name_and_kind");

        //Testing the difference. Should output a table with only dogs
        db1.difference("dogs_only", "cats_or_dogs","cats");
        db1.show("dogs_only");

        //Testing the product. Should output a table with dogs and all fur options
        //Should rename attributes to specify dogs_kind and fur_kind
        db1.create("furs", new String[]{"color VARCHAR","kind VARCHAR"}, new String[]{"color"});
        db1.insert("furs","golden","fine");
        db1.insert("furs","black","fluffy");
        db1.product("dogs_and_furs","dogs","furs");
        db1.show("dogs_and_furs");

        //Testing the select. Should output a table with dogs with only golden fur
        db1.select("dogs_with_gold_fur", new String[]{"color","golden","=="}, "dogs_and_furs");
        db1.show("dogs_with_gold_fur");
        
        //Testing the update. Should output a table where golden fur now means golden retriever
        db1.update("dogs_and_furs", new String[]{"color"}, new String[] {"yellow"}, new String[]{"color","golden","=="});
        db1.show("dogs_and_furs");

    }
}
