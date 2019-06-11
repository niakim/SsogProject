package project.semi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sist.service.util.ServiceUtil;

public class SsgDao {

	private static SsgDao dao;

	public static SsgDao getInstance() {
		if (dao == null) {
			dao = new SsgDao();
		}
		return dao;
	}

	public static void modifyPass(String pass2, String pass, String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "UPDATE MEMBER SET PW=? WHERE ID=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass2);
			pstmt.setString(2, id);

			rs = pstmt.executeQuery();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public boolean checkPass(String pass2, String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID FROM MEMBER WHERE PW=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass2);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("id").equals(id)) {
					return true;
				}
				return false;
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

	public SsgBean searchId(String name, String phone) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, NAME, CNUMBER, PW FROM MEMBER WHERE NAME=? AND CNUMBER=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				SsgBean bean = new SsgBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("CNUMBER"));
				bean.setPass(rs.getString("PW"));
				return bean;
			} else {
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
	}

	public boolean mateName(String name) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, NAME, CNUMBER FROM MEMBER WHERE NAME=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("name").equals(name)) {
					return true;
				}
				return false;
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

	public boolean matePhone(String name, String phone) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, NAME, CNUMBER FROM MEMBER WHERE NAME=? AND CNUMBER=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("CNUMBER").equals(phone)) {
					searchId(name, phone);
					return true;
				}
				return false;
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

	public boolean mateID(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, NAME, CNUMBER FROM MEMBER WHERE ID=? AND STATE = '가입'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("id").equals(id)) {
					return true;
				}
				return false;
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;
	}

}
