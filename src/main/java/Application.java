import domain.RaceResult;
import domain.RoundParser;
import domain.Winners;
import domain.car.Car;
import domain.car.CarNameParser;
import domain.strategy.RandomMovable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        //이름 입력을 받는 메소드
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();

        //입력받은 이름들을 나누는 메소드
        List<String> parsedNames = CarNameParser.nameParse(names);

        //각 이름으로 차 객체를 생성하는 메소드
        List<Car> cars = new ArrayList<>();

        for (String name : parsedNames) {
            cars.add(new Car(name, new RandomMovable(4, 10), 0));
        }

        //시도할 횟수를 입력받는 메소드
        System.out.println("시도할 회수는 몇회인가요?");
        //횟수를 입력받고 유효한지 확인 후 적절하면 저장한다.
        String round = sc.nextLine();
        int roundCount = RoundParser.parseRound(round);

        //실행결과를 출력
        for (int i = 0; i < roundCount; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        //우승자를 출력하는 메소드
        List<String> winners = Winners.findWinnersNames(cars);
        RaceResult.printWinner(winners);
    }
}
