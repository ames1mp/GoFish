import java.util.ArrayList;

public class Player {
	
	int score;
	ArrayList<Card> hand = new ArrayList<Card>();
	Deck deck;
	Game game;
	Card card;

	public Player(Deck deck, Game game) {
		this.deck = deck;
		this.game = game;
	}
	
	public int getScore(){
		return score;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(Card temp) {
		
		hand.add(temp);
	}

	/*******************************************************************************************************************
    Draws a card from the deck and adds it to the player's hand
    @return True if the player draws the card they asked for.
    @param request The card the player requested from another player.
    *******************************************************************************************************************/
	public boolean goFish(Rank request) {
		
		 card = deck.drawCard();
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
			for(int j = i; j < hand.size(); j++) {
				
				//if another card's rank matches the target card's rank add it to an array
				if(hand.get(i).getRank() == hand.get(j).getRank() && hand.get(i).getSuit() != hand.get(j).getSuit()) {
					remove.add(hand.get(j));
					
					//if the number of indices in the array is the size of a book - 1 . . .
					if(remove.size() == game.getBookSize()-1) {
						
						
						//adds the target card to the array 
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
	
	public Card askCard(Rank tempC){
		for(int d = 0; d < hand.size(); d++){
			if(hand.get(d).getRank() == tempC){
				card = hand.get(d);
				hand.remove(d);			
			break;
			}
			else{
				card = null;
			}
		}
		return(card);
	}
	
	public void displayHand(){
		for(int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).toString());		
		}
	}
}
