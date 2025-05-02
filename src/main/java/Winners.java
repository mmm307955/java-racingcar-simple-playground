import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<String> findWinnersNames(List<Car> cars){
        List<String> winners = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPosition() >= 5){
                winners.add(cars.get(i).getCarName());
            }
        }
        return winners;
    }
}
