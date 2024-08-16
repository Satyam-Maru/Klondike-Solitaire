package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;

public class LeaderBoard extends JFrame {
    JPanel panel;
    private static ImageIcon im;
    private static Image img;
    JLabel image = new JLabel();

    static {
        im = new ImageIcon("C:\\Klondike-Solitaire\\src\\main\\java\\com\\Images\\gp.png");
        img = im.getImage().getScaledInstance(440, 440, Image.SCALE_DEFAULT);
        im = new ImageIcon(img);
    }

    LeaderBoard() {

        panel = new JPanel();
        panel.setBounds(0, 0, 440, 440);
        panel.setBackground(new Color(133, 94, 66));
        panel.setLayout(null);

        add(panel);

        setUndecorated(true);
        setSize(450, 450);
        setLocation(510, 220);
        setVisible(true);
        setLayout(null);

    }

}
