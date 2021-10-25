package VO;

public class SickBookListVO {
	
	// Fields
	private String registerDate;
	private String bookIsbn;
	private String bookId;
	private String bookName;
	private String sickCategoryName;
	private String sickLevelName;
	private String userId;
	private String userReportComment;
	
	// Constructors
	public SickBookListVO(String registerDate, String bookIsbn, String bookId, String bookName,
			String sickCategoryName, String sickLevelName, String userId, String userReportComment) {
		super();
		this.registerDate = registerDate;
		this.bookIsbn = bookIsbn;
		this.bookId = bookId;
		this.bookName = bookName;
		this.sickCategoryName = sickCategoryName;
		this.sickLevelName = sickLevelName;
		this.userId = userId;
		this.userReportComment = userReportComment;
	}

	// Getters and Setters
	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSickCategoryName() {
		return sickCategoryName;
	}

	public void setSickCategoryName(String sickCategoryName) {
		this.sickCategoryName = sickCategoryName;
	}

	public String getSickLevelName() {
		return sickLevelName;
	}

	public void setSickLevelName(String sickLevelName) {
		this.sickLevelName = sickLevelName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserReportComment() {
		return userReportComment;
	}

	public void setUserReportComment(String userReportComment) {
		this.userReportComment = userReportComment;
	}		

}
