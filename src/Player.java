import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	int score;
	ArrayList<Card> hand = new ArrayList<Card>();
	Deck deck;
	Game game;

	public Player(Deck deck, Game game) {
		this.deck = deck;
		this.game = game;
		score = 0;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	/*******************************************************************************************************************
    Draws a card from the deck and adds it to the player's hand
    @return True if the player draws the card they asked for.
    @param request The card the player requested from another player.
    *******************************************************************************************************************/
	public boolean goFish(Rank request) {
		
		Card card = deck.drawCard();
		hand.add(card);
		
		if(card.rank == request)
			return true;
		return false;
	}
	
	
	/*******************************************************************************************************************
    Check's the player's hand for a book (set of N cards of the same rank).
    Remove the book from the player's hand and add 1 to the player's score if found.
    @return True if a book is found
    *******************************************************************************************************************/
	public boolean checkForBook() {
		
		ArrayList<Card> remove = new ArrayList<Card>();
		boolean bookFound = false;
		
		//for each card in the player's hand loop through every other card and compare ranks
		for(int  i = 0; i < hand.size(); i++) {
			for(int j = 0; j < hand.size(); j++) {
				
				//if another card's rank matches the target card's rank add it to an array
				if(hand.get(i).getRank() == hand.get(j).getRank() && hand.get(i).getSuit() != hand.get(j).getSuit()) {
					remove.add(hand.get(j));
					
					//if the number of indices in the array is the size of a book - 1 . . .
					if(remove.size() == game.getBookSize() - 1) {
						
						//add the current target's index to the array
						remove.add(hand.get(i));
						
						//and remove all of the cards from the player's hand
						hand.removeAll(remove);
						bookFound = true;
						score++;
						//break the inner loop and continue with the outer loop
						break;						
					}
				}
			}			
		}
		return bookFound;
	}
	
	/*******************************************************************************************************************
    Ask another player for any cards of the given rank
    @return An ArrayList containing the requested cards. If the other player has none of the requested
    cards an empty array is returned. 
    @param request The card the player requested from another player.
    @param other The player the request is being made of
    *******************************************************************************************************************/
	public ArrayList<Card> requestCard(Rank request, Player other){
		ArrayList<Card> requestedCards = new ArrayList<Card>();
		int numCards = other.checkForCard(request);
		if(numCards == 0)
			return requestedCards;
		else {
			for(int i = 0; i < numCards; i++) {
				
			}
		}
	}
	
	
	/*******************************************************************************************************************
    Checks this player's hand for the requested card.
    @return The number of cards of the given rank in this player's hand
    @param request The card rank the other player would like
    *******************************************************************************************************************/
	public int checkForCard(Rank request) {
		int numCards = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getRank() == request) 
				numCards++;		
		}
		return numCards;
	}
	
	
	/*******************************************************************************************************************
    Draws a card from the deck and adds it to the player's hand
    @return True if the player draws the card they asked for.
    @param request The card the player requested from another player.
    *******************************************************************************************************************/
	public Card giveCard(Rank request) {
		
	}

}
