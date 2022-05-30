import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class MainWindow {
	private JFrame frame;
	private JTextField textField;
	
	boolean flagDirection = true;
	
	LinkedList <Element> list =  new LinkedList<>();
	private JTextField textFieldNameF;
	private JTextField textFieldNameI;
	private JTextField textFieldNameO;
	private JTextField textFieldNumber;

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
		frame.setBounds(100, 100, 436, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 402, 381);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(143, 401, 269, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041F\u043E\u0438\u0441\u043A\u043E\u0432\u0430\u044F \u0441\u0442\u0440\u043E\u043A\u0430");
		lblNewLabel.setBounds(10, 404, 110, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSearchDeleteButton = new JButton("\u041F\u043E\u0438\u0441\u043A \u0438 \u0443\u0434\u0430\u043B\u0435\u043D\u0438\u0435");
		btnSearchDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).nameF.equals(textField.getText())) {
                        list.remove(i);
                        break;
                    }
                }
				
				StringBuilder sb = new StringBuilder();
                if(flagDirection) {
                	Iterator<Element> it = list.iterator();
                	while (it.hasNext()) {
                        Element search = it.next();

                        sb.append(search.nameF).append(' ').append(search.nameI)
                        .append(' ').append(search.nameO).append(' ')
                        .append(search.number).append('\n');
                    }
                } else {
                	Iterator <Element> itReverse = list.descendingIterator();
                	while (itReverse.hasNext()) {
                        Element search = itReverse.next();

                        sb.append(search.nameF).append(' ').append(search.nameI)
                        .append(' ').append(search.nameO).append(' ')
                        .append(search.number).append('\n');
                       }
                }
                
                
                textArea.setText(sb.toString());
			}
		});
		btnSearchDeleteButton.setBounds(10, 436, 175, 21);
		frame.getContentPane().add(btnSearchDeleteButton);
		
		JButton btnAddButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.add(new Element (textFieldNameF.getText(), textFieldNameI.getText(),
						textFieldNameO.getText(),textFieldNumber.getText()));
				StringBuilder sb = new StringBuilder();
				if(flagDirection) {
					Iterator <Element> it = list.iterator(); //Создаём итератор пряямого обхода
					while(it.hasNext()) {
						Element search = it.next();
						sb.append(search.nameF).append(' ').append(search.nameI)
						.append(' ').append(search.nameO).append(' ')
						.append(search.number).append('\n');
					}
				}else {
					Iterator <Element> itReverse = list.descendingIterator(); //Создаём итератор обратного обхода
					while(itReverse.hasNext()) {
						Element search = itReverse.next();
						sb.append(search.nameF).append(' ').append(search.nameI)
						.append(' ').append(search.nameO).append(' ')
						.append(search.number).append('\n');
					}
				}
				
				textArea.setText(sb.toString());
			}
		});
		btnAddButton.setBounds(184, 436, 110, 21);
		frame.getContentPane().add(btnAddButton);
		
		JButton btnDerectionButton = new JButton("\u041D\u0430\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u0438\u0435");
		btnDerectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(!flagDirection) {
					Iterator <Element> it = list.iterator(); //Создаём итератор прямого обхода
					while(it.hasNext()) {
						Element search = it.next();
						sb.append(search.nameF).append(' ').append(search.nameI)
						.append(' ').append(search.nameO).append(' ')
						.append(search.number).append('\n');
					}
				}else {
					Iterator <Element> itReverse = list.descendingIterator(); //Создаём итератор обратного обхода
					while(itReverse.hasNext()) {
						Element search = itReverse.next();
						sb.append(search.nameF).append(' ').append(search.nameI)
						.append(' ').append(search.nameO).append(' ')
						.append(search.number).append('\n');
					}
				}
				
				textArea.setText(sb.toString());
				flagDirection = !flagDirection;
			}
		});
		btnDerectionButton.setBounds(294, 436, 118, 21);
		frame.getContentPane().add(btnDerectionButton);
		
		textFieldNameF = new JTextField();
		textFieldNameF.setText("null");
		textFieldNameF.setBounds(175, 467, 237, 19);
		frame.getContentPane().add(textFieldNameF);
		textFieldNameF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		lblNewLabel_1.setBounds(10, 473, 155, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldNameI = new JTextField();
		textFieldNameI.setText("null");
		textFieldNameI.setBounds(175, 496, 237, 19);
		frame.getContentPane().add(textFieldNameI);
		textFieldNameI.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u0418\u043C\u044F");
		lblNewLabel_2.setBounds(10, 499, 155, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldNameO = new JTextField();
		textFieldNameO.setText("null");
		textFieldNameO.setBounds(175, 525, 237, 19);
		frame.getContentPane().add(textFieldNameO);
		textFieldNameO.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u041E\u0447\u0435\u0441\u0442\u0432\u043E");
		lblNewLabel_3.setBounds(10, 528, 155, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setText("null");
		textFieldNumber.setBounds(175, 554, 237, 19);
		frame.getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		JLabel lblNewLabelNumber = new JLabel("\u041D\u043E\u043C\u0435\u0440 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430");
		lblNewLabelNumber.setBounds(10, 557, 155, 13);
		frame.getContentPane().add(lblNewLabelNumber);
	}
}
