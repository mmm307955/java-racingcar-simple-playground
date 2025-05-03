import domain.Car;
import domain.Movable;
import domain.RandomMove;
import domain.Winners;
import util.car.name.CarNameParser;
import util.car.name.CarNameValidator;
import util.round.RoundValidator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView resultView = new ResultView();

        //사용자에게 ,(쉼표)가 포함된 자동차 이름을 입력받는다.
        String carNames = input.readCarNames();
        //,가 올바르게 사용되었는지 체크하는 예외
        CarNameValidator.validCarName(carNames);
        //이름 공백을 제거하고 리스트에 담는다.
        List<String> parsedCarNames = CarNameParser.parseCarNames(carNames);
        CarNameValidator.validNameLength(parsedCarNames);

        //라운드 횟수를 입력받고 유효성 체크
        int round = input.readGameRound();
        RoundValidator.isValidRound(round);

        //자동차 객체 생성
        List<Car> cars = new ArrayList<>();
        for(String name : parsedCarNames){
            cars.add(new Car(name));
        }

        System.out.println("실행 결과");
        Movable movable = new RandomMove();
        for(int i = 0; i < round; i++){
            for(Car car : cars){
                car.move(movable);
            }
            resultView.printRoundResult(cars);
        }

        //우승자를 리스트로 만들고 출력한다.
        List<String> winners = Winners.findWinnersNames(cars, round);
        resultView.printWinners(winners);
    }
}
