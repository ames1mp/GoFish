package gvsu.winter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * @author Lanndon Rose
 * @author Michael Ames
 * @version Winter 2017
 *
 * Specifies the GUI layout, and contains the main driver method
 * for the application.
 *
 */
public class GUIgoFish implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  The container for the user interface. **/
	private static JFrame frame;

	/** The panel for the game interface. **/
	private JPanel panel = new JPanel();

	/** Game instance. **/
	private Game game;

	/** ImageStore instance. **/
	private ImageStore store;

	/** Declare JLabels.**/
	private JLabel yourMsg, theirMsg, yourScore, theirScore,
	opponent, player, youSay, theySay, logo, background, speech;

	/** Declare JButtons.**/
	private JButton btnStart;

	/** Standardized offsets used to position GUI elements.
	 *  Offsets are calculated as 1/4 card width and height.
	 *
	 **/
	 private int wOffset, hOffset;

	 /**
	 * hasmap for the cards.
	 */
	HashMap<String, JButton> cardButtons;



	/**
	 * Constructor. Instantiates objects and
	 * calls the initialize method to define the GUI.
	 **/

	public GUIgoFish() {
		game = new Game(this);
		store = new ImageStore();
		wOffset = store.getImages().get("cardBack").getIconWidth() / 4;
		hOffset = store.getImages().get("cardBack").getIconHeight() / 4;
		initialize();
	}

	/** Defines and creates the GUI. **/
	private void initialize() {

		frame = new JFrame();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		panel.setBounds(frame.getBounds());
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		background = new JLabel();
		store.loadBackground(frame.getBounds());
		background.setIcon(store.getImages().get("background"));
		background.setBounds(frame.getBounds());


		logo = new JLabel();
		logo.setIcon(store.getImages().get("logo"));
		logo.setBounds(center(store.getImages().get("logo")));
		panel.add(logo);

		opponent = new JLabel();
		opponent.setIcon(store.getImages().get("opponent"));
		opponent.setBounds(1250, 0, 582, 282);

		player = new JLabel();
		player.setIcon(store.getImages().get("player"));
		player.setBounds(1250, 670, 582, 282);

		int sayWidth = store.getImages().get("pbub").getIconWidth();
		int sayHeight = store.getImages().get("pbub").getIconHeight();
		int sayX = panel.getWidth() / 2 - wOffset;
		int sayY = panel.getHeight() / 2;

		youSay = new JLabel();
		sayY -= hOffset * 1.5;
		youSay.setIcon(store.getImages().get("pbub"));
		youSay.setBounds(sayX, sayY, sayWidth, sayHeight);
		background.add(youSay);

		theySay = new JLabel();
		theySay.setIcon(store.getImages().get("aibub"));
		sayY -= hOffset * 8.75;
		theySay.setBounds(sayX-25, sayY+95, sayWidth, sayHeight);
		background.add(theySay);

		yourMsg = (new JLabel());
		yourMsg.setBounds(1500, 600, 100, 50);
		yourMsg.setBackground(Color.WHITE);
		yourMsg.setText("text");
		yourMsg.setOpaque(false);

		theirMsg = (new JLabel());
		theirMsg.setBounds(1500, 300, 100, 50);
		theirMsg.setBackground(Color.WHITE);
		theirMsg.setText("text");
		theirMsg.setOpaque(false);

		theirScore = new JLabel();
		theirScore.setText("SCORE:T");
		theirScore.setBounds(wOffset, (int) (hOffset * 4.5)
				- hOffset * 2, 50, 50);
		theirScore.setOpaque(false);
		//panel.add(theirScore);

		yourScore = new JLabel();
		yourScore.setText("SCORE:Y");
		yourScore.setBounds(wOffset, (panel.getHeight())
				- hOffset * 4, 50, 50);
		yourScore.setOpaque(false);
		//panel.add(yourScore);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				newGame();
			}

		});
		mnFile.add(mntmNewGame);


		JMenuItem mntmOpenSave = new JMenuItem("Open Save");
		mnFile.add(mntmOpenSave);
		mntmOpenSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Game.loadObject();
				game = Game.getLoadGame();
				panel.removeAll();
				background.removeAll();
				panel.add(background);
				showCards();
				showAICards();
				background.repaint();
				
			}

		});
		

		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnFile.add(mntmSaveGame);
		mntmSaveGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				game.writeObject();
				
			}

		});
		
		
		JMenuItem mntmEXIT = new JMenuItem("Exit");
		mntmEXIT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
				
			}

		});
		mnFile.add(mntmEXIT);
		frame.getContentPane().setLayout(null);

		JButton btnGoFish = new JButton("Go Fish");
		btnGoFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
			}
		});


		btnStart = new JButton("New Game");
		btnStart.setBounds((panel.getWidth() / 2) - (89 / 2),
				(panel.getHeight() / 2)
				+ store.getImages().get("logo")
				.getIconHeight() / 2 + 11, 100, 23);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				newGame();
				panel.remove(btnStart);
				panel.remove(logo);
				updateView();
			}
		});
		panel.add(btnStart);
	}

	/**
	 * @param img - the image
	 * @return A bounding rectangle.
	 */
	public Rectangle center(final ImageIcon img) {
		int width = img.getIconWidth();
		int height = img.getIconHeight();

		int x = panel.getWidth() / 2 - width / 2;
		int y = panel.getHeight() / 2 - height / 2;

		Rectangle r = new Rectangle(x, y, width, height);
		return r;
	}

	/**
	 * @param width - the width of the image
	 * @param height - the height of the image
	 * @return A bounding rectangle.
	 */
	public Rectangle center(final int width, final int height) {

		int x = panel.getWidth() / 2 - width / 2;
		int y = panel.getHeight() / 2 + height / 2;

		Rectangle r = new Rectangle(x, y, width, height);
		return r;
	}

	/**
	 *
	 */


	public void showCards() {

		int x = wOffset * 15;
		int y = (int) ((panel.getHeight()) - (hOffset * 14.75));
		int width = store.getImages().get("cardBack").getIconWidth();
		int height = store.getImages().get("cardBack").getIconHeight();

		for (int i = 0; i < game.getPlayer().getHand().size(); i++) {
			ImageIcon card = store.getImages().get(game.getPlayer()
					.getHand().get(i).toString());
			Rank rank = game.getPlayer().getHand().get(i).getRank();
			String key = game.getPlayer().getHand().get(i).toString();
			JButton cardButton = new JButton(card);
			cardButton.setBounds(x, y+135, width, height);
 
			cardButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					printTxt("Got any " + rank.toString() + "s?", true);
					// PLAYER TURN LOGIC
					if (game.isPlayerTurn()) {

						// Card request = game.getPlayer().getHand().get(i);
						ArrayList<Card> returnedCards = game.getAi()
								.askCard(rank);
						if (returnedCards.size() > 0) {
						printTxt("Yup, here are " + returnedCards.size() +
			" " + returnedCards.get(0).getRank().toString() + "s!", false);
							game.getPlayer().setHand(returnedCards);
							returnedCards.clear();
							game.updateGame();
							updateView();
							game.setPlayerTurn(false);

						} else {
							printTxt("Go Fish!", false);
							if (game.getPlayer().goFish(rank)) {
								printTxt("I got my card! Free turn!", true);
								game.updateGame();
								updateView();
							} else {
								game.setPlayerTurn(false);
								game.updateGame();
								updateView();
							}
						}
						// AI TURN LOGIC
					} else {
						Rank request = game.getAi().aiTurn();
						printTxt("Got any " + rank.toString() + "s?", false);
						ArrayList<Card> returnedCards = game.getPlayer()
								.askCard(request);
						if (returnedCards.size() > 0) {
							game.getAi().setHand(returnedCards);
							returnedCards.clear();
							game.updateGame();
							updateView();
							game.setPlayerTurn(true);
						} else {
							printTxt("Go Fish!", true);
							if (game.getAi().goFish(request)) {
								printTxt("I got my card! Free turn!", false);
								game.setPlayerTurn(true);
								game.updateGame();
								updateView();
							} else {
								game.setPlayerTurn(true);
								game.updateGame();
								updateView();
							}
						}
					}

				}
			});
			background.add(cardButton);
			x += 50;

		}
	}

	public void showAICards() {

		int x = wOffset * 15;
		int y = hOffset * 10;
		int width = store.getImages().get("cardBack").getIconWidth();
		int height = store.getImages().get("cardBack").getIconHeight();

		for (int i = 0; i < game.getAi().getHand().size(); i++) {

			JLabel cardBackLabel = new JLabel(
					store.getImages().get("cardBack"));
			cardBackLabel.setBounds(x, y-135, width, height);
			background.add(cardBackLabel);

			x += 50;
		}
	}

	public void showDeck() {

		int X = 40;
		int Y = (panel.getHeight() / 2) - (3 * store.getImages().get("cardBack").getIconHeight() / 4);
		for (int i = 0; i < game.getDeck().getSize(); i++) {

			JLabel cardBackLabel = new JLabel(store.getImages().get("cardBack"));
			cardBackLabel.setBounds(X, Y, 113, 149);
			background.add(cardBackLabel);

			X += 25;
		}
	}

	/**
	 * puts the deck of cards on the screen.
	 */
	public void showScore() {
		int X = 40;
		int Y = 400;
		for (int i = 0; i < 38; i++) {

			ImageIcon Card = new ImageIcon(
					new ImageIcon("res/cardBack.png").getImage()
							.getScaledInstance(100, 140, Image.SCALE_SMOOTH));

			JLabel cardBack = new JLabel(Card);
			cardBack.setBounds(X, Y, 113, 149);
			panel.add(cardBack);

			X = (X + 40);
		}
	}

	/**
	 * @param msg
	 * @param playerSpeaks
	 */
	public void printTxt(final String msg, boolean playerSpeaks) {

		Timer  timer = new Timer(1500, new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                updateView();
                panel.add(theySay);
            	theySay.setVisible(true);
            }
        });
        timer.setRepeats(false);


		youSay.setText(msg);
		youSay.setHorizontalTextPosition(JLabel.CENTER);
		youSay.setVerticalTextPosition(JLabel.CENTER);

		if (playerSpeaks) {
			background.remove(youSay);
			background.remove(theySay);
			background.repaint();
			timer.start();

			background.remove(youSay);
			background.remove(theySay);
			background.repaint();
			panel.repaint();
			updateView();
		}  else {
			panel.add(theySay);
			 theySay.setText(msg);
				theySay.setHorizontalTextPosition(JLabel.CENTER);
				theySay.setVerticalTextPosition(JLabel.CENTER);
			timer.start();
		}

		//return speech;
	}

	/**
	 * reloads all the items back to the panel.
	 */
	private void updateView() {
		background.removeAll();
		panel.add(background);
		background.add(youSay);
		showCards();
		//background.add(printTxt("aasdfasdf", false));
		showAICards();
		//background.add(opponent);
		//background.add(player);

		//background.add(youSay);
		//background.add(theySay);
		background.add(yourMsg);
		background.add(theirMsg);
		background.add(yourScore);
		background.add(theirScore);
		
		background.repaint();
	}

	private void newGame() {
		game = new Game(this);
		updateView();
	}


	/**
	 * Launch the application.
	 *
	 * @param args
	 *            - main args
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUIgoFish window = new GUIgoFish();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @return
	 */
	public JLabel getYourMsg() {
		return yourMsg;
	}

	/**
	 * @param yourMsg
	 */
	public void setYourMsg(JLabel yourMsg) {
		this.yourMsg = yourMsg;
	}

	/**
	 * @return
	 */
	public JLabel getYourScore() {
		return yourScore;
	}

	/**
	 * @param yourScore
	 */
	public void setYourScore(JLabel yourScore) {
		this.yourScore = yourScore;
	}

	/**
	 * @return
	 */
	public JLabel getTheirMsg() {
		return theirMsg;
	}

	/**
	 * @param theirMsg
	 */
	public void setTheirMsg(JLabel theirMsg) {
		this.theirMsg = theirMsg;
	}

	public static void getERROR(){
JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		
	}



}
