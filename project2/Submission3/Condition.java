import java.util.Vector;

/**
 * QueryPlan for Conditions.
 */
public class Condition extends QueryPlan{

    /**
     * Used to hold the conjunctions of a condition.
     */
    public Vector<Conjunction> conjuncVec = new Vector<>();

    Condition(){
        conjuncVec = new Vector<>();
    }
}