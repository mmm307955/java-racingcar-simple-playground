package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveTest {

    @Test
    @DisplayName("랜덤으로 4이상일 때 테스트가 성공한다")
    void test_over_4_when_random() {
        RandomMove randomMove = new RandomMove();
        boolean result = randomMove.canMove();
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("4이상일 때 true를 반환하는지 테스트한다")
    void test_over_4() {
        RandomMove randomMove = new RandomMove(()-> 5);
        boolean result = randomMove.canMove();
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("4미만일 때 false를 반환하는지 테스트한다")
    void test_under_4() {
        RandomMove randomMove = new RandomMove(()-> 3);
        boolean result = randomMove.canMove();
        assertThat(result).isFalse();
    }

}
