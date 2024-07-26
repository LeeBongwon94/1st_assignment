package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App extends Exception{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        // 마지막에 "exit"를 쓰기전까지 무한루프
        while(true) {
            int result = 0;

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 문자열에서 맨 앞 문자만 가져옴
            // next()는 String이지만 charAt(0)으로 문자를 가져와서 char형 가능
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                calculator.calculate(num1, num2, operator);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            // "remove" 입력 시 가장 먼저 등록된 데이터가 사라지고 한 칸씩 앞으로 당김
            if(sc.next().equals("remove"))
                calculator.removeResult();

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            // "inquiry" 입력 시 모든 데이터 조회
            if(sc.next().equals("inquiry"))
                calculator.inquiryResults();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            // 다음 입력 받은 값이 "exit"이면 반복문 나가기.
            if (sc.next().equals("exit"))
                break;
        }
    }
}