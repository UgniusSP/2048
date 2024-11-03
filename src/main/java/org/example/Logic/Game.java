package org.example.Logic;

import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.*;
import org.example.Logic.Utils.Board;
import org.example.Logic.Utils.TileGenerator;
import org.example.Logic.Utils.TileMerger;

public class Game {

    private final Mover mover;
    private final Tile[][] tiles;
    private final TileMerger tileMerger;
    private final TileGenerator tileGenerator;
    private final Board board;

    public Game(Mover mover, Board board, TileMerger tileMerger, TileGenerator tileGenerator, Tile[][] tiles) {
        this.mover = mover;
        this.board = board;
        this.tiles = tiles;
        this.tileMerger = tileMerger;
        this.tileGenerator = tileGenerator;
        initializeBoard();
    }

    public Tile getTile(int row, int col){
        return tiles[row][col];
    }

    public void moveUp(){
        mover.setMoveStrategy(new MoveUp(tileMerger));
        mover.move(tiles);
        tileGenerator.generateTile(tiles);
    }

    public void moveDown(){
        mover.setMoveStrategy(new MoveDown(tileMerger));
        mover.move(tiles);
        tileGenerator.generateTile(tiles);
    }

    public void moveRight(){
        mover.setMoveStrategy(new MoveRight(tileMerger));
        mover.move(tiles);
        tileGenerator.generateTile(tiles);
    }

    public void moveLeft(){
        mover.setMoveStrategy(new MoveLeft(tileMerger));
        mover.move(tiles);
        tileGenerator.generateTile(tiles);
    }

    private void initializeBoard() {
        tileGenerator.generateTile(tiles);
        tileGenerator.generateTile(tiles);
    }

    public boolean isGameOver(){
        return board.gameOver(tiles);
    }

    public boolean isGameWon(){
        return board.gameWon(tiles);
    }
}
