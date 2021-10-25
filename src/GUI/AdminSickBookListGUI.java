package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import DAO.SickBookListDAO;
import VO.SickBookListVO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AdminSickBookListGUI {

	private JFrame frame;
	private JTable table;
	
	SickBookListDAO dao = new SickBookListDAO();
	
	Object[][] sickBookData;
	String[] columnHeader;
	private JTextField tfSearchDate;
	
	String searchDate;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSickBookListGUI window = new AdminSickBookListGUI();
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
	public AdminSickBookListGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new setGUI();
		frame.setBounds(550,250, 900, 600);
		frame.getContentPane().setBackground(new Color(250,233,220));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Layout -> null
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uD30C\uC694 \uB3C4\uC11C \uBAA9\uB85D");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 49));
		lblNewLabel.setForeground(new Color(250, 138, 98));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 40, 425, 60);
		frame.getContentPane().add(lblNewLabel);
		
		// Query데이터를 Object로
		ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
		sickBookList = dao.getSickBookList();
		
		sickBookData = new Object[sickBookList.size()][8];
		columnHeader = new String[8];
		
		// Column Header 설정
		columnHeader[0] = "아파요 등록일";
		columnHeader[1] = "도서 ISBN";
		columnHeader[2] = "도서 순번ID";
		columnHeader[3] = "도서 이름";
		columnHeader[4] = "아파요 종류";
		columnHeader[5] = "아파요 정도";
		columnHeader[6] = "유저아이디";
		columnHeader[7] = "유저코멘트";
		
		// Table Contents Object[][] 내용 집어넣기
		for(int i = 0; i < sickBookList.size(); i++) {
			sickBookData[i][0] = sickBookList.get(i).getRegisterDate();
			sickBookData[i][1] = sickBookList.get(i).getBookIsbn();
			sickBookData[i][2] = sickBookList.get(i).getBookId();
			sickBookData[i][3] = sickBookList.get(i).getBookName();
			sickBookData[i][4] = sickBookList.get(i).getSickCategoryName();
			sickBookData[i][5] = sickBookList.get(i).getSickLevelName();
			sickBookData[i][6] = sickBookList.get(i).getUserId();
			sickBookData[i][7] = sickBookList.get(i).getUserReportComment();
		}
		
		// JTable 내용 부여주기
		JTable mainTable = new JTable(sickBookData, columnHeader);
		mainTable.setVisible(true);
		
		// Scroll 추가하기
		JScrollPane mainTableScrollPane = new JScrollPane(mainTable);
		mainTableScrollPane.setBounds(34, 183, 817, 354);
		mainTableScrollPane.setVisible(true);
		
		frame.getContentPane().add(mainTableScrollPane);
		
		JButton btnNewButton = new RoundedButton("메인으로 돌아가기");
		btnNewButton.setText("\uBA54\uC778 \uB3CC\uC544\uAC00\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMainGUI.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(681, 40, 170, 34);
		btnNewButton.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btnNewButton);

		//  조회데이터입력
		tfSearchDate = new JTextField();
		tfSearchDate.setBounds(123, 139, 116, 34);
		frame.getContentPane().add(tfSearchDate);
		tfSearchDate.setColumns(10);
		
		// Combobox 부분
		String[] sickCategory = new String[] {"0: 전체", "1: 찢김", "2: 낙서", "3: 오염", "4: 오래됨", "5: 기타"};
		String[] sickLevel = new String[] {"0: 전체", "1: 상", "2: 중", "3: 하"};
		
		JComboBox cbSickCategory = new JComboBox(sickCategory);
		cbSickCategory.setBounds(360, 139, 115, 34);
		frame.getContentPane().add(cbSickCategory);
		
		JComboBox cbSickLevel = new JComboBox(sickLevel);
		cbSickLevel.setBounds(600, 139, 115, 34);
		frame.getContentPane().add(cbSickLevel);
		
	
		JLabel lblNewLabel_1 = new JLabel("\uC544\uD30C\uC694 \uC885\uB958");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_1.setBounds(251, 145, 97, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC544\uD30C\uC694 \uC815\uB3C4");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label.setBounds(495, 145, 107, 23);
		frame.getContentPane().add(label);
		
		// 조건이 포함된 테이블 조회
		JButton btnSelectSickBookList = new RoundedButton("\uC870\uD68C");
		btnSelectSickBookList.setForeground(Color.WHITE);
		btnSelectSickBookList.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnSelectSickBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 콤보박스 값 받아옴
				int sickCategoryValue = cbSickCategory.getSelectedIndex();
				int sickLevelValue = cbSickLevel.getSelectedIndex();
				
				searchDate = tfSearchDate.getText();
				
				System.out.println(sickCategoryValue);
				System.out.println(sickLevelValue);
				System.out.println(searchDate);
				
				// Query데이터를 Object로
				ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
				sickBookList = dao.getSickBookList(searchDate, sickCategoryValue, sickLevelValue);
				
				System.out.println(sickBookList.size());
				
				sickBookData = new Object[sickBookList.size()][8];
				columnHeader = new String[8];
				
				// Column Header 설정
				columnHeader[0] = "아파요 등록일";
				columnHeader[1] = "도서 ISBN";
				columnHeader[2] = "도서 순번ID";
				columnHeader[3] = "도서 이름";
				columnHeader[4] = "아파요 종류";
				columnHeader[5] = "아파요 정도";
				columnHeader[6] = "유저아이디";
				columnHeader[7] = "유저코멘트";
				
				// Table Contents Object[][] 내용 집어넣기
				for(int i = 0; i < sickBookList.size(); i++) {
					sickBookData[i][0] = sickBookList.get(i).getRegisterDate();
					sickBookData[i][1] = sickBookList.get(i).getBookIsbn();
					sickBookData[i][2] = sickBookList.get(i).getBookId();
					sickBookData[i][3] = sickBookList.get(i).getBookName();
					sickBookData[i][4] = sickBookList.get(i).getSickCategoryName();
					sickBookData[i][5] = sickBookList.get(i).getSickLevelName();
					sickBookData[i][6] = sickBookList.get(i).getUserId();
					sickBookData[i][7] = sickBookList.get(i).getUserReportComment();
				}
				
				JTable mainTable = new JTable(sickBookData, columnHeader);
				mainTable.setVisible(true);
				
				JScrollPane mainTableScrollPane = new JScrollPane(mainTable);
				mainTableScrollPane.setBounds(34, 183, 817, 354);
				mainTableScrollPane.setVisible(true);
				
				frame.getContentPane().add(mainTableScrollPane);
				
			}
		});
		btnSelectSickBookList.setBounds(727, 139, 122, 34);
		btnSelectSickBookList.setBackground(new Color(221, 138, 98));
		frame.getContentPane().add(btnSelectSickBookList);
		
		JLabel lblNewLabel_2 = new JLabel("\uB4F1\uB85D\uC77C\uC790");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2.setBounds(44, 145, 72, 23);
		frame.getContentPane().add(lblNewLabel_2);
	
	}
}

