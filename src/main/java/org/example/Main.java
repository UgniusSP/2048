package org.example;

import org.example.Logic.Game;
import org.example.Logic.Model.Tile;
import org.example.Logic.Movement.Mover;
import org.example.Logic.Utils.Board;
import org.example.Logic.Utils.TileGenerator;
import org.example.Logic.Utils.TileMerger;
import org.example.UI.BoardUI;
import org.example.UI.ScoreboardUI;
import org.example.UI.Window;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Mover(), new Board(), new TileMerger(), new TileGenerator(), new Tile[4][4]);
        Window window = new Window("2048");
        ScoreboardUI scoreboard = ScoreboardUI.getInstance();
        BoardUI boardUI = BoardUI.getInstance(game, scoreboard);

        window.add(scoreboard, BorderLayout.NORTH);
        window.add(boardUI, BorderLayout.CENTER);

        window.showWindow();
    }
}