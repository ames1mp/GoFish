package gvsu.winter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * player class for the game Gofish.
 *
 * @author Lanndon Rose
 * @author Michael Ames
 */

public class Player {

    /**
     * variable for keeping the players score.
     */
    private int score;


    /**
     * Array list for holding the cards in the players hand.
     */
    private ArrayList<Card> hand = new ArrayList<Card>();


    /**
     * variable for the current deck being used in the game.
     */
    private Deck deck;


    /**
     * variable for the current game being played.
     */
    private Game game;


    /**
     * variable for a specific card in the player hand.
     */
    private Card card;




    /**
     * @return deck the passed in Deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param pDeck deck to set
     */
    public void setDeck(final Deck pDeck) {
        this.deck = pDeck;
    }

    /**
     * @return game the current game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param pGame game to set
     */
    public void setGame(final Game pGame) {
        this.game = pGame;
    }

    /**
     * @return card
     */
    public Card getCard() {
        return card;
    }

    /**
     * @param pCard card to set
     */
    public void setCard(final Card pCard) {
        this.card = pCard;
    }

    /**
     * @param pScore score to set
     */
    public void setScore(final int pScore) {
        this.score = pScore;
    }

    /**
     * @param pHand hand to set the player's hand to
     */
    public void setHand(final ArrayList<Card> pHand) {
        this.hand = pHand;
    }

    /***************************************************************************
     * Constructor for the player.
     *
     * @param tdeck
     *            current deck
     * @param tgame
     *            current game
     **************************************************************************/
    public Player(final Deck tdeck, final Game tgame) {
        this.deck = tdeck;
        this.game = tgame;
    }

    /**
     * returns the players score.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * returns the players current hand.
     *
     * @return hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * adds the parameter card to the player hand.
     *
     * @param temp
     *            temporary variable
     */
    public void setHand(final Card temp) {

        hand.add(temp);
    }

    /**************************************************************************
     * Draws a card from the deck and adds it to the player's hand.
     *
     * @return True if the player draws the card they asked for.
     * @param request
     *            The card the player requested from another player.
     **************************************************************************/
    public boolean goFish(final String request) {
    	
    	String[] trash = request.split(" ");
    	
    	Rank tempR =  Rank.valueOf(trash[0].toUpperCase());
    	
        card = deck.drawCard();
        hand.add(card);
        // checks to see if the card the player gets is the one they asked for.
        // if true, the player takes their turn again.
        if (card.getRank() == tempR) {
            return true;
        }
        return false;
    }

    /**************************************************************************
     * Check's the player's hand for a book (set of N cards of the same rank).
     * Remove the book from the player's hand and add 1 to the player's score if
     * found.
     *
     * @return True if a book is found
     **************************************************************************/
    public boolean checkForBook() {

        ArrayList<Card> remove = new ArrayList<Card>();
        boolean bookFound = false;

        // for each card in the player's hand loop through every other
        // card and compare ranks
        for (int i = 0; i < hand.size(); i++) {
            for (int j = i; j < hand.size(); j++) {

                // if another card's rank matches the target card's rank add it
                // to an array
                if (hand.get(i).getRank() == hand.get(j).getRank()
                        && hand.get(i).getSuit() != hand.get(j).getSuit()) {
                    remove.add(hand.get(j));

                    // if the number of indices in the array is the size of a
                    // book - 1 . . .
                    if (remove.size() == game.getBookSize() - 1) {
                        // adds the target card to the array
                        remove.add(hand.get(i));

                        System.out.println("you got a point for "
                        + remove.get(0).getRank() + "s");

                        // and remove all of the cards from the player's hand
                        hand.removeAll(remove);
                        bookFound = true;
                        score++;
                        // break the inner loop and continue with the outer loop
                        break;
                    }
                }
            }
            remove.clear();
        }
        return bookFound;

    }

    /**************************************************************************
     * method for checking the opponents hand to see if they had the card asked
     * for.
     *
     * @param stringC the ranked the player is asking for.
     * @return true or false
     *************************************************************************/
    public boolean  askCard(final String stringC) {
    	
    	String[] trash = stringC.split(" ");
    	
    	Rank tempC =  Rank.valueOf(trash[0].toUpperCase());
        ArrayList<Card> cards = new ArrayList<Card>();

        // loops through every card and checks it with the one asked
        for (int i = 0; i < Game.getAi().getHand().size(); i++) {
        	
        	
            if (Game.getAi().getHand().get(i).getRank().equals(tempC)) {
                cards.add(Game.getAi().getHand().get(i));
                Game.getAi().getHand().remove(Game.getAi().getHand().get(i));
                
          
        }
        }
        System.out.println(" ");
        
        if (cards.size() > 0) {
          for (Card c : cards) {
              Game.getPlayer().setHand(c);
          }
        } else { 
        	return false;
        }
		return true;
        
        }
    

    /**
     * method for displaying the players hand.
     */
    public void displayHand() {
        // loops through every card and prints it out
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }

    /**************************************************************************
     * Checks to see whether the player has a card of the passed in rank in his
     * or her hand.
     *
     * @param rank The rank in question
     * @return boolean whether the player has a card of the requested rank
     *************************************************************************/
    public boolean hasRankInHand(final Rank rank) {
        Boolean hasRank = false;
        for (Card c : hand) {
            if (rank.equals(c.getRank())) {
                hasRank = true;
            }
        }
        return hasRank;
    }
}
