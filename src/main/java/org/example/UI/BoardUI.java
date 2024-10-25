package org.example.UI;

import javax.swing.*;
import java.awt.*;

import static org.example.UI.Colors.*;

public class BoardUI extends JPanel {

    private TileUI[][] tilePlaces;
    TileUI tileUI = new TileUI();
    private static final int TITLE_PLACE_START_X = 133;
    private static final int TITLE_PLACE_START_Y = 120;

    public BoardUI(){
        initializeTilePlaces();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    public void drawBoard(Graphics g) {
        drawBackground(g);
        drawTilePlaces(g);

        for(int i = 0; i < 2; i++){
            tileUI.generateTile(g);
        }

    }

    public void drawBackground(Graphics g) {
        int boardWidth = 500;
        int x = (getWidth() - boardWidth) / 2;

        int boardHeight = 500;
        int y = (getHeight() - boardHeight) / 2;

        g.setColor(BOARD_BACKGROUND);
        g.fillRect(x, y, boardWidth, boardHeight);
    }

    private void drawTilePlaces(Graphics g){
        int x = TITLE_PLACE_START_X;
        int y = TITLE_PLACE_START_Y;

        for(int i = 0; i < tilePlaces.length; i++){
            for(int j = 0; j < tilePlaces.length; j++){
                tilePlaces[i][j].setTilePlaceStyle(g, x, y);
                x += 120;
            }
            x = TITLE_PLACE_START_X;
            y += TITLE_PLACE_START_Y + 1;
        }
    }

    private void initializeTilePlaces(){
        tilePlaces = new TileUI[4][4];
        for(int i = 0; i < tilePlaces.length; i++){
            for(int j = 0; j < tilePlaces.length; j++){
                tilePlaces[i][j] = new TileUI();
            }
        }
    }

}
