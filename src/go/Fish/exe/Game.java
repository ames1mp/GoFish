package go.Fish.exe;

import java.util.Scanner;

/**
 * The class where the game is put together and run. 
 * @author Lanndon Rose
 * @author Michael Ames
 */
public class Game {
/**
 *sets the number of cards need to get a point.
 */
private int bookSize = 3;

/**
 * variable for whether or not it is the players turn.
 */
private boolean playerTurn = true;

/**
 * instantiates a deck of cards.
 */
private Deck deck = new Deck();

/**
 * instantiates a new human player.
 */
private Player player = new Player(deck, this);

/**
 * instantiates a new AI player.
 */
private AiPlayer ai = new AiPlayer(deck, this);

/**
 * scanner for taking in user input.
 */
private Scanner reader = new Scanner(System.in);

/**
 * method for returning number of same cards needed to gain a point.
 * @return booksize - number of cards needed
 */
public int getBookSize() {
return bookSize;
}
	
	/**
	 * The main method for playing GoFish.
	 * @param args basic for main method
	 */
	public static void main(final String[] args) {
		// create a new game
		Game game = new Game();
		
		System.out.println("Welcome to Gofish");
		System.out.println("This version is single player, ");
		System.out.println("so you will being playing an AI.");
		System.out.println("The human player starts first.");
		String n = "S";
	while (!n.equals("b")) {
		
		System.out.println("Press B then Enter to begin");
		// Scans the next token of the input as a Char.
		 n = game.reader.next(); 
	}

		System.out.println("Lets begin.");
		//adds seven cards to the players hand
		for (int l = 0; l < 7; l++) {
			game.player.setHand(game.player.deck.drawCard());
			
		}
		//adds seven cards to the AI players hand
		for (int l = 0; l < 7; l++) {
			game.ai.setHand(game.ai.deck.drawCard());
			
		}
	//checks to see if user got a point at the start of the game
		if (game.player.checkForBook() == true) {
			System.out.println("you got a point.");
		}
		
		game.player.checkForBook();
		System.out.println("");

	//games is over when the deck has no cards left
		while (game.deck.getSize() != 0) {	
			
			if (game.player.checkForBook() == true) {
				System.out.println("you got a point.");
				System.out.println("");
			}
			
			game.player.checkForBook();
			game.ai.checkForBook();
		System.out.println("Player Score: " + game.player.getScore());
		System.out.println("AI Score: " + game.ai.getScore());
		
		//spacing
		System.out.println("");
		System.out.println("");
						
			System.out.println("Your Hand: ");
			//displays user hand
			game.player.displayHand();
			System.out.println("");
		
			System.out.println("");
			
			String rankAsked = null;
			Card tempC = null;
			Rank temp = null;
			
			//variable to loop going
			int k = 0;
//print outs that tell user what is going on
System.out.println("It's your turn ");
System.out.println("");
System.out.println("What rank of a card would you like to ask for?");
System.out.println("");
			while (k != 1) {
rankAsked = game.reader.next(); // Scans the next token of the input as a Char.
			 try {
				// but this validates with all the enum values
				 Rank.valueOf(rankAsked.toUpperCase()); 
		           temp = Rank.valueOf(rankAsked.toUpperCase());
		           k = 1;
		        } catch (IllegalArgumentException e) {
	 System.out.println("invalid option, please try another. ");
		        } 
			}
			
			
			
			 tempC = game.ai.askCard(temp);
			 
			//checks to see if tempC was set to anything
			 if (tempC != null) {
				 game.player.getHand().add(tempC);
				 game.playerTurn = false;
				 
			 } else {
	System.out.println("Ai did not have the card you were looking for ");
	System.out.println("Go Fish! ");
	System.out.println(""); 
				 if (game.player.goFish(temp) == true) {
         System.out.println("You got the card you asked for from the deck");
		 System.out.println("So you get to take your turn again.");
				 
				game.playerTurn = true;
			 
				 } else {
				 game.playerTurn = false;
			 }
			 
			 }
			 if (game.playerTurn == false) {
			 temp = game.ai.aiTurn();
			 tempC = game.player.askCard(temp);
			 if (tempC != null) {
				 game.ai.getHand().add(tempC);
			 
			 } else {
				 game.ai.goFish(temp);
			 }
			 
			 }
		}
		
		
		
	}	
}
