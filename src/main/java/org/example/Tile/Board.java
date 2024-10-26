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
        generateTile();
        generateTile();
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
                    if(lastMerged != null && targetRow > 0 && tiles[targetRow - 1][i] != null && tiles[targetRow - 1][i].getValue() == tiles[targetRow][i].getValue()){
                        tiles[targetRow - 1][i].setValue(tiles[targetRow - 1][i].getValue() * 2);
                        tiles[targetRow][i] = null;
                        merged = true;
                    }
                    lastMerged = tiles[targetRow][i];
                    if(merged){
                        targetRow--;
                        merged = false;
                    }
                    targetRow++;
                }
            }
        }
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
                    if(lastMerged != null && targetRow < 4 && tiles[targetRow + 1][i] != null && tiles[targetRow + 1][i].getValue() == tiles[targetRow][i].getValue()){
                        tiles[targetRow + 1][i].setValue(tiles[targetRow + 1][i].getValue() * 2);
                        tiles[targetRow][i] = null;
                        merged = true;
                    }
                    lastMerged = tiles[targetRow][i];
                    if(merged){
                        targetRow++;
                        merged = false;
                    }
                    targetRow--;
                }
            }
        }
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
                    if(lastMerged != null && targetColumn > 0 && tiles[i][targetColumn - 1] != null && tiles[i][targetColumn - 1].getValue() == tiles[i][targetColumn].getValue()){
                        tiles[i][targetColumn - 1].setValue(tiles[i][targetColumn - 1].getValue() * 2);
                        tiles[i][targetColumn] = null;
                        merged = true;
                    }
                    lastMerged = tiles[i][targetColumn];
                    if(merged){
                        targetColumn--;
                        merged = false;
                    }
                    targetColumn++;
                }
            }
        }
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
                    if(lastMerged != null && targetColumn > 0 && tiles[i][targetColumn + 1] != null && tiles[i][targetColumn + 1].getValue() == tiles[i][targetColumn].getValue()){
                        tiles[i][targetColumn + 1].setValue(tiles[i][targetColumn + 1].getValue() * 2);
                        tiles[i][targetColumn] = null;
                        merged = true;
                    }
                    lastMerged = tiles[i][targetColumn];
                    if(merged){
                        targetColumn++;
                        merged = false;
                    }
                    targetColumn--;
                }
            }
        }
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }
}
