package org.example.Tile;

import java.sql.SQLOutput;

public class Board {

    private final Tile[][] tiles;
    private boolean merged = false;

    public Board() {
        tiles = new Tile[4][4];
        initializeBoard();
    }

    private void initializeBoard() {
        generateTile();
        generateTile();

    }

    public void generateTile() {
        int[] position;

        do {
            position = generateTilePosition();
        } while (!isTileEmpty(position[0], position[1]));


        Tile tile = new Tile(position[0], position[1], generateTileValue());
        tiles[position[0]][position[1]] = tile;
    }

    private int generateTileValue() {
        return Math.random() < 0.9 ? 2 : 4;
    }

    private int[] generateTilePosition() {
        int[] position = new int[2];
        position[0] = (int) (Math.random() * 4);
        position[1] = (int) (Math.random() * 4);
        return position;
    }

    private boolean isTileEmpty(int x, int y){
        return tiles[x][y] == null;
    }

    public void mergeTiles(Tile lastMerged, int row, int col, int rowOffset, int colOffset) {
        int newRow = row + rowOffset;
        int newCol = col + colOffset;

        if (lastMerged != null && newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4
                && tiles[newRow][newCol] != null && tiles[newRow][newCol].getValue() == tiles[row][col].getValue()) {
            tiles[newRow][newCol].setValue(tiles[newRow][newCol].getValue() * 2);
            tiles[row][col] = null;
            merged = true;
        }
    }

    public void moveUp() {
        for (int i = 0; i < 4; i++) {
            int targetRow = 0;
            Tile lastMerged = null;

            for (int j = 0; j < 4; j++) {
                if (tiles[j][i] != null) {
                    if (j != targetRow) {
                        tiles[targetRow][i] = tiles[j][i];
                        tiles[j][i] = null;
                    }
                    mergeTiles(lastMerged, targetRow, i, -1, 0);
                    lastMerged = tiles[targetRow][i];

                    if(merged){
                        targetRow--;
                        merged = false;
                    }
                    targetRow++;
                }
            }
        }
        generateTile();
    }

    public void moveDown() {
        for (int i = 0; i < 4; i++) {
            int targetRow = 3;
            Tile lastMerged = null;

            for (int j = 3; j >= 0; j--) {
                if (tiles[j][i] != null) {
                    if (j != targetRow) {
                        tiles[targetRow][i] = tiles[j][i];
                        tiles[j][i] = null;
                    }
                    mergeTiles(lastMerged, targetRow, i, 1, 0);
                    lastMerged = tiles[targetRow][i];

                    if(merged){
                        targetRow++;
                        merged = false;
                    }
                    targetRow--;
                }
            }
        }
        generateTile();
    }

    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            int targetColumn = 0;
            Tile lastMerged = null;

            for (int j = 0; j < 4; j++) {
                if (tiles[i][j] != null) {
                    if (j != targetColumn) {
                        tiles[i][targetColumn] = tiles[i][j];
                        tiles[i][j] = null;
                    }
                    mergeTiles(lastMerged, i, targetColumn, 0, -1);
                    lastMerged = tiles[i][targetColumn];

                    if(merged){
                        targetColumn--;
                        merged = false;
                    }
                    targetColumn++;
                }
            }
        }
        generateTile();
    }

    public void moveRight() {
        for (int i = 0; i < 4; i++) {
            int targetColumn = 3;
            Tile lastMerged = null;

            for (int j = 3; j >= 0; j--) {
                if (tiles[i][j] != null) {
                    if (j != targetColumn) {
                        tiles[i][targetColumn] = tiles[i][j];
                        tiles[i][j] = null;
                    }
                    mergeTiles(lastMerged, i, targetColumn, 0, 1);
                    lastMerged = tiles[i][targetColumn];

                    if(merged){
                        targetColumn++;
                        merged = false;
                    }
                    targetColumn--;
                }
            }
        }
        generateTile();
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }
}
