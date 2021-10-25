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

public class UserDAO {

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

		} catch (Exception e) {

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// checkDuplicatedID
	// ���̵� �ߺ� ���� Ȯ�� Method
	public boolean checkDuplicateId(String userId) {

		boolean isDuplicate = false;
		int idCnt = 0;
		connect(); // DB Connetion

		String sql = "SELECT COUNT(USER_ID) AS ID_CNT " + "FROM USER_LIST " + "WHERE LOWER(USER_ID) = LOWER(?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);

			rs = pst.executeQuery();

			rs.next();
			idCnt = rs.getInt(1);

			System.out.println(userId);
			System.out.println(idCnt);

			isDuplicate = (idCnt == 0) ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDuplicate;
	}

	// �α����� �������� Ȯ���ϴ� Method (���̵�, ��й�ȣ ��ġ���� Ȯ��) Method
	public boolean isUserLoginValid(String userId, String userPw) {

		boolean isValidLogin = false;
		int idCnt = 0;
		connect(); // DB Connetion

		String sql = "SELECT COUNT(USER_ID) AS ID_CNT " + "FROM USER_LIST " + "WHERE 1=1 AND LOWER(USER_ID) = LOWER(?)"
				+ "	AND USER_PW = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			pst.setString(2, userPw);

			rs = pst.executeQuery();

			rs.next();
			idCnt = rs.getInt(1);

			isValidLogin = (idCnt == 0) ? false : true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isValidLogin;
	}

	// Create User Account Method
	public int createUserAccount(UserVO dto) {

		int cnt = 0;
		connect();

		String sql = "INSERT INTO USER_LIST"
				+ "(USER_NAME	, USER_ID	, USER_PW	, USER_BIRTH_DATE	, USER_PHONE	, USER_POINT)" + "VALUES"
				+ "(?			, ?			, ?			, ?					, ?				, 0)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, dto.getUserName());
			pst.setString(2, dto.getUserId());
			pst.setString(3, dto.getUserPw());
			pst.setString(4, dto.getUserBirthDate());
			pst.setString(5, dto.getUserPhone());

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// User Login Method
	public void loginUserAccount() {

	}
}
