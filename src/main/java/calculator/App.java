package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] resultArr = new int[10];
        // 현재 인덱스 값을 저장할 변수
        int curIdx = 0;
        // 마지막 인덱스 값을 저장할 변수
        int lastIdx = 0;

        while(true) {

            int result = 0;

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // sc.next()는 기본적으로 String을 반환하지만, charAt()을 사용함으로
            // 문자열 중에서 문자 1개만 반환하기에 사용이 가능하다.
            // charAt(idx) 문자열 중 입력한 idx 위치에 해당하는 1개의 문자만 반환
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("결과 : " + result);
                    // 정상적으로 결과값이 출력 된 경우 결과값 배열에 저장
                    resultArr[curIdx] = result;
                    // 현재 idx 값이 마지막 결과 idx에 저장하고, 현재 idx 값이 1 증가
                    lastIdx = curIdx++;
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.println("결과 : " + result);
                    // 정상적으로 결과값이 출력 된 경우 결과값 배열에 저장
                    resultArr[curIdx] = result;
                    // 현재 idx 값이 마지막 결과 idx에 저장하고, 현재 idx 값이 1 증가
                    lastIdx = curIdx++;
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.println("결과 : " + result);
                    // 정상적으로 결과값이 출력 된 경우 결과값 배열에 저장
                    resultArr[curIdx] = result;
                    // 현재 idx 값이 마지막 결과 idx에 저장하고, 현재 idx 값이 1 증가
                    lastIdx = curIdx++;
                    break;

                case '/':
                    // 2번째 입력한 정수가 0일 경우 아래 메시지가 뜨고, 0이 아닐 경우 결과 메시지 출력
                    if (num2 == 0)
                        System.out.println("나눗셈 연산에선 분모(두 번째 정수)에는 0이 입력될 수 없습니다.");
                    else {
                        result = num1 / num2;
                        System.out.println("결과 : " + result);
                        // 정상적으로 결과값이 출력 된 경우 결과값 배열에 저장
                        resultArr[curIdx] = result;
                        // 현재 idx 값이 마지막 결과 idx에 저장하고, 현재 idx 값이 1 증가
                        lastIdx = curIdx++;
                    }
                    break;

                default:
                    // 사칙연산(+, -, *, / 를 제외한 다른 문자가 입력되면 실행
                    System.out.println("사칙연산 기호가 아닙니다.");
            }

            // 다음 입력 받은 값이 "exit"이면 반복문 나가기.
            if (sc.next().equals("exit"))
                break;


        }
    }
}
