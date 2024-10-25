package org.example.UI;

import org.example.Tile.Tile;
import org.example.Tile.Board;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static org.example.UI.Colors.*;

public class TileUI extends JPanel {

    private final int tileWidth = 110;
    private final int tileHeight = 110;
    Board board = new Board();

    public void setTilePlaceStyle(Graphics g, int x, int y) {
        g.setColor(TILE_BACKGROUND);
        g.fillRect(x, y, tileWidth, tileHeight);
    }

    public void generateTile(Graphics g) {
        Tile tile = board.generateTile();

        int offsetX = 133 + tile.getX() * 120;
        int offsetY = 120 + tile.getY() * 121;

        g.setColor(WHITE);
        g.fillRect(offsetX, offsetY, tileWidth, tileHeight);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(BLACK);
        g.drawString(String.valueOf(tile.getValue()), offsetX + 40, offsetY + 70);

    }
}
