
import java.util.Scanner;

public class Game {
	int bookSize = 4;
	
	boolean playerTurn = true;
	
	Deck deck = new Deck();
	Player player = new Player(deck, this);
	AiPlayer Ai = new AiPlayer(deck,this);
	
	Scanner reader = new Scanner(System.in);  // Reading from System.in
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
		
		System.out.println("Type any letter to continue");
		 n = game.reader.next(); // Scans the next token of the input as a Char.
	}

		System.out.println("Lets begin.");
		
		for( int L = 0; L < 5; L++ ){
			game.player.setHand(game.player.deck.drawCard());
			
		}
		
		for( int L = 0; L < 5; L++ ){
			game.Ai.setHand(game.Ai.deck.drawCard());
			
		}
		
		game.player.displayHand();
				
		if(game.player.checkForBook() == true){
			System.out.println("you got a point.");
		}
		
		game.player.checkForBook();
		System.out.println("");
		
		int N = 0;
		while(N != 10){	
			
			if(game.player.checkForBook() == true){
				System.out.println("you got a point.");
				System.out.println("");
			}
			
			game.player.checkForBook();
			game.Ai.checkForBook();
			
			System.out.println("Player Score: " + game.player.getScore());
			System.out.println("AI Score: " + game.Ai.getScore());
			System.out.println("");
			System.out.println("");
						
			System.out.println("Your Hand: ");
			game.player.displayHand();
			System.out.println("");
			
			game.Ai.displayHand();
			System.out.println("");
			String rankAsked = null;
			Card tempC = null;
			Rank temp = null;
			int k = 0;
			System.out.println("It's your turn ");
			System.out.println("");
			System.out.println("What rank of a card would you like to ask for?");
			System.out.println("");
			while(k != 1){
			 rankAsked = game.reader.next(); // Scans the next token of the input as a Char.
			 try {
		           Rank.valueOf(rankAsked.toUpperCase()); // but this validates with all the enum values
		           temp = Rank.valueOf(rankAsked.toUpperCase());
		           k = 1;
		        } catch (IllegalArgumentException e) {
		           System.out.println("invalid option, please try another. ");
		        } 
			}
			
			
			
			 tempC = game.Ai.askCard(temp);
			 
			
			 if(tempC != null){
				 game.player.hand.add(tempC);
				 game.playerTurn = false;
			 }
			 else{
				 System.out.println("Ai did not have the card you were looking for ");
				 System.out.println("Go Fish! ");
				 System.out.println(""); 
				 if(game.player.goFish(temp) == true){
				 
				game.playerTurn = true;
			 }
			 else{
				 game.playerTurn = false;
			 }
			 
			 }
			 if(game.playerTurn != true){
			 temp = game.Ai.AiTurn();
			 tempC = game.player.askCard(temp);
			 if(tempC != null){
				 game.Ai.hand.add(tempC);
			 }
			 else{
				 game.Ai.goFish(temp);
			 }
			 
			 }
			 
			 
			 N++;
		}
		
		
		
	}	
}
