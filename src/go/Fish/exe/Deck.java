package go.Fish.exe;
import java.util.ArrayList;
import java.util.Random;

/**
 * class for making the deck of cards for GoFish.
 * @author Lanndon Rose
 * @author Michael Ames
 */
public class Deck {
	
	/**
	 * Array list for the cards in the deck.
	 */
	private ArrayList<Card> deck;
	
	/**
	 * random number variable.
	 */
	private Random rand = new Random();
	
	/**
	 * Instantiator class for the card deck.
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
