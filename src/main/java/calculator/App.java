package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App extends Exception{
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ArrayList<>(), new ArrayList<>());
        Scanner sc = new Scanner(System.in);

        // 마지막에 "exit"를 쓰기전까지 무한루프
        while(true) {
            int result = 0;
            boolean repeat = true; // 사칙연산 or 원의 넓이 선택을 정상적으로 진행될 수 있도록 확인
            int flag = 0; // 0 : 사칙연산   1 : 원의 넓이

            while(repeat){
                System.out.println("사칙연산을 진행하시려면 0, 원의 넓이를 구하시려면 1을 눌러주세요");
                flag = sc.nextInt();

                switch(flag) {
                    case 0:
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
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        // "remove" 입력 시 가장 먼저 등록된 데이터가 사라지고 한 칸씩 앞으로 당김
                        if (sc.next().equals("remove"))
                            calculator.removeResult();

                        System.out.println("저장된 모든 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        // "inquiry" 입력 시 모든 데이터 조회
                        if (sc.next().equals("inquiry"))
                            calculator.inquiryResults();

                        repeat = false; // 연산 타입 정상 선택
                        break;
                    case 1:
                        System.out.println("반지름을 입력해주세요.");
                        calculator.calculateCircleArea(sc.nextDouble());

                        System.out.println("저장된 모든 원이 넓이를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        // "inquiry" 입력 시 모든 데이터 조회
                        if (sc.next().equals("inquiry"))
                            calculator.inquiryAreas();

                        repeat = false; // 연산 타입 정상 선택
                        break;
                    default: // 0과 1 외에 다른 값 입력 시 다시 선택하도록 돌아감
                        System.out.println("잘못 입력하셨습니다. 0 또는 1을 입력해주세요.");
                        continue;
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            // 다음 입력 받은 값이 "exit"이면 반복문 나가기.
            if (sc.next().equals("exit"))
                break;
        }
    }
}