package calculator;

public class Calculator implements java.io.Serializable {
    private double operandOne;
    private double operandTwo;
    private String operation;
    
    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }
    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Calculator() {}

    public double performOperation() {
        double result = 0;
        if (this.operation.equals("+")) {
            result = this.operandOne + this.operandTwo;
        } else if (this.operation.equals("-")) {
            result = this.operandOne - this.operandTwo;
        }
        return result;
    }

    public void getResults() {
        System.out.println("Result is: " + performOperation()); 
    }
}