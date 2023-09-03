package cheat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand {
	
	private List<Card> cards;
	
	public Hand(List<Card> cards) {
		List<Card> temp = new ArrayList<>(cards);
		this.cards = temp;
	}
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void add(Card c) {
		if (!cards.contains(c))
			cards.add(c);
	}
	
	public void addAll(List<Card> c1) {
		cards.addAll(c1);
	}
	
	public boolean exists(Card c) {
		Iterator<Card> iterator = cards.iterator();
		CardComparator comp = new CardComparator();
		while (iterator.hasNext()) {
			Card card = iterator.next();
			int val = comp.compare(card,c);
			if (val==0)
				return true;
		}
		return false;
	}
	
	
	public Card removeMatchedCards(Card...c) {
		if (cards.isEmpty()) {
			System.out.println("No more cards left! I am the winner!");
			return null;
		}
		for (Card cardToRemove : c) {
	        Iterator<Card> iterator = cards.iterator();
	        while (iterator.hasNext()) {
	            Card card = iterator.next();
	            if (card.getRank() == cardToRemove.getRank()) {
	                iterator.remove();
	            }
	        }
		}
		return removeSomething();
	}
	
	public Card removeSomething() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left! I am the winner!");
			return null;
		}
		return cards.remove(0);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}

}