package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarTest {

    @Test
    @DisplayName("자동차는 이동조건이 true일때 전진한다")
    void car_can_move_when_movable_true(){
        Car car = new Car("TestCar");
        car.move(()->true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 이동조건이 false일때 멈춘다")
    void car_stop_when_movable_false(){
        Car car = new Car("TestCar");
        car.move(()->false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차 이름을 확인할 수 있다")
    void get_car_name(){
        Car car = new Car("Tcar");
        assertThat(car.getCarName()).isEqualTo("Tcar");
    }
}
