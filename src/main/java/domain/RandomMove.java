package domain;

import java.util.function.Supplier;

public class RandomMove implements Movable {
    //값의 의미나 목적을 코드에서 명확하게 알리고 가독성을 위한 상수 사용
    //4는 전진 조건, 10은 랜덤 범위를 의미. 추후 변경 시 상수만 수정하면 됨
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private final Supplier<Integer> randomSupplier;

    public RandomMove(){
        this(()-> (int) (Math.random() * 10));
    }

    //테스트용 생성자 : 값 주입
    public RandomMove(Supplier<Integer> randomSupplier){
        this.randomSupplier = randomSupplier;
    }

    @Override
    public boolean canMove(){
        //nextInt(10)은 0~9까지의 랜덤한 값을 반환. 그 값이 4보다 크거나 같으면 true 반환
        return randomSupplier.get() >= MOVE_THRESHOLD;
    }

}