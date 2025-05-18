package View;

import domain.car.Car;
import java.util.List;

public class OutputView {
    public static void printWinner(List<String> winners) {
        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다.");
        }
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public static void printCarStatus(Car car){
        System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
    }
}
