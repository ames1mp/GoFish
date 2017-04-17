package gvsu.winter;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ImageStore {

	ImageIcon cardBack;
	HashMap<String, ImageIcon> images;
	Deck deck;

	public ImageStore() {
		deck = new Deck();
	}

	void loadImages() {
		cardBack = new ImageIcon(new ImageIcon("res/cardBack.png")
				.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH));

		images = new HashMap<String, ImageIcon>();
		for (Card c : deck.getDeck()) {

			String key = c.toString();

			ImageIcon card = new ImageIcon(new ImageIcon(c.getFilename())
					.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH));

			images.put(key, card);
		}
	}

}
