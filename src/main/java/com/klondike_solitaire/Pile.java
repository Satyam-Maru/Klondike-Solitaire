package com.klondike_solitaire;

import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JPanel;

public abstract class Pile extends JPanel{

    protected int x, y;
    protected Stack<Card> cards;

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