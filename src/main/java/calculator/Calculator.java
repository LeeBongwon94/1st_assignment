package calculator;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator{
    private List<Double> result;

    public Calculator(List<Double> result){
        this.result = result;
    }

    public void removeResult(int idx){
        result.remove(idx);
    }

    abstract void inquiryResults();

    public void setResult(double val){
        result.add(val);
    };

    public List<Double> getResult(){
        return result;
    }











}
