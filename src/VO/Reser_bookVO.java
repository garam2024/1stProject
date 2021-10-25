package VO;

import java.util.Date;

public class Reser_bookVO {
	private String  RESERV_CODE;
	private String USER_ID;
	private Date RESERV_DATE;
	private String ISBN;
	private int BOOK_ID;
	
	public Reser_bookVO(String RESERV_CODE, String USER_ID, Date RESERV_DATE, String ISBN,
			int BOOK_ID) {
		super();
		this.RESERV_CODE = RESERV_CODE;
		this.USER_ID = USER_ID;
		this.RESERV_DATE = RESERV_DATE;
		this.ISBN = ISBN;
		this.BOOK_ID = BOOK_ID;
		
		
	}

	public String getRESERV_CODE() {
		return RESERV_CODE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public Date getRESERV_DATE() {
		return RESERV_DATE;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}
	
	
}