package org.example.Logic.Movement;

import org.example.Logic.Model.Tile;

public class Mover {
    private MoveStrategy moveStrategy;

    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    public void move(Tile[][] tiles){
        if(moveStrategy != null){
            moveStrategy.move(tiles);
        }
    }
}
