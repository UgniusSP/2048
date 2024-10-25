package org.example.UI;

import javax.swing.*;

import static org.example.UI.Colors.*;

public class Window extends JFrame {
    private final JFrame frame;

    public Window(String title) {
        super(title);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        setBackground(frame);
    }

    public void showWindow(){
        frame.setVisible(true);
    }

    private void setBackground(JFrame frame){
        frame.getContentPane().setBackground(WINDOW_BACKGROUND);
    }

    public void add(JPanel panel){
        frame.add(panel);
    }

}
