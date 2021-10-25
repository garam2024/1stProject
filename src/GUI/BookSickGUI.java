package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import DAO.BookDAO;
import DAO.SickBookListDAO;
import VO.BookVO;
import VO.SickBookListVO;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class BookSickGUI {

   private JFrame frame;
   SickBookListDAO daoSick;
   BookVO voBook;
   BookDAO daoBook;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               BookSickGUI window = new BookSickGUI();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the application.
    */
   public BookSickGUI(BookVO bookVO) {
      initialize(bookVO);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(BookVO bookVO) {
      
      BookDAO bookDAO = new BookDAO();
      
      frame = new setGUI();
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setBounds(750,250, 450, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC544\uD30C\uC694");
      lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 35));
      lblNewLabel.setForeground(new Color(250, 138, 98));
      lblNewLabel.setBounds(153, 37, 180, 42);
      frame.getContentPane().add(lblNewLabel);
      
      JComboBox cb_state = new JComboBox();
      cb_state.setModel(new DefaultComboBoxModel(new String[] {"\uCC45\uC758 \uC0C1\uD0DC", "1. \uCC22\uAE40", "2. \uB099\uC11C", "3. \uC624\uC5FC", "4. \uC624\uB798\uB428, \uB0A1\uC74C", "5. \uAE30\uD0C0(\uC758\uACAC\uC744 \uC801\uC5B4\uC8FC\uC138\uC694)"}));
      cb_state.setFont(new Font("����", Font.PLAIN, 15));
      cb_state.setBounds(44, 139, 159, 33);
      frame.getContentPane().add(cb_state);
      
      JComboBox cb_stateLevel = new JComboBox();
      cb_stateLevel.setModel(new DefaultComboBoxModel(new String[] {"\uC0C1\uD0DC \uC815\uB3C4", "1. \uC0C1", "2. \uC911", "3. \uD558"}));
      cb_stateLevel.setFont(new Font("����", Font.PLAIN, 15));
      cb_stateLevel.setBounds(229, 139, 154, 33);
      frame.getContentPane().add(cb_stateLevel);
      
      JTextArea textArea = new JTextArea("20�� �̳��� ��Ź�帳�ϴ�.",21, 0);
      
      textArea.setFont(new Font("������", Font.PLAIN, 13));
      textArea.setBounds(35, 216, 355, 222);
      //textArea.setText("20�� �̳��� ��Ź�帳�ϴ�.");
      
      textArea.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
              if (textArea.getText().length() == 21) {
                  e.consume();
              }
          }
      });//20���� ����
      
      textArea.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked(MouseEvent e){
        	  textArea.setText("");
          }
      });//�⺻���� Ŭ���ϸ� �ڵ�����
      
      frame.getContentPane().add(textArea);
      
      //BookVO bookVO2 = daoBook.getAllInfo(voBook);
      
      JButton btn_insert = new RoundedButton("\uB4F1\uB85D");
      btn_insert.setForeground(new Color(255, 255, 255));
      btn_insert.setBackground(new Color(241, 109, 80));
      

      btn_insert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            String bookIsbn = bookVO.getISBN();
            int bookId = 1;                        // bookVO���� �����;ߵǴµ� ���� ȭ���� bookVO�� id�� ���� => ����������Ʈ������ �߻����ϰ� �������� ��...
            String userId = UserLoginGUI.userIdStatic;
            
            
            int bookState = cb_state.getSelectedIndex();            // SICK_CAT
            int stateLevel = cb_stateLevel.getSelectedIndex();         // SICK_LEVEL
            String comment = textArea.getText();
            
//            System.out.println(bookIsbn);
//            System.out.println(bookId);
//            System.out.println(userId);
//            System.out.println(bookState);
//            System.out.println(stateLevel);
//            System.out.println(comment);
            
            int sickResultCnt = bookDAO.insertSickReview(bookIsbn, bookId, userId, bookState, stateLevel, comment);
            
            
            if (sickResultCnt > 0) {
               JOptionPane.showMessageDialog(null, 
                     "���Ŀ� ��� �Ϸ�!!", "Message", 
                     JOptionPane.INFORMATION_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, 
                     "���Ŀ� ��� ����", "Message", 
                     JOptionPane.ERROR_MESSAGE);
            }
            
            
//            txt_bookName.setText(bookVO2.getBookName());
            
            //SickBookListVO voSick = new SickBookListVO(null, null, null, null, bookState, stateLevel, null, comment);
            //daoSick.insertSick(voSick);
            
         }
      });
      btn_insert.setFont(new Font("���� ���", Font.BOLD, 21));
      btn_insert.setBounds(50, 470, 122, 34);
      frame.getContentPane().add(btn_insert);
      
      JButton btn_close = new RoundedButton("\uB2EB\uAE30");
      btn_close.setForeground(new Color(255, 255, 255));
      btn_close.setBackground(new Color(246, 147, 99));
      btn_close.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            SwingUtilities.updateComponentTreeUI(BookInfoGUI.getFrame());
            BookInfoGUI.getFrame().invalidate();
            BookInfoGUI.getFrame().validate();
            BookInfoGUI.getFrame().repaint();
            
            BookInfoGUI.getFrame().setVisible(true);
            
         }
      });
      btn_close.setFont(new Font("���� ���", Font.BOLD, 21));
      btn_close.setBounds(250, 470, 122, 34);
      frame.getContentPane().add(btn_close);
      
      JPanel panel = new JPanel();
      panel.setToolTipText("");
      panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC790\uC138\uD788 \uC54C\uB824\uC8FC\uC138\uC694", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      panel.setBounds(28, 196, 370, 252);
      frame.getContentPane().add(panel);
      
      
   }
}