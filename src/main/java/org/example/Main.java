package org.example;

import org.example.Logic.Game;
import org.example.Logic.Movement.Mover;
import org.example.Logic.Utils.Board;
import org.example.UI.BoardUI;
import org.example.UI.Window;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(new Mover(), board);
        Window window = new Window("2048");
        BoardUI boardUI = new BoardUI(game);

        window.add(boardUI);
        window.showWindow();
    }
}