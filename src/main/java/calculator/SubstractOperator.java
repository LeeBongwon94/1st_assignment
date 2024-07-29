package calculator;

public class SubstractOperator implements Operator {
    @Override
    public double operate(int num1, int num2){
        return num1 - num2;
    }
}
