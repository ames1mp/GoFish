package gvsu.winter;

import java.io.Serializable;

/**
 * This class represents a playing card, and holds the
 * rank and suit of the card. It also contains a file name
 * that corresponds to the image file for that card.
 *
 * @author Lanndon Rose
 * @author Michael Ames
 */

public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * variable for the suite of a card.
     */
    private Suit suit;

    /**
     * variables to the Rank of a card.
     */
    private Rank rank;

    /**
     * The name of the card's image file.
     */
    private String fileName;

    /**
     * Card constructor.
     *
     * @param temp1
     *            suit of a card
     * @param temp2
     *            rank of a card
     */
    public Card(final Suit temp1, final Rank temp2) {
        this.rank = temp2;
        this.suit = temp1;
        fileName = genFileName();
    }

    /**
     *Returns the name of the card's image file.
     * @return fileName the file name.
     */
    public String getFilename() {
    	return fileName;
    }

    /**
     * Generates the file name of the card's
     * corresponding image file.
     * @return lFileName a filename
     */
    private String genFileName() {
    	String lFileName = "";
    	lFileName = "res/";
    	lFileName += getRank().toString().toUpperCase();
    	lFileName += "_of_";
    	lFileName += getSuit().toString().toLowerCase();
    	lFileName += ".png";
    	return lFileName;
	}

    /**
     * Getter method to retrieve the rank of a card.
     *
     * @return rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Sets the rank of card to a specified enum value.
     *
     * @param trank
     *            card rank
     */
    public void setRank(final Rank trank) {
        this.rank = trank;
    }

    /**
     * Returns suit of a card.
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Set suit of a card.
     *
     * @param temp
     *            suit of a card
     */
    public void setSuit(final Suit temp) {
        this.suit = temp;
    }

    /**
     * Returns a string representation of the card
     * in the form 'rank of suit'.
     */
    @Override
    public String toString() {
        String suitSTR = this.suit.toString().toLowerCase();
        String rankSTR = this.rank.toString().toLowerCase();
        return rankSTR + " of " + suitSTR;
    }

}



