package org.example.UI;

import org.example.Logic.Utils.Scoreboard;

import javax.swing.*;

public class ScoreboardUI extends JPanel {
    private final JLabel scoreLabel;

    public ScoreboardUI() {
        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);
    }

    public void updateScore() {
        scoreLabel.setText("Score: " + Scoreboard.getScore());
    }

}
