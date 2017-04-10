package gvsu.winter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * class for the cards of a deck.
 *
 * @author Lanndon Rose
 * @author Michael Ames
 */

public class Card {
    /**
     * variable for the suite of a card.
     */
    private Suit suit;

    /**
     * variables to the Rank of a card.
     */
    private Rank rank;

    private String fileName;

    private Image img;

    private final int SMALL_SIZE = 100;



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

    public String getFilename() {
    	return fileName;
    }

    private String genFileName(){
    	String fileName;
    	fileName = "res/";
    	fileName += getRank().toString().toUpperCase();
    	fileName +="_of_";
    	fileName += getSuit().toString().toLowerCase();
    	fileName +=".png";
    	return fileName;

	}

    /**
     * getter method to retrieve the rank of a card.
     *
     * @return rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * sets the rank of card to a specified enum value.
     *
     * @param trank
     *            card rank
     */
    public void setRank(final Rank trank) {
        this.rank = trank;
    }

    /**
     * returns suit of a card.
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * set suit of a card.
     *
     * @param temp
     *            suit of a card
     */
    public void setSuit(final Suit temp) {
        this.suit = temp;
    }

    public Image getImage() {
    	return img;
    }

    private Image createImage() {
    	BufferedImage img = null;
    	try {
    	    img = ImageIO.read(new File(genFileName()));
    	} catch (IOException e) {
    	}

    	BufferedImage newImage = new BufferedImage(100, 140,
    			BufferedImage.TYPE_INT_RGB);

    	Graphics g = newImage.createGraphics();
    	g.drawImage(img, 0, 0, SMALL_SIZE, SMALL_SIZE, null);
    	g.dispose();

    	Image img3 = newImage;

    	img3.getScaledInstance(100, 140, Image.SCALE_SMOOTH);

    	return img3;
    }

    /**
     * toString method for displaying a card with rank and suit.
     *
     * {@link java.lang.Object#toString()}
     * @return rankSTR
     */
    @Override
    public String toString() {
        String suitSTR = this.suit.toString().toLowerCase();
        String rankSTR = this.rank.toString().toLowerCase();
        return rankSTR + " of " + suitSTR;
    }

}

