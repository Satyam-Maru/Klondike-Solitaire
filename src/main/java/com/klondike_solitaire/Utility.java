package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utility extends JFrame implements ActionListener {

    // width and height of GamePanel is 600 x 600

    // Top panel will occupy 800 width and 40 height

    // Bottom panel will occupy 800 width and 40 height

    public static void main(String[] args) {
        new Utility();
    }

    JButton btn1, btn2;

    Utility(){
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getButtons();
        setVisible(true);
    }

    protected void getButtons(){
        btn1 = setButton(btn1, "Btn1");
        btn1.setBounds(20, 20, 100, 50);

        btn2 = setButton(btn2, "Btn2");
        btn2.setBounds(20, 80, 100, 50);

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

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
