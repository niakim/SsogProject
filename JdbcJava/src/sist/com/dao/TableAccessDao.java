package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import sist.com.jdbc.app.JTableProcess;
import sist.com.jdbc.app.JdbcProcessEx1;
import sist.service.util.ServiceUtil;

public class TableAccessDao {

	public static void selectAccess(JdbcProcessEx1 pr, String sql) {
		
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		int row, col;
		Object[][] data;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			rs.last();
			row = rs.getRow();
			rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			data = new Object[row][col];
			int i = 0;
			rs.beforeFirst();
			while (rs.next()) {
				for (int j = 0; j < col; j++) {
                     data[i][j]=rs.getString(j+1);
				}
				i++;
			}
			JTableProcess JTableProcess=new JTableProcess(data);
			String []colName=new String[col];
			for (int j = 0; j < colName.length; j++) {
				colName[j]=rsmd.getColumnName(j+1);
			}
			JTableProcess.setColName(colName);
			pr.getJtable().setModel(JTableProcess);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
