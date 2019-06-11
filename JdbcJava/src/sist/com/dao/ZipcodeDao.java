package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

import sist.com.jdbc.JTableModel;
import sist.com.model.BoardModel;
import sist.com.model.CouponBean;
import sist.com.model.ZipcodeBean;
import sist.service.util.ServiceUtil;

public class ZipcodeDao {
	static JTableModel table;
	
	public static CouponBean couponSS(String id){
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CouponBean cb = new CouponBean();
		try {
			String sql="SELECT ID,NAME FROM SEMICOUPON WHERE ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cb.setId(rs.getNString("id"));
				cb.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return cb;
	}
	
	
//	zipcode	sido	gugu	dong	bunji
/*	public static List<ZipcodeBean>selectZipCode (String dong){
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd; //resultsetÀÌ¸¸µé¾îÁö°í metadata°¡ µé¾î°¡¾ßÇÔ.
		ArrayList<ZipcodeBean>list = new ArrayList<ZipcodeBean>();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ZIPCODE,SIDO,GUGU,DONG,NVL(BUNJI,' ')BUNJI FROM ZIPCODE WHERE DONG LIKE '%' || ? || '%'");
		//.append("FROM ZIPCODE")
		//.append("WHERE DONG LIKE '%' || ? || '%'");
		try {
			pstmt=con.prepareStatement(sb.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
			rsmd=rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			//System.out.println(rs.first());
			while(rs.next()) {
				ZipcodeBean zipCodeBean = new ZipcodeBean();
				zipCodeBean.setZipcode(rs.getString(1));
				zipCodeBean.setSido(rs.getString(2));
				zipCodeBean.setGugu(rs.getString(3));
				zipCodeBean.setDong(rs.getString(4));
				zipCodeBean.setBunji(rs.getString(5));
				list.add(zipCodeBean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}*/
	
	public static boolean idCheckBoolean(String id) {
		boolean state = false;
		Connection con=ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;//¿î¹Ý°´Ã¼
		ResultSet rs=null;
		try {
			String sql = "SELECT ID FROM SEMICOUPON WHERE ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}
	
	
	public static String getSeq(int row) {
		return (String)table.getValueAt(row, 0);
	}
	public static CouponBean selectBean(String no) {
		Connection con=ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;//¿î¹Ý°´Ã¼
		ResultSet rs=null;
		CouponBean couponBean=new CouponBean();
		try {
			String sql="SELECT NO,ID,NAME,COUPON,PRICE FROM SEMICOUPON WHERE NO=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				couponBean.setNo(rs.getInt(1));
				couponBean.setId(rs.getString(2));
				couponBean.setName(rs.getString(3));
				couponBean.setCoupon(rs.getString(4));
				couponBean.setPrice(rs.getInt(5));
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return couponBean;
	}
	
	public static void selectZipCode(String id,JTable jtable){
		Connection con=ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;//¿î¹Ý°´Ã¼
		Object[][]data=null;
		StringBuffer sb=new StringBuffer();
		ResultSet rs=null;
		ResultSetMetaData rsmd;
		String []col;
		String sql=("SELECT NO,ID,NAME,COUPON,PRICE FROM SEMICOUPON WHERE ID LIKE '%' || ? || '%' ");
		try {
			//pstmt=con.prepareStatement(sb.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rsmd=rs.getMetaData();
			rs.last(); 
			data=new Object[rs.getRow()][rsmd.getColumnCount()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					data[i][j]=rs.getString(j+1);
				}
				i++;
			}
			col=new String[rsmd.getColumnCount()];
			for (int j = 0; j < col.length; j++) {
				col[j]=rsmd.getColumnName(j+1);
			}
			table=new JTableModel(data);
			table.setColName(col);
			jtable.setModel(table);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	

}





