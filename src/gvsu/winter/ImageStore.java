package gvsu.winter;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * A class to load and store all of the images used by the game.
 * Images are stored in a hash map as ImageIcons, and accessed by
 * String keys. Keys for cards are produced by the card's toString method.
 *
 */
public class ImageStore {

	/**
	 *A hash map which holds game images as ImageIcons,
	 *and accesses them with string keys.
	 */
	private HashMap<String, ImageIcon> images;

	/**
	 * Creates a new ImageStore object, which hold all of the
	 * images used in the game.
	 */



	public ImageStore() {
		images = new HashMap<String, ImageIcon>();
		loadImages();
	}

	/**
	 * Load images into memory, and store them in a hash map.
	 */
	private void loadImages() {

		Deck deck = new Deck();
		ImageIcon cardBack = new ImageIcon(
				new ImageIcon("res/cardBack.png").getImage()
				.getScaledInstance(
						100, 140, Image.SCALE_SMOOTH));
		images.put("cardBack", cardBack);

		ImageIcon logo = new ImageIcon(
				new ImageIcon("res/logo.png").getImage()
				.getScaledInstance(
						582, 282, Image.SCALE_SMOOTH));
		images.put("logo", logo);


		ImageIcon opponent = new ImageIcon(
				new ImageIcon("res/opponent.jpg")
				.getImage().getScaledInstance(
						582, 282, Image.SCALE_SMOOTH));
		images.put("opponent", opponent);


		ImageIcon player = new ImageIcon(
				new ImageIcon("res/player.jpg")
				.getImage().getScaledInstance(
						582, 282, Image.SCALE_SMOOTH));
		images.put("player", player);




		for (Card c : deck.getDeck()) {

			String key = c.toString();

			ImageIcon card = new ImageIcon(
					new ImageIcon(c.getFilename())
					.getImage().getScaledInstance(
						100, 140, Image.SCALE_SMOOTH));

			images.put(key, card);
		}
	}

	public void loadBackground(Rectangle r) {
		ImageIcon background = new ImageIcon(
				new ImageIcon("res/background.png")
				.getImage().getScaledInstance(
						r.width, r.height, Image.SCALE_SMOOTH));
		images.put("background", background);
	}



	/**
	 * @return images the hash map containg the images
	 */
	public HashMap<String, ImageIcon> getImages() {
		return images;
	}



}
