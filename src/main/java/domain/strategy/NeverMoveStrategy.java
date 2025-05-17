package domain.strategy;

import domain.Movable;

public class NeverMoveStrategy implements Movable {
    @Override
    public boolean canMove() {
        return false;
    }
}
