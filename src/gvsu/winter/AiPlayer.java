package gvsu.winter;
import java.util.ArrayList;
import java.util.Random;

/**************************************************
 * Class for the AI opponent that extends the player class.
 *
 * @author Lanndon Rose
 * @author Michael Ames
 * @version February 2017
 ***************************************************/
public class AiPlayer extends Player {
    /**
     * A variable which holds the last rank the AI asked for.
     */
    private Rank lastChoice = null;
    /**
     * Random number the chooses a random card from the AI's hand.
     */
    private Random rand = new Random();

    /**
     * AI player constructor.
     *
     * @param deck
     *            card deck
     * @param game
     *            the current game
     */
    public AiPlayer(final Deck deck, final Game game) {
        super(deck, game);
    }

    /******************************************************************
     * This method is how the AI opponent chooses the card he is going to ask
     * the player for. It checks to see if the AI has any multiples in its hand,
     * if so it will ask for that card from the player
     *
     * @return tempR the card the AI player is choosing to ask for.
     *******************************************************************/
    public Rank aiTurn() {
        Rank tempR = null;

        ArrayList<Rank> aiChoice = new ArrayList<Rank>();

        // for each card in the player's hand loop through
        // every other card and compare ranks
        for (int i = 0; i < getHand().size(); i++) {
            for (int j = i; j < getHand().size(); j++) {

                // if another card's rank matches the target card's rank add it
                // to an array
                if (getHand().get(i).getRank() == getHand().get(j).getRank()
                        && getHand().get(i).getSuit()
                        != getHand().get(j).getSuit()) {
                    aiChoice.add(getHand().get(j).getRank());

                    // add the current target's index to the array
                    aiChoice.add(getHand().get(i).getRank());
                    tempR = aiChoice.get(0);

                }
            }
        }

        if (tempR == null) {
            tempR = getHand().get(0).getRank();
        }
        if (lastChoice == tempR) {
            // causes the AI to ask for another card at random
            int randomNum = rand.nextInt(getHand().size());
            tempR = getHand().get(randomNum).getRank();
        }
        // Prints out the card the AI wants to ask for
       // System.out.println("Do you have any: " + tempR);
        lastChoice = tempR;
        return tempR;
    }
}
