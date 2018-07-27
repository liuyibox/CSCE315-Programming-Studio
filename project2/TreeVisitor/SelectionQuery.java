/**
 * Created by ellie on 6/27/2017.
 */
import java.util.ArrayList;

// selection ::= select ( condition ) atomic-expr
public class SelectionQuery extends QueryPlan{
    private ArrayList<String> condition;
    private QueryPlan atom_expr;

    public SelectionQuery(){
        condition = new ArrayList<String>();
        atom_expr = new QueryPlan();
    }

    public void setAtomicQuery(QueryPlan _atom){atom_expr = _atom;}
    public void addCondition(String comp){condition.add(comp);}

    @Override public void execute(){
        System.out.println("Executing a selection query");
    }
}
