package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import DAO.UserDAO;
import VO.UserVO;
import javax.swing.JPasswordField;

public class UserCreateAccountGUI {

   private JFrame frame;
   private JTextField tfUserId;
   private JTextField tfUserBirthDate;
   private JTextField tfUserPhone;
   private JTextField tfUserName;
   private JPasswordField pfUserPw;
   private JPasswordField pfUserPwChecked;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UserCreateAccountGUI window = new UserCreateAccountGUI();
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
   public UserCreateAccountGUI() {
      initialize();
      frame.setVisible(true);      // Event Handler에 의해 실행되었을 때 화면 보여주기
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new setGUI();
      frame.setBounds(750,250, 450, 600);
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Layout -> null
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setBounds(45, 128, 60, 23);
      lblNewLabel.setForeground(new Color(210, 105, 30));
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(lblNewLabel);
      
      JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
      label.setBounds(45, 166, 80, 23);
      label.setForeground(new Color(210, 105, 30));
      label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(label);
      
      JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
      label_1.setBounds(45, 203, 120, 23);
      label_1.setForeground(new Color(210, 105, 30));
      label_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(label_1);
      
      JLabel label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
      label_2.setBounds(45, 266, 80, 23);
      label_2.setForeground(new Color(210, 105, 30));
      label_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(label_2);
      
      JLabel label_3 = new JLabel("\uD734\uB300\uC804\uD654\uBC88\uD638");
      label_3.setBounds(45, 299, 120, 23);
      label_3.setForeground(new Color(210, 105, 30));
      label_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(label_3);
      
      tfUserId = new JTextField();
      tfUserId.setBounds(177, 130, 124, 21);
      frame.getContentPane().add(tfUserId);
      tfUserId.setColumns(10);
      
      tfUserBirthDate = new JTextField();
      tfUserBirthDate.setColumns(10);
      tfUserBirthDate.setBounds(177, 268, 124, 21);
      frame.getContentPane().add(tfUserBirthDate);
      
      tfUserPhone = new JTextField();
      tfUserPhone.setColumns(10);
      tfUserPhone.setBounds(177, 301, 124, 21);
      frame.getContentPane().add(tfUserPhone);
      
      JButton btnCheckDuplicateId = new RoundedButton("\uC911\uBCF5\uD655\uC778");
      btnCheckDuplicateId.setForeground(Color.WHITE);
      btnCheckDuplicateId.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      btnCheckDuplicateId.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            UserDAO dao = new UserDAO();
            boolean isDuplicate = dao.checkDuplicateId(tfUserId.getText().trim());
            
            if (isDuplicate) {
               JOptionPane.showMessageDialog(null, "사용 중인 아이디오니 아이디를 다시 입력해주세요 X:D", "아이디 중복", JOptionPane.ERROR_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, "이 아이디로 생성이 가능합니다. X:D", "아이디 중복아님", JOptionPane.PLAIN_MESSAGE);
            }
         }
      });
      
      
      btnCheckDuplicateId.setBounds(313, 130, 97, 23);
      btnCheckDuplicateId.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(btnCheckDuplicateId);
      
      JButton button = new RoundedButton("\uC77C\uCE58\uD655\uC778");
      button.setForeground(Color.WHITE);
      button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      // 회원가입시 비밀번호 일치여부 확인
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            String userPw = new String(pfUserPw.getPassword());
            String userPwChecked = new String(pfUserPwChecked.getPassword());
            
            if (userPw.equals(userPwChecked)) {
               JOptionPane.showMessageDialog(null, "비밀번호 일치합니다, 계속해주세요 ^0^", "비밀번호 일치", JOptionPane.PLAIN_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다, 다시 입력해주세요.", "비밀번호 불일치", JOptionPane.ERROR_MESSAGE);
            }
         }
      });
      button.setBounds(313, 205, 97, 23);
      button.setBackground(new Color(221, 138, 98));
      frame.getContentPane().add(button);
      
      JButton btnNewButton_1 = new RoundedButton("\uACC4\uC815\uB9CC\uB4E4\uAE30");
      btnNewButton_1.setText("\uACC4\uC815 \uB9CC\uB4E4\uAE30");
      btnNewButton_1.setForeground(Color.WHITE);
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            String userName = tfUserName.getText();
            String userId = tfUserId.getText();
            String userPw = new String(pfUserPw.getPassword());
            String userBirthDate = tfUserBirthDate.getText();
            String userPhone = tfUserPhone.getText();
            
            System.out.println(userName);
            System.out.println(userId);
            System.out.println(userBirthDate);
            System.out.println(userPhone);
            
            UserVO vo = new UserVO(userName, userId, userPw, userBirthDate, userPhone);
            UserDAO dao = new UserDAO();
               
            int insertedRow = dao.createUserAccount(vo);
            
            if(insertedRow == 0) {
               JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입 에러", JOptionPane.ERROR_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입 완료", JOptionPane.PLAIN_MESSAGE);
            }
            
            //입력한 TextField 초기화
            tfUserName.setText("   ");
            tfUserId.setText("");
            pfUserPw.setText("");
            pfUserPwChecked.setText("");
            tfUserBirthDate.setText("");
            tfUserPhone.setText("");   
         }
      });
      btnNewButton_1.setBounds(111, 373, 240, 50);
      btnNewButton_1.setBackground(new Color(241, 109, 80));
      frame.getContentPane().add(btnNewButton_1);
      
      JButton btnBackToLoginPage = new RoundedButton("\uB85C\uADF8\uC778 \uD398\uC774\uC9C0\uB85C");
      btnBackToLoginPage.setText("\uB85C\uADF8\uC778 \uD558\uAE30");
      btnBackToLoginPage.setForeground(Color.WHITE);
      btnBackToLoginPage.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      btnBackToLoginPage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            UserLoginGUI.main(null);
            frame.dispose();
         }
      });
      btnBackToLoginPage.setBounds(111, 445, 240, 50);
      btnBackToLoginPage.setBackground(new Color(246,147,99));
      frame.getContentPane().add(btnBackToLoginPage);
      
      JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uD398\uC774\uC9C0");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      lblNewLabel_1.setForeground(new Color(250, 138, 98));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(61, 25, 322, 60);
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel btnUserName = new JLabel("\uC774\uB984");
      btnUserName.setBounds(45, 236, 80, 23);
      btnUserName.setForeground(new Color(210, 105, 30));
      btnUserName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      frame.getContentPane().add(btnUserName);
      
      tfUserName = new JTextField();
      tfUserName.setColumns(10);
      tfUserName.setBounds(177, 238, 124, 21);
      frame.getContentPane().add(tfUserName);
      
      pfUserPw = new JPasswordField();
      pfUserPw.setBounds(177, 168, 124, 21);
      frame.getContentPane().add(pfUserPw);
      
      pfUserPwChecked = new JPasswordField();
      pfUserPwChecked.setBounds(175, 205, 126, 21);
      frame.getContentPane().add(pfUserPwChecked);
   }
}