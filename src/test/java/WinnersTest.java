import domain.Winners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.Car;
import java.util.List;
import View.*;

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
        int gameRound = 5;

        List<Car> cars = List.of(carA, carB, carC);
        assertThat(Winners.findWinnersNames(cars,gameRound)).containsExactlyInAnyOrder("Car A","Car C");
    }
}
