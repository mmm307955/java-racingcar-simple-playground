public class RandomMove implements Movable {
    //값의 의미나 목적을 코드에서 명확하게 알리고 가독성을 위한 상수 사용
    //4는 전진 조건, 10은 랜덤 범위를 의미. 추후 변경 시 상수만 수정하면 됨
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;

    @Override
    public boolean canMove(){
        //nextInt(10)은 0~9까지의 랜덤한 값을 반환. 그 값이 4보다 크거나 같으면 true 반환
        return (int)(Math.random() * RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}