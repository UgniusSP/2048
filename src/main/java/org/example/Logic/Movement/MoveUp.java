package org.example.Logic.Movement;

import org.example.Logic.Model.Tile;
import org.example.Logic.Utils.TileMerger;

public class MoveUp implements MoveStrategy {

    private final TileMerger tileMerger;

    public MoveUp(TileMerger tileMerger) {
        this.tileMerger = tileMerger;
    }

    @Override
    public void move(Tile[][] tiles) {
        for (int i = 0; i < 4; i++) {
            int targetRow = 0;
            Tile lastMerged = null;

            for (int j = 0; j < 4; j++) {
                if (tiles[j][i] != null) {
                    if (j != targetRow) {
                        tiles[targetRow][i] = tiles[j][i];
                        tiles[j][i] = null;
                    }

                    if(lastMerged != null && tileMerger.merge(tiles, targetRow, i, targetRow - 1, i)){
                        lastMerged = null;
                        targetRow--;
                    } else {
                        lastMerged = tiles[targetRow][i];
                    }

                    targetRow++;
                }
            }
        }
    }
}
