package org.example;

import org.example.UI.BoardUI;
import org.example.UI.Window;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("2048");
        BoardUI boardUI = new BoardUI();

        window.add(boardUI);
        window.showWindow();
    }
}