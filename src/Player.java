import java.util.ArrayList;

/**
 * player class for the game Gofish.
 * @author Lanndon Rose
 * @author Michael Ames
 */
public class Player {

/**
 *variable for keeping the players score.
 */
private int score;
/**
 *Array list for holding the cards in the players hand.
 */
private ArrayList<Card> hand = new ArrayList<Card>();
/**
 *variable for the current deck being used in the game.
 */
Deck deck;
/**
 *variable for the current game being played.
 */
private Game game;
/**
 *variable for a specific card in the player hand. 
 */
private Card card;

/**
 * constructor for the player.
 * @param tdeck current deck
 * @param tgame current game
 */
public Player(final Deck tdeck, final Game tgame) {
this.deck = tdeck;
this.game = tgame;
}

/**
 * returns the players score.
 * @return score
 */
public int getScore() {
return score;
}
/**
 * returns the players current hand.
 * @return hand
 */
public ArrayList<Card> getHand() {
return hand;
}

/**
 * adds the parameter card to the player hand.
 * @param temp temporary variable
 */
public void setHand(final Card temp) {

hand.add(temp);
}

/**************************************************************************
    Draws a card from the deck and adds it to the player's hand.
    @return True if the player draws the card they asked for.
    @param request The card the player requested from another player.
    **************************************************************************/
public boolean goFish(final Rank request) {
card = deck.drawCard();
hand.add(card);
//checks to see if the card the player gets is the one they asked for.
//if true, the player takes their turn again.
if (card.getRank() == request) {
return true;
}
return false;
}

/**************************************************************************
Check's the player's hand for a book (set of N cards of the same rank).
Remove the book from the player's hand and add 1 to the player's
score if found.
@return True if a book is found
**************************************************************************/
	public boolean checkForBook() {

		ArrayList<Card> remove = new ArrayList<Card>();
		boolean bookFound = false;

//for each card in the player's hand loop through every other
//card and compare ranks
for (int  i = 0; i < hand.size(); i++) {
for (int j = i; j < hand.size(); j++) {

//if another card's rank matches the target card's rank add it to an array
if (hand.get(i).getRank() == hand.get(j).getRank()
&& hand.get(i).getSuit() != hand.get(j).getSuit()) {
					remove.add(hand.get(j));
					
	//if the number of indices in the array is the size of a book - 1 . . .
if (remove.size() == game.getBookSize() - 1) {
//adds the target card to the array 
remove.add(hand.get(i));
						
System.out.println("you got a point for " + remove.get(0).getRank() + "s");
						
//and remove all of the cards from the player's hand
						hand.removeAll(remove);
						bookFound = true;
						score++;
//break the inner loop and continue with the outer loop
break;						
					}
				}
			}
			remove.clear();
		}
		return bookFound;
		
		
	}
	
/**
 * method for checking the opponents hand to see if they had the card asked
 * for.
 * @param tempC the ranked the player is asking for.
 * @return card the card the player has or does not have.
 */
	public Card askCard(final Rank tempC) {
		//loops through every card and checks it with the one asked
		for (int d = 0; d < hand.size(); d++) {
			if (hand.get(d).getRank() == tempC) {
				card = hand.get(d);
				hand.remove(d);			
			break;
			
			} else {
				card = null;
			}
		}
		return card;
	}
	
	/**
	 * method for displaying the players hand.
	 */
	public void displayHand() {
		//loops through every card and prints it out
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).toString());		
		}
	}
}
