package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.BookDAO;
import VO.BookSearchModelVO;
import VO.BookVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserMainGUI {

   private JFrame frame;
   private JTextField txt_search;
   BookDAO dao = new BookDAO();

   public static JTable table;
   DefaultTableModel mod;

   String[] title;
   Object[][] bookInfo;
   String value;
   private JScrollPane scrollPane;
   private JButton btn_home;
   private JLabel lblNewLabel;
   private JTextArea textArea;
   private JPanel contentPane;
   BookSearchModelVO bsm = new BookSearchModelVO(null);

   static String bookName;
   static String ISBN;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UserMainGUI window = new UserMainGUI();
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
   public UserMainGUI() {
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new setGUI();
      frame.setBounds(750,250, 450, 600);
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      // 마이페이지랑 연결하기
      JButton btn_myPage = new RoundedButton("\uB9C8\uC774\uD398\uC774\uC9C0");
      btn_myPage.setForeground(Color.WHITE);
      btn_myPage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserMyPageGUI.main(null);
            frame.dispose();
         }
      });
      btn_myPage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      btn_myPage.setBackground(new Color(221, 138, 98));
      btn_myPage.setBounds(300, 14, 115, 31);
      frame.getContentPane().add(btn_myPage);

      // 처음 화면에 책 리스트가 보이게 하기
      ArrayList<BookVO> bookList = new ArrayList<BookVO>();
      bookList = dao.getBookAll();
      bookInfo = new Object[bookList.size()][5];
      title = new String[5];
      title[0] = "도서 이름";
      title[1] = "저자";
      title[2] = "출판사";
      title[3] = "도서번호";
//      title[4] = "도서시리즈";
//      title[5] = "대출건수";
//      title[5] = "발행년도";
      title[4] = "주제분류번호";

      for (int i = 0; i < bookList.size(); i++) {
         bookInfo[i][0] = bookList.get(i).getBookName();
         bookInfo[i][1] = bookList.get(i).getAuthor();
         bookInfo[i][2] = bookList.get(i).getPublisher();
         bookInfo[i][3] = bookList.get(i).getISBN();
//         bookInfo[i][4] = bookList.get(i).getBookID();
//         bookInfo[i][4] = bookList.get(i).getBookSeries();
//         bookInfo[i][5] = bookList.get(i).getBorrowed();
//         bookInfo[i][5] = bookList.get(i).getIssueDate();
         bookInfo[i][4] = bookList.get(i).getClassNum();
//         bookInfo[i][9] = bookList.get(i).getRegistrationDay();
      }

      // 수정불가능하게 함
      mod = new DefaultTableModel(bookInfo, title) {
         public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
         }
      };

      table = new JTable(mod);

      // 책을 클릭하면 해당 게시물로 이동하는 메소드
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent evt) {
            frame.dispose();
            int row = table.getSelectedRow();
            TableModel dataBook = table.getModel();

            String bookName = (String) dataBook.getValueAt(row, 0);
            String author = (String) dataBook.getValueAt(row, 1);
            String publisher = (String) dataBook.getValueAt(row, 2);
            String ISBN = (String) dataBook.getValueAt(row, 3);
//            int book_series = Integer.parseInt(dataBook.getValueAt(row, 4).toString());
//            String issueDate = (String) dataBook.getValueAt(row, 5);
            String classNum = (String) dataBook.getValueAt(row, 4);
            
//            System.out.println(bookName);
//            System.out.println(author);
//            System.out.println(publisher);
//            System.out.println(ISBN);
//            System.out.println(classNum);
            
            
            BookVO bookOne = new BookVO(bookName, author,publisher,ISBN, classNum);
//            System.out.println(bookOne.getBookName());
//            System.out.println(bookOne.getAuthor());
//            System.out.println(bookOne.getPublisher());
//            System.out.println(bookOne.getISBN());
//            System.out.println(bookOne.getClassNum());
            
            BookInfoGUI frame = new BookInfoGUI(bookOne);

         }
      });

      
      
      table.setVisible(true);
      scrollPane = new JScrollPane(table);
      scrollPane.setBounds(25, 155, 390, 385);

      scrollPane.setVisible(true);
      frame.getContentPane().add(scrollPane);

      // 홈 버튼 누르면 첫 화면으로 돌아가기
      btn_home = new RoundedButton("\uB85C\uADF8\uC544\uC6C3");
      btn_home.setForeground(Color.WHITE);
      btn_home.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      btn_home.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            UserLoginGUI.main(null);
            frame.dispose();

            // 미사용
//            ArrayList<BookVO> bookList = new ArrayList<BookVO>();
//            bookList = dao.getBookAll();
//            bookInfo = new Object[bookList.size()][5];
//            title = new String[5];
//            title[0] = "도서 이름";
//            title[1] = "저자";
//            title[2] = "출판사";
//            title[3] = "도서번호";
////            title[4] = "도서시리즈";
////            title[5] = "대출건수";
////            title[5] = "발행년도";
//            title[4] = "주제분류번호";
//
//            for (int i = 0; i < bookList.size(); i++) {
//               bookInfo[i][0] = bookList.get(i).getBookName();
//               bookInfo[i][1] = bookList.get(i).getAuthor();
//               bookInfo[i][2] = bookList.get(i).getPublisher();
//               bookInfo[i][3] = bookList.get(i).getISBN();
////               bookInfo[i][4] = bookList.get(i).getBookID();
////               bookInfo[i][4] = bookList.get(i).getBookSeries();
////               bookInfo[i][5] = bookList.get(i).getBorrowed();
////               bookInfo[i][5] = bookList.get(i).getIssueDate();
//               bookInfo[i][4] = bookList.get(i).getClassNum();
////               bookInfo[i][9] = bookList.get(i).getRegistrationDay();
//            }
//
//            table = new JTable(bookInfo, title);
//
//            table.setVisible(true);
//            scrollPane = new JScrollPane(table);
//            scrollPane.setBounds(32, 151, 806, 382);
//
//            scrollPane.setVisible(true);
//            frame.getContentPane().add(scrollPane);

         }
      });
      btn_home.setBounds(30, 14, 98, 31);
      btn_home.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(btn_home);

      // 검색창 둘레
      JPanel panel = new JPanel();
      panel.setBackground(new Color(241,184,145));
      panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB3C4\uC11C \uAC80\uC0C9",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      panel.setBounds(35, 78, 367, 63);
      frame.getContentPane().add(panel);
      panel.setLayout(null);

      // 검색창 라벨
      lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85 \uC785\uB825");
      lblNewLabel.setForeground(Color.BLACK);
      lblNewLabel.setBounds(10, 26, 83, 15);
      panel.add(lblNewLabel);
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));

      // 텍스트 적는 곳(엔터로 검색)
      txt_search = new JTextField();
      txt_search.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent arg0) {
            if (arg0.getKeyChar() == '\n') {
               String strName = txt_search.getText();

               table.setModel(new BookSearchModelVO(strName));
            }
         }
      });
      txt_search.setBounds(95, 18, 173, 31);
      panel.add(txt_search);
      txt_search.setColumns(20);

      // 검색 버튼
      JButton btn_search = new RoundedButton("\uAC80\uC0C9");
      btn_search.setForeground(Color.WHITE);
      btn_search.setBounds(280, 18, 70, 30);
      btn_search.setBackground(new Color(221, 138, 98));
      panel.add(btn_search);

      btn_search.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            String strName = txt_search.getText();

            if (table != null) {
               if (strName.length() < 2) {
                  JOptionPane.showMessageDialog(null, "2자 이상 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
               } else {
                  try {
                     table.setModel(new BookSearchModelVO(strName));

                  } catch (Exception e2) {
                     e2.printStackTrace();
                  }
               }
            }

         }
      });

      textArea = new JTextArea();
      textArea.setEditable(false);

      btn_search.setFont(new Font("맑은 고딕", Font.BOLD, 16));

   }
   
   // 화변 보이고 안보이는 Method 만들기
   public void setVisible(boolean b) {
      
      if (b) {
         frame.setVisible(true);
      }
      
      else {
         frame.setVisible(false);
      }
   }
}