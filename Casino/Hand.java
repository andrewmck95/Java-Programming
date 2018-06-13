import java.util.ArrayList;

public class Hand {

	static ArrayList<Card> hand;

	public Hand(ArrayList hand) {
		this.hand=hand;
	}
	
	public String toString() {
		return hand+"";
	}
}
