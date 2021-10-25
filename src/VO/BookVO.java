package VO;

import DAO.BookDAO;

public class BookVO {
	private String bookName;
	private String author;
	private String publisher;
	private String ISBN;
	private int bookID;
	private int bookSeries;
	private int borrowed;
	private String issueDate;
	private String classNum;
	private String RegistrationDay;
	
	public BookVO(String bookName, String author, String publisher, String iSBN, int bookID, int bookSeries,
			int borrowed, String issueDate, String classNum, String registrationDay) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookID = bookID;
		this.bookSeries = bookSeries;
		this.borrowed = borrowed;
		this.issueDate = issueDate;
		this.classNum = classNum;
		RegistrationDay = registrationDay;
	}
	
	public BookVO(String bookName, String author, String publisher, String iSBN, int bookID,
			int borrowed, String issueDate, String classNum, String registrationDay) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookID = bookID;
		this.borrowed = borrowed;
		this.issueDate = issueDate;
		this.classNum = classNum;
		RegistrationDay = registrationDay;
	}
	
	public BookVO(String bookName, String author, String publisher, String iSBN, int bookID,
			String registrationDay) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookID = bookID;
		RegistrationDay = registrationDay;
	}
	
	public BookVO(String bookName, String author, String publisher, String iSBN, int bookSeries,
			String issueDate, String classNum) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookSeries = bookSeries;
		this.issueDate = issueDate;
		this.classNum = classNum;
	}

	public BookVO(String bookName, String author, String publisher, String iSBN, int bookSeries, int borrowed,
			String issueDate, String classNum) {
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.bookSeries = bookSeries;
		this.borrowed = borrowed;
		this.issueDate = issueDate;
		this.classNum = classNum;
		
	}

	public BookVO(String bookName, String author, String publisher, String iSBN, String classNum) {
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		ISBN = iSBN;
		this.classNum = classNum;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getBookID() {
		return bookID;
	}

	public int getBookSeries() {
		return bookSeries;
	}

	public int getBorrowed() {
		return borrowed;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String getClassNum() {
		return classNum;
	}

	public String getRegistrationDay() {
		return RegistrationDay;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public void setBookSeries(int bookSeries) {
		this.bookSeries = bookSeries;
	}

	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public void setRegistrationDay(String registrationDay) {
		RegistrationDay = registrationDay;
	}

	@Override
	public String toString() {
		return "BookVO [bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + ", ISBN=" + ISBN
				+ ", bookID=" + bookID + ", bookSeries=" + bookSeries + ", borrowed=" + borrowed + ", issueDate="
				+ issueDate + ", classNum=" + classNum + ", RegistrationDay=" + RegistrationDay + "]";
	}
	
}
