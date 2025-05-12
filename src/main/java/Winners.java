import java.util.List;
import java.util.stream.Collectors;

public class Winners {

  public static List<String> findWinnersNames(List<Car> cars) {
    return cars.stream()
        .filter(car -> car.getPosition() >= 5)
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }
}
