package org.example.Logic.Utils;

import org.example.Logic.Model.Tile;

public class TileMerger {

    public boolean merge(Tile[][] tiles, int row, int column, int nextRow, int nextColumn){
        Tile currentTile = tiles[row][column];
        Tile nextTile = tiles[nextRow][nextColumn];

        if(currentTile != null && nextTile != null && currentTile.canMerge(nextTile)){
            currentTile.merge(nextTile);
            tiles[row][column] = null;
            return true;
        }
        return false;
    }
}
