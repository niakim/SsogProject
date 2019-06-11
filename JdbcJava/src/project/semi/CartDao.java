package project.semi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sist.service.util.ServiceUtil;

public class CartDao {

	private static CartDao cartDao;

	public static CartDao getInstance() {
		if (cartDao == null)
			cartDao = new CartDao();
		return cartDao;
	}

	public void addCart(CartBean bean) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO CARTLIST VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getCimg());
			pstmt.setString(2, bean.getCname());
			pstmt.setInt(3, bean.getCcount());
			pstmt.setInt(4, bean.getCpoint());
			pstmt.setInt(5, bean.getCdanga());
			pstmt.setInt(6, bean.getCsum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void modifyCart(CartBean bean) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "UPDATE CARTLIST SET CCOUNT=?, CPOINT=?, CSUM=? WHERE CNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getCcount());
			pstmt.setInt(2, bean.getCpoint());
			pstmt.setInt(3, bean.getCsum());
			pstmt.setString(4, bean.getCname());
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

	public static CartBean selectCart(String cname) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartBean bean = new CartBean(cname);
		try {
			String sql = "SELECT CIMG, CNAME, CCOUNT, CPOINT, CSUM FROM CARTLIST WHERE CNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setCimg(rs.getString("cimg"));
				System.out.println(rs.getString("cimg"));
				bean.setCname(rs.getString("cname"));
				System.out.println(rs.getString("cname"));
				bean.setCcount(rs.getInt("ccount"));
				System.out.println(rs.getInt("ccount"));
				bean.setCpoint(rs.getInt("cpoint"));
				System.out.println(rs.getInt("cpoint"));
				bean.setCsum(rs.getInt("csum"));
				System.out.println(rs.getInt("csum"));
			}
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
			}
		}
		return bean;
	}

	/*
	 * public void deleteCart(String cname) { Connection con =
	 * ServiceUtil.getConnection(); PreparedStatement pstmt= null; ResultSet
	 * rs=null;
	 * 
	 * String sql="DELETE FROM CARTLIST WHERE CNAME=?"; try {
	 * pstmt=con.prepareStatement(sql); pstmt.setString(1, cname);
	 * rs=pstmt.executeQuery(); con.commit(); } catch (Exception e) { // TODO:
	 * handle exception e.printStackTrace(); } finally { try { if(con!=null)
	 * con.close(); if(pstmt!=null)pstmt.close(); } catch (Exception e2) { // TODO:
	 * handle exception e2.printStackTrace(); } }
	 * 
	 * }
	 */

	public void deleteCart() {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "DELETE CARTLIST";
		try {
			pstmt = con.prepareStatement(sql);
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

	public void insertCart() {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO CARTLIST(CNAME) VALUES('관리용')";

		try {
			pstmt = con.prepareStatement(sql);
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

	public List<CartBean> listMember() {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<CartBean> list = new ArrayList<CartBean>();
		String sql = "SELECT CIMG, CNAME, CCOUNT, CDANGA, CSUM FROM CARTLIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartBean bean = new CartBean();
				bean.setCimg(rs.getString("cimg"));
				bean.setCname(rs.getString("cname"));
				bean.setCcount(rs.getInt("ccount"));
				bean.setCdanga(rs.getInt("cdanga"));
				bean.setCsum(rs.getInt("csum"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
