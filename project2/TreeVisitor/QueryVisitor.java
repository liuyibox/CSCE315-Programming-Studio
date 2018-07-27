/**
 * Created by ellie on 6/27/2017.
 */

import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.ArrayList;

public class QueryVisitor extends QueryPlan{
    private String table_name;
    private QueryPlan expr;

    public QueryVisitor(){
        table_name = "";
        expr = new QueryPlan();
    }

    public void setTableName(String _name){table_name=_name;}
    public void setExpr(QueryPlan _expr){expr = _expr;}

    @Override public void execute(){
        System.out.println("Executing a query");
        expr.execute();
    }

}