package view;

import util.round.RoundValidator;

import java.util.Scanner;

import static util.car.name.CarNameValidator.validCarName;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.nextLine();
        validCarName(carNames);
        return carNames;
    }

    public int readGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            int input = Integer.parseInt(sc.nextLine());//nextInt는 \n이 남아 nextLine()사용
            RoundValidator.isValidRound(input);//입력된 라운드가 0보다 큰지 확인
            return input;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
