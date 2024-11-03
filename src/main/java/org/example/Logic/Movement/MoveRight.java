package org.example.Logic.Movement;

import org.example.Logic.Model.Tile;
import org.example.Logic.Utils.TileMerger;

public class MoveRight implements MoveStrategy {

    private final TileMerger tileMerger;

    public MoveRight(TileMerger tileMerger) {
        this.tileMerger = tileMerger;
    }

    @Override
    public void move(Tile[][] tiles) {
        for (int i = 0; i < 4; i++) {
            int targetColumn = 3;
            Tile lastMerged = null;

            for (int j = 3; j >= 0; j--) {
                if (tiles[i][j] != null) {
                    if (j != targetColumn) {
                        tiles[i][targetColumn] = tiles[i][j];
                        tiles[i][j] = null;
                    }

                    if(lastMerged != null && tileMerger.merge(tiles, i, targetColumn, i, targetColumn + 1)){
                        lastMerged = null;
                        targetColumn++;
                    } else {
                        lastMerged = tiles[i][targetColumn];
                    }

                    targetColumn--;
                }
            }
        }
    }
}
