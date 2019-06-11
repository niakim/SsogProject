package project.semi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import sist.service.util.ServiceUtil;

public class ProductDao {

	public static List<ProductModel> Prolist(String s) {
		Connection con = ServiceUtil.getConnection();// ���ᰴü
		PreparedStatement pstmt = null;// ��ݰ�ü
		ResultSet rs = null;
		Vector<ProductModel> vector = new Vector<ProductModel>();
		String sql = "SELECT NAME,PRICE,CNAME FROM SSG WHERE NO LIKE ?||'%'";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();

			for (; rs.next();) {
				ProductModel m = new ProductModel();
				m.setNAME(rs.getString("NAME"));
				m.setPRICE(rs.getString("PRICE"));
				m.setCNAME(rs.getString("CNAME"));

				vector.add(m);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return vector;
	}

	public static String Prolistno(String s, int a) {
		Connection con = ServiceUtil.getConnection();// ���ᰴü
		PreparedStatement pstmt = null;// ��ݰ�ü
		ResultSet rs = null;
		String no = "";
		String sql = "SELECT NO from SSG WHERE NO LIKE ?||'%'|| LPAD(?,3,0)";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s);
			pstmt.setInt(2, a);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				no = rs.getString("no");
				System.out.println(no);
				return no;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return no;
	}

	public static int[] setSubImgArray(String tabStr) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int[] tmp = new int[12];

		String sql = "SELECT SUBIMG FROM SSG WHERE NO LIKE ? || '%'";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, tabStr);
			rs = pst.executeQuery();

			int i = 0;
			while (rs.next()) {
				tmp[i++] = Integer.parseInt(rs.getString(1));
			}
			return tmp;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
		return tmp;
	}

}