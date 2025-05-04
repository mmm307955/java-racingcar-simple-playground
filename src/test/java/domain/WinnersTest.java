package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승자가 2명 이상인 경우 모두 반환한다")
    void return_WinnerNames(){
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
        List<String> winners = Winners.findWinnersNames(cars,5);

        assertThat(Winners.findWinnersNames(cars,gameRound)).containsExactlyInAnyOrder("Car A","Car C");
    }

    @Test
    @DisplayName("한 명만 우승했을 때 한 명 이름만 반환한다")
    void return_single_winner_when_winnerisOne(){
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        for(int i = 0; i < 5; i++){
            car1.move(()->true);
        }
        for(int i = 0; i < 3; i++){
            car2.move(()->true);
        }
        for(int i = 0; i < 1; i++){
            car3.move(()->true);
        }

        int gameRound = 5;
        List<Car> cars = List.of(car1,car2,car3);
        List<String> winners = Winners.findWinnersNames(cars,gameRound);

        assertThat(winners).containsExactly("Car1");
    }

    @Test
    @DisplayName("아무도 우승 조건에 해당하지 않으면 빈 리스트를 반환한다")
    void return_empty_list_when_no_winner(){
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        for(int i = 0; i < 4; i++){
            car1.move(()->true);
        }
        for(int i = 0; i < 3; i++){
            car2.move(()->true);
        }
        int gameRound = 5;
        List<Car> cars = List.of(car1, car2);
        List<String> winners = Winners.findWinnersNames(cars,gameRound);

        assertThat(winners).isEmpty();
    }
}
