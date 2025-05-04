package util.car.name;

import java.util.List;

public class CarNameValidator {
    private CarNameValidator(){
        throw new AssertionError("util 클래스는 생성할 수 없습니다. ");
    }

    //쉼표 포함 / 포맷 체크
    public static void validCarName(String carNames) {
        String[] split = carNames.split(",");

        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 시작하거나 끝날 수 없습니다.");
        }
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름 사이에 빈 이름이 포함되어있습니다.");
        }
        if(split.length <= 1){
            throw new IllegalArgumentException("쉼표(,)로 구분된 자동차 이름을 2개 이상 입력해주세요.");
        }

    }
    //이름 길이 체크
    public static void validNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
