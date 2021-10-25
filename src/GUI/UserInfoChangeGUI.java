package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.UserInfoChangeDAO;
import VO.UserInfoChangeVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfoChangeGUI {

   private JFrame frame;
   private JTextField tf_username;
   private JTextField tf_userpw;
   private JTextField tf_userphone;
   private JTextField tf_userbirth;

   public UserInfoChangeDAO dao = new UserInfoChangeDAO();

   /**
    * Launch the application.
    */

   /**
    * Create the application.
    */
   public UserInfoChangeGUI() {
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new setGUI();
      frame.setBounds(750,250, 450, 600);
      frame.getContentPane().setBackground(new Color(250, 233, 220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(105, 36, 229, 38);
      frame.getContentPane().add(lblNewLabel);

      JLabel lblPw = new JLabel("PW : ");
      lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      lblPw.setBounds(63, 201, 57, 15);
      frame.getContentPane().add(lblPw);

      JLabel label = new JLabel("\uC774\uB984 : ");
      label.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      label.setBounds(63, 136, 73, 31);
      frame.getContentPane().add(label);

      JLabel label_1 = new JLabel("\uBC88\uD638 : ");
      label_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      label_1.setBounds(63, 258, 57, 15);
      frame.getContentPane().add(label_1);

      JLabel labelbirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C : ");
      labelbirth.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      labelbirth.setBounds(55, 319, 104, 22);
      frame.getContentPane().add(labelbirth);

      tf_username = new JTextField();
      tf_username.setBounds(171, 139, 204, 31);
      frame.getContentPane().add(tf_username);
      tf_username.setColumns(10);

      tf_userpw = new JTextField();
      tf_userpw.setColumns(10);
      tf_userpw.setBounds(171, 196, 204, 31);
      frame.getContentPane().add(tf_userpw);

      tf_userphone = new JTextField();
      tf_userphone.setColumns(10);
      tf_userphone.setBounds(171, 253, 204, 31);
      frame.getContentPane().add(tf_userphone);

      tf_userbirth = new JTextField();
      tf_userbirth.setColumns(10);
      tf_userbirth.setBounds(171, 310, 204, 31);
      frame.getContentPane().add(tf_userbirth);

      JButton but_dispose = new RoundedButton("\uB2EB\uAE30");
      but_dispose.setBackground(new Color(246,147,99));
      but_dispose.setForeground(new Color(255, 255, 255));
      but_dispose.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      but_dispose.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserInfoChangeGUI.main(null); // 수정누르면 수정하는 창으로 이동
            frame.dispose();
            UserMyPageGUI.main(null); // 닫기 누르면 메인창으로

         }
      });
      but_dispose.setBounds(273, 390, 97, 39);
      frame.getContentPane().add(but_dispose);

      JButton but_save = new RoundedButton("\uC800\uC7A5");
      but_save.setBackground(new Color(241, 109, 80));
      but_save.setForeground(new Color(255, 255, 255));
      but_save.setFont(new Font("맑은 고딕", Font.BOLD, 19));
      but_save.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
//            UserInfoChangeGUI.main(null); // 수정누르면 수정하는 창으로 이동
//            frame.dispose();
//            UserMyPageGUI.main(null);
//            String USER_ID = tf_userid.getText(); // 텍스트 필드의 값을 가지고오고 싶을때
            String USER_PW = tf_userpw.getText();
            String USER_NAME = tf_username.getText();
            String USER_PHONE = tf_userphone.getText();
            String USER_BIRTH = tf_userbirth.getText();

            UserInfoChangeVO vo = new UserInfoChangeVO(USER_NAME, USER_PW, USER_PW, USER_PHONE, 0, USER_BIRTH);
            int result = dao.UserInfoChange(vo);

            if (result == 0) {
               JOptionPane.showMessageDialog(null, "회원정보 수정 실패", "회원가입", JOptionPane.ERROR_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, "회원정보 수정 성공");
            }

         }
      });
      but_save.setBounds(70, 390, 97, 39);
      frame.getContentPane().add(but_save);
   }

   protected static void main(Object object) {
      // TODO Auto-generated method stub

   }

}