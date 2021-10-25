package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import VO.SickReviewVO;

public class SickReviewDAO {
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


			public ArrayList<SickReviewVO> getsickreview(String user_Id) {
				ArrayList<SickReviewVO> SickReviewList = new ArrayList<SickReviewVO>();
				connect();
				try {
					String sql = "select REG_DATE, USER_ID,BOOK_ID,SICK_LEVEL,PRT_COMMENT from BOOK_SICK where user_id=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, user_Id);
					rs = pst.executeQuery();
				
					while (rs.next()) {
						Date REG_DATE = rs.getDate(1);
						String USER_ID = rs.getString(2);
						int BOOK_ID= rs.getInt(3);
						int SICK_LEVEL = rs.getInt(4);
						String PRT_COMMENT = rs.getString(5);
						
						
						SickReviewVO vo = new SickReviewVO(REG_DATE, USER_ID,BOOK_ID, SICK_LEVEL, PRT_COMMENT);
						SickReviewList.add(vo);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return SickReviewList;
				
			}
			
			 
			  public static void main(String[] args) {
				  SickReviewDAO dao = new SickReviewDAO();
			      ArrayList<SickReviewVO> arrayList = dao.getSickReviewList();
			      
 
//			      System.out.println(arrayList.toString());
//			      System.out.println("�Ƴ�");
			  }

			 ArrayList<SickReviewVO> getSickReviewList() {
				// TODO Auto-generated method stub
				return null;
			}

			ArrayList<SickReviewVO> SickReviewlist() {
				// TODO Auto-generated method stub
				return null;
			}

		
		}
		
