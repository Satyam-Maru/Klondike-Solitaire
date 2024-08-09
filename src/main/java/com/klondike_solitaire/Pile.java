package com.klondike_solitaire;

import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JPanel;

public abstract class Pile extends JPanel{

    protected int x, y;
    protected Stack<Card> cards;


}