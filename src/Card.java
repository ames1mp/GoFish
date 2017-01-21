
public class Card {
	Suit suit;
	Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		String suit = this.suit.toString().toLowerCase();
		String rank = this.rank.toString().toLowerCase();
		return rank + " of " + suit;
	}
	
	
	
	
}
