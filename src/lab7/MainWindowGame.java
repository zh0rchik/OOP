package lab7;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;



public class MainWindowGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowGame window = new MainWindowGame();
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
	public MainWindowGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PaintPanel panel = new PaintPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(panel);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					panel.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					panel.moveRight();
					break;
				case KeyEvent.VK_UP:
					panel.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					panel.moveDown();
					break;
				default:
					break;	
				}
				
			}
		});
	}
}
