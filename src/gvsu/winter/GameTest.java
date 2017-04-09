package gvsu.winter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGetBookSize() {
		 Game game = new Game();

		 assertEquals(game.getBookSize(), 4);

	}

	@Test
	public void testMain() {
		Game game = new Game();
		String input = "two";
		 InputStream in = new ByteArrayInputStream(input.getBytes());
		 System.setIn(in);

		 assertEquals(Rank.TWO, game.scanRank());




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
