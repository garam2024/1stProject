package GUI;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.AdminStatDAO;
import VO.AdminStatVO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class BookBorrowedListGUI {

   private JFrame frame;
   private Container con;
   
   AdminStatDAO dao = new AdminStatDAO();

   Object[] title=new Object[3];
   String[]field= {"µµº≠∏Ì","¿€∞°","¥Î√‚¥©¿˚"};
   private JScrollPane scrollPane;
   String value;
   DefaultTableModel tableModel = new DefaultTableModel(field,0);
   JTable table = new JTable(tableModel);
   JScrollPane sp = new JScrollPane(table);
   private final JButton btnNewButton = new RoundedButton("\uB3CC\uC544\uAC00\uAE30");
   private final JLabel lblNewLabel = new JLabel("\uB300\uCD9C \uD1B5\uACC4");


   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      new BookBorrowedListGUI();
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BookBorrowedListGUI window = new BookBorrowedListGUI();
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
   public BookBorrowedListGUI() {
      initialize();
      frame = new setGUI();
      frame.getContentPane().setBackground(new Color(250,233,220));
      frame.setBounds(550,250, 900,600);
      //frame.setBounds(750,250, 900,600);
      con = frame.getContentPane();
      //frame.setBounds(750,200, 510, 761);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      sp.setBounds(35, 116, 805, 418);
      con.add(sp);
      btnNewButton.setBackground(new Color(244, 164, 96));
      btnNewButton.setForeground(new Color(255, 255, 255));
      btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 19));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            AdminMainGUI.main(null);
         }
      });
      btnNewButton.setBounds(721, 59, 119, 29);
      
      frame.getContentPane().add(btnNewButton);
      lblNewLabel.setForeground(new Color(244, 164, 96));
      lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
      lblNewLabel.setBounds(25, 23, 280, 83);
      
      frame.getContentPane().add(lblNewLabel);
      ArrayList<AdminStatVO> BookBorrowed = dao.selectAllBoorrowed();
      for (int i = 0; i < BookBorrowed.size(); i++) {
         AdminStatVO dto = BookBorrowed.get(i);
         title[0] = dto.getboook_name();
         title[1] = dto.getAuthor();
         title[2] = dto.getborrowed_booknum();
         tableModel.addRow(title);

      }
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
   }
}