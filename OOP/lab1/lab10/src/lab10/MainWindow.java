package lab10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame frame;
	
	String [] array = null;
	

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
		frame.setBounds(100, 100, 450, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 416, 197);
		frame.getContentPane().add(textArea);
		
		JTextField textFieldDownload = new JTextField("None");
		textFieldDownload.setBounds(20, 217, 202, 19);
		frame.getContentPane().add(textFieldDownload);
		textFieldDownload.setColumns(10);
		
		JButton btnAddButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					textFieldDownload.setText(jfc.getSelectedFile().getAbsolutePath());
					try {
						Scanner sc = new Scanner(new File(jfc.getSelectedFile().getAbsolutePath()));
						String text = "";
						while (sc.hasNext()) {
							text += sc.nextLine() + " \n";
						}
						sc.close();
						textArea.setText(text);
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAddButton.setBounds(268, 217, 158, 21);
		frame.getContentPane().add(btnAddButton);
		
		JButton btnNewButton = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] mass = textArea.getText().split("\n");

				int count = mass.length;
				
				array = mass.clone();
				
				for(int i = 0; i < count; i++) {
					mass[i] = mass[i].trim();
				}
				
				for(int i = count-1; i > count-2; i--) {
					for(int j = 0; j < i; j++) {
						if(Integer.parseInt(mass[j]) > Integer.parseInt(mass[j+1])) {
							String k = mass[j];
							mass[j] = mass[j+1];
							mass[j+1] = k;
						}
					}
				
				}
				
				boolean flag = true;
				if (array != null) {
					for(int i = 0; i < count; i++) {
						if(!mass[i].equals(array[i])) {
							flag = false;
							break;
						}
					}
				
				}
				

				if(flag == true) {
					JOptionPane.showMessageDialog(null, "Массив отсортирован!", "", JOptionPane.INFORMATION_MESSAGE);
				}

				
				textArea.setText(String.join("\n", mass));
				
			}
		});
		btnNewButton.setBounds(164, 259, 140, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
