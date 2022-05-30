package src.lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setBounds(10, 10, 277, 287);
		frame.getContentPane().add(textArea);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(297, 10, 142, 31);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("\u041F\u043E\u0441\u0442\u0440\u043E\u0438\u0442\u044C (while)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				
				String f = ""; // строка
				
				int i = 0;
				while(i < (2*n)) {
					if(i < n) {
						int k = 0;
						while(k < i) {
							f += "  ";
							k++;
						}
						int j = n;
						while (j > i) {
							f += j + " ";
							j--;
						}
						f += "\n";
					} else if(i > n) {
						int k = 0;
						while(k < n-1) {
							f += "  ";
							k++;
						}
						int j = 2*n - i;
						while (j <= n) {
							f += j + " ";
							j++;
						}
						f += "\n";
					}
					i++;
				}
				textArea.setText(f);
			}
		});
		btnNewButton.setBounds(297, 62, 142, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u041F\u043E\u0441\u0442\u0440\u043E\u0438\u0442\u044C (do while)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				
				String f = ""; // строка
				
				int i = 0;
				do {
					if(i < n) {
						int k = 0;
						do {
							if(i == 0) {
								break;
							}
							f += "  ";
							k++;
						} while(k < i);
						int j = n;
						do {
							f += j + " ";
							j--;
						} while (j > i);
						f += "\n";
					} else if(i > n) {
						int k = 0;
						do {
							f += "  ";
							k++;
						} while(k < n-1);
						int j = 2*n - i;
						do {
							f += j + " ";
							j++;
						} while (j <= n);
						f += "\n";
					}
					i++;
				} while (i < (2*n));
				textArea.setText(f);
			}
		});
		btnNewButton_1.setBounds(297, 116, 142, 31);
		frame.getContentPane().add(btnNewButton_1);
	}
}
