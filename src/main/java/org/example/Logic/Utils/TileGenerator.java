package org.example.Logic.Utils;

import org.example.Logic.Model.Tile;

import java.util.Random;

public class TileGenerator {
    private final Random random = new Random();

    public void generateTile(Tile[][] tiles) {
        int[] position;
        do {
            position = generateTilePosition();
        } while (!isTileEmpty(tiles, position[0], position[1]));

        tiles[position[0]][position[1]] = new Tile(position[0], position[1], generateTileValue());
    }

    private boolean isTileEmpty(Tile[][] tiles, int x, int y) {
        return tiles[x][y] == null;
    }

    private int[] generateTilePosition() {
        return new int[]{random.nextInt(4), random.nextInt(4)};
    }

    private int generateTileValue() {
        return random.nextDouble() < 0.9 ? 2 : 4;
    }
}
