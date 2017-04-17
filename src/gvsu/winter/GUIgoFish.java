package gvsu.winter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIgoFish {

	private JFrame frame;

	private JPanel panel = new JPanel();

	private Game game;

	private ImageStore store;

	JLabel yourMsg, theirMsg, yourScore, theirScore, opponent, player, youSay,
	theySay, score, score2;
	ImageIcon cardBack;



	/**
	 * Create the application.
	 */
	public GUIgoFish() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		game = new Game(this);
		store = new ImageStore();
		store.loadImages();
		cardBack = new ImageIcon(
				new ImageIcon("res/cardBack.png").getImage()
				.getScaledInstance(100, 140, Image.SCALE_SMOOTH));

		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Dimension size = frame.getBounds().getSize(); Rectangle dimension =
		 * new Rectangle(); dimension.setBounds(0, 0, (int)size.getWidth(),
		 * (int)size.getHeight()); frame.. frame.setBounds(dimension);
		 */

		panel.setBounds(frame.getBounds());
		panel.setBackground(Color.darkGray);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel logo = new JLabel();
		ImageIcon logoIcon = new ImageIcon(new ImageIcon("res/logo.png")
				.getImage().getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		logo.setIcon(logoIcon);

		logo.setBounds(center(logoIcon));

		// logo.setBounds(300, 200, 582, 282);

		panel.add(logo);

		opponent = new JLabel();
		ImageIcon opponentIcon = new ImageIcon(new ImageIcon("res/opponent.jpg")
				.getImage().getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		opponent.setIcon(opponentIcon);
		opponent.setBounds(1250, 0, 582, 282);

		player = new JLabel();
		ImageIcon playerIcon = new ImageIcon(new ImageIcon("res/player.jpg")
				.getImage().getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		player.setIcon(playerIcon);
		player.setBounds(1250, 670, 582, 282);

		JLabel star = new JLabel();
		ImageIcon starIcon = new ImageIcon(new ImageIcon("res/star.png")
				.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		star.setIcon(starIcon);
		star.setBounds(100, 855, 100, 100);

		youSay = new JLabel();
		youSay.setText("You say:");
		youSay.setBounds(1250, 600, 100, 50);
		youSay.setOpaque(false);

		theySay = new JLabel();
		theySay.setText("Opponent says:");
		theySay.setBounds(1250, 300, 100, 50);
		theySay.setOpaque(false);

		yourMsg = new JLabel();
		yourMsg.setBounds(1500, 600, 100, 50);
		yourMsg.setBackground(Color.WHITE);
		yourMsg.setText("text");
		yourMsg.setOpaque(false);

		theirMsg = new JLabel();
		theirMsg.setBounds(1500, 300, 100, 50);
		theirMsg.setBackground(Color.WHITE);
		theirMsg.setText("text");
		theirMsg.setOpaque(false);

		yourScore = new JLabel();
		yourScore.setBounds(100, 855, 100, 100);
		yourScore.setBackground(Color.WHITE);
		yourScore.setText("SCORE");
		yourScore.setOpaque(true);

		theirScore = new JLabel();
		theirScore.setBounds(100, 100, 100, 100);
		theirScore.setBackground(Color.WHITE);
		theirScore.setText("SCORE");
		theirScore.setOpaque(true);

		score = new JLabel();
		score.setText("SCORE:");
		score.setBounds(0, 0, 50, 50);
		score.setOpaque(false);

		score2 = new JLabel();
		score2.setText("SCORE:");
		score2.setBounds(0, panel.getHeight() - 50, 50, 50);
		score2.setOpaque(false);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnFile.add(mntmNewGame);

		JMenuItem mntmOpenSave = new JMenuItem("Open Save");
		mnFile.add(mntmOpenSave);

		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnFile.add(mntmSaveGame);
		frame.getContentPane().setLayout(null);

		JButton btnGoFish = new JButton("Go Fish");
		btnGoFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("Your Hand: ");
				// displays user hand
				game.getPlayer().displayHand();
				System.out.println("\n\n");

			}
		});
		btnGoFish.setBounds(300, 400, 89, 23);

		JButton btnStart = new JButton("New Game");

		btnStart.setBounds((panel.getWidth() / 2) - (89 / 2),
				(panel.getHeight() / 2) + logoIcon.getIconHeight() / 2 + 11, 89,
				23);

		// btnStart.setBounds(550, 500, 113, 49);

		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				//Game game = new Game();
				panel.remove(btnStart);
				panel.remove(logo);
				frame.repaint();

				btnGoFish.setBounds(400, 350, 89, 23);

				panel.add(btnGoFish);
				panel.add(opponent);
				panel.add(player);
				panel.add(youSay);
				panel.add(score);
				panel.add(score2);
				panel.add(theySay);
				//panel.add(star);
				panel.add(yourMsg);
				panel.add(theirMsg);
				panel.add(yourScore);
				panel.add(theirScore);
				// Game.newGame();
				showCards();
				showAICards();
				showDeck();
				panel.repaint();
			}
		});

	}

	public Rectangle center(ImageIcon img) {
		int width = img.getIconWidth();
		int height = img.getIconHeight();

		int x = panel.getWidth() / 2 - width / 2;
		int y = panel.getHeight() / 2 - height / 2;

		Rectangle r = new Rectangle(x, y, width, height);
		return r;
	}

	public Rectangle center(int width, int height) {

		int x = panel.getWidth() / 2 - width / 2;
		int y = panel.getHeight() / 2 + height / 2;

		Rectangle r = new Rectangle(x, y, width, height);
		return r;
	}

	public void showCards() {
		int X = 40;
		int Y = panel.getHeight() / 3 + 140;

		for (int i = 0; i < game.getPlayer().getHand().size(); i++) {
			/*
			ImageIcon card = new ImageIcon(new ImageIcon(
					game.getPlayer().getHand().get(i).getFilename()).getImage()
							.getScaledInstance(100, 140, Image.SCALE_SMOOTH));
			card.setDescription(game.getPlayer().getHand().get(i).toString());
			*/
			ImageIcon card = store.images.get(game.getPlayer().getHand().get(i).toString());
			Rank rank = game.getPlayer().getHand().get(i).getRank();
			JButton BtButton = new JButton(card);
			BtButton.setBounds(X, Y, 113, 149);

			BtButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					//System.out.println("Your Hand: ");
					// displays user hand
					//game.getPlayer().displayHand();
					//System.out.println("\n\n");

					//PLAYER TURN LOGIC
					if(game.isPlayerTurn()) {
						 //Card request = game.getPlayer().getHand().get(i);
						 ArrayList<Card> returnedCards = game.getAi().askCard(rank);
						 if(returnedCards.size() > 0) {
							 game.getPlayer().setHand(returnedCards);
							 returnedCards.clear();
							 game.updateGame();
							 updateView();
							 game.setPlayerTurn(false);

						 } else {
							 theirMsg.setText("Go Fish!");
							 if(game.getPlayer().goFish(rank)) {
								 yourMsg.setText("You Got your Card! FREE TURN");
								 game.updateGame();
								 updateView();
							 } else {
								 game.setPlayerTurn(false);
								 game.updateGame();
								 updateView();
							 }
						 }
						 //AI TURN LOGIC
					 } else {
						 Rank request = game.getAi().aiTurn();
						 ArrayList<Card> returnedCards = game.getPlayer().askCard(request);
						 if(returnedCards.size() > 0) {
							 game.getAi().setHand(returnedCards);
							 returnedCards.clear();
							 game.updateGame();
							 updateView();
							 game.setPlayerTurn(true);
						 } else {
							 yourMsg.setText("Go Fish!");
							 if (game.getAi().goFish(request)) {
								 theirMsg.setText("You Got your Card! FREE TURN");
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
			panel.add(BtButton);
			/*
			JButton btButton = new JButton(card);
			btButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					game.getAi().askCard(card.getDescription());
				}
			});
			btButton.setBounds(X, Y, 113, 149);
			panel.add(btButton);
*/
			X += 50;

		}
	}

	public void showAICards() {
		int X = 40;
		int Y = 50;
		for (int i = 0; i < game.getPlayer().getHand().size(); i++) {
			/*
			ImageIcon Card = new ImageIcon(
					new ImageIcon("res/cardBack.png").getImage()
							.getScaledInstance(100, 140, Image.SCALE_SMOOTH));
*/
			JLabel cardBackLabel = new JLabel(store.cardBack);
			cardBackLabel.setBounds(X, Y, 113, 149);
			panel.add(cardBackLabel);

			X += 50;
		}
	}

	public void showDeck() {

		int X = 40;
		int Y = 200;
		for (int i = 0; i < game.getDeck().getSize(); i++) {
/*
			ImageIcon Card = new ImageIcon(new ImageIcon("res/cardBack.png")
					.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH));
*/
			JLabel cardBackLabel = new JLabel(cardBack);
			cardBackLabel.setBounds(X, Y, 113, 149);
			panel.add(cardBackLabel);

			X += 25 ;
		}
	}

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

	private void updateView() {
		panel.removeAll();
		showCards();
		showDeck();
		showAICards();
		panel.add(opponent);
		panel.add(player);
		panel.add(youSay);
		panel.add(score);
		panel.add(score2);
		panel.add(theySay);
		//panel.add(star);
		panel.add(yourMsg);
		panel.add(theirMsg);
		panel.add(yourScore);
		panel.add(theirScore);
		panel.repaint();
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
}