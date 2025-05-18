package controller;

import View.OutputView;
import domain.Winners;
import domain.car.Car;
import domain.car.CarNameParser;
import domain.strategy.RandomMovable;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(String carNames) {
        List<String> parsedNames = CarNameParser.nameParse(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : parsedNames) {
            cars.add(new Car(name, new RandomMovable(4, 10), 0));
        }
        return cars;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                OutputView.printCarStatus(car);
            }
            System.out.println();
        }
        OutputView.printWinner(Winners.findWinnersNames(cars));
    }
}
