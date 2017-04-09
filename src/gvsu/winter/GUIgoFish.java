package gvsu.winter;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIgoFish {

	private Card testCard = new Card(Suit.hearts, Rank.ACE);

	private JFrame frame;

	//private ImageIcon[] H = new ImageIcon[];


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
		frame = new JFrame();
		frame.setBounds(100, 100, 434, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout());

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

		JButton btnGoFish = new JButton();
		btnGoFish.setIcon(new ImageIcon(testCard.getImage()));
		btnGoFish.setPreferredSize(new Dimension(100,140));
		btnGoFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				 System.out.println("Your Hand: ");
				 // displays user hand
            //Game.getPlayer().displayHand();
           // System.out.println("\n\n");
			}
		});



		btnGoFish.setBounds(165, 170, 100, 140);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				frame.getContentPane().remove(btnStart);
				frame.repaint();


				panel.setBounds(0, 0, 434, 250);
				panel.setLayout(new CardLayout());
				panel.add(btnGoFish);
				panel.repaint();
				Game.newGame();
			}
		});


		btnStart.setBounds(165, 124, 89, 23);
		frame.getContentPane().add(btnStart);






	}
	public void showCards () {
		Game.getPlayer().getHand();
	}
}