package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.Reser_bookDAO;
import VO.Reser_bookVO;

public class Reser_bookGUI {

   private JTable table;
   private JFrame frame;
   Object[][] Reser_bookData;
   String[] columnHeader;
   Reser_bookDAO dao = new Reser_bookDAO();
   private JTable table_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Reser_bookGUI window = new Reser_bookGUI();
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
   public Reser_bookGUI() {
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new setGUI();
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setBounds(750,250, 450, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblNewLabel = new JLabel("\uC608\uC57D\uD55C \uB3C4\uC11C");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(23, 29, 187, 37);
      frame.getContentPane().add(lblNewLabel);

      ArrayList<Reser_bookVO> Reser_booklist = new ArrayList<Reser_bookVO>();
      System.out.println(UserLoginGUI.userIdStatic);
      Reser_booklist = dao.getreser(UserLoginGUI.userIdStatic);

      Reser_bookData = new Object[Reser_booklist.size()][5];
      columnHeader = new String[5];

      columnHeader[0] = "예약코드";
      columnHeader[1] = "사용자 아이디";
      columnHeader[2] = "예약 날짜";
      columnHeader[3] = "도서 번호";
      columnHeader[4] = "도서 아이디";

      for (int i = 0; i < Reser_booklist.size(); i++) {
         Reser_bookData[i][0] = Reser_booklist.get(i).getRESERV_CODE();
         Reser_bookData[i][1] = Reser_booklist.get(i).getUSER_ID();
         Reser_bookData[i][2] = Reser_booklist.get(i).getRESERV_DATE();
         Reser_bookData[i][3] = Reser_booklist.get(i).getISBN();
         Reser_bookData[i][4] = Reser_booklist.get(i).getBOOK_ID();

      }

      JTable mainTable = new JTable(Reser_bookData, columnHeader);
      mainTable.setVisible(true);

      JScrollPane mainTableScrollPane = new JScrollPane(mainTable);
      mainTableScrollPane.setBounds(7, 76, 415, 455);
      mainTableScrollPane.setVisible(true);

      frame.getContentPane().add(mainTableScrollPane);
      // mainTableScrollPane.setRowHeaderView(table_1);

      table = new JTable();

      JButton btn_back = new RoundedButton("\uC774\uC804\uC73C\uB85C");
      btn_back.setForeground(new Color(255, 255, 255));
      btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      btn_back.setBounds(286, 80, 122, 34);
      btn_back.setBackground(new Color(232, 149, 109));
      btn_back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserMyPageGUI.main(null); // 닫기 누르면 메인창으로
            frame.dispose();
         }
      });
      btn_back.setBounds(311, 30, 97, 37);
      frame.getContentPane().add(btn_back);

   }
}