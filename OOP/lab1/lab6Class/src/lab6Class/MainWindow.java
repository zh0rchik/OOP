package lab6Class;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	
	int [][] array;
	int row;
	int column;
	
	int [][] newArray;
	int newRow;
	int newColumn;
	
	private JTextField textField_1;

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
	
	public int sumNum(int n) {
		int summ = 0;
		while (n>0) {
			summ += n % 10;
			n = n / 10;
		}
		
		return summ;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(62, 446, 226, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041F\u0443\u0442\u044C");
		lblNewLabel.setBounds(10, 450, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C...");
		btnAdd.setBounds(298, 446, 105, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		
		PaintPanel panel = new PaintPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 355, 426);
		frame.getContentPane().add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(375, 10, 144, 426);
		frame.getContentPane().add(textArea);
		
		JButton btnOutput = new JButton("Output");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Scanner sc = new Scanner(new File(textField.getText()));
					row = sc.nextInt();
					column = sc.nextInt();
					newRow = row;
					newColumn = column;
					
					array = new int[row][column];
					newArray = new int[row][column];
					
					for(int i = 0; i < row; i++) {
						for(int j = 0; j < column; j++) {
							array[i][j] = sc.nextInt();
						}
					}
					
					for(int i = 0; i < newRow; i++) {
						for(int j = 0; j < newColumn; j++) {
							newArray[i][j] = array[i][j];
						}
					}
					
					sc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String f = "";
				
				for(int i = 0; i < row; i++) {
					for(int j = 0; j < column; j++) {
						f += array[i][j] + " ";
					}
					f += "\n";
				}
				
				f+="\n";
				
				for (int i = 0; i < newRow; ) {
					int flag = 1;
					int summ = 0;
					for (int j = 0; j < newColumn; j++) {
						summ = sumNum(newArray[i][j]);
						if(summ >= 5) {
							flag = 0;
							break;
						}
					}
						
					if (flag == 1) {
						for (int i2 = i; i2 < newRow-1; i2++) {
							for(int j = 0; j < newColumn; j++) {
								newArray[i2][j] = newArray[i2+1][j];
							}
						}
						newRow--;
					} 
					else {
						i++;
					}
				}

				
				for(int i = 0; i < newRow; i++) {
					for(int j = 0; j < newColumn; j++) {
						f += newArray[i][j] + " ";
					}
					f += "\n";
				}
				
				textArea.setText(f);
				panel.setData(array, row, column, newArray, newRow, newColumn);
				panel.repaint();
			}
		});
		btnOutput.setBounds(420, 446, 89, 23);
		frame.getContentPane().add(btnOutput);
		
	}
}