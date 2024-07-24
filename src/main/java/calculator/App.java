package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        System.out.println("사칙연산 기호를 입력하세요 : ");

        // sc.next()는 String 문자열을 반환하지만, charAt을 사용함으로 String 문장을
        // 1글자(Char 형태)를 반환하므로 char형 변수에 저장할 수 있다.
        // charAt(idx) : 문자열의 idx에 해당하는 문자 반환
        char operator = sc.next().charAt(0);

        System.out.println("operator = " + operator);
    }
}
