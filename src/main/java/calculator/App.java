package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        // sc.next()는 기본적으로 String을 반환하지만, charAt()을 사용함으로
        // 문자열 중에서 문자 1개만 반환하기에 사용이 가능하다.
        // charAt(idx) 문자열 중 입력한 idx 위치에 해당하는 1개의 문자만 반환
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);
    }
}
