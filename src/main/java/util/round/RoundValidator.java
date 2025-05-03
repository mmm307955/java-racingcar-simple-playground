package util.round;

public class RoundValidator {
    private RoundValidator(){
        throw new AssertionError("util 클래스는 생성할 수 없습니다. ");
    }

    public static void isValidRound(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야합니다. ");
        }
    }
}
