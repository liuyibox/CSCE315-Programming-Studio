import java.util.ArrayList;

/**
 * Created by ellie on 6/28/2017.
 */

// renaming ::= rename ( attribute-list ) atomic expr
public class RenamingQuery extends QueryPlan {
    private ArrayList<String> attributes;
    private QueryPlan atom_expr;

    public RenamingQuery(){
        attributes = new ArrayList<String>();
        atom_expr = new QueryPlan();
    }

    public void setAtomicQuery(QueryPlan _atom){atom_expr = _atom;}
    public void addAttribute(String attr){attributes.add(attr);}

    @Override public void execute(){
        System.out.println("Executing a renaming query");
    }
}
