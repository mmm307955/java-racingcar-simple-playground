public class Car {

  private final String carName;
  private int position = 0;
  private final RandomMove randomMove;

  public Car(String name, RandomMove randomMove,int position) {

    this.carName = name;
    this.randomMove = randomMove;
    this.position = position;
  }

  public void move(Movable movable) {
    if (randomMove.canMove()) {
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
