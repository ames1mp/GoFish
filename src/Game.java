import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	int bookSize = 4;
	
	Deck deck = new Deck();
	Player player = new Player(deck, this);
	
	public Game(){
	}
	
	public int getBookSize() {
		return bookSize;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		System.out.println("Welcome to Gofish");
		System.out.println("This version is single player, so you will being playing an AI.");
		System.out.println("The human player starts first.");
		String n = "S";
	while(n == "S"){	
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Type any letter to continue");
		 n = reader.next(); // Scans the next token of the input as an int.
	}
	
		System.out.println("Lets begin.");
		
		for( int L = 0; L < 5; L++ ){
			game.player.setHand(game.player.deck.drawCard());
			
		}
		/*
		for(int i = 0; i < deck.deck.size(); i++) {
			System.out.println(deck.getDeck().get(i).getRank() + " of " + deck.getDeck().get(i).getSuit());
		}
		*/
		/*
		Card card;
		
		System.out.println("Num cards in decK: " + game.deck.getDeck().size());
		
		for(int i = 0; i < 20; i++) {
			card = game.deck.drawCard();
			System.out.println(card.toString());
			System.out.println("Num cards in deck: " + game.deck.getDeck().size());		
		}
		
		*/
		
//		ArrayList<Card> hand = new ArrayList<Card>();
//		
//		Card card = new Card(Suit.CLUBS, Rank.ACE);
//		hand.add(card);
//		
//		Card card3 = new Card(Suit.DIAMONDS, Rank.ACE);
//		hand.add(card3);
//		
//		Card card1 = new Card(Suit.SPADES, Rank.ACE);
//		hand.add(card1);
//		
//		Card card2 = new Card(Suit.HEARTS, Rank.ACE);
//		hand.add(card2);
//		
//		Card card4 = new Card(Suit.DIAMONDS, Rank.TWO);
//		hand.add(card4);
//		
//		game.player.setHand(hand);
		
		for(int i = 0; i < game.player.getHand().size(); i++) {
			System.out.println(game.player.getHand().get(i).toString());		
		}
		
		if(game.player.checkForBook() == true){
			System.out.println("you got a point.");
		}
		
		game.player.checkForBook();
		System.out.println("");
		
		
		for(int i = 0; i < game.player.getHand().size(); i++) {
			System.out.println(game.player.getHand().get(i).toString());		
		}
		
		
		
	}	
}
