package project.semi.nk;

import javax.swing.table.AbstractTableModel;

public class nkJTableModel extends AbstractTableModel {
	private Object[][] data;
	// private String []colName=
	// {"EMPNO","ENAME","JOB","MGR","HIREDATE","SAL","COMM","DEPTNO"};
	private String[] colName = { "NO", "ID", "COUPON", "COUPONNID", "PRICE" }; // zipcode
	// "NO","ID","COUPON","PRICE"
	// NO ID NAME COUPONNID COUPON PRICE GIVENDATE

	public nkJTableModel() {
		super();
	}

	public nkJTableModel(Object[][] data) {
		super();
		this.data = data;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String[] getColName() {
		return colName;
	}

	public void setColName(String[] colName) {
		this.colName = colName;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colName[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data[rowIndex][columnIndex] = aValue;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

}
