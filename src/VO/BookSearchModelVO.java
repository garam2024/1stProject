package VO;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.BookDAO;

public class BookSearchModelVO extends AbstractTableModel {
	private String[] columnNames = {
			"책 이름", "저자", "출판사", "ISBN","책 시리즈","발행일자","분류번호"};
	private ArrayList<BookVO> datas;
	
	public BookSearchModelVO(String strName) {
		BookDAO dao = new BookDAO();
		datas = dao.searchBook(strName);
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	public int getRowCount() {
		return datas.size();
	}
	
	public int getColumnCount() {
		return 7;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result= "";
		BookVO vo = datas.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			result = vo.getBookName();
			break;
		case 1:
			result = vo.getAuthor();
			break;
		case 2:
			result = vo.getPublisher();
			break;
		case 3:
			result = vo.getISBN();
			break;
		case 4:
			result = Integer.toString(vo.getBookSeries());
			break;
		case 5:
			result = vo.getIssueDate();
			break;
		case 6:
			result = vo.getClassNum();
			break;
		}
		return result;
	}

//	@Override
//	public void addTableModelListener(TableModelListener l) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void removeTableModelListener(TableModelListener l) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		
//	}
}
