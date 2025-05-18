package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.car.Car;
import domain.strategy.RandomMovable;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    @DisplayName("우승자들 다수의 이름을 반환하는지 테스트한다")
    void return_Winners_Names() {
        //Given
        Car normalCar = new Car("일반차", new RandomMovable(4, 10), 7);
        Car electricCar = new Car("일렉이", new RandomMovable(5, 10), 7);
        Car truck = new Car("트럭이", new RandomMovable(6, 10), 2);
        Car mini = new Car("쪼꼬미", new RandomMovable(3, 10), 7);
        List<Car> cars = List.of(normalCar, electricCar, truck, mini);

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).containsExactlyInAnyOrder("일반차", "일렉이",
            "쪼꼬미");
    }

    @Test
    @DisplayName("우승자 한 명의 이름을 반환하는지 테스트한다")
    void return_One_Winner_Name() {
        //Given
        Car puppy = new Car("강아지", new RandomMovable(4, 10), 7);
        Car kitty = new Car("고양이", new RandomMovable(5, 10), 6);
        Car hamster = new Car("햄스터", new RandomMovable(6, 10), 3);
        List<Car> cars = List.of(puppy, kitty, hamster);

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).containsExactlyInAnyOrder("강아지");
    }

    @Test
    @DisplayName("우승자 리스트가 비어 있을 때 빈 리스트를 반환하는지 테스트한다")
    void return_empty_List() {
        //Given
        List<Car> cars = List.of();

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).isEmpty();
    }
}
