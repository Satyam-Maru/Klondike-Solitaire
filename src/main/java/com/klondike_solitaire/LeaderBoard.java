package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoard extends JFrame {
    JPanel panel;
    private static ImageIcon im;
    private static Image img;
    JLabel rankLabel, userNameLabel, scoreLabel;

    static {
        im = new ImageIcon( System.getProperty("user.dir") +"\\src\\main\\java\\com\\Images\\gp.png");
        img = im.getImage().getScaledInstance(440, 440, Image.SCALE_DEFAULT);
        im = new ImageIcon(img);
    }

    public static void main(String[] args) {
        new LeaderBoard();
    }

    LeaderBoard() {

        panel = new JPanel();
        panel.setBounds(0, 0, 440, 440);
        panel.setBackground(Color.black);
        panel.setLayout(null);

        add(panel);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(0, 0, 450, 35);
        bluePanel.setLayout(null);
        panel.add(bluePanel);

        rankLabel = initLabels(rankLabel, "Rank");
        rankLabel.setBounds(15, 3, 120, 28);
        bluePanel.add(rankLabel);

        userNameLabel = initLabels(userNameLabel, "Username");
        userNameLabel.setBounds(150, 3, 180, 28);
        bluePanel.add(userNameLabel);

        scoreLabel = initLabels(scoreLabel, "Score");
        scoreLabel.setBounds(345, 3, 150, 28);
        bluePanel.add(scoreLabel);

        JTable table = new JTable();
        table.setBackground(Color.black);
        table.setBounds(0, 40, 450, 350);
        table.setFont(new Font("SERIF", Font.PLAIN, 18));
        panel.add(table);
        try {

            // table.setModel(DbUtils.resultSetToTableModel());
            // open comment and rs object in method
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);

        // scrollPane.setLayout(null);
        add(scrollPane);

        JButton button = new JButton("Back");
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBounds(140, 390, 150, 30);
        button.setFocusable(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(450, 450);
        setLocation(510, 220);
        setVisible(true);
        setLayout(null);

    }

    private JLabel initLabels(JLabel label, String name){

        label = new JLabel(name);
        label.setBackground(Color.BLUE);
        label.setForeground(Color.white);
        label.setFont(new Font("Consalas", Font.BOLD, 25));
        label.setOpaque(true);

        return label;
    }

}