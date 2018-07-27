/**
 * Created by ellie on 6/27/2017.
 */

import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.ArrayList;

public class QueryVisitor extends QueryPlan{

    /**
     * The new table for the expression.
     */
    private String table_name = "";

    /**
     * QueryPlan to execute.
     */
    private QueryPlan expr = new QueryPlan();

    /**
     * Sets the name of the new table.
     * @param _name The new table.
     */
    public void setTableName(String _name){table_name=_name;}

    /**
     * Sets the expression to execute.
     * @param _expr The expression to execute
     */
    public void setExpr(QueryPlan _expr){expr = _expr;}

    /**
     * Executes the expression after assigning its table.
     */
    @Override public void execute(){
        System.out.println("Executing a query");
        expr.setNewTableName(table_name);
        expr.execute();
    }

}