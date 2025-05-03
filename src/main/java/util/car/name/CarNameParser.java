package util.car.name;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {
    private CarNameParser(){
        throw new AssertionError("util 클래스는 생성할 수 없습니다. ");
    }
    //이름에 공백이 있다면 제거하고 리스트에 담는다.
    public static List<String> parseCarNames(String input) {
        String[] split = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String carName : split) {
            carNames.add(carName.trim());
        }
        return carNames;
    }
}
