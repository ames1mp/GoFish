package gvsu.winter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Mike Ames
 * @author Lanndon Rose
 *
 */
public class PlayerTest {



    /**
     *test the checkForBook method true case.
     */
    @Test
    public void testCheckForBook() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        player.setHand(hand);

        assertEquals(player.checkForBook(), true);
    }

    /**
     *test the checkForBook method false case.
     */
    @Test
    public void testCheckForBook2() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        player.setHand(hand);

        assertEquals(player.checkForBook(), false);

    }

    /**
     *test the checkForBook method true case.
     */
    @Test
    public void testCheckForBook3() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.CLUBS, Rank.TWO));
        hand.add(new Card(Suit.DIAMONDS, Rank.TWO));
        hand.add(new Card(Suit.HEARTS, Rank.TWO));
        hand.add(new Card(Suit.SPADES, Rank.TWO));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        player.setHand(hand);

        assertEquals(player.checkForBook(), true);
    }

    /**
     *test the checkForBook method false case.
     */
    @Test
    public void testCheckForBook4() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));

        player.setHand(hand);

        assertEquals(player.checkForBook(), false);
    }

    /**
     *test the goFish method true case.
     */
    @Test
    public void testGoFish() {
        Game game = new Game();
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(Suit.DIAMONDS, Rank.ACE));
        game.getDeck().setDeck(deck);
        Player player = new Player(game.getDeck(), game);


        assertEquals(player.goFish(Rank.ACE), true);
    }

    /**
     *test the goFish method false case.
     */
    @Test
    public void testGoFish2() {
        Game game = new Game();
        ArrayList<Card> deck = new ArrayList<Card>();
        deck.add(new Card(Suit.DIAMONDS, Rank.ACE));
        game.getDeck().setDeck(deck);
        Player player = new Player(game.getDeck(), game);


        assertEquals(player.goFish(Rank.THREE), false);
    }

    /**
     *test the AskCard method true case.
     */
    @Test
    public void testAskCard() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));
        player.setHand(hand);

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(new Card(Suit.DIAMONDS, Rank.ACE));
        expectedOutput.add(new Card(Suit.HEARTS, Rank.ACE));
        expectedOutput.add(new Card(Suit.SPADES, Rank.ACE));

        ArrayList<Card> output = new ArrayList<Card>();
        output = player.askCard(Rank.ACE);

        assertEquals(output.size() == expectedOutput.size(), true);

        for (Card c : output) {
        	int i = output.indexOf(c);
        	assertEquals(c.getRank()
        			== expectedOutput.get(i).getRank(), true);
        	 assertEquals(c.getSuit()
                     == expectedOutput.get(i).getSuit(), true);
        }


    }

    /**
     *test the askCard method false case.
     */
    @Test
    public void testAskCard2() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));
        player.setHand(hand);

        ArrayList<Card> expectedOutput = new ArrayList<Card>();


        ArrayList<Card> output = new ArrayList<Card>();
        output = player.askCard(Rank.THREE);

        assertEquals(output.size() == expectedOutput.size(), true);
    }

    /**
     *test the askCard method false case.
     */
    @Test
    public void testAskCard3() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));
        player.setHand(hand);

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(new Card(Suit.HEARTS, Rank.ACE));


        ArrayList<Card> output = new ArrayList<Card>();
        output = player.askCard(Rank.THREE);

        assertEquals(output.size() != expectedOutput.size(), true);
    }

    /**
     *test the hasRankInHand method true.
     */
    @Test
    public void testHasRankInHand() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));

        player.setHand(hand);

        assertEquals(player.hasRankInHand(Rank.ACE), true);
    }

    /**
     * test the hasRankInHand method false.
     */
    @Test
    public void testHasRankInHand2() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN));

        player.setHand(hand);

        assertEquals(player.hasRankInHand(Rank.THREE), false);
    }

    /**
     * test the sortHand method.
     */
    @Test
    public void testSortHand() {
        Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        ArrayList<Card> lHand = new ArrayList<Card>();

        lHand.add(new Card(Suit.HEARTS, Rank.TWO));
        lHand.add(new Card(Suit.SPADES, Rank.EIGHT));
        lHand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        player.setHand(lHand);


        lHand = new ArrayList<Card>();
        lHand.add(new Card(Suit.SPADES, Rank.THREE));
        lHand.add(new Card(Suit.SPADES, Rank.SEVEN));
        player.setHand(lHand);

        player.sortHand();

        ArrayList<Card> sortedHand = new ArrayList<Card>();
        sortedHand.add(new Card(Suit.DIAMONDS, Rank.ACE));
        sortedHand.add(new Card(Suit.HEARTS, Rank.TWO));
        sortedHand.add(new Card(Suit.SPADES, Rank.THREE));
        sortedHand.add(new Card(Suit.SPADES, Rank.SEVEN));
        sortedHand.add(new Card(Suit.SPADES, Rank.EIGHT));

        assertEquals(player.getHand().get(0).getRank(),
        		sortedHand.get(0).getRank());
        }

    /**
     * test get/set score.
     */
    @Test
    public void score() {
    	Game game = new Game();
        Player player = new Player(game.getDeck(), game);
        int score = 4;
        player.setScore(score);

        assertEquals(player.getScore(), score);
    }





}
