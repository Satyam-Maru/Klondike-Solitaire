package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utility extends JPanel implements ActionListener {

    private static JPanel topPanel, bottomPanel;

    // width and height of GamePanel is 800 x 600

    // Top panel will occupy 800 width and 40 height

    // Bottom panel will occupy 800 width and 40 height

    public static void main(String[] args) {
        new Utility();
    }

    JButton btn1, btn2;

    Utility(){
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//        setLayout(null);
//
        setTopPanel();
        setBottomPanel();
//        add(getTopPanel());
//        add(getBottomPanel());
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getButtons();
//        setVisible(true);
    }

    protected void getButtons(){
        btn1 = setButton(btn1, "Btn1");
        btn1.setBounds(0, 0, 100, 40);

        btn2 = setButton(btn2, "Btn2");
        btn2.setBounds(70, 0, 100, 40);

        this.add(btn1);
        this.add(btn2);
    }

    protected JButton setButton(JButton button, String name){

        button = new JButton(name);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setForeground(Color.gray);
        button.setFocusable(false);
        button.addActionListener(this);

        return button;
    }

    protected void setTopPanel(){
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 800, 40);
        topPanel.setBackground(Color.BLACK);
    }

    protected void setBottomPanel(){
        bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 560, 800, 40);
        bottomPanel.setBackground(Color.ORANGE);
    }

    protected static JPanel getTopPanel(){
        return topPanel;
    }

    protected static JPanel getBottomPanel(){
        return bottomPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == btn1){
            System.out.println("btn 1");
        }else if(e.getSource() == btn2){
            System.out.println("btn 2");
        }
    }
}
