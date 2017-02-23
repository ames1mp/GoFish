
/**
 * class for the cards of a deck.
 * 
 *@author Lanndon Rose
 *@author Michael Ames
 */
public class Card {
/**
 * variable for the suite of a card.
 */
private Suit suit;

/**
 * variables to the Rank of a card.
 */
private Rank rank;
	
/**
	 * Card constructor.
	 * @param temp1 suit of a card
	 * @param temp2 rank of a card
	 */
	public Card(final Suit temp1, final Rank temp2) {
		this.rank = temp2;
		this.suit = temp1;
	}

	/**
	 * getter method to retrieve the rank of a card.
	 * @return rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * sets the rank of card to a specified enum value.
	 * @param trank card rank
	 */
	public void setRank(final Rank trank) {
		this.rank = trank;
	}

	/**
	 * returns suit of a card.
	 * @return suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * set suit of a card.
	 * @param temp suit of a card
	 */
	public void setSuit(final Suit temp) {
		this.suit = temp;
	}

	/**
	 * toString method for displaying a card with rank and suit.
	 * @see java.lang.Object#toString().
	 * @return rankSTR
	 */
	public String toString() {
String suitSTR = this.suit.toString().toLowerCase();
String rankSTR = this.rank.toString().toLowerCase();
		return rankSTR + " of " + suitSTR;
	}
	
	
	
	
}
