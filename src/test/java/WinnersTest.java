import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

  @Test
  @DisplayName("우승자(들) 이름을 반환한다")
  void returnWinnerNames() {
    Car normalCar = new Car("Car A",new RandomMove(4,10),5);
    Car electricCar = new Car("Car B",new RandomMove(5,10),4);
    Car truck = new Car("Car C",new RandomMove(6,10),2);
    Car mini = new Car("Car D",new RandomMove(3,10),5);

    List<Car> cars = List.of(normalCar, electricCar, truck, mini);
    assertThat(Winners.findWinnersNames(cars)).containsExactlyInAnyOrder("Car A", "Car D");
  }
}
