package util.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamePaserTest {
    @Test
    @DisplayName("자동차 이름에 공백이 제거되어 저장되었는지 테스트한다")
    void return_carNames_removeSpace_and_split(){
        String input = "car1, car2, car3";
        List<String> result = CarNameParser.parseCarNames(input);
        assertThat(result).containsExactly("car1", "car2", "car3");
    }
    @Test
    @DisplayName("공백이 없는 문자열도 정상적으로 파싱된다")
    void return_carNames_split(){
        String input = "car1,car2,car3";
        List<String> result = CarNameParser.parseCarNames(input);
        assertThat(result).containsExactly("car1","car2","car3");
    }
}
