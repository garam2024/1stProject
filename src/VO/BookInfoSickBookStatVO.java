package VO;

public class BookInfoSickBookStatVO {

	private int sickCnt;
	private String sickCategoryName;
	private String sickLevelName;
	
	public BookInfoSickBookStatVO(int sickCnt, String sickCategoryName, String sickLevelName) {
		
		super();
		this.sickCnt = sickCnt;
		this.sickCategoryName = sickCategoryName;
		this.sickLevelName = sickLevelName;
		
	}

	public int getSickCnt() {
		return sickCnt;
	}

	public void setSickCnt(int sickCnt) {
		this.sickCnt = sickCnt;
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

}
