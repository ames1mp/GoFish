package gvsu.winter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/******************************************************************************
 * @author Lanndon Rose
 * @author Michael Ames
 *****************************************************************************/

public class Game implements Serializable {

	/**
	 *
	 */
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
	 * instantiates the gui.
	 */
	private  GUIgoFish gui;

	private static Game loadGame;


	/**
	 * method for setting the gui up with instances of game aspects.
	 *
	 * @param gui
	 *            gofish user interface variable
	 */
	public Game(final GUIgoFish gui) {
		this.deck = new Deck();
		this.player = new Player(this.deck, this);
		this.ai = new AiPlayer(this.deck, this);
		this.gui = gui;

		// adds seven cards to the players hand
		for (int i = 0; i < HANDSIZE; ++i) {
			player.setHand(deck.drawCard());
		}
		// adds seven cards to the AI players hand
		for (int i = 0; i < HANDSIZE; ++i) {
			ai.setHand(deck.drawCard());
		}

		// gameLoop();
	}

	/**
	 * method for determining if it is the player turn or not.
	 *
	 * @return true or false
	 */
	public boolean isPlayerTurn() {
		return playerTurn;
	}

	/**
	 * method for returning number of same cards needed to gain a point.
	 *
	 * @return BOOKSIZE - number of cards needed to score a point
	 */
	public int getBookSize() {
		return BOOKSIZE;
	}

	/**
	 * Method for updating score and tell player they got a point.
	 */
	public void updateGame() {

		if (player.checkForBook()) {
			gui.getYourMsg().setText("You scored a point!");
			gui.getYourScore().setText("Your Score:" + player.getScore());
		}

		if (ai.checkForBook()) {
			gui.getTheirMsg().setText("You scored a point!");
			gui.getTheirMsg().setText("Your Score:" + ai.getScore());
		}
	}

	public static Game getLoadGame(){
		return loadGame;
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
	 * sets boolean to true or false depending on whether it is the players turn
	 * or not.
	 *
	 * @param playerTurn
	 *            boolean
	 */
	public void setPlayerTurn(final boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	/**
	 * method for saving game.
	 */
	public void writeObject() {
		try (FileOutputStream file = new FileOutputStream("res/game.ser");
				BufferedOutputStream buffer = new BufferedOutputStream(file);
				ObjectOutputStream output = new ObjectOutputStream(buffer);) {
			output.writeObject(this);
			output.close();
		} catch (IOException ex) {
			GUIgoFish.getERROR();
			ex.printStackTrace();
		}
	}

	static void loadObject() {
		try (InputStream file = new FileInputStream("res/game.ser");
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream(buffer);) {

			 loadGame = (Game) input.readObject();
		} catch (ClassNotFoundException ex) {

		} catch (IOException ex) {

		}
	}
}
