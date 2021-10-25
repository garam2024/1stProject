package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import DAO.BookDAO;
import VO.BookVO;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.table.DefaultTableModel;

public class AdminBookListGUI {

	private JFrame frame;
	private JTable table;
	BookDAO dao = new BookDAO();
	private JTable table_1;

	String[] title;
	Object[][] bookInfo;
	private JScrollPane scrollPane;
	String value;

	/**
	 * Launch the application.(나중에 제거)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBookListGUI window = new AdminBookListGUI();
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
	public AdminBookListGUI() {
		initialize(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BookVO BookVO) {
		frame = new setGUI();
		frame.getContentPane().setBackground(new Color(250,233,220));
		frame.setBounds(550,250, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "\uCC45\uC774\uB984", "\uC800\uC790", "\uCD9C\uD310\uC0AC", "ISBN",
						"\uB3C4\uC11C\uAD00\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uC2DC\uB9AC\uC988",
						"\uB300\uCD9C\uAC74\uC218", "\uBC1C\uD589\uB144\uB3C4", "\uC8FC\uC81C\uBD84\uB958\uBC88\uD638",
						"\uB4F1\uB85D\uC77C\uC790" }));

		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		bookList = dao.getBookAll();
		bookInfo = new Object[bookList.size()][10];
		title = new String[10];
		title[0] = "도서 이름";
		title[1] = "저자";
		title[2] = "출판사";
		title[3] = "도서번호";
		title[4] = "도서관도서번호";
		title[5] = "도서시리즈";
		title[6] = "대출건수";
		title[7] = "발행년도";
		title[8] = "주제분류번호";
		title[9] = "등록일자";

		for (int i = 0; i < bookList.size(); i++) {
//			System.out.print(bookList.get(i).getBookName());
//			System.out.print(bookList.get(i).getAuthor());
//			System.out.println();
			bookInfo[i][0] = bookList.get(i).getBookName();
			bookInfo[i][1] = bookList.get(i).getAuthor();
			bookInfo[i][2] = bookList.get(i).getPublisher();
			bookInfo[i][3] = bookList.get(i).getISBN();
			bookInfo[i][4] = bookList.get(i).getBookID();
			bookInfo[i][5] = bookList.get(i).getBookSeries();
			bookInfo[i][6] = bookList.get(i).getBorrowed();
			bookInfo[i][7] = bookList.get(i).getIssueDate();
			bookInfo[i][8] = bookList.get(i).getClassNum();
			bookInfo[i][9] = bookList.get(i).getRegistrationDay();
//			
		}

		table_1 = new JTable(bookInfo, title);
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table_1.rowAtPoint(evt.getPoint());
				int col = table_1.columnAtPoint(evt.getPoint());
				value = (String) table_1.getValueAt(row, 3);

			}
		});

		table_1.setVisible(true);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(34, 127, 820, 370);

		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);

//		scrollPane_1.setViewportView(table);

//		BookVO VOBook = dao.getBookList(BookVO);

		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uAD00\uB9AC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 49));
		lblNewLabel.setForeground(new Color(250, 138, 98));
		lblNewLabel.setBounds(270, 26, 334, 76);
		frame.getContentPane().add(lblNewLabel);

		JButton btn_insert = new RoundedButton("\uB4F1\uB85D");
		btn_insert.setForeground(Color.WHITE);
		btn_insert.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminBookInsertGUI insert = new AdminBookInsertGUI();
			}
		});
		btn_insert.setBounds(598, 517, 122, 34);
		btn_insert.setBackground(new Color(241,109, 99));
		frame.getContentPane().add(btn_insert);

		JButton btn_delete = new RoundedButton("\uC0AD\uC81C");
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				int cnt = dao.delete(value);
				if (cnt > 0) {
					System.out.println("삭제완료");
					dao.getBookAll();

				} else {
					System.out.println("실패");
				}
				frame.dispose();
				AdminBookListGUI.main(null);

			}
		});
		btn_delete.setBounds(732, 517, 122, 34);
		btn_delete.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btn_delete);

		JButton btn_main = new RoundedButton("\uBA54\uC778 \uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_main.setText("\uBA54\uC778 \uB3CC\uC544\uAC00\uAE30");
		btn_main.setForeground(Color.WHITE);
		btn_main.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMainGUI.main(null);
				frame.dispose();
			}
		});
		btn_main.setBounds(34, 517, 170, 34);
		btn_main.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btn_main);

		JButton btn_update = new RoundedButton("\uC0C8\uB85C\uACE0\uCE68");
		btn_update.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btn_update.setForeground(Color.WHITE);
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<BookVO> bookList = new ArrayList<BookVO>();
				bookList = dao.getBookAll();
				bookInfo = new Object[bookList.size()][10];
				title = new String[10];
				title[0] = "도서 이름";
				title[1] = "저자";
				title[2] = "출판사";
				title[3] = "도서번호";
				title[4] = "도서관도서번호";
				title[5] = "도서시리즈";
				title[6] = "대출건수";
				title[7] = "발행년도";
				title[8] = "주제분류번호";
				title[9] = "등록일자";

				for (int i = 0; i < bookList.size(); i++) {
//					System.out.print(bookList.get(i).getBookName());
//					System.out.print(bookList.get(i).getAuthor());
//					System.out.println();
					bookInfo[i][0] = bookList.get(i).getBookName();
					bookInfo[i][1] = bookList.get(i).getAuthor();
					bookInfo[i][2] = bookList.get(i).getPublisher();
					bookInfo[i][3] = bookList.get(i).getISBN();
					bookInfo[i][4] = bookList.get(i).getBookID();
					bookInfo[i][5] = bookList.get(i).getBookSeries();
					bookInfo[i][6] = bookList.get(i).getBorrowed();
					bookInfo[i][7] = bookList.get(i).getIssueDate();
					bookInfo[i][8] = bookList.get(i).getClassNum();
					bookInfo[i][9] = bookList.get(i).getRegistrationDay();
//					
				}

				table_1 = new JTable(bookInfo, title);
				table_1.addMouseListener(new java.awt.event.MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						int row = table_1.rowAtPoint(evt.getPoint());
						int col = table_1.columnAtPoint(evt.getPoint());
						value = (String) table_1.getValueAt(row, 3);

					}
				});

				table_1.setVisible(true);
				scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(34, 127, 820, 370);

				scrollPane.setVisible(true);
				frame.getContentPane().add(scrollPane);

			}
		});

		btn_update.setBounds(736, 83, 122, 34);
		btn_update.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btn_update);
	}

}
