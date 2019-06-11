package project.semi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import sist.service.util.ServiceUtil;

public class proDao {

	public static void uppro(String title, String text, String PW, String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;// 운반객체
		String sql = "INSERT INTO QNATABLE(NO,PW,TEXT,TITLE,DATE1,HIT,ID) VALUES(qna.NEXTVAL,?,?,?,SYSDATE,0,?)";
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, PW);
			pstmt.setString(2, text);
			pstmt.setString(3, title);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			con.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static List<proModel> listBoard(String id) {
		Connection con = ServiceUtil.getConnection();// 연결객체
		PreparedStatement pstmt = null;// 운반객체
		ResultSet rs = null;
		Vector<proModel> vector = new Vector<proModel>();

		String sql = "SELECT NO, ID,TEXT, TITLE, DATE1,pw, HIT FROM QNATABLE WHERE ID=? ORDER BY NO ASC";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			for (; rs.next();) {
				proModel m = new proModel();
				m.setNo(rs.getInt("no"));
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setText(rs.getString("TEXT"));
				m.setDate1("         ".concat(rs.getString("DATE1")));
				m.setHit(rs.getInt("HIT"));

				if (rs.getString("TITLE").equals("기타") || rs.getString("TITLE").equals("상품")
						|| rs.getString("TITLE").equals("배송")) {
					m.setTitle(rs.getString("TITLE").concat("        "));

				} else {

					m.setTitle(rs.getString("TITLE"));
				}

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

	public static List<ReviewModel> listreview(String no) {
		Connection con = ServiceUtil.getConnection();// 연결객체
		PreparedStatement pstmt = null;// 운반객체
		ResultSet rs = null;
		Vector<ReviewModel> vector = new Vector<ReviewModel>();
		String sql = "SELECT REVIEW,TITLE,CONTANCS,date1 FROM QNATABLE1 WHERE NO=? ORDER BY date1";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			for (; rs.next();) {

				ReviewModel m = new ReviewModel();
				m.setReview(rs.getString("REVIEW"));
				m.setTitle(rs.getString("title"));
				m.setContancs(rs.getString("CONTANCS"));
				m.setDate1(rs.getString("date1"));

				/*
				 * if(rs.getString("TITLE").equals("기타")||rs.getString("TITLE").equals("상품")||rs
				 * .getString("TITLE").equals("배송")) {
				 * m.setTitle(rs.getString("TITLE").concat("        "));
				 * 
				 * }else {
				 */

				m.setTitle(rs.getString("TITLE"));
				// }

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

	public static void reveiwupdate(String review, String title, String contancs, String no) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;// 운반객체

		System.out.println("dd");
		String sql = "INSERT INTO QNATABLE1(REVIEW,TITLE,CONTANCS,DATE1,NO) VALUES(?,?,?,sysdate,?)";
		try {
			con.setAutoCommit(false);
			System.out.println(review + "  " + title + "  " + contancs + "  " + no + "  ");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review);
			pstmt.setString(2, title);
			pstmt.setString(3, contancs);
			pstmt.setString(4, no);
			pstmt.executeUpdate();

			con.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}