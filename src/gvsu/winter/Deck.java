package gvsu.winter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mike Ames
 * @author Lanndon Rose
 *
 */
public class Deck implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 * Array list for the cards in the deck.
	 */
	private ArrayList<Card> deck;

	/**
	 * random number variable.
	 */
	private Random rand = new Random();

	/**
	 * Constructor for the card deck.
	 */
	public Deck() {
		deck = new ArrayList<Card>();
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
		deck.add(new Card(Suit.values()[suit], Rank.values()[rank]));
			}
		}
	}

	/**
	 * getter method for retrieving the deck of cards.
	 * @return deck the deck of cards
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}

	/**
	 * @param pDeck deck to set
	 */
	public void setDeck(final ArrayList<Card> pDeck) {
        this.deck = pDeck;
    }

/**
 * draws a random card from the deck.
 * @return deck.remove(randNum) returns the card and removes it from the deck
 */
	public Card drawCard() {
// generate a random number between 0 and the number of cards in the deck
		int randNum = rand.nextInt(deck.size());

		//remove and return a card from the deck
		return deck.remove(randNum);
	}

	/**
	 * method for getting the deck size.
	 * @return deck.size() the size of the deck
	 */
	public int getSize() {

		return deck.size();
	}


}


