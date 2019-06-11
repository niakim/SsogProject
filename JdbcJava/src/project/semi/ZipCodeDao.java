package project.semi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;

import sist.service.util.ServiceUtil;

public class ZipCodeDao {
	public static void searchZipCode(String addr, JTable jtb) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Object[][] data = null;
		ResultSetMetaData rsmd;
		String[] col;

		try {
			String sql = "SELECT SEQ, ZIPCODE, SIDO, SIGUNGU, DORO FROM ZIP WHERE DORO LIKE '%' || ? || '%'";
			pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pst.setString(1, addr);
			rs = pst.executeQuery();
			rsmd = rs.getMetaData();
			rs.last();

			data = new Object[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();

			int i = 0;
			while (rs.next()) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					data[i][j] = rs.getString(j + 1);
				}
				i++;
			}

			col = new String[rsmd.getColumnCount()];
			for (int j = 0; j < col.length; j++) {
				col[j] = rsmd.getColumnName(j + 1);
			}

			JTableModel table = new JTableModel(data);
			table.setColName(col);
			jtb.setModel(table);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static ZipCodeBean selectBean(String seq) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ZipCodeBean bean = new ZipCodeBean();

		try {
			String sql = "SELECT ZIPCODE, SIDO, SIGUNGU, DORO FROM ZIP WHERE SEQ = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(seq));
			rs = pst.executeQuery();

			if (rs.next()) {
				bean.setZipcode(rs.getString(1));
				bean.setSido(rs.getString(2));
				bean.setSigungu(rs.getString(3));
				bean.setDoro(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return bean;
	}
}
