/**
 * Class that holds Comparison information.
 */
//O1, O2 means operand1, operand 2
public class Comparison  {
    /**
     * The first operand.
     */
    private String operand1 = "";

    /**
     * The second operand.
     */
    private String operand2 = "";

    /**
     * The operation to be used for comparing.
     */
    private String operation = "";

    /**
     * Default constructor.
     */
    public Comparison() {}

    /**
     * TODO: never used
     * @param op1 The first operand.
     * @param op2 The second operand.
     * @param op The operation to be used for comparing.
     */
    public Comparison(String op1, String op2, String op){
        operand1 = op1;
        operand2 = op2;
        operation = op;
    }

    /**
     * First operand setter.
     * @param _op1 First operand.
     */
    public void setOperand1(String _op1){operand1=_op1;}

    /**
     * Second operand setter.
     * @param _op2 Second operand.
     */
    public void setOperand2(String _op2){operand2=_op2;}

    /**
     * Operation setter.
     * @param _op Operation.
     */
    public void setOperation(String _op){operation=_op;}

    /**
     * First operand getter.
     * @return First operand.
     */
    public String getOperand1(){return operand1;}

    /**
     * Second operand getter.
     * @return
     */
    public String getOperand2(){return operand2;}

    /**
     * Operation getter.
     * @return
     */
    public String getOperation(){return operation;}
}