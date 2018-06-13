public class Card {

	public String rank;
	public String suit;

	public Card(String r, String s) {
		this.rank = r;
		this.suit = s;
	}

	public String toString() {
		return this.rank + " of " + this.suit;
	}
}
