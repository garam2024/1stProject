package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.SickBookListVO;
import VO.UserVO;
import VO.BookInfoSickBookStatVO;
import VO.BookVO;

public class SickBookListDAO {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	// DB Connection
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:system";
			String user = "hr";
			String password = "hr";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	// DB Dis-Connection
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
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// ���Ŀ� ���� GUI�� ��� ������� SELECT
	public ArrayList<SickBookListVO> getSickBookList() {
		
		ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
		connect();
		try {
//			String sql = "SELECT * FROM BOOK_SICK";
			String sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
					"        , A.ISBN\r\n" + 
					"        , A.BOOK_ID\r\n" + 
					"        , B.BOOK_NAME\r\n" + 
					"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
					"                        WHEN 2 THEN '����'\r\n" + 
					"                        WHEN 3 THEN '����'\r\n" + 
					"                        WHEN 4 THEN '����'\r\n" + 
					"                        WHEN 5 THEN '��Ÿ'\r\n" + 
					"                        ELSE 'Ȯ���ʿ�'\r\n" + 
					"          END   AS SICK_CAT_NAME\r\n" + 
					"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
					"                          WHEN 2 THEN '��'\r\n" + 
					"                          WHEN 3 THEN '��'\r\n" + 
					"          END   AS SICK_LEVEL_NAME\r\n" + 
					"        , A.USER_ID\r\n" + 
					"        , A.PRT_COMMENT\r\n" + 
					"FROM BOOK_SICK      A\r\n" + 
					"LEFT JOIN BOOK_LIST B\r\n" + 
					"ON 1=1\r\n" + 
					"    AND A.ISBN      = B.ISBN\r\n" + 
					"    AND A.BOOK_ID   = B.BOOK_ID\r\n" + 
					"WHERE 1=1\r\n" + 
					"    AND A.REG_DATE  = '20200108'";
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				// Fields
				String registerDate = rs.getString(1);
				String bookIsbn = rs.getString(2);
				String bookId = rs.getString(3);
				String bookName = rs.getString(4);
				String sickCategoryName = rs.getString(5);
				String sickLevelName = rs.getString(6);
				String userId = rs.getString(7);
				String userReportComment = rs.getString(8);

				SickBookListVO dto = new SickBookListVO(registerDate, bookIsbn, bookId, bookName, 
						sickCategoryName, sickLevelName, userId, userReportComment);
				sickBookList.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return sickBookList;
	}
	

	// ���Ŀ� ���� GUI�� ��� ������� SELECT
	public ArrayList<SickBookListVO> getSickBookList(String searchDate, int sickCategoryValue, int sickLevelValue) {
		
		ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
		connect();
		try {
			
			String sql;
			if (sickCategoryValue == 0 && sickLevelValue != 0) {
				sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
						"        , A.ISBN\r\n" + 
						"        , A.BOOK_ID\r\n" + 
						"        , B.BOOK_NAME\r\n" + 
						"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
						"                        WHEN 2 THEN '����'\r\n" + 
						"                        WHEN 3 THEN '����'\r\n" + 
						"                        WHEN 4 THEN '����'\r\n" + 
						"                        WHEN 5 THEN '��Ÿ'\r\n" + 
						"                        ELSE 'Ȯ���ʿ�'\r\n" + 
						"          END   AS SICK_CAT_NAME\r\n" + 
						"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
						"                          WHEN 2 THEN '��'\r\n" + 
						"                          WHEN 3 THEN '��'\r\n" + 
						"          END   AS SICK_LEVEL_NAME\r\n" + 
						"        , A.USER_ID\r\n" + 
						"        , A.PRT_COMMENT\r\n" + 
						"FROM BOOK_SICK      A\r\n" + 
						"LEFT JOIN BOOK_LIST B\r\n" + 
						"ON 1=1\r\n" + 
						"    AND A.ISBN          = B.ISBN\r\n" + 
						"    AND A.BOOK_ID       = B.BOOK_ID\r\n" + 
						"WHERE 1=1\r\n" + 
						"    AND A.REG_DATE      = ?\r\n" + 
						"    AND A.SICK_LEVEL    = ?";
				
				pst = conn.prepareStatement(sql);
				pst.setString(1, searchDate);
				pst.setInt(2, sickLevelValue);
				
			} else if (sickCategoryValue != 0 && sickLevelValue == 0){
				sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
						"        , A.ISBN\r\n" + 
						"        , A.BOOK_ID\r\n" + 
						"        , B.BOOK_NAME\r\n" + 
						"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
						"                        WHEN 2 THEN '����'\r\n" + 
						"                        WHEN 3 THEN '����'\r\n" + 
						"                        WHEN 4 THEN '����'\r\n" + 
						"                        WHEN 5 THEN '��Ÿ'\r\n" + 
						"                        ELSE 'Ȯ���ʿ�'\r\n" + 
						"          END   AS SICK_CAT_NAME\r\n" + 
						"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
						"                          WHEN 2 THEN '��'\r\n" + 
						"                          WHEN 3 THEN '��'\r\n" + 
						"          END   AS SICK_LEVEL_NAME\r\n" + 
						"        , A.USER_ID\r\n" + 
						"        , A.PRT_COMMENT\r\n" + 
						"FROM BOOK_SICK      A\r\n" + 
						"LEFT JOIN BOOK_LIST B\r\n" + 
						"ON 1=1\r\n" + 
						"    AND A.ISBN          = B.ISBN\r\n" + 
						"    AND A.BOOK_ID       = B.BOOK_ID\r\n" + 
						"WHERE 1=1\r\n" + 
						"    AND A.REG_DATE      = ?\r\n" + 
						"    AND A.SICK_CAT      = ?\r\n";		
				
				pst = conn.prepareStatement(sql);
				pst.setString(1, searchDate);
				pst.setInt(2, sickCategoryValue);
				
			} else if (sickCategoryValue == 0 && sickLevelValue == 0) {
				sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
						"        , A.ISBN\r\n" + 
						"        , A.BOOK_ID\r\n" + 
						"        , B.BOOK_NAME\r\n" + 
						"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
						"                        WHEN 2 THEN '����'\r\n" + 
						"                        WHEN 3 THEN '����'\r\n" + 
						"                        WHEN 4 THEN '����'\r\n" + 
						"                        WHEN 5 THEN '��Ÿ'\r\n" + 
						"                        ELSE 'Ȯ���ʿ�'\r\n" + 
						"          END   AS SICK_CAT_NAME\r\n" + 
						"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
						"                          WHEN 2 THEN '��'\r\n" + 
						"                          WHEN 3 THEN '��'\r\n" + 
						"          END   AS SICK_LEVEL_NAME\r\n" + 
						"        , A.USER_ID\r\n" + 
						"        , A.PRT_COMMENT\r\n" + 
						"FROM BOOK_SICK      A\r\n" + 
						"LEFT JOIN BOOK_LIST B\r\n" + 
						"ON 1=1\r\n" + 
						"    AND A.ISBN          = B.ISBN\r\n" + 
						"    AND A.BOOK_ID       = B.BOOK_ID\r\n" + 
						"WHERE 1=1\r\n" + 
						"    AND A.REG_DATE      = ?\r\n"; 	
				
				pst = conn.prepareStatement(sql);
				pst.setString(1, searchDate);
				
			} else {
				sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
						"        , A.ISBN\r\n" + 
						"        , A.BOOK_ID\r\n" + 
						"        , B.BOOK_NAME\r\n" + 
						"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
						"                        WHEN 2 THEN '����'\r\n" + 
						"                        WHEN 3 THEN '����'\r\n" + 
						"                        WHEN 4 THEN '����'\r\n" + 
						"                        WHEN 5 THEN '��Ÿ'\r\n" + 
						"                        ELSE 'Ȯ���ʿ�'\r\n" + 
						"          END   AS SICK_CAT_NAME\r\n" + 
						"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
						"                          WHEN 2 THEN '��'\r\n" + 
						"                          WHEN 3 THEN '��'\r\n" + 
						"          END   AS SICK_LEVEL_NAME\r\n" + 
						"        , A.USER_ID\r\n" + 
						"        , A.PRT_COMMENT\r\n" + 
						"FROM BOOK_SICK      A\r\n" + 
						"LEFT JOIN BOOK_LIST B\r\n" + 
						"ON 1=1\r\n" + 
						"    AND A.ISBN          = B.ISBN\r\n" + 
						"    AND A.BOOK_ID       = B.BOOK_ID\r\n" + 
						"WHERE 1=1\r\n" + 
						"    AND A.REG_DATE      = ?\r\n" + 
						"    AND A.SICK_CAT      = ?\r\n" + 
						"    AND A.SICK_LEVEL    = ?";		
				
				pst = conn.prepareStatement(sql);
				pst.setString(1, searchDate);
				pst.setInt(2, sickCategoryValue);
				pst.setInt(3, sickLevelValue);
			}


			
			System.out.println(searchDate);
			System.out.println(sickCategoryValue);
			System.out.println(sickLevelValue);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				// Fields
				String registerDate = rs.getString(1);
				String bookIsbn = rs.getString(2);
				String bookId = rs.getString(3);
				String bookName = rs.getString(4);
				String sickCategoryName = rs.getString(5);
				String sickLevelName = rs.getString(6);
				String userId = rs.getString(7);
				String userReportComment = rs.getString(8);

				SickBookListVO dto = new SickBookListVO(registerDate, bookIsbn, bookId, bookName, 
						sickCategoryName, sickLevelName, userId, userReportComment);
				sickBookList.add(dto);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return sickBookList;
	}

	

	// ���Ŀ� �����˻�
	// Ư�� ISBN���� �˻�
	public ArrayList<SickBookListVO> getSickBookList(String inputBookIsbn) {
		
		ArrayList<SickBookListVO> sickBookList = new ArrayList<SickBookListVO>();
		connect();
		try {
//				String sql = "SELECT * FROM BOOK_SICK";
			String sql = "SELECT    TO_CHAR(A.REG_DATE, 'YYYY-MM-DD') AS REG_DATE\r\n" + 
					"        , A.ISBN\r\n" + 
					"        , A.BOOK_ID\r\n" + 
					"        , B.BOOK_NAME\r\n" + 
					"        , CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
					"                        WHEN 2 THEN '��Ÿ'\r\n" + 
					"                        WHEN 3 THEN '����'\r\n" + 
					"                        WHEN 4 THEN '����'\r\n" + 
					"                        WHEN 5 THEN '��Ÿ'\r\n" + 
					"                        ELSE 'Ȯ���ʿ�'\r\n" + 
					"          END   AS SICK_CAT_NAME\r\n" + 
					"        , CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
					"                          WHEN 2 THEN '��'\r\n" + 
					"                          WHEN 3 THEN '��'\r\n" + 
					"          END   AS SICK_LEVEL_NAME\r\n" + 
					"        , A.USER_ID\r\n" + 
					"        , A.PRT_COMMENT\r\n" + 
					"FROM BOOK_SICK      A\r\n" + 
					"LEFT JOIN BOOK_LIST B\r\n" + 
					"ON 1=1\r\n" + 
					"    AND A.ISBN          = B.ISBN\r\n" + 
					"    AND A.BOOK_ID       = B.BOOK_ID\r\n" + 
					"WHERE 1=1\r\n" + 
					"    AND A.ISBN			 = ?"; 
					
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, inputBookIsbn);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				// Fields
				String registerDate = rs.getString(1);
				String bookIsbn = rs.getString(2);
				String bookId = rs.getString(3);
				String bookName = rs.getString(4);
				String sickCategoryName = rs.getString(5);
				String sickLevelName = rs.getString(6);
				String userId = rs.getString(7);
				String userReportComment = rs.getString(8);

				SickBookListVO dto = new SickBookListVO(registerDate, bookIsbn, bookId, bookName, 
						sickCategoryName, sickLevelName, userId, userReportComment);
				sickBookList.add(dto);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return sickBookList;
	}
	
	// [���־�]
	public int insertSick(SickBookListVO voSick) {
		connect();

		int cnt = 0;
		String sql = "insert into book_sick values(sysdate,?,?,?,1,?,0,?,?,)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, voSick.getRegisterDate());
			pst.setString(2, voSick.getBookIsbn());
			pst.setString(3, voSick.getBookId());
			pst.setString(4, voSick.getBookName());
			pst.setString(5, voSick.getSickCategoryName());
			pst.setString(6, voSick.getSickLevelName());
			pst.setString(7, voSick.getUserReportComment());

			cnt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

//	// [���־�]
//	// 08.01 ���̵� ������ �Խ��� �ۼ��� �г����� �˾Ƴ��� �޼ҵ�
//	public String getuserID(UserVO voUser) {
//		String name = "";
//		connect();
//		String sql = "SELECT name FROM User_list WHERE id=?";
//		// try �� �ȿ� �ۼ��� �Ǿ� ���� ���� �� ������ �߻��ϸ� ���α׷� �ٿ�
//		// try �� ���� �ۼ��� �Ǿ� ���� ��� ��� ������ ������
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setString(1, .getUserID());
//			rs = pst.executeQuery();
//			if (rs.next()) {
//				name = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			// e.printStackTrace();
//		} finally {
//			close();
//		}
//		return name;
//	}
	
	
	
	// ���� �� �������� ���� ��� ������ ��� ����
	public BookInfoSickBookStatVO querySickBookStat(String inputBookIsbn, int inputBookId) {
		
		BookInfoSickBookStatVO vo = null;

		connect();
		try {
//			String sql = "SELECT * FROM BOOK_SICK";
			String sql = "SELECT A.SICK_CNT, NVL(B.SICK_CAT_NAME,' '), NVL(B.SICK_LEVEL_NAME, ' ')\r\n" + 
					"FROM\r\n" + 
					"(\r\n" + 
					"    SELECT    COUNT(*) AS SICK_CNT\r\n" + 
					"    FROM BOOK_SICK\r\n" + 
					"    WHERE 1=1\r\n" + 
					"        AND ISBN        = ?\r\n" + 
					"        AND BOOK_ID     = ?\r\n" + 
					"        AND REG_DATE    BETWEEN ADD_MONTHS(SYSDATE, -1) AND SYSDATE\r\n" + 
					") A\r\n" + 
					"LEFT JOIN\r\n" + 
					"(\r\n" + 
					"    SELECT CASE SICK_CAT WHEN 1 THEN '����'\r\n" + 
					"                         WHEN 2 THEN '����'\r\n" + 
					"                         WHEN 3 THEN '����'\r\n" + 
					"                         WHEN 4 THEN '����'\r\n" + 
					"                         WHEN 5 THEN '��Ÿ'\r\n" + 
					"            END AS SICK_CAT_NAME,\r\n" + 
					"            CASE SICK_LEVEL WHEN 1 THEN '��'\r\n" + 
					"                            WHEN 2 THEN '��'\r\n" + 
					"                            WHEN 3 THEN '��'\r\n" + 
					"            END AS SICK_LEVEL_NAME\r\n" + 
					"    FROM\r\n" + 
					"    (\r\n" + 
					"        SELECT    SICK_CAT\r\n" + 
					"                , SICK_LEVEL\r\n" + 
					"                , ROW_NUMBER() OVER(ORDER BY REG_DATE DESC) AS ROW_ID\r\n" + 
					"        FROM BOOK_SICK\r\n" + 
					"        WHERE 1=1\r\n" + 
					"            AND ISBN        = ?\r\n" + 
					"            AND BOOK_ID     = ?\r\n" + 
					"    ) A\r\n" + 
					"    WHERE 1=1\r\n" + 
					"        AND ROW_ID = 1\r\n" + 
					") B\r\n" + 
					"ON 1=1";
					
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, inputBookIsbn);
			pst.setInt(2, inputBookId);
			pst.setString(3, inputBookIsbn);
			pst.setInt(4, inputBookId);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				// Fields
				int sickCnt  = rs.getInt(1);
				String sickCategoryName = rs.getString(2);
				String sickLevelName = rs.getString(3);

				vo = new BookInfoSickBookStatVO(sickCnt, sickCategoryName, sickLevelName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;				
	}
}




















