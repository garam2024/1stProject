package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.BookDAO;
import DAO.SickBookListDAO;
import VO.BookInfoSickBookStatVO;
import VO.BookVO;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class BookInfoGUI {

   public static JFrame getFrame() {
      return frame;
   }

   public void setFrame(JFrame frame) {
      this.frame = frame;
   }

   private static JFrame frame;
   BookDAO dao = new BookDAO();
   SickBookListDAO sickBookDAO = new SickBookListDAO();

//   private int index;
//   private static final String[] Images= {
//      "9788946472907.PNG","9788949135014.PNG"   ,"9788949135021.PNG"
//   };

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               BookInfoGUI window = new BookInfoGUI(null);
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the application.
    */
   public BookInfoGUI(BookVO bookVO) {
      initialize(bookVO);
      frame.setVisible(true);
      System.out.println(UserLoginGUI.userIdStatic + "1234");
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(BookVO bookVO) {
      frame = new setGUI();
      frame.setBounds(750,250, 450, 600);
      frame.getContentPane().setBackground(new Color(250, 233, 220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      // 특정book정보 가져오기
      BookVO bookVO2 = dao.getAllInfo(bookVO);
      // 마이페이지랑 연결하기
      JButton btn_myPage = new RoundedButton("\uB9C8\uC774\uD398\uC774\uC9C0");
      btn_myPage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserMyPageGUI.main(null);
         }
      });
      btn_myPage.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      btn_myPage.setBounds(270, 15, 130, 30);
      btn_myPage.setBackground(new Color(221, 138, 98));
      btn_myPage.setForeground(new Color(255, 255, 255));
      frame.getContentPane().add(btn_myPage);

      JButton btn_home = new RoundedButton("\uD648");
      btn_home.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserMainGUI.main(null);
            frame.dispose();
         }
      });
      btn_home.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      btn_home.setBounds(35, 15, 65, 30);
      btn_home.setBackground(new Color(221, 138, 98));
      btn_home.setForeground(new Color(255, 255, 255));
      frame.getContentPane().add(btn_home);

      JLabel lb_bookName = new JLabel();
      lb_bookName.setFont(new Font("맑은 고딕", Font.BOLD, 20));

      lb_bookName.setText("\uCC45\uC81C\uBAA9");
      lb_bookName.setBounds(50, 70, 65, 21);
      frame.getContentPane().add(lb_bookName);

      JLabel lb_author = new JLabel();
      lb_author.setText("\uC800\uC790");
      lb_author.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_author.setBounds(40, 330, 109, 20);
      frame.getContentPane().add(lb_author);

      JLabel lb_publisher = new JLabel();
      lb_publisher.setText("\uCD9C\uD310\uC0AC");
      lb_publisher.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_publisher.setBounds(40, 360, 109, 20);
      frame.getContentPane().add(lb_publisher);

      JLabel lb_classNum = new JLabel();
      lb_classNum.setText("\uBD84\uB958\uBC88\uD638");
      lb_classNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_classNum.setBounds(40, 390, 109, 20);
      frame.getContentPane().add(lb_classNum);

      JLabel lb_issueDate = new JLabel();
      lb_issueDate.setText("\uBC1C\uD589\uB144\uB3C4");
      lb_issueDate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_issueDate.setBounds(40, 420, 109, 20);
      frame.getContentPane().add(lb_issueDate);

      JLabel lb_ISBN = new JLabel();
      lb_ISBN.setText("ISBN");
      lb_ISBN.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_ISBN.setBounds(40, 300, 109, 20);
      frame.getContentPane().add(lb_ISBN);

      JTextPane txt_bookName = new JTextPane();
      txt_bookName.setFont(new Font("맑은 고딕", Font.BOLD, 18));

      // 책 제목 가져오기
      txt_bookName.setText(bookVO2.getBookName());
      txt_bookName.setBounds(128, 65, 259, 30);
      frame.getContentPane().add(txt_bookName);

      JTextPane txt_author = new JTextPane();
      // 작가 가져오기
      txt_author.setText(bookVO2.getAuthor());
      txt_author.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_author.setBounds(190, 325, 197, 25);
      frame.getContentPane().add(txt_author);

      JTextPane txt_publisher = new JTextPane();
      // 출판사 가져오기
      txt_publisher.setText(bookVO2.getPublisher());
      txt_publisher.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_publisher.setBounds(190, 355, 197, 25);
      frame.getContentPane().add(txt_publisher);

      JTextPane txt_classNum = new JTextPane();
      // 분류번호 가져오기
      txt_classNum.setText(bookVO2.getClassNum());
      txt_classNum.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_classNum.setBounds(190, 385, 197, 25);
      frame.getContentPane().add(txt_classNum);

      JTextPane txt_issueDate = new JTextPane();
      // 발행년도 가져오기
      txt_issueDate.setText(bookVO2.getIssueDate());
      txt_issueDate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_issueDate.setBounds(190, 415, 197, 25);
      frame.getContentPane().add(txt_issueDate);

      JTextPane txt_ISBN = new JTextPane();
      // ISBN 가져오기
      txt_ISBN.setText(bookVO2.getISBN());
      txt_ISBN.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_ISBN.setBounds(190, 295, 197, 25);
      frame.getContentPane().add(txt_ISBN);

      // 도서 예약하기
      String userId = UserLoginGUI.userIdStatic;
      String bookISBN = bookVO2.getISBN();
      int bookId = bookVO2.getBookID();

      System.out.println(bookId + 9999);
      System.out.println(userId);
      System.out.println(bookISBN);
      System.out.println(bookId);

      JButton btn_reservate = new RoundedButton("\uC608\uC57D\uD558\uAE30");
      btn_reservate.setForeground(new Color(255, 255, 255));
      btn_reservate.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      btn_reservate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            System.out.println("전");
            boolean isAreadyReserved = dao.isAlreadyBookReserved(userId, bookISBN, bookId);
            System.out.println("후");
            System.out.println(isAreadyReserved);
            if (!isAreadyReserved) { // <-- 이라인 수정함

               int cnt = dao.reserveBook(userId, bookISBN, bookId);

               if (cnt > 0) {
                  JOptionPane.showMessageDialog(null, "예약완료", "Message", JOptionPane.INFORMATION_MESSAGE);
               } else {
                  JOptionPane.showMessageDialog(null, "예약실패", "Message", JOptionPane.ERROR_MESSAGE);
               }
            }

            else {

               JOptionPane.showMessageDialog(null, "이미 예약하신 도서입니다. 마이페이지를 확인해주세요 ^0^", "Message",
                     JOptionPane.ERROR_MESSAGE);
            }

         }
      });
      btn_reservate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      btn_reservate.setBounds(35, 502, 99, 34);
      btn_reservate.setBackground(new Color(241, 109, 80));
      
      frame.getContentPane().add(btn_reservate);

      JLabel lb_issueDate_1 = new JLabel();
      lb_issueDate_1.setText("\uC2DC\uB9AC\uC988");
      lb_issueDate_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lb_issueDate_1.setBounds(40, 450, 109, 20);
      frame.getContentPane().add(lb_issueDate_1);

      JTextPane txt_bookSeries = new JTextPane();
      // 책 시리즈 가져오기
      txt_bookSeries.setText(Integer.toString(bookVO2.getBookSeries()));
      txt_bookSeries.setFont(new Font("맑은 고딕", Font.BOLD, 12));
      txt_bookSeries.setBounds(190, 445, 197, 25);
      frame.getContentPane().add(txt_bookSeries);

      JButton btn_bookSIck = new RoundedButton("\uC544\uD30C\uC694");
      btn_bookSIck.setForeground(new Color(255, 255, 255));
      btn_bookSIck.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // frame.dispose();
            frame.setVisible(false);
            BookSickGUI bookSick = new BookSickGUI(bookVO);
         }
      });
      btn_bookSIck.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      btn_bookSIck.setBounds(265, 502, 109, 31);
      btn_bookSIck.setBackground(new Color(246, 147, 99));
      frame.getContentPane().add(btn_bookSIck);

//      ImageIcon test = new ImageIcon("src\\1.png");
//      JLabel lb_bookImage = new JLabel(test);
//      lb_bookImage.setBounds(35, 175, 217, 273);
//      frame.getContentPane().add(lb_bookImage);

//      lb_bookImage.setIcon(new ImageIcon(Images[0]));
//      frame.getContentPane().add(lb_bookImage);

      // 특정 도서에 대한 아파요 현황 보여주기
      BookInfoSickBookStatVO sickVO = sickBookDAO.querySickBookStat(bookVO.getISBN(), 1); // 현재 table에 BookId가 없어서 이렇게
                                                                     // 가라로 1로 해놓음

      int sickCnt = 0;
      String sickCategoryName = "";
      String sickLevelName = "";
      String resultMessage = "";

      if (sickVO.getSickCnt() != 0) {
         sickCnt = sickVO.getSickCnt();
         sickCategoryName = sickVO.getSickCategoryName();
         sickLevelName = sickVO.getSickLevelName();

         resultMessage = String.format("<html><p> 최근 한달 아파요 %d건 <br> %s, %s ...... 상세보기 클릭</p></html>", sickCnt,
               sickCategoryName, sickLevelName);
      } else {
         resultMessage = String.format("<html><p> 최근 한달 아파요 0건 </p></html>");
      }

      JLabel lblBookSickMessage = new JLabel();
      lblBookSickMessage.setFont(new Font("맑은 고딕", Font.ITALIC, 18));
      lblBookSickMessage.setText(resultMessage);

      lblBookSickMessage.setBounds(214, 125, 180, 150);
      frame.getContentPane().add(lblBookSickMessage);

      // 책 이미지 생성
      String imagePath = String.format("images/%s.jpg", bookVO.getISBN());
      System.out.println(imagePath);
      ImageIcon imageIcon = new ImageIcon(
            new ImageIcon(imagePath).getImage().getScaledInstance(184, 208, Image.SCALE_DEFAULT));

      JLabel lblBookImage = new JLabel(imageIcon);
      lblBookImage.setBounds(25, 105, 177, 179);
      frame.getContentPane().add(lblBookImage);

      lblBookSickMessage.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {

            UserSickBookInfoGUI userSickBookInfo = new UserSickBookInfoGUI(bookVO);
            frame.setVisible(false);
         }
      });

   }
   

   public void frameDispose(boolean b) {

      if (b) {
         this.frame.dispose();
      }
   }
}