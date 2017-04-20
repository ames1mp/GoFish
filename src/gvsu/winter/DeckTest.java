package gvsu.winter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * Test file for the Deck class.
 *
 */
public class DeckTest {

	/** Test the drawCard method. **/
	@Test
	public void testDrawCard() {
		Deck d = new Deck();
		int size = d.getSize();
		d.drawCard();
		 assertEquals(size - 1, d.getSize());
	}

	/** Test the setters and getters. **/
	@Test
	public void testSetGet() {
		Deck d = new Deck();
		d.drawCard();
		d.drawCard();
		d.drawCard();
		d.drawCard();
		d.drawCard();
		d.drawCard();
		Deck e = new Deck();
		d.setDeck(e.getDeck());
		 assertEquals(52, d.getSize());
	}

}
