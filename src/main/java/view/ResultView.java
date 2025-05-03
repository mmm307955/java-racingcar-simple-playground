package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printRoundResult(List<Car> cars){
        for(Car car : cars){
            printCarPosition(car);
        }
        System.out.println();
    }
    public void printCarPosition(Car car){
        String nowPosition = "-".repeat(car.getPosition());
        System.out.println(car.getCarName() + " : " + nowPosition);
    }

    public void printWinners(List<String> winners){
        if(winners.isEmpty()){
            System.out.println("아무도 우승하지 못했습니다...");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i));
            if(i < winners.size()-1){
                sb.append(", ");
            }
        }
        System.out.println(sb + "가 최종 우승했습니다.");
    }
}
