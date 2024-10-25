package org.example.Tile;

public class Board {

    private final Tile[][] board = new Tile[4][4];

    public Tile generateTile() {
        int[] position;

        do {
            position = generateTilePosition();
        } while (!isTileEmpty(position[0], position[1]));

        Tile tile = new Tile(position[0], position[1], generateTileValue());
        board[position[0]][position[1]] = tile;

        return tile;
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
        return board[x][y] == null;
    }

    private void moveUp(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j] != null){
                    int k = j;
                    while(k > 0 && board[i - 1][k] == null){
                        board[i + 1][k] = board[i][k];
                        board[i][k] = null;
                        k--;
                    }
                }
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }
}
