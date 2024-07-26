package calculator;

import java.util.ArrayList;

public class Calculator{
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    // Double 값을 저장하는 ArrayList 생성
    ArrayList<Double> resultArr = new ArrayList<>();
    String msg; // 오류 메시지 전달하기 위한 매개변수
    double result;

    public double calculate(int num1, int num2, String operator) throws Exception {
        switch (operator) {
            case "+":
                result = (double)(num1 + num2);
                break;

            case "-":
                result = (double)(num1 - num2);
                break;

            case "*":
                result = (double)(num1 * num2);
                break;

            case "/":
                if(num2 == 0){
                    msg = "분모는 0이 될 수 없습니다. 분모";
                    throw new BadInsertValueException(msg);
                }
                result = (double)(num1 / num2);
                break;

            default:
                // 사칙연산(+, -, *, /) 를 제외한 다른 문자가 입력되면 실행
                msg = "사칙연산 기호";
                throw new BadInsertValueException(msg);
        }

        // 결과값 리스트에 이번 연산결과 추가
        // 예외처리로 흐르면 throw 뒤의 로직 건너뜀
        resultArr.add(result);

        return result;
    }
}
