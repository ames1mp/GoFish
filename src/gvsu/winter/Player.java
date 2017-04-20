package gvsu.winter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the player. It stores and updates the player's
 * state. The player's state includes the player's current score,
 * and the player's current hand.
 * @author Lanndon Rose
 * @author Michael Ames
 */

public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * Sets the player's score.
	 * @param pScore
	 *            score to set
	 */
	public void setScore(final int pScore) {
		this.score = pScore;
	}

	/**
	 * @param pHand
	 *            hand to set the player's hand to
	 */
	public void setHand(final ArrayList<Card> pHand) {
		if (this.hand.size() == 0) {
			this.hand = pHand;
		} else {
			this.hand.addAll(pHand);
		}

	}

	/***********************************************************************
	 * Constructor for the player.
	 *
	 * @param tdeck
	 *            current deck
	 * @param tgame
	 *            current game
	 **********************************************************************/
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
	 *            the card to add
	 */
	public void setHand(final Card temp) {

		hand.add(temp);
	}

	/***********************************************************************
	 * Draws a card from the deck and adds it to the player's hand.
	 *
	 * @return True if the player draws the card they asked for.
	 * @param request
	 *            The card the player requested from another player.
	 **********************************************************************/
	public boolean goFish(final Rank request) {
		card = deck.drawCard();
		hand.add(card);
		// checks to see if the card the player
		// gets is the one they asked for.
		// if true, the player takes their turn again.
		if (card.getRank() == request) {
			return true;
		}
		return false;
	}

	/***********************************************************************
	 * Check's the player's hand for a book
	 * (set of N cards of the same rank).
	 * Remove the book from the player's hand
	 * and add 1 to the player's score if found.
	 * @return True if a book is found
	 **********************************************************************/
	public boolean checkForBook() {

		ArrayList<Card> remove = new ArrayList<Card>();
		boolean bookFound = false;

		// for each card in the player's hand loop through every other
		// card and compare ranks
		for (int i = 0; i < hand.size(); i++) {
			for (int j = i; j < hand.size(); j++) {

				// if another card's rank matches the target
				// card's rank add it to an array
				if (hand.get(i).getRank()
						== hand.get(j).getRank()
						&& hand.get(i).getSuit()
						!= hand.get(j).getSuit()) {
					remove.add(hand.get(j));

					// if the number of indices in
					//the array is the size of a
					// book - 1 . . .
					if (remove.size()
						== game.getBookSize() - 1) {
					// adds the target card to the array
						remove.add(hand.get(i));

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

	/***********************************************************************
	 * Method for checking the opponents hand to see if
	 * they had the card asked for.
	 *
	 * @param tempC
	 *            the rank the player is asking for.
	 * @return card the card the player has or does not have.
	 *********************************************************************/
	public ArrayList<Card> askCard(final Rank tempC) {

		ArrayList<Card> cards = new ArrayList<Card>();

		// loops through every card and checks it with the one asked
		Iterator<Card> it = hand.iterator();
		while (it.hasNext()) {
			Card nextItem = it.next();
			if (nextItem.getRank() == tempC) {
				cards.add(nextItem);
				it.remove();
			}
		}
		return cards;
	}


	/***********************************************************************
	 * Checks to see whether the player has a card of the passed in
	 * rank in his or her hand.
	 *
	 * @param rank
	 *            The rank in question
	 * @return boolean whether the player has a card of the requested rank
	 *********************************************************************/
	public boolean hasRankInHand(final Rank rank) {
		Boolean hasRank = false;
		for (Card c : hand) {
			if (rank.equals(c.getRank())) {
				hasRank = true;
			}
		}
		return hasRank;
	}

	/**
	 * Sorts the player's hand by rank.
	 */
	public void sortHand() {
		System.out.println("I have " + hand.size() + " cards");
		int indexOfSmallest = 0;
		for (int i = 0; i < hand.size(); i++) {
			indexOfSmallest = i;
			for (int j = (i + 1); j < hand.size(); j++) {
				if (hand.get(j).getRank()
						.compareTo(hand
						.get(indexOfSmallest)
						.getRank()) < 0) {
					indexOfSmallest = j;
				}
			}
			Card temp = hand.get(i);
			hand.set(i, hand.get(indexOfSmallest));
			hand.set(indexOfSmallest, temp);
		}
	}
}
