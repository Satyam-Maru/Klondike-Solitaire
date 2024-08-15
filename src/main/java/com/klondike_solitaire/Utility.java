package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utility extends JPanel implements ActionListener, Runnable {

    // width and height of GamePanel is 800 x 600

    // Top panel will occupy 800 width and 40 height

    // Bottom panel will occupy 800 width and 40 height

    private static JPanel topPanel, bottomPanel;
    JButton leaderboardBtn, statisticsBtn, undoBtn, resetBtn;
    static  JLabel scoreLabel, scoreValueLabel, moveLabel, moveValueLabel, timeLabel, timeValueLabel;
    Thread thread;
    int count = 0;
    int sec = 0, min = 0;

    Utility() {
        getButtons();
        setLabels();
        setTopPanel();
        setBottomPanel();
    }

    protected void getButtons() {
        // for top panel
        leaderboardBtn = initButton(leaderboardBtn, "LeaderBoard");
        leaderboardBtn.setBounds(0, 5, 140, 35);

        statisticsBtn = initButton(statisticsBtn, "Statistics");
        statisticsBtn.setBounds(150, 5, 120, 35);

        // for bottom panel
        undoBtn = initButton(undoBtn, "Undo");
        undoBtn.setBounds(250, 0, 100, 35);

        resetBtn = initButton(resetBtn, "Reset");
        resetBtn.setBounds(400, 0, 100, 35);
    }

    protected JButton initButton(JButton button, String name) {

        button = new JButton(name);
        button.setFont(new Font("Rockwell", Font.BOLD, 16));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.GREEN);
        // button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.addActionListener(this);

        return button;
    }

    protected void setTopPanel() {
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 800, 40);
        topPanel.setBackground(Color.GREEN);
        topPanel.setLayout(null);

        topPanel.add(leaderboardBtn);
        topPanel.add(statisticsBtn);
        topPanel.add(scoreLabel);
        topPanel.add(scoreValueLabel);
        topPanel.add(moveLabel);
        topPanel.add(moveValueLabel);
        topPanel.add(timeLabel);
        topPanel.add(timeValueLabel);
    }

    protected void setBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0, 560, 800, 40);
        bottomPanel.setBackground(Color.GREEN);

        bottomPanel.add(undoBtn);
        bottomPanel.add(resetBtn);
    }

    protected JLabel initLabel(JLabel label, String name) {
        label = new JLabel(name);
        label.setFont(new Font("Rockwell", Font.BOLD, 21));
        label.setForeground(Color.BLACK);
        return label;
    }

    protected void setLabels() {
        // 5-5 (x) gab between string and score label
        scoreLabel = initLabel(scoreLabel, "Score:");
        scoreLabel.setBounds(320, 5, 65, 30);

        scoreValueLabel = initLabel(scoreValueLabel, "0");
        scoreValueLabel.setBounds(390, 5, 50, 30);

        moveLabel = initLabel(moveLabel, "Moves:");
        moveLabel.setBounds(460, 5, 80, 30);

        moveValueLabel = initLabel(moveValueLabel, "0");
        moveValueLabel.setBounds(545, 5, 50, 30);

        timeLabel = initLabel(timeLabel, "Time:");
        timeLabel.setBounds(610, 5, 65, 30);

        timeValueLabel = initLabel(timeValueLabel, "00:00");
        timeValueLabel.setBounds(680, 5, 80, 30);
    }

    protected static JPanel getTopPanel() {
        return topPanel;
    }

    protected static JPanel getBottomPanel() {
        return bottomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == undoBtn) {

            if(!GamePanel.undo.isEmpty()){
                if(Pile.point-20<=0){
                    Pile.point=0;
                    Utility.scoreValueLabel.setText(String.valueOf(Pile.point));
                }
                else{
                    Pile.point-=20;
                    Utility.scoreValueLabel.setText(String.valueOf(Pile.point));
                }

                Pile prevPile = GamePanel.undo.peek().prevPile;
                Pile currentPile = GamePanel.undo.peek().currentPile;

                prevPile.push(GamePanel.undo.pop());
                currentPile.pop();

                prevPile.repaint();
                currentPile.repaint();
                System.out.println("check");
            }
        }
        else if (e.getSource() == resetBtn) {
            Solitaire.solitaire.dispose();
            Solitaire.solitaire = new Solitaire();
        }
    }

    @Override
    public void run() {
        try {
            while (min != 60) {

                if (sec == 60) {
                    sec = 0;
                    min++;
                } else {
                    sec++;
                }

                timeValueLabel.setText(String.valueOf(min) + " : " + String.valueOf(sec));

                Thread.sleep(1000);
            }
            System.out.println("Thread completed!!!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
