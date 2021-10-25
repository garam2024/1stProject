package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.AdminDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLoginGUI {

   private JFrame frame;
   private JTextField tfAdminId;
   
   AdminDAO dao = new AdminDAO();
   private JPasswordField pfAdminPw;
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AdminLoginGUI window = new AdminLoginGUI();
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
   public AdminLoginGUI() {
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
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 49)); 
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(120, 24, 630, 120);
      lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
      
      frame.getContentPane().add(lblNewLabel);
      
      tfAdminId = new JTextField();
      tfAdminId.setBounds(300, 195, 450, 45);
      frame.getContentPane().add(tfAdminId);
      tfAdminId.setColumns(10);
      
      JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 160, 119));
        panel_1.setBounds(94, 195, 166, 45);
        frame.getContentPane().add(panel_1);
      
      JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
      lblNewLabel_1.setForeground(Color.WHITE);
      panel_1.add(lblNewLabel_1);
      lblNewLabel_1.setBackground(new Color(244,218,181));
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 26));
      
      JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(245, 160, 119));
        panel_1_1.setBounds(94, 301, 166, 45);
        frame.getContentPane().add(panel_1_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
      lblNewLabel_1_1.setForeground(Color.WHITE);
      panel_1_1.add(lblNewLabel_1_1);
      lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 26));
      
      
      JButton btnAdminLogin = new RoundedButton("\uB85C\uADF8\uC778");
      btnAdminLogin.setForeground(new Color(255, 255, 255));
      btnAdminLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            // 어드민 로그인 로직 확인후에 유저메인페이지로 이동
            boolean isValidLogin = false;
            
            String adminId = tfAdminId.getText();
            String adminPw = new String(pfAdminPw.getPassword());
            
            isValidLogin = dao.isAdminLoginValid(adminId, adminPw);
            
            if (isValidLogin) {
               
               AdminMainGUI.main(null);
               frame.dispose();
            }
            
            else {
               JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인해주세요!!", "로그인 에러!!", JOptionPane.ERROR_MESSAGE);
            }
            
         }
      });
      btnAdminLogin.setBounds(94, 450, 170, 55);
      btnAdminLogin.setBackground(new Color(241,109, 99));
      btnAdminLogin.setFont(new Font("맑은 고딕", Font.BOLD, 26));
      frame.getContentPane().add(btnAdminLogin);
      
      JButton btnNewButton_1 = new RoundedButton("\uD648\uD398\uC774\uC9C0 \uBA54\uC778\uC73C\uB85C");
      btnNewButton_1.setForeground(new Color(255, 255, 255));
      btnNewButton_1.setText("\uBA54\uC778\uC73C\uB85C");
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            HomeMainGUI.main(null);
            frame.dispose();
         }
      });
      btnNewButton_1.setBounds(560, 450, 170, 55);
      btnNewButton_1.setBackground(new Color(221, 138, 98));
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 26));
      frame.getContentPane().add(btnNewButton_1);
      
      pfAdminPw = new JPasswordField();
      pfAdminPw.setBounds(300, 300, 450, 45);
      frame.getContentPane().add(pfAdminPw);
   }
}