package calculator;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator{
    private static final double pi = 3.14; // static final을 쓰면 값을 수정할 수 없다. 원주율은 값은 고정이니까 사용

    public CircleCalculator(List<Double> result){
        super(result);
    }

    // 원의 넓이 결과 리스트 출력
    @Override
    public void inquiryResults(){
        for(double i : super.getResult())
            System.out.print(i + " ");

        System.out.print("\n"); // 데이터 조회 후 줄바꿈
    }

    public void calculateCircleArea(double radius){
        super.setResult(pi * radius * radius);
    }
}
