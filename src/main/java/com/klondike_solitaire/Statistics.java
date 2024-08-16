package com.klondike_solitaire;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Statistics extends JFrame {

    // private JButton back;
    private JLabel statisticsLable, gameplayedLable, gameWonLable, besttimeLale, totalmoveLable, bestscoreLable;
    private JPanel panel;

    public Statistics() {

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, 340, 390);
        panel.setLayout(null);
        add(panel);

        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setBackground(Color.BLUE);
        statisticsPanel.setBounds(0, 0, 350, 35);
        statisticsPanel.setLayout(null);
        panel.add(statisticsPanel);

        statisticsLable = new JLabel("STATISTICS");
        statisticsLable.setBackground(Color.BLUE);
        statisticsLable.setForeground(Color.white);
        statisticsLable.setFont(new Font("Consalas", Font.BOLD, 30));
        statisticsLable.setBounds(80, 5, 340, 34);
        statisticsLable.setOpaque(true);
        statisticsPanel.add(statisticsLable);

        gameplayedLable = new JLabel("Game Played :");
        gameplayedLable.setBackground(Color.black);
        gameplayedLable.setForeground(Color.white);
        gameplayedLable.setFont(new Font("Consalas", Font.BOLD, 18));
        gameplayedLable.setBounds(20, 80, 200, 20);
        gameplayedLable.setOpaque(true);
        panel.add(gameplayedLable);

        gameWonLable = new JLabel("Game Won:");
        gameWonLable.setBackground(Color.black);
        gameWonLable.setForeground(Color.white);
        gameWonLable.setFont(new Font("Consalas", Font.BOLD, 18));
        gameWonLable.setBounds(20, 130, 200, 20);
        gameWonLable.setOpaque(true);
        panel.add(gameWonLable);

        besttimeLale = new JLabel("Best Time:");
        besttimeLale.setBackground(Color.black);
        besttimeLale.setForeground(Color.white);
        besttimeLale.setFont(new Font("Consalas", Font.BOLD, 18));
        besttimeLale.setBounds(20, 180, 200, 20);
        besttimeLale.setOpaque(true);
        panel.add(besttimeLale);

        totalmoveLable = new JLabel("Total Moves:");
        totalmoveLable.setBackground(Color.black);
        totalmoveLable.setForeground(Color.white);
        totalmoveLable.setFont(new Font("Consalas", Font.BOLD, 18));
        totalmoveLable.setBounds(20, 230, 200, 20);
        totalmoveLable.setOpaque(true);
        panel.add(totalmoveLable);

        bestscoreLable = new JLabel("Highest Score:");
        bestscoreLable.setBackground(Color.black);
        bestscoreLable.setForeground(Color.white);
        bestscoreLable.setFont(new Font("Consalas", Font.BOLD, 18));
        bestscoreLable.setBounds(20, 280, 200, 20);
        bestscoreLable.setOpaque(true);
        panel.add(bestscoreLable);

        JButton button = new JButton("Back");
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBounds(100, 350, 150, 30);
        button.setFocusable(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(350, 400);
        this.setLocation(580, 220);

        this.setUndecorated(true);
        this.setVisible(true);
        this.setLayout(null);

    }

}
