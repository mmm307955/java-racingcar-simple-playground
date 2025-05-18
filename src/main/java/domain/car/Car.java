package domain.car;

import domain.strategy.Movable;

public class Car {
    private final String carName;
    private int position;
    private final Movable movable;
    private static final int MAX_LENGTH = 5;


    public Car(String name, Movable movable, int position) {
        validateName(name);
        this.carName = name;
        this.movable = movable;
        this.position = position;
    }

    private void validateName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("이름은 비워둘 수 없습니다.");
        }
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move() {
        if (movable.canMove()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
