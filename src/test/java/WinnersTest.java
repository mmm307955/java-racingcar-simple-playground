import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승자(들) 이름을 반환한다")
    void returnWinnerNames(){
        Car carA = new Car("Car A");
        Car carB = new Car("Car B");
        Car carC = new Car("Car C");

        for(int i = 0; i < 5; i++){
            carA.move(()->true);
        }

        for(int i = 0; i < 4; i++){
            carB.move(()->true);
        }
        for(int i = 0; i < 5; i++){
            carC.move(()->true);
        }

        List<Car> cars = List.of(carA, carB, carC);
        assertThat(Winners.findWinnersNames(cars)).containsExactlyInAnyOrder("Car A","Car C");
    }
}
