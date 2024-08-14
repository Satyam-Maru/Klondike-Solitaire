package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;

public class Solitaire extends JFrame {

    protected static GamePanel gamePanel;
    protected static final int PANEL_WIDTH = 800, PANEL_HEIGHT = 600;

    public Solitaire(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLocation(300,110);
        setResizable(false);
        add(gamePanel);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Solitaire();
    }
}