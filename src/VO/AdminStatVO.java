package VO;

public class AdminStatVO {
	private String boook_name;
	private String author;
	private String publisher;
	private String ISBN;
	private int bookId;
	private int bookSeries;
	private int borrowed_booknum;
	private String issueDate;
	private String classNum;
	private String registration_date;
	public AdminStatVO(String boook_name, String author, String publisher, String iSBN, int bookId, int bookSeries,
			int borrowed_booknum, String issueDate, String classNum, String registration_date) {
		super();
		this.boook_name = boook_name;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookId = bookId;
		this.bookSeries = bookSeries;
		this.borrowed_booknum = borrowed_booknum;
		this.issueDate = issueDate;
		this.classNum = classNum;
		this.registration_date = registration_date;
	}
	
	
	public AdminStatVO(String boook_name, String author, int borrowed_booknum) {
		super();
		this.boook_name = boook_name;
		this.author = author;
		this.borrowed_booknum = borrowed_booknum;
	}


	public AdminStatVO(int borrowed_booknum) {
		super();
		this.borrowed_booknum = borrowed_booknum;
	}


	public String getboook_name() {
		return boook_name;
	}
	public void setboook_name(String boook_name) {
		this.boook_name = boook_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookSeries() {
		return bookSeries;
	}
	public void setBookSeries(int bookSeries) {
		this.bookSeries = bookSeries;
	}
	public int getborrowed_booknum() {
		return borrowed_booknum;
	}
	public void setborrowed_booknum(int borrowed_booknum) {
		this.borrowed_booknum = borrowed_booknum;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

}
