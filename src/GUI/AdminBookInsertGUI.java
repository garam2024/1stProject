package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.BookDAO;
import VO.BookVO;

import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdminBookInsertGUI {

	private JFrame frame;
	private JTextField tf_bookName;
	private JTextField tf_author;
	private JTextField tf_publisher;
	private JTextField tf_ISBN;
	private JTextField tf_series;
	private JTextField tf_issue;
	private JTextField tf_classNum;

	BookDAO dao = new BookDAO();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AdminBookInsertGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new setGUI();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(250, 233, 220));
		frame.setBounds(550,250, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uB4F1\uB85D");
//		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
//		lblNewLabel.setBounds(173, 34, 91, 28);
//		frame.getContentPane().add(lblNewLabel);
//
//		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C \uC774\uB984");
//		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1.setBounds(58, 104, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1);
//
//		JLabel lblNewLabel_1_1 = new JLabel("\uC800\uC790");
//		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1.setBounds(58, 138, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1);
//
//		JLabel lblNewLabel_1_1_1 = new JLabel("\uCD9C\uD310\uC0AC");
//		lblNewLabel_1_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1_1.setBounds(58, 173, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1_1);
//
//		JLabel lblNewLabel_1_1_2 = new JLabel("\uB3C4\uC11C\uBC88\uD638");
//		lblNewLabel_1_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1_2.setBounds(58, 209, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1_2);
//
//		JLabel lblNewLabel_1_1_3 = new JLabel("\uB3C4\uC11C \uC2DC\uB9AC\uC988");
//		lblNewLabel_1_1_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1_3.setBounds(58, 244, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1_3);
//
//		JLabel lblNewLabel_1_1_4 = new JLabel("\uBC1C\uD589\uB144\uB3C4");
//		lblNewLabel_1_1_4.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1_4.setBounds(58, 278, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1_4);
//
//		JLabel lblNewLabel_1_1_5 = new JLabel("\uC8FC\uC81C\uBD84\uB958\uBC88\uD638");
//		lblNewLabel_1_1_5.setFont(new Font("±¼¸²", Font.PLAIN, 15));
//		lblNewLabel_1_1_5.setBounds(58, 314, 103, 15);
//		frame.getContentPane().add(lblNewLabel_1_1_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 160, 119));
		panel_1.setBounds(142, 153, 166, 34);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lb_ISBN = new JLabel();
		lb_ISBN.setBounds(35, 3, 96, 30);
		lb_ISBN.setForeground(new Color(255, 255, 255));
		panel_1.add(lb_ISBN);
		lb_ISBN.setText("\uB3C4\uC11C \uC774\uB984");
		lb_ISBN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(245, 160, 119));
		panel_1_1.setBounds(142, 197, 166, 34);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lb_ISBN_1 = new JLabel();
		lb_ISBN_1.setBounds(61, 3, 44, 30);
		lb_ISBN_1.setForeground(new Color(255, 255, 255));
		lb_ISBN_1.setText("\uC800\uC790");
		lb_ISBN_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		panel_1_1.add(lb_ISBN_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(245, 160, 119));
		panel_1_1_1.setBounds(142, 241, 166, 34);
		frame.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		JLabel lb_ISBN_1_1 = new JLabel();
		lb_ISBN_1_1.setBounds(50, 3, 66, 30);
		lb_ISBN_1_1.setForeground(new Color(255, 255, 255));
		lb_ISBN_1_1.setText("\uCD9C\uD310\uC0AC");
		lb_ISBN_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		panel_1_1_1.add(lb_ISBN_1_1);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(245, 160, 119));
		panel_1_1_1_1.setBounds(142, 285, 166, 34);
		frame.getContentPane().add(panel_1_1_1_1);
		panel_1_1_1_1.setLayout(null);

		JLabel lb_ISBN_1_1_1 = new JLabel();
		lb_ISBN_1_1_1.setBounds(37, 3, 91, 29);
		lb_ISBN_1_1_1.setForeground(new Color(255, 255, 255));
		lb_ISBN_1_1_1.setText("\uB3C4\uC11C \uBC88\uD638");
		lb_ISBN_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));
		panel_1_1_1_1.add(lb_ISBN_1_1_1);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setBackground(new Color(245, 160, 119));
		panel_1_1_1_1_1.setBounds(142, 329, 166, 34);
		frame.getContentPane().add(panel_1_1_1_1_1);
		panel_1_1_1_1_1.setLayout(null);

		JLabel lb_ISBN_1_1_1_1 = new JLabel();
		lb_ISBN_1_1_1_1.setBounds(24, 3, 118, 30);
		lb_ISBN_1_1_1_1.setForeground(new Color(255, 255, 255));
		lb_ISBN_1_1_1_1.setText("\uB3C4\uC11C \uC2DC\uB9AC\uC988");
		lb_ISBN_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		panel_1_1_1_1_1.add(lb_ISBN_1_1_1_1);

		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setBackground(new Color(245, 160, 119));
		panel_1_1_1_1_1_1.setBounds(142, 370, 166, 34);
		frame.getContentPane().add(panel_1_1_1_1_1_1);
		panel_1_1_1_1_1_1.setLayout(null);

		JLabel lb_ISBN_1_1_1_1_1 = new JLabel();
		lb_ISBN_1_1_1_1_1.setBounds(39, 3, 88, 30);
		lb_ISBN_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lb_ISBN_1_1_1_1_1.setText("\uBC1C\uD589\uB144\uB3C4");
		lb_ISBN_1_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		panel_1_1_1_1_1_1.add(lb_ISBN_1_1_1_1_1);

		tf_bookName = new JTextField();
		tf_bookName.setBounds(367, 153, 373, 34);
		frame.getContentPane().add(tf_bookName);
		tf_bookName.setColumns(10);

		tf_author = new JTextField();
		tf_author.setColumns(10);
		tf_author.setBounds(367, 197, 373, 34);
		frame.getContentPane().add(tf_author);

		tf_publisher = new JTextField();
		tf_publisher.setColumns(10);
		tf_publisher.setBounds(367, 240, 373, 35);
		frame.getContentPane().add(tf_publisher);

		tf_ISBN = new JTextField();
		tf_ISBN.setColumns(10);
		tf_ISBN.setBounds(367, 285, 373, 34);
		frame.getContentPane().add(tf_ISBN);

		tf_series = new JTextField();
		tf_series.setColumns(10);
		tf_series.setBounds(367, 329, 373, 33);
		frame.getContentPane().add(tf_series);

		tf_issue = new JTextField();
		tf_issue.setColumns(10);
		tf_issue.setBounds(367, 370, 373, 34);
		frame.getContentPane().add(tf_issue);

		tf_classNum = new JTextField();
		tf_classNum.setColumns(10);
		tf_classNum.setBounds(367, 414, 373, 37);
		frame.getContentPane().add(tf_classNum);

//		RoundedButton roundedButton = new RoundedButton("\uB4F1\uB85D");
//		roundedButton.setForeground(Color.WHITE);
//		roundedButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
//		roundedButton.setBackground(new Color(221, 138, 98));
//		roundedButton.setBounds(215, 507, 129, 37);
//		frame.getContentPane().add(roundedButton);

		JButton btn_Insert = new RoundedButton("\uB4F1\uB85D");
		btn_Insert.setForeground(Color.WHITE);
		btn_Insert.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

				boolean isDuplicate = dao.checkDuplicateISBN(tf_ISBN.getText());
				String bookName = tf_bookName.getText();
				String author = tf_author.getText();
				String publisher = tf_publisher.getText();
				String ISBN = tf_ISBN.getText();
				int series = Integer.parseInt(tf_series.getText()); // textÇÊµå¿¡ °ªÀ» ¼ýÀÚ(int)·Î º¯Çü
				String issueDate = tf_issue.getText();
				String classNum = tf_classNum.getText();

				if (isDuplicate) {
					JOptionPane.showMessageDialog(null, "µµ¼­¹øÈ£(ISBN)°¡ Áßº¹µË´Ï´Ù.", "ISBN Áßº¹", JOptionPane.ERROR_MESSAGE);
				} else if (bookName == "" || author == "" || publisher == "" || ISBN == "" || issueDate == ""
						|| classNum == "") {

					JOptionPane.showMessageDialog(null, "ºñ¾îÀÖ´Â Ä­ÀÌ ÀÖ½À´Ï´Ù.", "°ø¶õÀÌ ÀÖ½À´Ï´Ù", JOptionPane.ERROR_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "µî·ÏµÇ¾ú½À´Ï´Ù.", "µî·Ï¿Ï·á", JOptionPane.PLAIN_MESSAGE);

					bookName = tf_bookName.getText();
					author = tf_author.getText();
					publisher = tf_publisher.getText();
					ISBN = tf_ISBN.getText();
					series = Integer.parseInt(tf_series.getText()); // textÇÊµå¿¡ °ªÀ» ¼ýÀÚ(int)·Î º¯Çü
					issueDate = tf_issue.getText();
					classNum = tf_classNum.getText();

					BookVO vo = new BookVO(bookName, author, publisher, ISBN, series, issueDate, classNum);
					dao.insertBook(vo);

					clear();
				}

			}
		});
		btn_Insert.setBounds(142, 496, 166, 37);
		btn_Insert.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btn_Insert);

		RoundedButton roundedButton = new RoundedButton("\uB4F1\uB85D");
		roundedButton.setText("\uB2EB\uAE30");
		roundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		roundedButton.setForeground(Color.WHITE);
		roundedButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		roundedButton.setBackground(new Color(241, 109, 99));
		roundedButton.setBounds(574, 496, 166, 37);
		frame.getContentPane().add(roundedButton);

//		JButton btn_Insert_1 = new JButton("\uB2EB\uAE30");
//		btn_Insert_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//			}
//		});
//		btn_Insert_1.setBounds(251, 364, 97, 23);
//		frame.getContentPane().add(btn_Insert_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 160, 119));
		panel.setBounds(142, 414, 166, 34);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(17, 3, 132, 30);
		label.setText("\uC8FC\uC81C\uBC88\uD638\uBD84\uB958");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		panel.add(label);

		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uB4F1\uB85D");
		lblNewLabel.setBounds(332, 37, 213, 66);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 49));
		lblNewLabel.setForeground(new Color(250, 138, 98));
	}

	public void clear() {
		tf_bookName.setText("");
		tf_author.setText("");
		tf_publisher.setText("");
		tf_ISBN.setText("");
		tf_series.setText(""); // textÇÊµå¿¡ °ªÀ» ¼ýÀÚ(int)·Î º¯Çü
		tf_issue.setText("");
		tf_classNum.setText("");
	}

}
