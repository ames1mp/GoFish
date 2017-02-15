import java.util.*;
public class AiPlayer extends Player {

	public AiPlayer(Deck deck, Game game) {
		super(deck, game);
	}

	public Rank AiTurn(){
		Rank tempR = null;
		
		ArrayList<Rank> aiChoice = new ArrayList<Rank>();
		
		//for each card in the player's hand loop through every other card and compare ranks
		for(int  i = 0; i < hand.size(); i++) {
			for(int j = i; j < hand.size(); j++) {
				
				//if another card's rank matches the target card's rank add it to an array
				if(hand.get(i).getRank() == hand.get(j).getRank() && hand.get(i).getSuit() != hand.get(j).getSuit()) {
					aiChoice.add(hand.get(j).getRank());		
						
						//add the current target's index to the array
						aiChoice.add(hand.get(i).getRank());
						tempR = aiChoice.get(i);
				}
	
			}
		}
		
		if(tempR == null){
			tempR = hand.get(0).getRank();
		}
		
		System.out.println("Do you have any: " + tempR);
		return tempR;
	}
}



