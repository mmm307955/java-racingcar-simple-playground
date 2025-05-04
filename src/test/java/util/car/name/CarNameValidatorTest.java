package util.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarNameValidatorTest {
    @Test
    @DisplayName("쉼표를 입력하지 않으면 예외가 발생한다")
    void exception_return_when_not_contain_comma(){
        String input = "c1c2";

        assertThatThrownBy(()-> CarNameValidator.validCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표(,)로 구분된 자동차 이름을 2개 이상 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 쉼표로 시작되거나 끝나면 예외가 발생한다")
    void exception_return_when_start_or_end_comma(){
        assertAll(
                () -> assertThatThrownBy( ()->CarNameValidator.validCarName(",car1car2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 쉼표(,)로 시작하거나 끝날 수 없습니다."),
                () -> assertThatThrownBy( ()->CarNameValidator.validCarName("car1car2,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 쉼표(,)로 시작하거나 끝날 수 없습니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 비어 있으면 예외가 발생한다")
    void exception_return_when_empty_name(){
        String input = "car1,,car2";

        assertThatThrownBy(()-> CarNameValidator.validCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 사이에 빈 이름이 포함되어있습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void exception_when_carNameLength_Over_5(){
        List<String> carNames = List.of("car1","car2","car7777");
        assertThatThrownBy(
                ()-> CarNameValidator.validNameLength(carNames)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
