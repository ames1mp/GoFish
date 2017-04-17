package gvsu.winter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIgoFish {

	private JFrame frame;

	private JPanel panel = new JPanel();
	
	private Game game1;
	
	private boolean hasCard = true;
	
	private boolean playerTurn = true;
	
	private String playerCardasked;


	/**
	 * Launch the application.
	 * @param args - main args
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
	 * Create the application.
	 */
	public GUIgoFish() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 game1 = new Game();

		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Dimension size = frame.getBounds().getSize();
		Rectangle dimension = new Rectangle();
dimension.setBounds(0, 0, (int)size.getWidth(), (int)size.getHeight());
		frame..
		frame.setBounds(dimension);*/


		panel.setBounds(frame.getBounds());
		panel.setBackground(Color.orange);
		frame.getContentPane().add(panel);
		panel.setLayout(null);



		JLabel logo = new JLabel();
		ImageIcon logoIcon = new ImageIcon(new ImageIcon
				("res/logo.png").getImage()
				.getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		logo.setIcon(logoIcon);
		logo.setBounds(300, 200, 582, 282);
		panel.add(logo);

		JLabel opponent = new JLabel();
		ImageIcon opponentIcon = new ImageIcon(new ImageIcon
				("res/opponent.jpg").getImage()
				.getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		opponent.setIcon(opponentIcon);
		opponent.setBounds(1250, 0, 582, 282);

		JLabel player = new JLabel();
		ImageIcon playerIcon = new ImageIcon(new ImageIcon
				("res/player.jpg").getImage()
				.getScaledInstance(582, 282, Image.SCALE_SMOOTH));
		player.setIcon(playerIcon);
		player.setBounds(1250, 670, 582, 282);

		JLabel star = new JLabel();
		ImageIcon starIcon = new ImageIcon(new ImageIcon
				("res/star.png").getImage()
				.getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		star.setIcon(starIcon);
		star.setBounds(100, 855, 100, 100);

		JLabel youSay = new JLabel();
		youSay.setText("You say:");
		youSay.setBounds(20, 290, 100, 50);
		youSay.setOpaque(false);


		JLabel theySay = new JLabel();
		theySay.setText("Opponent says:");
		theySay.setBounds(20, 200, 100, 50);
		theySay.setOpaque(false);

		JLabel pScore = new JLabel();
		pScore.setText("YOUR SCORE: " +  Game.getPlayer().getScore());
		pScore.setBounds(0, 0, 100, 100);
		pScore.setOpaque(false);

		JLabel aiScore = new JLabel();
		aiScore.setText("AI SCORE: " + Game.getAi().getScore());
		aiScore.setBounds(0, 50, 100, 100);
		aiScore.setOpaque(false);





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
		if (Game.getPlayer().goFish(playerCardasked) == hasCard) {
				playerTurn = true;
				showCards();
				panel.repaint();
				JOptionPane.showMessageDialog(
	  frame, "You got the card you asked the AI for"
	+ " so you get to play your turn again");
			}
				
			}
		});

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(550, 500, 113, 49);
		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				panel.remove(btnStart);
				panel.remove(logo);
				frame.repaint();

				btnGoFish.setBounds(500, 350, 89, 23);

				panel.add(btnGoFish);
				panel.add(opponent);
				panel.add(player);
				panel.add(youSay);
				panel.add(pScore);
				panel.add(aiScore);
				panel.add(theySay);
				panel.add(star);
				Game.newGame();
				showCards();
				showAICards();
				showDeck();
				panel.revalidate();
			}
		});

	}

	public void showCards () {
		int X = 140;
		int Y = 400;
	for (int i=0; i < Game.getPlayer().getHand().size(); i++) {
		ImageIcon card = new ImageIcon(new ImageIcon(
	Game.getPlayer().getHand().get(i).getFilename()).getImage()
	.getScaledInstance(100, 140, Image.SCALE_SMOOTH));
	card.setDescription(Game.getPlayer().getHand().get(i).toString());

		JButton btButton = new JButton(card);
		btButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
						
				if (playerTurn == hasCard) {
			 playerCardasked =	card.getDescription();
			 if (Game.getAi().askCard(card.getDescription()) != hasCard) {
					JOptionPane.showMessageDialog(
		      frame, "AI Doesn't Have any of those GOFISH!");
				}
				showCards();
				showAICards();
				panel.repaint();
				playerTurn = false;
			}
			}
		});
		if (i >= 9) { 
			 Y = 580;
			 X = 140;
		}
		btButton.setBounds(X, Y, 113, 149);
		panel.add(btButton);

		X = (X + 120);
	}
	}

	public void showAICards () {
		int X = 140;
		int Y = 50;
	for (int i = 0; i < Game.getAi().getHand().size(); i++) {
		ImageIcon card = new ImageIcon(new ImageIcon(
				"res/cardBack.png").getImage()
		.getScaledInstance(100, 140, Image.SCALE_SMOOTH));

		JLabel cardBack = new JLabel(card);
		cardBack.setBounds(X, Y, 113, 149);
		panel.add(cardBack);

		X = (X + 120);
	}
	}

	public void showDeck() {
		int X = 140;
		int Y = 200;
		for (int i = 0; i < 38; i++) {

			ImageIcon Card = new ImageIcon(
					new ImageIcon("res/cardBack.png").getImage()
							.getScaledInstance(50, 70, Image.SCALE_SMOOTH));

			JLabel cardBack = new JLabel(Card);
			cardBack.setBounds(X, Y, 113, 149);
			panel.add(cardBack);

			X = (X + 20);
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
	//if this is here the push worked
}