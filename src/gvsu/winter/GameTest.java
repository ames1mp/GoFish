package gvsu.winter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *Test file for the game class.
 */
public class GameTest {

	/**
	 * The the getBook method.
	 */
	@Test
	public void testGetBookSize() {
		 Game game = new Game();
		 assertEquals(game.getBookSize(), 4);
	}


/*
	@Test
	public void testGetDeck() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAi() {
		fail("Not yet implemented");
	}
*/
}
