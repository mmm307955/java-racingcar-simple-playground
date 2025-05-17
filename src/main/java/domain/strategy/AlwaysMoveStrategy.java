package domain.strategy;

import domain.Movable;

public class AlwaysMoveStrategy implements Movable {
    @Override
    public boolean canMove(){
        return true;
    }
}
