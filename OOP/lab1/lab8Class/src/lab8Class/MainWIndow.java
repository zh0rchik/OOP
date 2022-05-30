package lab8Class;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;

public class MainWIndow {

	private JFrame frame;
	private JTextField textField;
	
	boolean flag = false;
	boolean flag1 = false;
	
	char []glasLetter = {'a', 'e', 'i', 'o', 'u','y'};
	char []glasLetterBig = {'A', 'E', 'I', 'O', 'U','Y'};
	
	int count = 1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWIndow window = new MainWIndow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean asList(char[] array, char s) {
		boolean flag = false;
		for(int i = 0; i < array.length; i++) {
			if(s == array[i]) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	public int getIndex(char[] array, char s) {
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(s == array[i]) {
				index = i;
			}
		}
		
		return index;
	}

	/**
	 * Create the application.
	 */
	public MainWIndow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBounds(10, 11, 728, 413);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u041F\u0443\u0442\u044C");
		lblNewLabel.setBounds(10, 434, 33, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 434, 170, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAddButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C...");
		btnAddButton.setBounds(233, 434, 106, 23);
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
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
		frame.getContentPane().add(btnAddButton);
		
		JButton btnProcessingButton = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnProcessingButton.setBounds(349, 434, 108, 23);
		btnProcessingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(textArea.getText());
				int n = 0;
				String charA = new String("A");
				while (n < sb.length()-1) {
					if (sb.charAt(n) == charA.charAt(0) && sb.charAt(n+1) == charA.charAt(0)) {
						sb.delete(n, n+2);
						sb.insert(n, "*");
					}
					n++;
				}
				textArea.setText(sb.toString());
			}
		});
		frame.getContentPane().add(btnProcessingButton);
		
		JButton btnHomeTask = new JButton("\u0414\u043E\u043C\u0430\u0448\u043A\u0430");
		btnHomeTask.setBounds(467, 434, 106, 21);
		btnHomeTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eh) {
				StringBuilder sbH = new StringBuilder(textArea.getText());
				int n = 0;
				while (n < sbH.length()) {
					if(sbH.charAt(n) == '\n') {
						count++;
					}
					if ((asList(glasLetter, sbH.charAt(n))) && (count%2==0)) {
						int index = getIndex(glasLetter, sbH.charAt(n));
						sbH.delete(n, n+1);
						sbH.insert(n, glasLetterBig[index]);
					}
					n++;
				}
				textArea.setText(sbH.toString());
			}
		});
		frame.getContentPane().add(btnHomeTask);
		
		
		JButton btnSaveButton = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0432 \u0444\u0430\u0439\u043B");
		btnSaveButton.setBounds(583, 433, 155, 23);
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int result = jfc.showSaveDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath())));
						bw.write(textArea.getText());
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnSaveButton);
		
	}
}
