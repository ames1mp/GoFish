package gvsu.winter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *Test file for the Card class.
 */
public class CardTest {

	/** Test the toString method. **/
	@Test
	public void testToString() {
		Card c = new Card(Suit.CLUBS, Rank.ACE);
		 String fName = c.toString();

		 assertEquals(fName, "ace of clubs");
	}

	/** Test the set rank and suit methods. **/
	@Test
	public void testSetters() {

		Card c = new Card(Suit.CLUBS, Rank.ACE);
		 c.setRank(Rank.JACK);
		 c.setSuit(Suit.HEARTS);
		 assertEquals(c.getRank(), Rank.JACK);
		 assertEquals(c.getSuit(), Suit.HEARTS);
	}

	/** Ensure the filename is returned correctly. **/
	@Test
	public void testFilename() {
		Card c = new Card(Suit.CLUBS, Rank.FOUR);
		String fName = "";
		fName = c.getFilename();

		assertEquals(fName, "res/FOUR_of_clubs.png");
	}

}
