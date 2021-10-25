package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class HomeMainGUI {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMainGUI window = new HomeMainGUI();
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
	public HomeMainGUI() {
		initialize();
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
		frame.setResizable(false);

		JButton btnNewButton = new RoundedButton("\uB85C\uADF8\uC778/\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(245, 160, 119));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 유저 로그인 & 홈페이지로 이동
				UserLoginGUI userLogin = new UserLoginGUI();
				userLogin.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(118, 308, 210, 75);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\uD074\uB9B0\uBD81 \uB3C4\uC11C\uAD00");
	      lblNewLabel_2.setBounds(55, 71, 319, 81);
	      frame.getContentPane().add(lblNewLabel_2);
	      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 45)); 
	      lblNewLabel_2.setForeground(new Color(250, 138, 98));
	      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	      frame.getContentPane().add(lblNewLabel_2);

		JButton button = new RoundedButton("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241,109, 99));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 관리지 로그인 페이지로 이동
				AdminLoginGUI.main(null);
				frame.dispose();
			}
		});
		button.setBounds(118, 410, 210, 75);
		frame.getContentPane().add(button);

		/// 여기에요 여기고쳤어요
		JButton btn_search = new RoundedButton("\uAC80\uC0C9\uC73C\uB85C \uC774\uB3D9");
		btn_search.setForeground(Color.WHITE);
		btn_search.setBackground(new Color(245, 160, 119));
		btn_search.setBounds(118, 206, 210, 75);
		frame.getContentPane().add(btn_search);
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserMainGUI.main(null);
			}
		});
		btn_search.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
