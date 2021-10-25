package VO;

import java.util.Date;

public class SickReviewVO {
	private Date REG_DATE;
	private String USER_ID;
	private int BOOK_ID;
	private int SICK_LEVEL;
	private String PRT_COMMENT;
	
	public SickReviewVO(Date REG_DATE, String USER_ID, int BOOK_ID, int SICK_LEVEL, String PRT_COMMENT) {
		super();
		this.REG_DATE = REG_DATE;
		this.USER_ID = USER_ID;
		this.BOOK_ID = BOOK_ID;
		this.SICK_LEVEL = SICK_LEVEL;
		this.PRT_COMMENT = PRT_COMMENT;
	}

	
	public Date getREG_DATE() {
		return REG_DATE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public int getSICK_LEVEL() {
		return SICK_LEVEL;
	}

	public String getPRT_COMMENT() {
		return PRT_COMMENT;
	}

	
	

}
	