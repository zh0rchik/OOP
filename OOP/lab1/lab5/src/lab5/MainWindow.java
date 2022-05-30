package lab5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;

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

	public double function(double x, double res, int p) { 
		res = Math.pow(x, p)/p;
		
		return res;
	}
	
	public double recurFunction(double x, int depth, double res, int p) { 
		
		if(depth <= 0) {
			return res;
		}
		
		res += function(x, res, p);
		p += 2;
		depth--;
		res = recurFunction(x, depth, res, p);
		
		return res;
	}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 276, 238);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(354, 11, 70, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(354, 42, 70, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("depth = ");
		lblNewLabel.setBounds(296, 45, 48, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x = ");
		lblNewLabel_1.setBounds(316, 11, 28, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u0421\u0447\u0438\u0442\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = (int)spinner.getValue();
				String s = textField.getText();
				double x = Double.parseDouble(s);
				
				if (Math.abs(x) <= 1) {
					double res = 0;
					int p = 1;
					
					res = 2 * recurFunction(x, m, res, p);
					String f = ""; // строка
					f += res;
					textArea.setText(f);
				} else {
					String f = "Ошибка. Область определения [-1; 1]";
					textArea.setText(f);
				}
				
			}

			
		});
		btnNewButton.setBounds(306, 73, 118, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
