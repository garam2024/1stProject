package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.SickBookListDAO;
import VO.BookVO;
import VO.SickBookListVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;

public class UserSickBookInfoGUI {

   private JFrame frame;

   SickBookListDAO dao = new SickBookListDAO();
   
   Object[][] sickBookData;
   String[] columnHeader;
   private JTextField tfSearchDate;
   
   String searchDate;
   
   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               UserSickBookInfoGUI window = new UserSickBookInfoGUI( );
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }      --> 왜 UNCOMMENT 했을 때 UserSickBookInfoGUI(BookVO bookVO)해도 에러나는지 모르겠음

   /**
    * Create the application.
    */
   public UserSickBookInfoGUI(BookVO bookVO){
      initialize(bookVO);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(BookVO bookVO) {
      frame = new setGUI();
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setBounds(750,250, 450, 600);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      
      /*
       *    해당 도서에 대한 아파요 표 보여주기
       */
      
      // Query데이터를 Object로
      ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
      sickBookList = dao.getSickBookList(bookVO.getISBN());
      
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
      mainTableScrollPane.setBounds(34, 110, 365, 362);
      mainTableScrollPane.setVisible(true);
      
      frame.getContentPane().add(mainTableScrollPane);
      
      // 도서 상세 페이지로
      JButton btnNewButton = new RoundedButton("\uB3C4\uC11C\uC0C1\uC138 \uD398\uC774\uC9C0\uB85C");
      btnNewButton.setForeground(new Color(255, 255, 255));
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      btnNewButton.setBackground(new Color(241, 109, 80));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            BookInfoGUI.getFrame().setVisible(true);
            
         }
      });
      btnNewButton.setBounds(115, 505, 207, 34);
      frame.getContentPane().add(btnNewButton);
      
      JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uC544\uD30C\uC694 \uC0C1\uC138 \uD604\uD669");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(39, -23, 481, 155);
      frame.getContentPane().add(lblNewLabel);
      
      // 도서 검색 메인 페이지로
//      JButton button = new JButton("\uB3C4\uC11C\uAC80\uC0C9 \uD398\uC774\uC9C0\uB85C");
//      button.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            frame.dispose();
//            new UserMainGUI();
//         }
//      });
//      button.setBounds(463, 421, 163, 23);
//      frame.getContentPane().add(button);
   }
}