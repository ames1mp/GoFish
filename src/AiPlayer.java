import java.util.*;
public class AiPlayer {

	int score;
	ArrayList<Card> hand = new ArrayList<Card>();
	Deck deck;
	Game game; 
	
	public AiPlayer(Deck deck, Game game){
		this.deck = deck;
		this.game = game;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void setHand(ArrayList<Card> hand){
		this.hand = hand;
	}
}
