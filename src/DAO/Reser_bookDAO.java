package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import VO.Reser_bookVO;

public class Reser_bookDAO {
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


			public ArrayList<Reser_bookVO> getreser(String user_Id) {
				ArrayList<Reser_bookVO> Reser_booklist = new ArrayList<Reser_bookVO>();
				connect();
				try {
					String sql = "select * from RESERVATION_LIST where user_id=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, user_Id);
					rs = pst.executeQuery();

				
					while (rs.next()) {
						String RESERV_CODE = rs.getString(1);
						String USER_ID = rs.getString(2);
						Date RESERV_DATE= rs.getDate(3);
						String ISBN = rs.getString(4);
						int BOOK_ID = rs.getInt(5);
						
						
						Reser_bookVO vo = new Reser_bookVO(RESERV_CODE, USER_ID,  RESERV_DATE, ISBN, BOOK_ID);
						Reser_booklist.add(vo);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return Reser_booklist;
			}
			
			private String getUSER_NAME() {
				// TODO Auto-generated method stub
				return null;
			}
			  public static void main(String[] args) {
				  Reser_bookDAO dao = new Reser_bookDAO();
			      ArrayList<Reser_bookVO> arrayList = dao.getReser_booklist();
			      
			     // System.out.println(arrayList.get(1).toString());
			   }

			ArrayList<Reser_bookVO> getReser_booklist() {
				// TODO Auto-generated method stub
				return null;
			}

		
		}
		
