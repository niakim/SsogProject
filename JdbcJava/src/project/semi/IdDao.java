package project.semi;

import java.awt.Component;
import java.awt.Label;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import sist.service.util.ServiceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sist.service.util.ServiceUtil;

public class IdDao {
	public static boolean searchId(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID FROM MEMBER WHERE ID = ? AND STATE = '가입'";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				return true;
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
		return false;
	}

	public static void insertMember(Member m) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "INSERT INTO MEMBER(ID, PW, NAME, SNUMBER, ADDR, CNUMBER, REFERRALCODE, CODE, GRADE, STATE, POINT, REGDATE, TOTAL) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setString(1, m.getId());
			pst.setString(2, m.getPw());
			pst.setString(3, m.getName());
			pst.setString(4, m.getSnumber());
			pst.setString(5, m.getAddr());
			pst.setString(6, m.getCnumber());
			pst.setString(7, m.getReferralCode());
			pst.setString(8, m.getCode());
			pst.setString(9, m.getGrade());
			pst.setString(10, m.getState());
			pst.setInt(11, m.getPoint());
			pst.setString(12, m.getRegdate());
			pst.setInt(13, m.getTotal());
			pst.executeUpdate();
			con.commit();
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
	}

	public static boolean pwCheck(String id, String pw) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT PW FROM MEMBER WHERE ID = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return true;
				}
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
		return false;
	}

	public static boolean searchCode(String code) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CODE FROM MEMBER WHERE CODE = ? AND STATE = '가입'";
			pst = con.prepareStatement(sql);
			pst.setString(1, code);
			rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
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
		return false;
	}

	public static void updatePoint(String code) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "UPDATE MEMBER SET POINT =  POINT + 100 WHERE CODE = ?";

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setString(1, code);
			pst.executeUpdate();
			con.commit();
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
	}

	public static Member searchName(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Member m = new Member();

		try {
			String sql = "SELECT ID, PW, NAME FROM MEMBER WHERE ID = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				m.setId(rs.getString(1));
				m.setPw(rs.getString(2));
				m.setName(rs.getString(3));
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
		return m;
	}

	public static Member searchSnumber(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Member m = new Member();

		try {
			String sql = "SELECT SNUMBER, ADDR FROM MEMBER WHERE ID = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				m.setSnumber(rs.getString(1));
				m.setAddr(rs.getString(2));
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
		return m;
	}

	public static void insertWithdrawal(WithdrawalBean w) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "INSERT INTO WITHDRAWAL(SNUMBER, ADDR, COMPLAIN, OPINION) VALUES(?, ?, ?, ?)";

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setString(1, w.getSnumber());
			pst.setString(2, w.getAddr());
			pst.setString(3, w.getComplain());
			pst.setString(4, w.getOpinion());
			pst.executeUpdate();
			con.commit();
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
	}

	public static void deleteId(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "UPDATE MEMBER SET STATE = '탈퇴' WHERE ID = ?";

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
			con.commit();
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
	}

	public static MemberJTableModel selectMember() {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Object[][] data = null;
		ResultSetMetaData rsmd;
		String[] col;
		String sql = "SELECT ID 아이디, NAME 이름, GRADE 등급, STATE 회원상태, POINT 포인트, CODE \"나의 추천코드\", REFERRALCODE 추천인, REGDATE \"신규 가입일\", TOTAL \"총 결제금액\"FROM MEMBER";
		MemberJTableModel table;

		try {
			pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

			table = new MemberJTableModel(data);
			table.setColName(col);
			return table;
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
		return null;
	}

	public static MemberJTableModel selectColumnMember(String[] jcbStr) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Object[][] data = null;
		ResultSetMetaData rsmd;
		String[] col;
		String sql = "SELECT ID 아이디, NAME 이름";
		MemberJTableModel table;

		for (int i = 0; i < jcbStr.length; i++) {
			switch (jcbStr[i]) {
			case "등급":
				sql += (", ".concat("GRADE 등급"));
				break;
			case "회원상태":
				sql += (", ".concat("STATE 회원상태"));
				break;
			case "포인트":
				sql += (", ".concat("POINT 포인트"));
				break;
			case "나의 추천코드":
				sql += (", ".concat("CODE \"나의 추천코드\""));
				break;
			case "추천인":
				sql += (", ".concat("REFERRALCODE 추천인"));
				break;
			case "신규 가입일":
				sql += (", ".concat("REGDATE \"신규 가입일\""));
				break;
			case "총 결제금액":
				sql += (", ".concat("TOTAL \"총 결제금액\""));
				break;
			default:
				sql += (", ".concat(
						"GRADE 등급, STATE 회원상태, POINT 포인트, CODE \"나의 추천코드\", REFERRALCODE 추천인, REGDATE \"신규 가입일\", TOTAL \"총 결제금액\""));
				break;
			}
		}
		sql = sql.concat(" FROM MEMBER");
		try {
			pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

			table = new MemberJTableModel(data);
			table.setColName(col);
			return table;
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
		return null;
	}

	public static MemberJTableModel searchCondition(String result) {
		System.out.println(result);
		String[] res = result.split("#");
		if (res[1].equals("--------------------")) {
			res[1] = "";
		}

		System.out.println(Arrays.toString(res));
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Object[][] data = null;
		ResultSetMetaData rsmd;
		String[] column;
		String sql = "SELECT ID 아이디, NAME 이름, GRADE 등급, STATE 회원상태, POINT 포인트, CODE \"나의 추천코드\", REFERRALCODE 추천인, REGDATE \"신규 가입일\", TOTAL \"총 결제금액\" FROM MEMBER WHERE ";
		MemberJTableModel table;

		try {
			switch (res[0]) {
			case "아이디":
				sql += ("ID = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[2]);
				break;
			case "이름":
				sql += ("NAME = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[2]);
				break;
			case "등급":
				sql += ("GRADE = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[1]);
				break;
			case "회원상태":
				sql += ("STATE = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[1]);
				break;
			case "포인트":
				if (res[1].equals("이상")) {
					sql += ("POINT >= ?");
					pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, Integer.parseInt(res[2]));
				} else if (res[1].equals("이하")) {
					sql += ("POINT <= ?");
					pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, Integer.parseInt(res[2]));
				}
				break;
			case "나의 추천코드":
				sql += ("CODE = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[2]);
				break;
			case "추천인":
				sql += ("REFERRALCODE = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[2]);
				break;
			case "신규 가입일":
				sql += ("REGDATE = ?");
				pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst.setString(1, res[2]);
				break;
			case "총 결제금액":
				if (res[1].equals("이상")) {
					sql += ("TOTAL >= ?");
					pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, Integer.parseInt(res[2]));
				} else if (res[1].equals("이하")) {
					sql += ("TOTAL <= ?");
					pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, Integer.parseInt(res[2]));
				}
				break;
			}
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

			column = new String[rsmd.getColumnCount()];
			for (int j = 0; j < column.length; j++) {
				column[j] = rsmd.getColumnName(j + 1);
			}

			table = new MemberJTableModel(data);
			table.setColName(column);
			return table;
		} catch (

		Exception e) {
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
		return null;
	}

}
