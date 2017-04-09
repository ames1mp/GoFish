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
import javax.swing.JPanel;

public class GUIgoFish {

	private JFrame frame;


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
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.GREEN);




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

		JLabel score = new JLabel();
		score.setText("AI Points: ");
		score.setBounds(0, 0, 200, 200);
		score.setVisible(true);

		JButton btnGoFish = new JButton("Go Fish");
		btnGoFish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ImageIcon imageIcon = new ImageIcon
						(new ImageIcon("res/queen_of_hearts2.png").getImage()
								.getScaledInstance(100,140,
						        Image.SCALE_SMOOTH));

				JButton BtButton = new JButton(imageIcon);

				frame.getContentPane().remove(btnGoFish);

				BtButton.setBounds(50, 75, 113, 149);
				panel.add(BtButton);
				panel.add(score);
				panel.repaint();
			}
		});
		btnGoFish.setBounds(800, 450, 89, 23);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JPanel panel2 = new JPanel();
				panel.setBounds(0, 0, 900, 600);
				frame.getContentPane().add(panel2);
				panel.setLayout(new BorderLayout());
				panel.setBackground(Color.MAGENTA);


				frame.getContentPane().remove(btnStart);
				frame.repaint();



				panel.add(btnGoFish);
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