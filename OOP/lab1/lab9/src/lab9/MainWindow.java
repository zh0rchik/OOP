package lab9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frame;
	private JTextField textFieldDownload;
	private JTextField textFieldCalculate;
	
	String html = "";
	String path = null;

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
		frame.setBounds(100, 100, 500, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 466, 373);
		frame.getContentPane().add(textArea);
		
		textFieldDownload = new JTextField("None");
		textFieldDownload.setBounds(10, 393, 296, 19);
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
		btnAddButton.setBounds(316, 392, 160, 21);
		frame.getContentPane().add(btnAddButton);
		
		textFieldCalculate = new JTextField();
		textFieldCalculate.setBounds(147, 434, 329, 19);
		frame.getContentPane().add(textFieldCalculate);
		textFieldCalculate.setColumns(10);
		
		JButton btnCalculateButton = new JButton("\u041F\u043E\u0441\u0447\u0438\u0442\u0430\u0442\u044C");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(textArea.getText());
				String word = textFieldCalculate.getText();
				path = textFieldDownload.getText();
	
				int count = 0;
				
				boolean checkFirstWord = true;
				
				if (!word.isEmpty()) {
					String textEdit = sb.toString();
			        char [] textChar = textEdit.toCharArray();
			        
					String wordEdit = word.toString();
			        char [] wordChar = wordEdit.toCharArray();
			        
					int lengthWord = word.length();
					int idWord = 0;
					for (int i = 0; i < sb.length() - 1; i++) {
						
						if (textChar[i] == ' ' || textChar[i] == '\n' || checkFirstWord) {
							idWord = 0;
							if (!checkFirstWord) {
								i++;
							}
							checkFirstWord = false;
							for (int j = 1; j <= lengthWord; j++, i++) {
								
								if (textChar[i] != wordChar[idWord]) {
									break;
								}
								if (j == lengthWord) {
									count++;
									i--;
								}
								idWord++;
							}
						}
					}
				}
				
				html = "<html>\n<body>\n"
						+ " <b><p align = \"center\">Лабораторная работа №9</p></b>\n"
						+ " <p align = \"center\">Вариант B</p>\n"
						+ " <p>Выполнил студент группы <i>ИВТАСбд-11 <b>Зюзин Георгий</b></i></p></i>\n"
						+ " <p>Файл: <b>" + path + "</b>"
						+ " <p>Начало слова: <b>" + word + "</b></p></i>\n"
						+ " <p>Количество найденных слов: <b>" + count + "</b></p></i>\n"
						+ " </body>\n</html>";
				
				JFileChooser fd = new JFileChooser();
				int res = fd.showSaveDialog(frame);
				if (res == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fd.getSelectedFile().getAbsolutePath())));
						bw.write(html);
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnCalculateButton.setBounds(10, 463, 466, 21);
		frame.getContentPane().add(btnCalculateButton);
		
		JLabel lblNewLabel = new JLabel("\u041F\u043E\u0438\u0441\u043A\u043E\u0432\u0430\u044F \u0441\u0442\u0440\u043E\u043A\u0430");
		lblNewLabel.setBounds(10, 437, 136, 13);
		frame.getContentPane().add(lblNewLabel);
	}
}
