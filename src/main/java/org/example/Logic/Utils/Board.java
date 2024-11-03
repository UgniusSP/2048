package org.example.Logic.Utils;

import org.example.Logic.Model.Tile;

public class Board {

    public boolean gameOver(Tile[][] tiles){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(tiles[i][j] == null){
                    return false;
                }
                if(i > 0 && tiles[i][j].getValue() == tiles[i - 1][j].getValue()){
                    return false;
                }
                if(j > 0 && tiles[i][j].getValue() == tiles[i][j - 1].getValue()){
                    return false;
                }
            }
        }
        return true;
    }
}
