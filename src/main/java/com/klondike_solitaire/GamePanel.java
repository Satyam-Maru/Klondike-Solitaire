package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        System.out.println("commit");
    }
}
