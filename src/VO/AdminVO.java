package VO;

public class AdminVO {

	// Fields - Member variables declaration
	private String userName;
	private String userId;
	private String userPw;
	private String userBirthDate;
	private String userPhone;
	
	
	// Constructors
	public AdminVO(String userName, String userId, String userPw, String userBirthDate, String userPhone) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userBirthDate = userBirthDate;
		this.userPhone = userPhone;
	}
	

	// Getters and Setters Methods
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserBirthDate() {
		return userBirthDate;
	}


	public void setUserBirthDate(String userBirthDate) {
		this.userBirthDate = userBirthDate;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
