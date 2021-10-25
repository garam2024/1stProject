package DAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.UserMainGUI;
import VO.BookVO;

public class BookDAO {
   Connection conn = null;
   PreparedStatement pst = null;
   ResultSet rs = null;

   public void connect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         String url = "jdbc:oracle:thin:@localhost:1521:system";
         String user = "hr";
         String password = "hr";

         conn = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void close() {
      try {
         if (rs != null) {
            rs.close();
         }
         if (pst != null) {
            pst.close();
         }
         if (conn != null) {
            conn.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   // å �ѱ��� ������ ��� �޼ҵ�/
   public BookVO getBookOne(String id) {
      BookVO vo = new BookVO(id, id, id, id, 0, id);

      connect();

      try {

         String sql = "select * from book_list where book_name= ?";
         pst = conn.prepareStatement(sql);
         pst.setString(1, id);
         rs = pst.executeQuery();

         if (rs.next()) {
            String bookName = rs.getString(1);
            String author = rs.getString(2);
            String publisher = rs.getString(3);
            String ISBN = rs.getString(4);
            int bookId = rs.getInt(5);
            int bookSeries = rs.getInt(6);
            int borrowed = rs.getInt(7);
            String issueDate = rs.getString(8);
            String classNum = rs.getString(9);
            String registration_date = rs.getString(10);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return vo;
   }

   // å ���θ� ������ �� �ִ� �޼ҵ�
   public ArrayList<BookVO> getBookAll() {
      ArrayList<BookVO> list = new ArrayList<BookVO>();
      connect();
      try {
         String sql = "select * from BOOK_LIST order by ISBN";
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();

         while (rs.next()) {
            String bookName = rs.getString(1);
            String author = rs.getString(2);
            String publisher = rs.getString(3);
            String ISBN = rs.getString(4);
            int bookId = rs.getInt(5);
            int bookSeries = rs.getInt(6);
            int borrowed = rs.getInt(7);
            String issueDate = rs.getString(8);
            String classNum = rs.getString(9);
            String registration_date = rs.getString(10);

            BookVO vo = new BookVO(bookName, author, publisher, ISBN, bookId, bookSeries, borrowed, issueDate,
                  classNum, registration_date);
            list.add(vo);

         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return list;
   }

   // å ���
   public int insertBook(BookVO vo) {
      connect();

      int cnt = 0;
      String sql = "insert into BOOK_LIST values(?,?,?,?,1,?,0,?,?,sysdate)";

      try {
         pst = conn.prepareStatement(sql);

         pst.setString(1, vo.getBookName());
         pst.setString(2, vo.getAuthor());
         pst.setString(3, vo.getPublisher());
         pst.setString(4, vo.getISBN());
         pst.setInt(5, vo.getBookSeries());
         pst.setString(6, vo.getIssueDate());
         pst.setString(7, vo.getClassNum());

         cnt = pst.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }

   // ISBN�� �ߺ��Ǵ��� ����Ȯ���ϴ� �޼ҵ�
   public boolean checkDuplicateISBN(String newISBN) {

      boolean isDuplicate = false;
      int idCnt = 0;
      connect(); // DB Connetion

      String sql = "SELECT COUNT(ISBN) AS ISBN_CNT " + "FROM BOOK_LIST " + "WHERE LOWER(ISBN) = LOWER(?)";

      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, newISBN);

         rs = pst.executeQuery();

         rs.next();
         idCnt = rs.getInt(1);

         System.out.println(newISBN);
         System.out.println(idCnt);

         isDuplicate = (idCnt == 0) ? false : true;

      } catch (Exception e) {
         e.printStackTrace();
      }

      return isDuplicate;
   }

   public int delete(String value) {
      int cnt = 0;
      
      connect();
      String sql = "delete from book_list where ISBN = ?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, value);
         cnt = pst.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close();
      }
      
      
      return cnt;
   }
   
   // �˻� �޼ҵ� ���� �������̱�
   public ArrayList<BookVO> searchBook(String strName){
      ArrayList<BookVO> datas = new ArrayList<BookVO>();
      
      connect();
      String sql = "select book_name,author,publisher, ISBN, book_series,"
            + "issue_date,class_num from book_list where book_name like ?";
      
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, "%"+strName+"%");
         rs = pst.executeQuery();
         
         while (rs.next()) {
            String bookName = rs.getString("book_name");
            String author = rs.getString("author");
            String publisher = rs.getString("publisher");
            String ISBN = rs.getString("ISBN");
            int bookSeries = rs.getInt("book_series");
            String issueDate = rs.getString("issue_date");
            String classNum = rs.getString("class_num");
            
            BookVO vo = new BookVO(bookName, author, publisher, ISBN, bookSeries,issueDate, classNum);
            datas.add(vo);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         close();
      }
      return datas;
   }

   // ����� Ŭ���ϸ� ���̺� ��� ���� ��������
   public BookVO getAllInfo(BookVO vo) {
      BookVO bookInfo = null;
      connect();
      String sql = "SELECT * FROM book_list WHERE isbn = ?";
      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, vo.getISBN());
         rs = pst.executeQuery();
         if (rs.next()) {
            String bookName = rs.getString(1);
            String author = rs.getString(2);
            String publisher = rs.getString(3);
            String ISBN = rs.getString(4);
            int bookId = rs.getInt(5);
            int bookSeries = rs.getInt(6);
            int borrowed = rs.getInt(7);
            String issueDate = rs.getString(8);
            String classNum = rs.getString(9);
            String registration_date = rs.getString(10);

            // ��� ������ return�� �� ���� ������ ���ο� ��ü�� ������
            bookInfo = new BookVO(bookName,author, publisher,ISBN,bookId,bookSeries,
                  borrowed, issueDate,classNum,registration_date);
            
//            System.out.println("����ȣȣ");
//            System.out.println(bookInfo.getRegistrationDay());
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return bookInfo;
   }
   

   // å �����ϱ�
   public int reserveBook(String userId, String isbn, int bookId) {
      
      int cnt = 0;
      String reserveNumber = "1";
      bookId = 1;
      
      connect();

      String sqlSub = "SELECT TO_CHAR(NVL(MAX(RESERV_CODE),0) + 1) AS RESERV_CODE\r\n" + 
                  "FROM RESERVATION_LIST\r\n" + 
                  "WHERE 1=1\r\n" + 
                  "    AND ISBN = ?\r\n" + 		// USER_ID �κ� �� (2021.01.11. 23:57) by �Ǽ���
                  "    AND BOOK_ID = ?";
      
      try {
         pst = conn.prepareStatement(sqlSub);
         
         pst.setString(1, isbn);
         pst.setInt(2, bookId);
         
         rs = pst.executeQuery();
         if (rs.next()) {
            reserveNumber = rs.getString(1);
         }
         
         System.out.println(reserveNumber);
         System.out.println(userId);
         System.out.println(isbn);
         System.out.println(bookId);
         
      } catch (SQLException e) {
         e.printStackTrace();
         
      } finally {
         //close();
      }
      
            
      String sql = "INSERT INTO RESERVATION_LIST"
                + "(RESERV_CODE   , USER_ID   , RESERV_DATE   , ISBN   , BOOK_ID)"
               + "VALUES"
               + "(?         , ?         , SYSDATE      , ?      , ?   )";
            
      try {
         
         pst = conn.prepareStatement(sql);
         
         System.out.println(reserveNumber);
         System.out.println(userId);
         System.out.println(isbn);
         System.out.println(bookId);
         
         pst.setString(1, reserveNumber);
         pst.setString(2, userId);
         pst.setString(3, isbn);
         pst.setInt(4, bookId);
      
         System.out.println(pst.toString());
         cnt = pst.executeUpdate();
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }   
      
      return cnt;      
   }
   
   //å ���࿩�� Ȯ���ϱ�
   public boolean isAlreadyBookReserved(String userId, String isbn, int bookId) {
      
      int cnt = 0;
      String reserveNumber = "0";
      boolean result = false;
      
      connect();

      String sql = "SELECT TO_CHAR(NVL(MAX(RESERV_CODE),0)) AS RESERV_CODE\r\n" + 
                  "FROM RESERVATION_LIST\r\n" + 
                  "WHERE 1=1\r\n" + 
                  "    AND USER_ID = ?\r\n" + 
                  "    AND ISBN = ?\r\n" + 
                  "    AND BOOK_ID = ?";
      
      try {
         pst = conn.prepareStatement(sql);
         
         pst.setString(1, userId);
         pst.setString(2, isbn);
         pst.setInt(3, bookId);
         
         rs = pst.executeQuery();
         if (rs.next()) {
            reserveNumber = rs.getString(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
         
      } finally {
         //close();
      }
      
      result = (reserveNumber.equals("0")) ? false : true;
      
      return result;      
   }

   
   // å �� ��ȸ���� ���Ŀ� ������ ���� ����ϱ�
   public int insertSickReview(String bookIsbn, int bookId, String userId, int bookState, int stateLevel, String sickComment) {

      int cnt = 0;
      int rptId = 1;
      
      bookId = 1;
      
      connect();

      String sqlSub = "SELECT NVL(MAX(RPT_ID),0) + 1 AS RPT_ID\r\n" + 
                  "FROM BOOK_SICK\r\n" + 
                  "WHERE 1=1\r\n" + 
                  "    AND ISBN = ?\r\n" + 
                  "    AND BOOK_ID = ?";
      
      try {
         pst = conn.prepareStatement(sqlSub);
         
         pst.setString(1, bookIsbn);
         pst.setInt(2, bookId);
         
         rs = pst.executeQuery();
         if (rs.next()) {
            rptId = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
         
      } finally {
         //close();
      }
      
      System.out.println(bookIsbn);
      System.out.println(bookId);
      System.out.println(userId);
      System.out.println(rptId);
      System.out.println(bookState);
      System.out.println(stateLevel);
      System.out.println(sickComment);
      
            
      String sql = "INSERT INTO BOOK_SICK"
                + "(ISBN   , BOOK_ID   , USER_ID   , RPT_ID   , SICK_CAT    , SICK_LEVEL    , REG_DATE    , PRT_COMMENT)"
               + "VALUES"
               + "(?      , ?         , ?         , ?         , ?         , ?            , SYSDATE   , ?   )";
            
      try {
         
         pst = conn.prepareStatement(sql);
         
         
         pst.setString(1, bookIsbn);
         pst.setInt(2, bookId);
         pst.setString(3, userId);
         pst.setInt(4, rptId);
         pst.setInt(5, bookState);
         pst.setInt(6, stateLevel);
         pst.setString(7, sickComment);
         
         cnt = pst.executeUpdate();
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }   
      
      return cnt;      
   }   
}