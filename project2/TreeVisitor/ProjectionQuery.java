import java.util.ArrayList;
import java.util.*;

/**
 * Created by ellie on 6/27/2017.
 */

// project ( attribute-list ) atomic-expr
public class ProjectionQuery extends QueryPlan {
    private ArrayList<String> attributes;
    private QueryPlan atom_expr;

    public ProjectionQuery(){
        attributes = new ArrayList<String>();
        atom_expr = new QueryPlan();
    }

    public void setAtomicQuery(QueryPlan _atom){atom_expr = _atom;}
    public void addAttribute(String attr){attributes.add(attr);}

    @Override public void execute(){
        System.out.println("Executing a projection query");
    }

}
