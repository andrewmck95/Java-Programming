import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	public static String[] suits = { "Clubs", "Spades", "Hearts", "Diamonds" };
	public static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static ArrayList<Card> deck = new ArrayList<Card>();
	

	public Deck() {
		for (String r : ranks) {
			for (String s : suits) {
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}

	public String toString() {
		return deck + "";
	}
	
	public void cardsRemaining() {
		System.out.println(deck.size()+" cards remaining.");
	}

	public void shuffle() {
		// Shuffle the deck
		Collections.shuffle(deck);
		// Checking that the deck is shuffled
		System.out.println("\nShuffled deck:\n-------------------\n" + deck);
	}

	public void createHand(int numPlayers) {
		// To distribute and even number of cards to each player
		int numCards = 52 / numPlayers;

		// Creating hand as arraylist, then inputting arraylist into hand object
		ArrayList<Card> hand = new ArrayList<Card>();

		for (int i = 0; i < numCards; i++) {
			//System.out.println(deck.remove(1));
			hand.add(deck.get(0));
			deck.remove(0);
		}
		Hand h = new Hand(hand);
		System.out.println(h);
		cardsRemaining();
	}

}
