import java.util.ArrayList;

/**
 * Created by ellie on 6/29/2017.
 */

// condition ::= conjunction { || conjunction }
public class ConditionQuery extends QueryPlan {
    private ArrayList<String> conj;

    public ConditionQuery(){
        conj = new ArrayList<String>();
    }

    public void addComp(String comp){conj.add(comp);}

    @Override public void execute(){
        System.out.println("Executing a condition");
    }

}
