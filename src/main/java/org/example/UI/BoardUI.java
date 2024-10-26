package org.example.UI;

import org.example.Tile.Board;
import org.example.Tile.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static org.example.UI.Colors.BOARD_BACKGROUND;
import static org.example.UI.Colors.TILE_BACKGROUND;

public class BoardUI extends JPanel implements KeyListener {

    private static final int TILE_WIDTH = 110;
    private static final int TILE_HEIGHT = 110;
    private static final int TITLE_PLACE_START_X = 133;
    private static final int TITLE_PLACE_START_Y = 120;
    private final Tile[][] tilePlaces = new Tile[4][4];
    private final Board board;

    public BoardUI(Board board) {
        this.board = board;
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawTilePlaces(g);
        drawTile(g);
    }

    public void drawBackground(Graphics g) {
        int boardWidth = 500;
        int x = (getWidth() - boardWidth) / 2;

        int boardHeight = 500;
        int y = (getHeight() - boardHeight) / 2;

        g.setColor(BOARD_BACKGROUND);
        g.fillRect(x, y, boardWidth, boardHeight);
    }

    private void drawTilePlaces(Graphics g) {
        int x = TITLE_PLACE_START_X;
        int y = TITLE_PLACE_START_Y;

        g.setColor(TILE_BACKGROUND);

        for (int i = 0; i < tilePlaces.length; i++) {
            for (int j = 0; j < tilePlaces[i].length; j++) {
                g.fillRect(x, y, TILE_WIDTH, TILE_HEIGHT);
                x += 120;
            }
            x = TITLE_PLACE_START_X;
            y += TITLE_PLACE_START_Y + 1;
        }
    }

    public void drawTile(Graphics g) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                Tile tile = board.getTile(i, j);

                if (tile != null && tile.getValue() > 0) {
                    int offsetX = TITLE_PLACE_START_X + j * 120;
                    int offsetY = TITLE_PLACE_START_Y + i * 120;

                    g.setColor(WHITE);
                    g.fillRect(offsetX, offsetY, TILE_WIDTH, TILE_HEIGHT);

                    g.setFont(new Font("Arial", Font.BOLD, 50));
                    g.setColor(BLACK);
                    g.drawString(String.valueOf(tile.getValue()), offsetX + 40, offsetY + 70);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                board.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                board.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                board.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                board.moveRight();
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}