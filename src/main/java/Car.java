public class Car {
    private final String carName;
    private int position = 0;

    public Car(String name){
        this.carName = name;
    }

    public void move(Movable movable){
        if(movable.canMove()){
            position++;
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionAsString(){
        return "-".repeat(position);
    }
}
