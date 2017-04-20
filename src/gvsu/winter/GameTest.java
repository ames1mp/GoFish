package gvsu.winter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class GameTest {
	GUIgoFish g = new GUIgoFish();
	@Test
	public void testGetBookSize() {
		 Game game = new Game(g);
		 assertEquals(game.getBookSize(), 4);
	}

	@Test
	public void testMain() {
		Game game = new Game(g);
		String input = "two";
		 InputStream in = new ByteArrayInputStream(input.getBytes());
		 System.setIn(in);

		// assertEquals(Rank.TWO, game.scanRank());


	}

	@Test
	public void saveGame() {
		Game game = new Game(g);
		game.getPlayer().setHand(new Card(Suit.SPADES, Rank.ACE));
		game.getPlayer().setHand(new Card(Suit.DIAMONDS, Rank.TWO));
		game.getPlayer().setHand(new Card(Suit.HEARTS, Rank.THREE));
		game.getPlayer().setHand(new Card(Suit.CLUBS, Rank.KING));

		game.writeObject();

	}

	@Test
	public void loadGame() {
		Game game = new Game(g);
		game.getPlayer().setHand(new Card(Suit.SPADES, Rank.ACE));
		game.getPlayer().setHand(new Card(Suit.DIAMONDS, Rank.TWO));
		game.getPlayer().setHand(new Card(Suit.HEARTS, Rank.THREE));
		game.getPlayer().setHand(new Card(Suit.CLUBS, Rank.KING));

		game.writeObject();
		game.loadObject();

		assertEquals(
		game.getPlayer().getHand().get(0),
		new Card(Suit.SPADES, Rank.ACE));

		assertEquals(
		game.getPlayer().getHand().get(1),
		new Card(Suit.DIAMONDS, Rank.TWO));

		assertEquals(
		game.getPlayer().getHand().get(2),
		new Card(Suit.HEARTS, Rank.THREE));

		assertEquals(
		game.getPlayer().getHand().get(3),
		new Card(Suit.CLUBS, Rank.KING));
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
