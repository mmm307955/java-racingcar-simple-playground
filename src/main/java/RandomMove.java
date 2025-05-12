import java.util.concurrent.ThreadLocalRandom;

public class RandomMove implements Movable {

  private final int moveThreshold;
  private final int randomBound;

  //생성자에서 전진 조건을 설정
  public RandomMove(int moveThreshold, int randomBound) {
    this.moveThreshold = moveThreshold;
    this.randomBound = randomBound;
  }

  @Override
  public boolean canMove() {
    return (ThreadLocalRandom.current().nextInt(randomBound)) >= moveThreshold;
  }
}
