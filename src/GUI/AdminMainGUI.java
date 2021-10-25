package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainGUI {

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AdminMainGUI window = new AdminMainGUI();
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
   public AdminMainGUI() {
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
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
      lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 49)); 
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(66, 48, 457, 48);
      frame.getContentPane().add(lblNewLabel);
      
      JButton btn_book = new RoundedButton("\uB3C4\uC11C \uAD00\uB9AC(\uB4F1\uB85D, \uC218\uC815, \uC0AD\uC81C)");
      btn_book.setForeground(Color.WHITE);
      btn_book.setText("\uB4F1\uB85D, \uC218\uC815, \uC0AD\uC81C");
      btn_book.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
      btn_book.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            AdminBookListGUI.main(null);
            frame.dispose();
         }
      });
      btn_book.setBounds(67, 265, 200, 241);
      btn_book.setBackground(new Color(246, 147, 99));
      frame.getContentPane().add(btn_book);
      
      JButton btn_booksick = new RoundedButton("\uD6FC\uC190 \uB3C4\uC11C \uD604\uD669/\uAD00\uB9AC");
      btn_booksick.setForeground(Color.WHITE);
      btn_booksick.setText("\uD604\uD669/\uAD00\uB9AC");
      btn_booksick.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            AdminSickBookListGUI.main(null);
            frame.dispose();
         }
      });
      btn_booksick.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
      btn_booksick.setBounds(340, 265, 200, 241);
      btn_booksick.setBackground(new Color(246, 147, 99));
      frame.getContentPane().add(btn_booksick);
      
      JButton btn_bookstat = new RoundedButton("\uB3C4\uC11C \uC774\uC6A9 \uD1B5\uACC4");
      btn_bookstat.setForeground(Color.WHITE);
      btn_bookstat.setText("\uD1B5\uACC4 \uC790\uB8CC");
      btn_bookstat.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            BookBorrowedListGUI.main(null);
         }
      });
      btn_bookstat.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
      btn_bookstat.setBounds(607, 268, 200, 234);
      btn_bookstat.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(btn_bookstat);
      
      JButton btn_logout = new RoundedButton("\uB85C\uADF8 \uC544\uC6C3");
      btn_logout.setText("\uB85C\uADF8\uC544\uC6C3");
      btn_logout.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
      btn_logout.setForeground(Color.WHITE);
      btn_logout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            AdminLoginGUI.main(null);
            frame.dispose();
         }
      });
      btn_logout.setBounds(688, 35, 128, 48);
      btn_logout.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(btn_logout);
      
      JPanel bgpanel_01 = new JPanel();
      bgpanel_01.setBorder(null);
      bgpanel_01.setLayout(null);
      bgpanel_01.setBackground(new Color(255 , 244  ,228));
      bgpanel_01.setBounds(67, 185, 200, 60);
      frame.getContentPane().add(bgpanel_01);
      
      
      JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uAD00\uB9AC");
      lblNewLabel_1.setForeground(new Color(241,109, 99));
      lblNewLabel_1.setBounds(0, 0, 200, 60);
      lblNewLabel_1.setBorder(null);
      lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 36));
      bgpanel_01.add(lblNewLabel_1);
      
      JPanel bgpanel_02 = new JPanel();
      bgpanel_02.setBounds(340, 185, 200, 60);
      bgpanel_02.setBackground(new Color(255 , 244  ,228));
      frame.getContentPane().add(bgpanel_02);
      bgpanel_02.setLayout(null);
      
      JLabel lblNewLabel_2 = new JLabel("\uD6FC\uC190\uB3C4\uC11C");
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setForeground(new Color(241,109, 99));
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 36));
      lblNewLabel_2.setBounds(0, 0, 200, 60);
      bgpanel_02.add(lblNewLabel_2);
      
      JPanel bgpanel_03 = new JPanel();
      bgpanel_03.setBounds(607, 185, 200, 60);
      bgpanel_03.setBackground(new Color(255 , 244  ,228));
      frame.getContentPane().add(bgpanel_03);
      bgpanel_03.setLayout(null);
      
      JLabel lblNewLabel_3 = new JLabel("\uB3C4\uC11C\uC774\uC6A9");
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 36));
      lblNewLabel_3.setForeground(new Color(241,109, 99));
      lblNewLabel_3.setBounds(0, 0, 200, 60);
      bgpanel_03.add(lblNewLabel_3);
   }
   
   

}