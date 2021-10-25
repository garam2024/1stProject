package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import DAO.SickReviewDAO;
import VO.SickReviewVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SickReviewGUI {

   private JFrame frame;
   Object[][] SickReviewData;
   String[] columnHeader;
   SickReviewDAO dao = new SickReviewDAO();
   private JTable table_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SickReviewGUI window = new SickReviewGUI();
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
   public SickReviewGUI() {
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

      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setBounds(42, 63, 57, 15);
      frame.getContentPane().add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("\uC544\uD30C\uC694\uD55C \uB9AC\uBDF0");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      lblNewLabel_1.setForeground(new Color(250, 138, 98));
      lblNewLabel_1.setBounds(23, 19, 241, 38);
      frame.getContentPane().add(lblNewLabel_1);

      ArrayList<SickReviewVO> SickReviewlist = new ArrayList<SickReviewVO>();
      SickReviewlist = dao.getsickreview(UserLoginGUI.userIdStatic);

      SickReviewData = new Object[SickReviewlist.size()][5];
      columnHeader = new String[5];

      columnHeader[0] = "작성 날짜";
      columnHeader[1] = "사용자 아이디";
      columnHeader[2] = "도서 아이디";
      columnHeader[3] = "아파요 레벨";
      columnHeader[4] = "아파요 코멘트";

      for (int i = 0; i < SickReviewlist.size(); i++) {
         SickReviewData[i][0] = SickReviewlist.get(i).getREG_DATE();
         SickReviewData[i][1] = SickReviewlist.get(i).getUSER_ID();
         SickReviewData[i][2] = SickReviewlist.get(i).getBOOK_ID();
         SickReviewData[i][3] = SickReviewlist.get(i).getSICK_LEVEL();
         SickReviewData[i][4] = SickReviewlist.get(i).getPRT_COMMENT();

      }

      JTable mainTable = new JTable(SickReviewData, columnHeader);
      mainTable.setVisible(true);

      JScrollPane mainTableScrollPane = new JScrollPane(mainTable);
      mainTableScrollPane.setBounds(23, 98, 384, 435);
      mainTableScrollPane.setVisible(true);

      frame.getContentPane().add(mainTableScrollPane);
      
      JButton btn_back = new RoundedButton("\uC774\uC804\uC73C\uB85C");
      btn_back.setBounds(286, 80, 122, 34);
      btn_back.setForeground(new Color(255, 255, 255));
      btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      btn_back.setBackground(new Color(232, 149, 109));
      btn_back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
                  UserMyPageGUI.main(null);
                  frame.dispose();

         }
      });
      btn_back.setBounds(310, 55, 97, 23);
      frame.getContentPane().add(btn_back);
   }
}