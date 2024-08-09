package com.klondike_solitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Deck extends Pile {

    static int count = 0;
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
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            count++;
            btn = new JButton(String.valueOf(count));
            btn.setBounds(10, this.getHeight() / 2, 60, 20);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    while(!GamePanel.getWastePile().isEmpty()){
                        push(GamePanel.getWastePile().pop());
                    }
                   // g.drawImage(Card.getCardBack(), 0, 0, getWidth(), getHeight(), null);
                }
            });
            this.add(btn);
        }
    }
}
