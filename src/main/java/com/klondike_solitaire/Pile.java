package com.klondike_solitaire;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.LinkedList;
import javax.swing.JPanel;

public class Pile extends JPanel{

//    protected int x, y;
    protected  static  int point=0;
    protected  static int Move=0;
    protected Stack<Card> cards;
    protected LinkedList<Card> history; // prev node will store prevPile, next node = nextPile (currentPile)
    protected static Stack<Card> moves;

    public Pile(int x, int y){
        super.setLocation(x, y);
        cards = new Stack<>();
    }

    public Card topCard(){

        if(!this.cards.isEmpty()){
            return this.cards.peek();
        }
        return null;
    }

    public Card pop(){

        try{
            return cards.pop();
        }catch (EmptyStackException e){
            return null;
        }
    }

    public void push(Card card){
        this.cards.push(card);
    }

    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

}