package VO;

public class UserInfoChangeVO {
	private String USER_ID;
	private String USER_NAME;
	private String USER_PW;
	private String USER_PHONE;
	private int USER_POINT;
	private String USER_BIRTH_DATE;
	
	
	public UserInfoChangeVO(String USER_NAME, String USER_ID, String USER_PW, String USER_PHONE, int USER_POINT,
			String USER_BIRTH_DATE) {
		super();
		this.USER_ID = USER_ID;
		this.USER_NAME = USER_NAME;
		this.USER_PW = USER_PW;
		this.USER_PHONE = USER_PHONE;
		this.USER_POINT = USER_POINT;
		this.USER_BIRTH_DATE = USER_BIRTH_DATE;
	}



	public String getUSER_ID(String string) {
		return USER_ID;
	}

	public String getUSER_NAME(String string) {
		return USER_NAME;
	}


	public String getUSER_PW() {
		return USER_PW;
	}


	public String getUSER_PHONE(String string) {
		return USER_PHONE;
	}


	public int getUSER_POINT(String string) {
		return USER_POINT;
	}


	public String getUSER_BIRTH_DATE(String string) {
		return USER_BIRTH_DATE;
	}


	public String getUSER_PW(String string) {
		
		return USER_PW;
	}
	
}
