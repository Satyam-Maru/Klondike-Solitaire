package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;

public class LeaderBoard extends JFrame {
    JPanel panel;
    LeaderBoard(){
         panel=new JPanel();
        panel.setBounds(0,0,440,440);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        add(panel);



        setUndecorated(true);
        setSize(450,450);
        setLocation(510,220);
        setVisible(true);
        setLayout(null);

    }

}
