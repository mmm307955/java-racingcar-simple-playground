package util.round;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RoundValidatorTest {
    @Test
    @DisplayName("0이하의 숫자가 입력되면 예외를 발생한다")
    void exception_return_when_round_under_1(){
        assertAll(
                ()-> assertThatThrownBy(()-> RoundValidator.isValidRound(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1 이상이어야합니다. "),
                ()-> assertThatThrownBy(()-> RoundValidator.isValidRound(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1 이상이어야합니다. "),
                ()-> assertThatCode(()-> RoundValidator.isValidRound(2))
                        .doesNotThrowAnyException()
        );
    }

    @Test
    @DisplayName("1이상의 숫자가 입력되면 예외를 발생하지 않는다")
    void exception_return_when_round_at_Least_1(){
        assertThatCode(()-> RoundValidator.isValidRound(1))
                        .doesNotThrowAnyException();
    }

}
