package com.klondike_solitaire;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public class Deck extends  Pile{
    public Deck(int x,int y){
        super(x,y);
        super.setSize(72,96);
        for(Suit suit:Suit.values()){
            for(int j=1;j<13;j++){
                push(new Card(j,suit));

            }

        }
        Collections.shuffle(cards);

    }
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.getStroke(new BasicStroke(5));
        g2d.setColor(Color.white);
        g2d.drawRect(0,0,72,this.getHeight());

    }

}
