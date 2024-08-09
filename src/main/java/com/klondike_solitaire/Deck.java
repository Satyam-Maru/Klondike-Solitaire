package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Deck extends Pile implements ActionListener{

    JButton btn = null;

    public Deck(int x, int y) {

        super(x, y);
        super.setSize(72, 96);

        for (Suit suit : Suit.values()) {
            for (int j = 1; j <= 13; ++j) {
                push(new Card(j, suit));
            }
        }

        Collections.shuffle(cards);

        initButton();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.white);
        g2d.drawRect(0, 0, this.getWidth(), this.getHeight());

        if (!isEmpty()) {
            g.drawImage(Card.getCardBack(), 0, 0, this.getWidth(), this.getHeight(), this);
            if(btn != null){
                // btn is created
                this.remove(btn);
                this.revalidate();
                this.repaint();
            }
        }else{
            // jyare deck khali hase tyare aa run thase
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            this.add(btn);
        }
    }

    protected void initButton(){
        btn = new JButton(String.valueOf("Reset"));
        btn.setFont(new Font("Sans Serif", Font.BOLD, 10));
        btn.setBounds(0, 30, 70, 20);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btn){
            while(!GamePanel.getWastePile().isEmpty()){
                push(GamePanel.getWastePile().pop());
            }
            this.repaint();
            GamePanel.getWastePile().repaint();
        }
    }
}
