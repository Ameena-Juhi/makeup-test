package cheat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static List<Card> table = new ArrayList<>();
	public static Hand player1 = new Hand();
	public static Hand player2 = new Hand();
	
	public boolean doubtClaim(Card c) {
		if (table.isEmpty()) {
			System.out.println("Table is empty. Cannot doubt.");
			return false;
		}
		if (table.get(table.size() - 1).getRank() == c.getRank())
			return false;
		else
			return true;
	}
	
	public void addAll(Card... cards) {
		for(Card card: cards) {
			table.add(card);
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		Deck deck = new Deck();
		
		System.out.println(deck.distributeCards(player1, player2));
		Scanner sc = new Scanner(System.in);
		System.out.println("Player who got Ace of Spades starts the game");
		Card card = new Card(sc.nextLine());
		if (player1.exists(card)) {
			player1.removeMatchedCards(card);
			game.addAll(card);
		}
		else {
			player2.removeMatchedCards(card);
			game.addAll(card);
		}
		
		int i = 0;
		while (i < 3) {
			System.out.println("Opponent's Turn");
			String input = sc.nextLine();
			if (input.equals("doubt")) {
				System.out.println("Player who doubts, provide card for checking the rank, "
						+ "and also mention whether you are player1 or player2");
				String[] parts = sc.nextLine().split(" ");
				Card doubtCard = new Card(parts[0]);
				String player = parts[1];
				if (game.doubtClaim(doubtCard)) {
					if (player.equals("player1"))
						player2.addAll(table);
					else
						player1.addAll(table);
				}
				else
					player2.addAll(table); 
				table.clear(); 
			}
			else {
				Card next = new Card(input);
				game.addAll(next);
				if (player1.exists(next)) {
					player1.removeMatchedCards(next);
					System.out.println(player1);
				}
				else {
					player2.removeMatchedCards(next);
					System.out.println(player2);
				}
			}
			System.out.println(table);
			i++;
		}
		System.out.println(player1);
		System.out.println(player2);
		System.out.println("Game Over");
		sc.close();
	}
}

