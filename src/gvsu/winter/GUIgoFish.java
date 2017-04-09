package gvsu.winter;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class GUIgoFish {

	private JFrame frame;
	
	private JPanel panel = new JPanel();


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

		
		panel.setBounds(0, 0, 884, 540);
		frame.getContentPane().add(panel);
				panel.setLayout(null);
		
			
		
		

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
	            Game.getPlayer().displayHand();
	            System.out.println("\n\n");
				
			}
		});
		btnGoFish.setBounds(800, 450, 89, 23);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(350, 290, 113, 49);
		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				panel.remove(btnStart);
				frame.repaint();

				btnGoFish.setBounds(350, 450, 89, 23);

				panel.add(btnGoFish);
				Game.newGame();
				showCards();
				panel.repaint();
			}
		});


		


	}

	public void showCards () {
		int X = 40;
	for(int i=0; i < Game.getPlayer().getHand().size(); i++){
		ImageIcon Card = new ImageIcon(new ImageIcon
				("res/" + Game.getPlayer().getHand().get(i).getFilename()).getImage()
				.getScaledInstance(100, 140, Image.SCALE_SMOOTH));
		
		JButton BtButton = new JButton(Card);
		BtButton.setBounds(X, 60, 113, 149);
		panel.add(BtButton);
		
		X= (X + 120);
	}
	}
}
