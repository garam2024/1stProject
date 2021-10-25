package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import VO.JoinchangeVO;

public class JoinchangeDAO {

	private static final String ID = null;
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

	public int Joinchange (JoinchangeVO vo) {
		
		JoinchangeVO vo1 = new JoinchangeVO(null, null, null, null, 0, null);

		connect();
		int cnt = 0;

		String sql = "update USER_LIST set USER_NAME=?,USER_PW=?,USER_PHONE=?,USER_BIRTH_DATE=?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getUSER_NAME("name"));
			//pst.setString(2, vo.getUSER_ID("id"));
			pst.setString(2, vo.getUSER_PW("pw"));
			pst.setString(3, vo.getUSER_PHONE("phone"));
			pst.setString(4, vo.getUSER_BIRTH_DATE("birthday_date"));

			cnt = pst.executeUpdate();
//			rs = pst.executeQuery();
//
//			
//			while (rs.next()) {
//				String USER_ID = rs.getString("ID");
//				String USER_NAME= rs.getString("NAME");
//				String USER_PW= rs.getString("PW");
//				String USER_PHONE= rs.getString("PHONE");
//				int USER_POINT= rs.getInt("POINT");
//				String USER_BIRTH_DATE= rs.getString("BIRTH_DATE");;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

}