package cheat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards = new ArrayList<Card>();
	public static int Max_cards = 13;
	public static int Max_suits = 4;
	
	public Deck() {
		for (int suit=1; suit<=Max_suits;suit++ ){
			for(int rank=1; rank<=Max_cards; rank++){
			cards.add(new Card(rank,suit));
			}
		
		}
	}
	
	public int getLen() {
		return cards.size();
	}
	
	public Card removeTop() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left!");
			return null;
		}
		return cards.remove(0);
	}
	
	public Card removeBottom() {
		return cards.remove(cards.size() - 1);
	}
	
	public void addToTop(Card c) {
		cards.add(0,c);
	}
	
	public void addToBottom(Card c) {
		cards.add(52,c);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public String distributeCards(Hand h1,Hand h2) {
		Deck deck = new Deck();
        deck.shuffle();

        while (deck.getLen()>0) {
            h1.add(deck.removeTop());
            if (deck.getLen()>0) {
                h2.add(deck.removeTop());
            }
        }
        return("Player1: " + h1 + "Player2: " + h2);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	
	}
	
}

