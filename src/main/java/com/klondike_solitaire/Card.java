package com.klondike_solitaire;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {

    public static String cardBackFilename = "",
                         cardOutlineFilename = "",
                         fpBaseFilename = "";

    public static String directory = "", extension = "";

    private Image im;
    private int value;
    private String suit;
    private boolean faceUp;
    private Colour colour;

    public Card(int value, Suit suit){

        this.value = value;

        switch (suit){

            case Clubs:
                this.suit = "c";
                colour = Colour.Black;
                break;

            case Diamonds:
                this.suit = "d";
                colour = Colour.Red;
                break;

            case Spades:
                this.suit = "s";
                colour = Colour.Black;
                break;

            case Hearts:
                this.suit = "h";
                colour = Colour.Red;
                break;
        }

        faceUp = false;

        try{
            ImageIcon ii = new ImageIcon(getClass().getResource("s"));
            im = ii.getImage();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private String cardFile(Suit s, int value){

        char ch;

        if (value < 1 || value > 13)
            throw new IllegalArgumentException("Bad Card Number");

        if(s == Suit.Clubs){
            ch = 'c';
        }else if(s == Suit.Hearts){
            ch = 'h';
        }else if(s == Suit.Spades){
            ch = 's';
        }else if(s == Suit.Diamonds){
            ch = 'd';
        }
        else throw new IllegalArgumentException("Bad Card Suit");

        if(value < 10)
            return "/0" + value + ch + extension;
        else
            return "/" + value + ch + extension;
    }

    public Image getCardImage(){
        return im;
    }

    public boolean isFaceUp(){
        return faceUp;
    }
}
