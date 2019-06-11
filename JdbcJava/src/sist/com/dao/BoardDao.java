package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import sist.com.model.BoardModel;
import sist.service.util.ServiceUtil;

public class BoardDao {
	
	public static void addBoard(BoardModel boModel) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;//¿î¹Ý°´Ã¼
		String sql="INSERT INTO SIBOARD(NO,TITLE,WRITER,CONTENTS,PASSWORD,"
				+ "HIT,REGDATE) VALUES (BOARD_SEQ.NEXTVAL,?,?,?,?,0,SYSDATE)";
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, boModel.getTitle());
			pstmt.setString(2, boModel.getWriter());
			pstmt.setString(3, boModel.getContents());
			pstmt.setString(4, boModel.getPassword());
			pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	public static List<BoardModel> listBoard(HashMap<String, Object>map){
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector<BoardModel>vector = new Vector<BoardModel>();
		String key = null;
		
		
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT NO,TITLE,WRITER,CONTENTS,PASSWORD,HIT,TO_CHAR(REGDATE,'YYYY/MM/DD')REGDATE FROM SIBOARD");
			//.append("FROM SIBOARD");
			
			if(map!=null) {
				key=map.entrySet().iterator().next().getKey().toString();
				sb.append("WHERE "+key+"LIKE '%'||?||'%' ");
			}
			
			pstmt=con.prepareStatement(sb.toString());
			if(map!=null) {
			pstmt.setString(1, map.get(key).toString());}
			
			
			rs=pstmt.executeQuery();
			for(;rs.next();) {
				BoardModel m=new BoardModel();
				m.setNo(rs.getInt("NO"));
				m.setTitle(rs.getString("TITLE"));
				m.setWriter(rs.getString("WRITER").concat("´Ô"));
				m.setContents(rs.getString("CONTENTS"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setHit(rs.getInt("HIT"));
				m.setRegdate(rs.getString("REGDATE"));
				vector.add(m);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return vector;
	}
	
	
	public static BoardModel InfoBoard(String title) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		String sql = "SELECT * FROM SIBOARD WHERE TITLE=?";
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				BoardModel m=new BoardModel();
				m.setNo(rs.getInt("NO"));
				m.setTitle(rs.getString("TITLE"));
				m.setWriter(rs.getString("WRITER"));
				m.setContents(rs.getString("CONTENTS"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setHit(rs.getInt("HIT"));
				m.setRegdate(rs.getString("REGDATE"));
				return m;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static int deleteBoard(String title) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		int rs=0;
			String sql = "DELETE FROM SIBOARD WHERE TITLE=?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, title);
				rs=pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
	}
	
	
	
	
	
	public static Integer getNumber(String title) { //info¸¦ no·Î Ã£À»¶§
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql = "SELECT NO FROM SIBOARD WHERE TITLE=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("no");
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
		
		return -1;
	}
	public static BoardModel selectInfo(int no) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardModel m=new BoardModel();
		try {
			String sql = "SELECT * FROM SIBOARD WHERE NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m.setNo(rs.getInt("NO"));
				m.setTitle(rs.getString("TITLE"));
				m.setWriter(rs.getString("WRITER").concat("´Ô"));
				m.setContents(rs.getString("CONTENTS"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setHit(rs.getInt("HIT"));
				m.setRegdate(rs.getString("REGDATE"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
	}
		return m;
	}
	
	public static void updateHit(int no) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		try {
			String sql = "UPDATE SIBOARD SET HIT = HIT+1 WHERE NO=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.execute();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
/*	m.setNo(rs.getInt("NO"));
	m.setTitle(rs.getString("TITLE"));
	m.setWriter(rs.getString("WRITER").concat("´Ô"));
	m.setContents(rs.getString("CONTENTS"));
	m.setPassword(rs.getString("PASSWORD"));
	m.setHit(rs.getInt("HIT"));
	m.setRegdate(rs.getString("REGDATE"));*/

	public static int modifyBoard(BoardModel board) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt=null;
		int rs=0;
		try {
			String sql = "UPDATE SIBOARD SET CONTENTS=?,PASSWORD=? WHERE TITLE=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getContents());
			pstmt.setString(2, board.getPassword());
			pstmt.setString(3, board.getTitle());
			rs=pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
		
	
		
	}
	
	
	
	
	
}
