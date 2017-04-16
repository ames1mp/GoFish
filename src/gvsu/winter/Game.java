package gvsu.winter;

import java.util.ArrayList;
import java.util.Scanner;

/******************************************************************************
 * @author Lanndon Rose
 * @author Michael Ames
 *****************************************************************************/

public class Game {
    /**
     * sets the number of cards need to get a point.
     */
    private static final int BOOKSIZE = 4;

    /**
     * variable for whether or not it is the players turn.
     */
    private boolean playerTurn = true;

    /**
     * instantiates a deck of cards.
     */
    private static Deck deck = new Deck();
    
    /**
     * object of game.
     */
    private static Game game1;

    /**
     * instantiates a new human player.
     */
    private static Player player = new Player(deck, game1);

    /**
     * instantiates a new AI player.
     */
    private static AiPlayer ai = new AiPlayer(deck, game1);

    /**
     * scanner for taking in user input.
     */
    private Scanner reader = new Scanner(System.in);
    
    

    /**
     * method for returning number of same cards needed to gain a point.
     *
     * @return BOOKSIZE - number of cards needed to score a point
     */
    public int getBookSize() {
        return BOOKSIZE;
    }


    /**************************************************************************
     * Scans a rank from user text input.
     *
     * @return The rank the user entered
     **************************************************************************/
    public Rank scanRank() {
        boolean running = true;
        String rankAsked = null;
        Rank temp = null;
        while (running) {
            rankAsked = this.reader.next(); // Scans the next token of the
                                            // input as a Char.
            try {
                // but this validates with all the enum values
                Rank.valueOf(rankAsked.toUpperCase());
                temp = Rank.valueOf(rankAsked.toUpperCase());
                running = false;
            } catch (IllegalArgumentException e) {
                System.out.println("invalid option, please try another. ");
            }
        }

        return temp;
    }


    /**************************************************************************
     * The main method for playing GoFish.
     *
     * @param args args
     *
     *************************************************************************/
//    public static void main(final String[] args) {
//        Game game = new Game();
//
//        System.out.println("Welcome to Gofish");
//        System.out.println("This version is single player, ");
//        System.out.println("so you will being playing an AI.");
//        System.out.println("The human player starts first.");
//        String n = "S";
//        while (!n.equalsIgnoreCase("b")) {
//
//            System.out.println("Press B then Enter to begin");
//            // Scans the next token of the input as a Char.
//            n = game.reader.next();
//        }
//
//        System.out.println("Lets begin.");
//        // adds seven cards to the players hand
//        for (int l = 0; l < 7; l++) {
//            game.player.setHand(game.player.getDeck().drawCard());
//
//        }
//        // adds seven cards to the AI players hand
//        for (int l = 0; l < 7; l++) {
//            game.ai.setHand(game.ai.getDeck().drawCard());
//
//        }
//        // checks to see if user got a point at the start of the game
//        if (game.player.checkForBook()) {
//            System.out.println("you got a point.");
//        }
//
//        game.player.checkForBook();
//        System.out.println("");
//
//        // games is over when the deck has no cards left
//        while (game.deck.getSize() != 0) {
//
//            if (game.player.checkForBook()) {
//                System.out.println("you got a point. \n");
//            }
//
//            game.player.checkForBook();
//            game.ai.checkForBook();
//            System.out.println("Player Score: " + game.player.getScore());
//            System.out.println("AI Score: " + game.ai.getScore() + "\n\n");
//
//            System.out.println("Your Hand: ");
//            // displays user hand
//            game.player.displayHand();
//            System.out.println("\n\n");
//
//            ArrayList<Card> tempC = null;
//            Rank temp = null;
//
//            // print outs that tell user what is going on
//            System.out.println("It's your turn \n");
//            System.out.println("What rank would you like to ask for? \n");
//
//            // Check that the user has the requested rank in his or her hand
//            while (true) {
//                Rank userInput = game.scanRank();
//                if (game.player.hasRankInHand(userInput)) {
//                    temp = userInput;
//                    break;
//                } else {
//                    System.out.println("Please request a rank that "
//                + "you have in your hand");
//                }
//            }
//
//            tempC = game.ai.askCard(temp);
//
//            // checks to see if tempC was set to anything
//            if (tempC.size() > 0) {
//                for (Card c : tempC) {
//                    game.player.setHand(c);
//                }
//
//                tempC.clear();
//
//                game.playerTurn = false;
//
//            } else {
//                System.out.println("AI did not have the card "
//            + "you were looking for ");
//                System.out.println("Go Fish! ");
//                System.out.println("");
//                if (game.player.goFish(temp)) {
//                    System.out.println("You got the card you asked "
//                + "for from the deck");
//                    System.out.println("So you get to take your turn again.");
//
//                    game.playerTurn = true;
//
//                } else {
//                    game.playerTurn = false;
//                }
//
//            }
//
//            if (!game.playerTurn) {
//                temp = game.ai.aiTurn();
//                tempC = game.player.askCard(temp);
//                if (tempC.size() > 0) {
//                    for (Card c : tempC) {
//                        game.ai.setHand(c);
//                    }
//
//                    tempC.clear();
//
//                } else {
//                    game.ai.goFish(temp);
//                }
//
//            }
//        }
//        
//      //checks to see who wins the game
//      		if  (game.player.getScore() == game.ai.getScore()) {
//      			System.out.println("The game is a tie ");
//      		}
//      		
//      		if  (game.player.getScore() < game.ai.getScore()) {
//      			System.out.println("The AI wins!");
//      			
//      		} else {
//      			System.out.println("You win!");
//      			
//      		}
//
//    }


    /**
     * @return deck the deck
     */
    public Deck getDeck() {
        return deck;
    }


    /**
     * @return player the player
     */
    public static Player getPlayer() {
        return player;
    }


    /**
     * @return ai the AI player
     */
    public static AiPlayer getAi() {
        return ai;
    }
    
    public static void newGame(){
    	 game1 = new Game();
    	 
    	// adds seven cards to the players hand
       for (int l = 0; l < 7; l++) {
           game1.player.setHand(game1.player.getDeck().drawCard());

       }
       // adds seven cards to the AI players hand
       for (int l = 0; l < 7; l++) {
           game1.ai.setHand(game1.ai.getDeck().drawCard());

       }
    	
    }


}
