package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class UserMyPageGUI {

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UserMyPageGUI window = new UserMyPageGUI();
               window.frame.setVisible(true); //¸ÞÀÎÃ¢À» º¸¿©ÁÜ
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   
   /**
    * Create the application.
    */
   public UserMyPageGUI() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new setGUI();
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setBounds(750,250, 450, 600);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      
      JButton btn_cha = new RoundedButton("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
      btn_cha.setForeground(new Color(255, 255, 255));
      btn_cha.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
      btn_cha.setBackground(new Color(246, 147, 99));
      btn_cha.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
//            UserMyPageGUI cha = new UserMyPageGUI();
             
            JoinchangeGUI join = new JoinchangeGUI(); //Ã¢ ¿¬°á
            frame.dispose();
         }
         
         
      });
      btn_cha.setBounds(27, 173, 185, 180);
      frame.getContentPane().add(btn_cha);
      
      JButton btn_reser = new RoundedButton("\uC608\uC57D\uD55C \uCC45");
      btn_reser.setForeground(new Color(255, 255, 255));
      btn_reser.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
      btn_reser.setBackground(new Color(244, 218, 181));
      
      
      
      btn_reser.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Reser_bookGUI test = new Reser_bookGUI();
            frame.dispose();
         
         }
      });
      
      
      
      
      btn_reser.setBounds(225, 173, 185, 180);
      frame.getContentPane().add(btn_reser);
      
      JButton button_review = new RoundedButton("\uC544\uD30C\uC694 \uB9AC\uBDF0");
      button_review.setForeground(new Color(255, 255, 255));
      button_review.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
      button_review.setBackground(new Color(241,109, 80));
      button_review.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            SickReviewGUI SickReview = new SickReviewGUI();
             frame.dispose();
         }
      });
      button_review.setBounds(27, 360, 185, 180);
      frame.getContentPane().add(button_review);
      
      
      
   
        
      JLabel lblNewLabel = new JLabel("");
      //lblNewLabel.setIcon(new ImageIcon("E:\\ÇÐ¿øÀÚ·á (2)\\ÇÁ·ÎÁ§Æ®\\(Á¦Ãâ¿ë) ÀÎ°øÁö´É 1Â÷ ÇÁ·Î±×·¥_ÀÚ¹Ù°ÔÆ¼ÆÀ\\(Á¦Ãâ¿ë) ¡Ú 5. ÇÁ·ÎÁ§Æ® ÄÚµå\\images\\garam.png"));
      lblNewLabel.setBounds(49, 40, 149, 119);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel label_point = new JLabel("\uD3EC\uC778\uD2B8 :");
      label_point.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label_point.setBounds(222, 103, 57, 15);
      frame.getContentPane().add(label_point);
      
      JLabel label_name = new JLabel("\uB2D8");
      label_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
      label_name.setBounds(325, 70, 57, 15);
      frame.getContentPane().add(label_name);
      
      JLabel lb_name = new JLabel("\uC591\uAC00\uB78C");
      lb_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));
      lb_name.setBounds(225, 61, 101, 24);
      frame.getContentPane().add(lb_name);
      //String USER_NAME = lb_name.getText();
      
      JLabel lb_point = new JLabel("100");
      lb_point.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lb_point.setBounds(280, 103, 57, 15);
      frame.getContentPane().add(lb_point);
      
      JButton button = new RoundedButton("\uB3CC\uC544\uAC00\uAE30");
      button.setForeground(new Color(255, 255, 255));
      button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
      button.setBackground(new Color(232, 149, 109));
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            frame.dispose();
            UserMainGUI.main(null);
         }
      });
      button.setBounds(225, 360, 185, 180);
      frame.getContentPane().add(button);
      //int USER_POINT = lb_point.get();
   }
}