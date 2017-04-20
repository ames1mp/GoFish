package gvsu.winter;

import java.io.Serializable;

/******************************************************************************
 *Tracks and updates the game state.
 *Keeps track of the state of the deck, the player's hand,
 *the AI's hand
 * @author Lanndon Rose
 * @author Michael Ames
 * @version Winter 2017
 *****************************************************************************/

public class Game implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 * sets the number of cards need to get a point.
	 */
	private static final int BOOKSIZE = 4;

	/**
	 * set the number of cards in the players hand.
	 */
	private static final int HANDSIZE = 7;

	/**
	 * variable for whether or not it is the players turn.
	 */
	private boolean playerTurn = true;

	/**
	 * instantiates a deck of cards.
	 */
	private Deck deck;

	/**
	 * instantiates a new human player.
	 */
	private  Player player;

	/**
	 * instantiates a new AI player.
	 */
	private  AiPlayer ai;

	/**
	 * Creates a new game, dealing hands to the players.
	 *
	 */
	    public Game() {
		this.deck = new Deck();
		this.player = new Player(this.deck, this);
		this.ai = new AiPlayer(this.deck, this);

		// adds seven cards to the players hand
		for (int i = 0; i < HANDSIZE; ++i) {
			player.setHand(deck.drawCard());
		}
		// adds seven cards to the AI players hand
		for (int i = 0; i < HANDSIZE; ++i) {
			ai.setHand(deck.drawCard());
		}
	}

	/**
	 * Method for determining if it is the player turn or not.
	 *
	 * @return true or false
	 */
	public boolean isPlayerTurn() {
		return playerTurn;
	}

	/**
	 * method for returning number of cards of the same rank
	 * needed to gain a point.
	 * @return BOOKSIZE - number of cards needed to score a point
	 */
	public int getBookSize() {
		return BOOKSIZE;
	}

	/**
	 * Method for updating score and removing cards from
	 * the players' hands.
	 */
	public void updateGame() {
        player.checkForBook();
		ai.checkForBook();
	}

	/**
	 * @return deck the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @return player the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return ai the AI player
	 */
	public AiPlayer getAi() {
		return ai;
	}

	/**
	 * Sets boolean to true or false depending
	 * on whether it is the players turn or not.
	 * @param lplayerTurn
	 *            boolean
	 */
	public void setPlayerTurn(final boolean lplayerTurn) {
		playerTurn = lplayerTurn;
	}

}
