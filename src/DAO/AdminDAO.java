package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import VO.UserVO;

import java.sql.PreparedStatement;


/*
 * ===================================================
 * 	USER_LIST TABLE ���� DAO(Data Access Object)
 * [�뵵]
 * 1. �̿��� ȸ������
 * 
 * --------------------------------------------------
 * [����]
 * 1st by �Ǽ���
 * 	- �����ۼ�, 2021.01.08.
 * ===================================================
 * 
 */


public class AdminDAO {

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
	

	// �α����� �������� Ȯ���ϴ� Method (���̵�, ��й�ȣ ��ġ���� Ȯ��) Method
	public boolean isAdminLoginValid(String adminID, String adminPw) {
		
		boolean isValidLogin = false;
		int idCnt = 0;
		connect();			// DB Connetion
		
		String sql =  "SELECT COUNT(ADMIN_ID) AS ID_CNT "
					+ "FROM ADMIN_LIST "
					+ "WHERE 1=1 AND LOWER(ADMIN_ID) = LOWER(?)"
					+ "	AND ADMIN_PW = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, adminID);
			pst.setString(2, adminPw);
			
			rs = pst.executeQuery();
			
			rs.next();
			idCnt = rs.getInt(1);
					
			isValidLogin = (idCnt == 0) ? false : true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isValidLogin;		
	}
	
}



