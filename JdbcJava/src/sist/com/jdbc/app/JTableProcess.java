package sist.com.jdbc.app;

import javax.swing.table.AbstractTableModel;

public class JTableProcess  extends AbstractTableModel{
	
	private Object[][]data;
	private String []colName;	
     
	public JTableProcess() {
		super();
	}

	public JTableProcess(Object[][] data) {
		super();
		this.data = data;
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
		data[rowIndex][columnIndex]=aValue;
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
