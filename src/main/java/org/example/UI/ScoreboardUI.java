package org.example.UI;

import org.example.Logic.Game;
import org.example.Logic.Utils.Scoreboard;

import javax.swing.*;

public class ScoreboardUI extends JPanel {
    private final JLabel scoreLabel;
    private static ScoreboardUI instance;

    public ScoreboardUI() {
        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);
    }

    public static ScoreboardUI getInstance() {
        if(instance == null) {
            instance = new ScoreboardUI();
        }
        return instance;
    }

    public void updateScore() {
        scoreLabel.setText("Score: " + Scoreboard.getScore());
    }

}
