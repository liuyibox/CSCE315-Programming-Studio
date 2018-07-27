/**
 * Created by liuyi on 6/30/2017.
 */
//O1, O2 means operand1, operand 2
public class Comparison  {
    private String operand1;
    private String operand2;
    private String operation;

    Comparison(String op1, String op,String op2){
        operand1 = op1;
        operand2 = op2;
        operation = op;
    }

    public String getOperand1(){return operand1;}
    public String getOperand2(){return operand2;}
    public String getOperation(){return operation;}
}
