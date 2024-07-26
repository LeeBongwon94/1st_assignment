package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator{
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    // Double 값을 저장하는 ArrayList 생성
    private ArrayList<Double> resultArr = new ArrayList<>();
    private ArrayList<Double> areaArr = new ArrayList<>();
    static final double pi = 3.14; // static final을 쓰면 값을 수정할 수 없다. 원주율은 값은 고정이니까 사용

    // 생성자
    public Calculator(ArrayList<Double> resultArr, ArrayList<Double> areaArr){
        this.resultArr = resultArr;
        this.areaArr = areaArr;
    }

    // getter, setter
    public List<Double> getResultArr(){
        return this.resultArr;
    }

    public void setResultArr(double result){
        resultArr.add(result);
    }

    public List<Double> getAreaArr(){
        return this.areaArr;
    }

    public void setAreaArr(double area){
        areaArr.add(area);
    }



    public void removeResult(){
        resultArr.remove(0);
    }

    // 원의 넓이 결과 리스트 출력
    public void inquiryAreas(){
        for(double i : areaArr)
            System.out.print(i + " ");

        System.out.print("\n"); // 데이터 조회 후 줄바꿈
    }

    // 사칙연산 결과 리스트 출력
    public void inquiryResults(){
        for(double i : resultArr)
            System.out.print(i + " ");

        System.out.print("\n"); // 데이터 조회 후 줄바꿈
    }

    public double calculate(int num1, int num2, char operator) throws Exception {
        String msg; // 오류 메시지 전달하기 위한 매개변수
        double result;

        switch (operator) {
            case '+':
                result = (double)(num1 + num2);
                break;

            case '-':
                result = (double)(num1 - num2);
                break;

            case '*':
                result = (double)(num1 * num2);
                break;

            case '/':
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
        setResultArr(result);

        return result;
    }

    public double calculateCircleArea(double radius){
        double area;
        area = pi * radius * radius;

        // 원의 넓이 결과 리스트에 저장
        setAreaArr(area);

        return area;
    }
}
