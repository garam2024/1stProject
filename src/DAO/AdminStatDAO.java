package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import VO.AdminStatVO;

public class AdminStatDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	AdminStatVO dto = null;
	
	
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
	public ArrayList<AdminStatVO> selectAllBoorrowed() {

		//����Ǽ� ������� ����� ���⵵������� ����ϴ�.
		ArrayList<AdminStatVO> BookBorrowed = new ArrayList<AdminStatVO>();
		try {
			connect();
			String sql = "SELECT book_name,author,borrowed_booknum FROM BOOK_LIST order by BORROWED_BOOKNUM DESC";
			// 3. sql ���� �غ� ��ü(preparedStatement) ����
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				String boook_name = rs.getString(1);
				String author = rs.getString(2);
				int borrowed_booknum = rs.getInt(3);

				AdminStatVO dto = new AdminStatVO(boook_name, author, borrowed_booknum);
				BookBorrowed.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(BookBorrowed);
		return BookBorrowed;

	}

//
//
//	// ����� ���൵�� ����� ���� ����
//	public ArrayList<ReservStatDTO> selectAllReserv() {
//
//		// ����Ǽ� ������� ����� ���⵵������� ����ϴ�.
//		ArrayList<ReservStatDTO> Bookreserv = new ArrayList<ReservStatDTO>();
//		try {connect();
//			// 1. jdbc ����̹� �����ε�
//			
//
//			String sql = "select count(isbn) as cnt, isbn from reservation_list group by isbn having count (isbn)>1 order by cnt DESC";
//			// 3. sql ���� �غ� ��ü(preparedStatement) ����
//			pst = conn.prepareStatement(sql);
//
//			rs = pst.executeQuery();
//
//			while (rs.next()) {
//				String ISBN = rs.getString(1);
//				int cnt = rs.getInt(2);
//
//				ReservStatDTO dto = new ReservStatDTO(ISBN, cnt);
//				Bookreserv.add(dto);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//
//		return Bookreserv;
//
//	}
	
	
	// �α⵵�����
	public ArrayList<AdminStatVO> selectBestsellers() {

		// ���⵵�� �������� ���� 10�� �����͸� �����Ͽ� ����� ����ϴ�.
		ArrayList<AdminStatVO> Bestsellers = new ArrayList<AdminStatVO>();
		try {connect();
			

			String sql = " select book_name, author, borrowed_booknum from (select * from BOOK_LIST order by BORROWED_BOOKNUM desc) where rownum<=10";
			// 3. sql ���� �غ� ��ü(preparedStatement) ����
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				String boook_name = rs.getString(1);
				String author = rs.getString(2);
				int borrowed_booknum = rs.getInt(3);

				AdminStatVO dto = new AdminStatVO(boook_name, author, borrowed_booknum);
				Bestsellers.add(dto);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return Bestsellers;

	}

	private void close() {
		try {
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
