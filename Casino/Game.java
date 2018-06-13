import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	static int numPlayers=0;
	ArrayList<Hand> hands = new ArrayList<Hand>();

	public static void main(String[] args) {

		Deck deck1 = new Deck();
		// Print the deck
		System.out.println("Deck:\n-------------------\n" + deck1);
		deck1.cardsRemaining();
		
		// Shuffling the deck
		deck1.shuffle();
		
		// Get user input 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of players: ");
		numPlayers = sc.nextInt();
		sc.close();
		
		// creating hands and specifying number of players as parameter
		System.out.println("\nCreating hands:\n-------------------");
		for(int i=0; i<numPlayers; i++) {
		System.out.println("\nHand number: "+(i+1));
		deck1.createHand(numPlayers);
		}

	}
}
