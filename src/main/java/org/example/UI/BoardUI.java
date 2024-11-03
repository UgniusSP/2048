package org.example.UI;

import org.example.Logic.Game;
import org.example.Logic.Model.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Color.BLACK;
import static org.example.UI.Colors.*;

public class BoardUI extends JPanel implements KeyListener {

    private static final int TILE_WIDTH = 110;
    private static final int TILE_HEIGHT = 110;
    private static final int TITLE_PLACE_START_X = 133;
    private static final int TITLE_PLACE_START_Y = 120;
    private final Tile[][] tilePlaces = new Tile[4][4];
    private final Game game;
    private final ScoreboardUI scoreboardUI;

    public BoardUI(Game game, ScoreboardUI scoreboardUI) {
        this.game = game;
        this.scoreboardUI = scoreboardUI;
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawTilePlaces(g);
        drawTile(g);
        gameOver();
    }

    public void drawBackground(Graphics g) {
        int boardWidth = 525;
        int x = (getWidth() - boardWidth) / 2;

        int boardHeight = 525;
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
                Tile tile = game.getTile(i, j);

                if (tile != null && tile.getValue() > 0) {
                    int offsetX = TITLE_PLACE_START_X + j * 120;
                    int offsetY = TITLE_PLACE_START_Y + i * 120;

                    g.setColor(TILE);
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
                game.moveUp();
                //System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                game.moveDown();
                //System.out.println("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                game.moveLeft();
                //System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                game.moveRight();
                //System.out.println("RIGHT");
                break;
        }
        scoreboardUI.updateScore();
        revalidate();
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

    private void gameOver() {
        if(game.isGameOver()){
            JOptionPane.showMessageDialog(this, "Game Over");
        } else if(game.isGameWon()){
            JOptionPane.showMessageDialog(this, "You won!");
        }
    }
}