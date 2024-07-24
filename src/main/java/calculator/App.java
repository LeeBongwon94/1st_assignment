package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 가변길이 배열 선언
        // List는 저장되는 순서를 반영하므로 채택
        ArrayList<Integer> resultArr = new ArrayList<>();

        // 결과값이 정상적으로 나왔는지 체크하기 위한 변수
        // chk값이 true인 경우에만 List에 값을 저장하기 위해 false로 초기화
        boolean chk = false;

        // 마지막에 "exit"를 쓰기전까지 무한루프
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

            // 입력되는 사칙연산 기호 분기
            switch (operator) {
                case '+':
                    chk = true; // 성공적인 결과 출력
                    result = num1 + num2;

                    System.out.println("결과 : " + result);

                    break;

                case '-':
                    chk = true; // 성공적인 결과 출력
                    result = num1 - num2;

                    System.out.println("결과 : " + result);

                    break;

                case '*':
                    chk = true; // 성공적인 결과 출력
                    result = num1 * num2;

                    System.out.println("결과 : " + result);

                    break;

                case '/':
                    // 2번째 입력한 정수가 0일 경우 아래 메시지가 뜨고, 0이 아닐 경우 결과 메시지 출력
                    if (num2 == 0)
                        System.out.println("나눗셈 연산에선 분모(두 번째 정수)에는 0이 입력될 수 없습니다.");
                    else {
                        chk = true; // 성공적인 결과 출력
                        result = num1 / num2;

                        System.out.println("결과 : " + result);
                    }
                    break;

                default:
                    // 사칙연산(+, -, *, / 를 제외한 다른 문자가 입력되면 실행
                    System.out.println("사칙연산 기호가 아닙니다.");
            }

            // chk 값이 true 인 경우에만 List에 저장
            if(chk){
                // chk값이 true인 경우에만 List에 값을 저장하기 위해 false로 초기화
                chk = false;
                // 현재 결과를 List에 저장
                resultArr.add(result);
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            // "remove" 입력 시 가장 먼저 등록된 데이터가 사라지고 한 칸씩 앞으로 당김
            if(sc.next().equals("remove"))
                resultArr.remove(0);
            /*
            // 배열 저장 확인
            for(int i = 0; i < resultArr.size() ; i++)
                System.out.print(resultArr.get(i) + " ");

            System.out.print("\n"); // 배열 저장 확인 후 개행문자 지우기
            */
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            // 다음 입력 받은 값이 "exit"이면 반복문 나가기.
            if (sc.next().equals("exit"))
                break;
        }
    }
}
