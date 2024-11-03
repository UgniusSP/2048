package org.example.UI;

import javax.swing.*;
import static org.example.UI.Colors.*;

public class Window extends JFrame {

    public Window(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setBackground();
    }

    public void showWindow() {
        setVisible(true);
    }

    private void setBackground() {
        getContentPane().setBackground(WINDOW_BACKGROUND);
    }

    public void add(JPanel panel) {
        super.add(panel);
    }
}
