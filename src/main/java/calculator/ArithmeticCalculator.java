package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(List<Double> result){
        super(result);
    }

    // 사칙연산 결과 리스트 출력
    @Override
    public void inquiryResults(){
        for(double i : super.getResult())
            System.out.print(i + " ");

        System.out.print("\n"); // 데이터 조회 후 줄바꿈
    }

    public double calculate(int num1, int num2, char operator) throws Exception {
        String msg; // 오류 메시지 전달하기 위한 매개변수
        double result;

        switch (operator) {
            case '+':
                result = new AddOperator().operate(num1, num2);
                break;

            case '-':
                result = new SubstractOperator().operate(num1, num2);
                break;

            case '*':
                result = new MultiplyOperator().operate(num1, num2);
                break;

            case '/':
                if(num2 == 0){
                    msg = "분모는 0이 될 수 없습니다. 분모";
                    throw new BadInsertValueException(msg);
                }
                result = new DivideOperator().operate(num1, num2);
                break;

            case '%':
                if(num2 == 0){
                    msg = "분모는 0이 될 수 없습니다. 분모";
                    throw new BadInsertValueException(msg);
                }
                result = new ModOperator().operate(num1, num2);
                break;

            default:
                // 사칙연산(+, -, *, /) 를 제외한 다른 문자가 입력되면 실행
                msg = "사칙연산 기호";
                throw new BadInsertValueException(msg);
        }

        // 결과값 리스트에 이번 연산결과 추가
        // 예외처리로 흐르면 throw 뒤의 로직 건너뜀
        super.setResult(result);

        return result;
    }
}
