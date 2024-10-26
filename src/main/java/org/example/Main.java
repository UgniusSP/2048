package org.example;

import org.example.Tile.Board;
import org.example.UI.BoardUI;
import org.example.UI.Window;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Window window = new Window("2048");
        BoardUI boardUI = new BoardUI(board);

        window.add(boardUI);
        window.showWindow();
    }
}