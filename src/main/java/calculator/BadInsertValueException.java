package calculator;

public class BadInsertValueException extends Exception{
    public BadInsertValueException(){ };

    public BadInsertValueException(String msg){ // 부모클래스인 Exception에 메시지 전송
        super(msg + "를 다시 입력해주세요.");
    }
}
