package com.klondike_solitaire;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class GameMoveListener extends MouseInputAdapter {
	
	private Deck deck = GamePanel.getDeck();
	private Waste waste = null;
	private Tableau selectedTaubleau = null;
	private Foundation selectedFoundation = null;
	private Card selectedCard = null;

	@Override
	public void mousePressed(MouseEvent e) {
		Component pressedComponent = e.getComponent().getComponentAt(e.getPoint());
		if(pressedComponent instanceof Foundation) {
			selectedFoundation = (Foundation) pressedComponent;
			selectedTaubleau = null;
			waste = null;
			selectedCard = selectedFoundation.topCard();
		}else if(pressedComponent instanceof Tableau) {
			selectedTaubleau = (Tableau) pressedComponent;
			waste = null;
			selectedCard = selectedTaubleau.getClickedCard(e.getY() - 200);
			// for directly moving card from tableau to foundation
			for(Foundation foundation : GamePanel.getFoundationPiles()) {
				if(selectedTaubleau.moveTo(foundation, selectedCard)) {
					selectedTaubleau = null;
					break;
				}
			}
		}else if(pressedComponent instanceof Deck) {
			selectedTaubleau = null;
			if(!deck.isEmpty()) {
				Waste waste = GamePanel.getWastePile();
				waste.push(deck.pop());
				GamePanel.moves.add(waste.topCard()); // adding current moved card into moves stack
				GamePanel.moves.peek().prevPile = deck;
				GamePanel.moves.peek().currentPile = waste;
				waste.topCard().showFace();
			}
		}else if(pressedComponent instanceof Waste) {
			selectedTaubleau = null;
			waste = GamePanel.getWastePile();
			selectedCard = waste.topCard();
			if(selectedCard != null) {
				for(Foundation foundation : GamePanel.getFoundationPiles()) {
					foundation.moveFromWaste(waste, selectedCard);
				}
			}
		}
		e.getComponent().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(selectedCard != null) {
			Component releasedComponent = e.getComponent().getComponentAt(e.getPoint());
			if(releasedComponent instanceof Tableau) {
				if(waste != null) {
					Tableau destination = (Tableau) releasedComponent;
					if(!waste.isEmpty()) {
						destination.moveFromWaste(waste, selectedCard);
					}
//					Utility.moves++;
					waste.repaint();
				}else if(selectedTaubleau != null) {
					Tableau source = selectedTaubleau;
					Tableau destination = (Tableau) releasedComponent;
					source.moveTo(destination, selectedCard);
//					Utility.moves++;
					source.repaint();
				}else if(selectedFoundation != null) { 
					Foundation source = selectedFoundation;
					Tableau destination = (Tableau) releasedComponent;
					source.moveTo(destination, selectedCard);
//					Utility.moves++;
					source.repaint();
					destination.repaint();
				}
			}
		}
//		Utility.moveValueLabel.setText(String.valueOf(Utility.moves));
		e.getComponent().repaint();
		selectedCard = null;
		selectedFoundation = null;
		selectedTaubleau = null;
		waste = null;
	}
}