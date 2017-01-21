import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck;
	Random rand = new Random();
	
	public Deck() {
		deck = new ArrayList<Card>();
		for(int suit = 0; suit < 4; suit++) {
			for(int rank = 0; rank < 13; rank++) {
				deck.add(new Card(Suit.values()[suit], Rank.values()[rank]));
			} 
		}
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public Card drawCard() {
		// generate a random number between 0 and the number of cards in the deck
		int randNum = rand.nextInt(deck.size());
		
		//remove and return a card from the deck
		return deck.remove(randNum);
	}
	
	
}


