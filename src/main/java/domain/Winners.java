package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<String> findWinnersNames(List<Car> cars, int gameRound){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == gameRound) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
