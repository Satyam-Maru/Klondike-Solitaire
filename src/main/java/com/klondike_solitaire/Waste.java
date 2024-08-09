package com.klondike_solitaire;

import java.awt.Graphics;

public class Waste extends Pile {

   public Waste(int x,int y){
       super(x,y);
       super.setSize(72,96);
   }

   protected  void paintComponent(Graphics g){

       super.paintComponent(g);

       if(this.isEmpty()){
           g.drawImage(Card.getCardOutline(),0,0,this.getWidth(),this.getHeight(),this);
       }
       else{
           g.drawImage(this.topCard().getCardImage(),0,0,this.getWidth(),this.getHeight(),this);
       }
   }
}
