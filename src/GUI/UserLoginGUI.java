package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import DAO.UserDAO;

public class UserLoginGUI {

   private JFrame frame;
   private JTextField tfUserId;
   private JPasswordField pfUserPw;
   UserDAO dao = new UserDAO();

   public static String userIdStatic;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UserLoginGUI window = new UserLoginGUI();
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
   public UserLoginGUI() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {

      frame = new setGUI();
      frame.setBounds(750,250, 450, 600);
      frame.getContentPane().setBackground(new Color(250, 233, 220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Layout -> Null로 만들기
      frame.getContentPane().setLayout(null);

      // 유저 아이디 입력칸
      tfUserId = new JTextField();
      tfUserId.setBounds(174, 157, 177, 31);
      frame.getContentPane().add(tfUserId);
      tfUserId.setColumns(10);

      // 유저 비밀번호 입력칸
      pfUserPw = new JPasswordField();
      pfUserPw.setBounds(172, 213, 177, 31);
      frame.getContentPane().add(pfUserPw);

      // 유저 로그인 버튼
      JButton btnLogin = new RoundedButton("\uB85C\uADF8\uC778");
      btnLogin.setForeground(Color.WHITE);
      btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            // 유저 로그인 로직 확인후에 유저메인페이지로 이동
            boolean isValidLogin = true;

            String userId = tfUserId.getText();
            String userPw = new String(pfUserPw.getPassword());

            isValidLogin = dao.isUserLoginValid(userId, userPw);

            if (isValidLogin) {

               userIdStatic = tfUserId.getText();
               System.out.println(userIdStatic);

               UserMainGUI.main(null);
               frame.dispose();
            }

            else {
               JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인해주세요!!", "로그인 에러!!", JOptionPane.ERROR_MESSAGE);
            }

         }
      });
      btnLogin.setBounds(67, 310, 132, 102);
      btnLogin.setBackground(new Color(241, 109, 80));
      frame.getContentPane().add(btnLogin);

      JButton btnCreateAccount = new RoundedButton("\uD68C\uC6D0\uAC00\uC785");
      btnCreateAccount.setForeground(Color.WHITE);
      btnCreateAccount.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      btnCreateAccount.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            UserCreateAccountGUI userCreateAccount = new UserCreateAccountGUI();
            frame.dispose();

         }
      });
      btnCreateAccount.setBounds(235, 310, 132, 102);
      btnCreateAccount.setBackground(new Color(246, 147, 99));
      frame.getContentPane().add(btnCreateAccount);

      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setForeground(new Color(210, 105, 30));
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      lblNewLabel.setBounds(71, 157, 100, 37);
      frame.getContentPane().add(lblNewLabel);

      JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
      label.setForeground(new Color(210, 105, 30));
      label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
      label.setBounds(69, 218, 110, 37);
      frame.getContentPane().add(label);

      JLabel lblNewLabel_1 = new JLabel("\uC790\uBC14\uAC8C\uD2F0 \uD074\uB9B0\uBD81 \uB3C4\uC11C\uAD00");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      lblNewLabel_1.setForeground(new Color(250, 138, 98));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(0, 53, 434, 52);
      frame.getContentPane().add(lblNewLabel_1);

      // 홈 메인으로 이동하는 버튼
      JButton btnBackToHomeMainGUI = new RoundedButton("\uBA54\uC778 \uD648\uD398\uC774\uC9C0\uB85C");
      btnBackToHomeMainGUI.setForeground(Color.WHITE);
      btnBackToHomeMainGUI.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      btnBackToHomeMainGUI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HomeMainGUI.main(null);
            frame.dispose();
         }
      });
      btnBackToHomeMainGUI.setBounds(68, 438, 298, 49);
      btnBackToHomeMainGUI.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(btnBackToHomeMainGUI);

   }

}