/**
 * This class contains the database implementation and command and query
 * methods associated.
 */

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

    /**
     *  A hashtable containing String keys and RelationTable values.
     *  Serves as the container for the database's RelationTables at runtime.
     */
    private Hashtable<String,RelationTable> memory;

    /**
     * Initializes an empty Hashtable in constructor.
     */
    public Database(){
        memory = new Hashtable<>();
    }

    /**
     * Used to access a specific RelationTable at runtime by looking
     * up the relationName key from memory.
     */
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

    /**
     * Opens a database (.db) file from the system and loads into the memory hashtable.
     * @param relationName The name of the file that is being added to the hashtable.
     */
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

    /**
     * Removes a given RelationTable from the memory Hashtable
     * @param relationName the name of the RelationTable to be closed.
     */
    public void close(String relationName){
        try {
            memory.remove(relationName);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Writes a given RelationTable to disk.
     * @param relationName The RelationTable to be written.
     */
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

    /**
     * Exits the program.
     */
    public void exit(){
        System.out.println("Exiting database...");
        System.exit(0);
    }

    /**
     * Prints a given RelationTable to the console.
     * @param relationName the table to be printed.
     */
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


    /**
     * Checks if a RelationTable already exists, and if not, creates one in
     * the main Hashtable
     *
     */
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

    /**
     * Determines which elements of a relationTable match against a condition.
     * @param table The RelationTable to be checked against
     * @param conditionTree The conditions to be used for checking.
     * @return The indices which match the condition.
     */
    public int[] conditionFunction(RelationTable table, Condition conditionTree){

        Set<Integer> tupleIndexSet = new HashSet<>();

        if (conditionTree.conjuncVec.size() == 0) {
            System.out.println("There are no conjunctions at all");
            return null;
        }
        //traverse the condition tree
        //for every conjunction
        for(int k = 0; k < conditionTree.conjuncVec.size(); k++){

            List<Integer> tupleIndexList = new LinkedList<Integer>();

            Conjunction conjunction = conditionTree.conjuncVec.get(k);
            if (conjunction.compareVec.size() == 0) {
                System.out.println("There are no Comparisons at all");
                return null;
            }

            // for every conjunction, we need to deal with the first comparison first;
            Comparison comparison1 = conjunction.compareVec.get(0);
            //String attr_name1 = "";
            int attr_index1 = 0;
            String operand1_1 = comparison1.getOperand1();
            for(int p = 0; p < table.getAttributeNames().size(); p++){
                if((table.getAttributeNames().get(p)).equals(operand1_1)){
                    attr_index1 = p;
                    //attr_name1 = operand1_1;
                    break;
                }
            }
            String operand2_1 = comparison1.getOperand2();
            //String operand2_1_type = table.getAttributeTypes().get(attr_index1);

            //after we get the attribute name, we traverse the table
            for(int q = 0; q < table.getTuples().size(); q++){
                Vector<String> tuple = table.getTuples().get(q);
                String operand2_1_InTable = tuple.get(attr_index1).replace(" ","");
                String operation = comparison1.getOperation();
                switch(operation){
                    case "==": if(operand2_1_InTable.equals(operand2_1)) tupleIndexList.add(q);
                        break;
                    case "!=": if(!operand2_1_InTable.equals(operand2_1)) tupleIndexList.add(q);
                        break;
                    case ">" : if(Integer.parseInt(operand2_1_InTable) > Integer.parseInt(operand2_1)) tupleIndexList.add(q);
                        break;
                    case "<" : if(Integer.parseInt(operand2_1_InTable) < Integer.parseInt(operand2_1)) tupleIndexList.add(q);
                        break;
                    case ">=": if(Integer.parseInt(operand2_1_InTable) >= Integer.parseInt(operand2_1)) tupleIndexList.add(q);
                        break;
                    case "<=": if(Integer.parseInt(operand2_1_InTable) <= Integer.parseInt(operand2_1)) tupleIndexList.add(q);
                        break;
                }
            }

            if(conjunction.compareVec.size() > 1) {
                for (int j = 1; j < conjunction.compareVec.size(); j++) {

                    List<Integer> tempIndexList = new LinkedList<>();

                    Comparison comparison = conjunction.compareVec.get(j);
                    int attr_index = 0;
                    String operand1 = comparison.getOperand1();
                    for (int p = 0; p < table.getAttributeNames().size(); p++) {
                        if (table.getAttributeNames().get(p).equals(operand1)) {
                            attr_index = p;
                            break;
                        }
                    }

                    //here we extract the corresponding tuple
                    String operand2 = comparison.getOperand2();
                    for(int q : tupleIndexList ){
                        Vector<String> tuple = table.getTuples().get(q);
                        String operand2_InTable = tuple.get(attr_index);
                        switch(comparison.getOperation()){
                            case "==": if(operand2_InTable.equals(operand2)) tempIndexList.add(q);
                                break;
                            case "!=": if(!operand2_InTable.equals(operand2)) tempIndexList.add(q);
                                break;
                            case ">" : if(Integer.parseInt(operand2_InTable) > Integer.parseInt(operand2)) tempIndexList.add(q);
                                break;
                            case "<" : if(Integer.parseInt(operand2_InTable) < Integer.parseInt(operand2)) tempIndexList.add(q);
                                break;
                            case ">=": if(Integer.parseInt(operand2_InTable) >= Integer.parseInt(operand2)) tempIndexList.add(q);
                                break;
                            case "<=": if(Integer.parseInt(operand2_InTable) <= Integer.parseInt(operand2)) tempIndexList.add(q);
                                break;
                        }
                    }
                    tupleIndexList = tempIndexList;
                }
            }

            for(Integer i : tupleIndexList){
                tupleIndexSet.add(i);
            }
        }

        int[] returnIndices = new int[tupleIndexSet.size()];
        int count = 0;
        for(int index : tupleIndexSet){
            returnIndices[count++] = index;
        }
        return returnIndices;
    }


    // TODO uncomment evalCondition when available
     /**
     * Updates a tuple's attributes if it meets given conditions.
     * @param relationName The name of the table to modify.
     * @param attr_names The names of the the attributes to be modified.
     * @param new_literals The new attributes to be assigned.
     * @param conditionTree The conditions to be checked against.
     */
    public void update(String relationName, String[] attr_names, String[] new_literals, Condition conditionTree){
        RelationTable current = findRelationIndex(relationName);

        // grab indices of tuples where condition is satisfied for update to occur
        int[] indices = conditionFunction(current, conditionTree);

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


    //insert an entry into a particular relation
    //check to make sure the relation you are inserting into exists
    //check to make  sure the fields match

    /**
     * Inserts an attribute into a RelationTable if the fields match and
     * table exists.
     * @param relationName The name of the RelationTable to insert into.
     * @param attributes The attributes to be inserted.
     */
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

    /**
     * Deletes tuples that meet conditions in a given RelationTable.
     * @param relationName The RelationTable to be checked against.
     * @param conditionTree The conditions to check with.
     */
    public void delete(String relationName, Condition conditionTree){
        RelationTable table = findRelationIndex(relationName);
        int[] indicies = conditionFunction(table, conditionTree);

        for(int index : indicies){
            memory.get(relationName).getTuples().remove(index);
        }
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                 QUERY FUNCTIONS                                               //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // TODO uncomment evalCondition when available
    // select will create a new table based on which tuples satisfy a particular condition

    /**
     * Creates a RelationTable with tuples that match given conditions in an existing
     * table.
     * @param new_table_name The name of the RelationTable to be created.
     * @param conditions The conditions to check with.
     * @param current_table_name The RelationTable to check against.
     */
    public void select(String new_table_name, Condition conditions, String current_table_name){
        RelationTable new_table = new RelationTable(new_table_name);
        RelationTable current = findRelationIndex(current_table_name);

        // old attributes, attribute types, and primary keys are all the same
        new_table.setAttributeNames(current.getAttributeNames());
        new_table.setAttributeTypes(current.getAttributeTypes());
        new_table.setPrimaryKeys(current.getPrimaryKeys());

        // iterate through old table and pull out satisfactory tuples
        int[] indices = conditionFunction(current, conditions);
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


    /**
     * Will create a new table with the selected attributes of an existing table.
     * @param new_table_name The name of the RelationTable to be created.
     * @param attributes Which attributes to be included in the new RelationTable.
     * @param table_name The name of the table to pull attributes from.
     */
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
    /**
     * Replaces a RelationTable's attribute names with new ones.
     * @param current_table The name of the RelationTable to modify.
     * @param updated_names The attribute names that will replace existing ones.
     * @param new_table_name The new name of the table.
     */

    public void rename(String new_table_name, Vector<String> updated_names, String current_table){
        RelationTable current = findRelationIndex(current_table);
        RelationTable new_table = new RelationTable(current);
        new_table.setTableName(new_table_name);
        new_table.setAttributeNames(updated_names);
        memory.put(new_table_name, new_table);
    }



    // unions two tables together and saves in memory under new_table_name

    /**
     * Creates a new RelationTable that combines entries from two existing tables.
     * @param new_table_name The name of the new RelationTable.
     * @param _table1 The name of the first table to be joined.
     * @param _table2 The name of the second table to be joined.
     */
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

    /**
     * Creates a new RelationTable that has tuples exclusively in the first table
     * and not the second table.
     * @param new_table_name The name of the new table to be created.
     * @param _table1 The name of the table to pull exclusive tuples from.
     * @param _table2 The name of the table to check for similar tuples from.
     */
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

    /**
     * Creates a name RelationTable that is the Cartesian product of two tables.
     * @param new_table_name The name of the new table.
     * @param _table1 The name of the first original table
     * @param _table2 The name of the second original table.
     */
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



    // natural-join combines two tables with common attributes and deletes overlap

    /**
     * Creates a new RelationTable with only similar attributes and nothing
     * unique.
     * @param new_name The name of the new RelationTable.
     * @param table_name1 The name of the first original table.
     * @param table_name2 The name of the second original table.
     */
    public void naturalJoin(String new_name, String table_name1, String table_name2){

        RelationTable new_table = new RelationTable();
        RelationTable table1 = findRelationIndex(table_name1);
        RelationTable table2 = findRelationIndex(table_name2);

        Vector<String> attributeNames1 = table1.getAttributeNames();
        Vector<String> attributeNames2 = table2.getAttributeNames();
        Vector<String> attributeTypes1 = table1.getAttributeTypes();
        Vector<String> attributeTypes2 = table2.getAttributeTypes();
        Vector<Vector<String>> tuples1 =  table1.getTuples();
        Vector<Vector<String>> tuples2 =  table2.getTuples();

        int count = 0;
        int attr_index1 = 0, attr_index2 = 0;
        String new_table_name = "";
        loop:
        for(int i = 0; i < attributeNames1.size(); i++){
            for(int j = 0; j < attributeNames2.size(); j++){
                if(attributeNames1.get(i).equals(attributeNames2.get(j)) &&
                        attributeTypes1.get(i).equals(attributeTypes2.get(j))){
                    new_table.setTableName(new_name);;
                    attr_index1 = i;
                    attr_index2 = j;
                    break loop;
                }
                count++;
            }
        }

        Vector<Vector<String>> new_Tuples = new Vector<>();
        //here we extract the tuples into the new table
        for(int i = 0; i < tuples1.size(); i++) {
            for (int j = 0; j < tuples2.size(); j++) {
                if(tuples1.get(i).get(attr_index1).equals(tuples2.get(j).get(attr_index2))){
                    Vector<String> tempTuple2 = new Vector<>(tuples2.get(j));
                    //tempTuple2 = tuples2.get(j);
                    /*for(int k = 0; k < tuples2.get(j).size(); k++){
                        tempTuple2.set(k,tuples2.get(j).get(k));
                    }*/
                    tempTuple2.remove(attr_index2);
                    tuples1.get(i).addAll(tempTuple2);
                    new_Tuples.add(tuples1.get(i));
                }
            }
        }

        Vector<String> new_primaryKeys = new Vector<>();
        new_primaryKeys.add(attributeNames1.get(attr_index1));
        attributeNames2.remove(attr_index2);
        attributeTypes2.remove(attr_index2);
        attributeNames1.addAll(attributeNames2);
        attributeTypes1.addAll(attributeTypes2);

        new_table.setPrimaryKeys(new_primaryKeys);
        new_table.setAttributeNames(attributeNames1);
        new_table.setAttributeTypes(attributeTypes1);
        new_table.setTuples(new_Tuples);

        if(attr_index1 != 0){
            for(int i = 0; i < new_table.getTuples().size(); i++){
                String temp = new_table.getTuples().get(i).get(attr_index1);
                new_table.getTuples().get(i).set(attr_index1,new_table.getTuples().get(i).get(0));
                new_table.getTuples().get(i).set(0,temp);
            }
            String temp1 = new_table.getAttributeNames().get(attr_index1);
            new_table.getAttributeNames().set(attr_index1,new_table.getAttributeNames().get(0));
            new_table.getAttributeNames().set(0,temp1);

            String temp2 = new_table.getAttributeTypes().get(attr_index1);
            new_table.getAttributeTypes().set(attr_index1,new_table.getAttributeTypes().get(0));
            new_table.getAttributeTypes().set(0,temp2);
        }
        memory.put(new_name, new_table);
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                            MAIN                                                               //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Currently used to test the DBMS.
     * @param args - NONE
     */
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
        db1.insert("species", new String[]{"dog"});
        db1.insert("animals", new String[]{"Joe", "cat", "4", "black"});
        db1.insert("animals", new String[]{"Benny", "dog", "5"});
        db1.show("species");
        db1.show("animals");

        //Test the write. Should throw exception if relation does not exist
        db1.write("animals");
        db1.write("people");

        //Test the close, if does not exist, should throw exception
        db1.close("animals");
        db1.close("people");

        //Test the union. Should combine cats and dogs
        db1.create("cats",new String[]{"name VARCHAR","kind VARCHAR"},new String[]{"name"});
        db1.create("dogs",new String[]{"name VARCHAR","kind VARCHAR"},new String[]{"name"});
        db1.insert("cats", new String[]{"Jack","cat"});
        db1.insert("cats", new String[]{"Buttons","cat"});
        db1.insert("dogs", new String[]{"Hamilton","dog"});
        db1.insert("dogs", new String[]{"Buttons","dog"});
        db1.insert("dogs", new String[]{"Charles","dog"});
        db1.show("cats");
        db1.show("dogs");
        db1.union("cats_or_dogs", "cats", "dogs");
        db1.show("cats_or_dogs");

        //Test the rename. Should rename attributes name and kind to aname and akind
        db1.rename("cats_renamed", new Vector<String>(Arrays.asList("aname","akind")), "cats");
        db1.show("cats_renamed");
        db1.rename("cats", new Vector<String>(Arrays.asList("name","kind")), "cats");
        db1.show("cats");

        //Test the projection. New table of dogs should only have name, not kind
        db1.project("dog_names",new Vector<String>(Arrays.asList("name")),"dogs");
        db1.show("dog_names");

        //Further projection testing. New table outputs only name and kind of the zoo animals
        db1.create("zoo",new String[]{"name VARCHAR","age INTEGER","kind VARCHAR"},new String[]{"name"});
        db1.insert("zoo", new String[]{"Wally","5","Kangaroo"});
        db1.insert("zoo", new String[]{"Jack","15","Elephant"});
        db1.insert("zoo",new String[]{"Julia","7","Lioness"});
        db1.project("name_and_kind",new Vector<String>(Arrays.asList("name","kind")),"zoo");
        db1.show("name_and_kind");

        //Testing the difference. Should output a table with only dogs
        db1.difference("dogs_only", "cats_or_dogs","cats");
        db1.show("dogs_only");

        //Testing the product. Should output a table with dogs and all fur options
        //Should rename attributes to specify dogs_kind and fur_kind
        db1.create("furs", new String[]{"color VARCHAR","kind VARCHAR"}, new String[]{"color"});
        db1.insert("furs",new String[]{"golden","fine"});
        db1.insert("furs",new String[]{"black","fluffy"});
        db1.product("dogs_and_furs","dogs","furs");
        db1.show("dogs_and_furs");

        //Testing the select. Should output a table with dogs with only golden fur
        //db1.select("dogs_with_gold_fur", new String[]{"color","golden","=="}, "dogs_and_furs");
        db1.show("dogs_with_gold_fur");

        //Testing the update. Should output a table where golden fur now means golden retriever
        //db1.update("dogs_and_furs", new String[]{"color"}, new String[] {"yellow"}, new Condition{"color","golden","=="});
        db1.show("dogs_and_furs");

    }
}