package sist.com.dao;
//? -> binding º¯¼ö
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sist.com.model.EmpBean;
import sist.service.util.ServiceUtil;

public class DemoDao {

	public static List<EmpBean> selectEMP() {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt = null;//¿î¹Ý°´Ã¼
		ArrayList<EmpBean>list = new ArrayList<EmpBean>();
		ResultSet rs=null;
		String sql = "SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'YYYY/MM/DD')HIREDATE,SAL,NVL(COMM,0)COMM,DEPTNO FROM EMP";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpBean bean = new EmpBean();
				bean.setEmpno(rs.getInt(1));
				bean.setEname(rs.getString(2));
				bean.setJob(rs.getString(3));
				bean.setMgr(rs.getInt(4));
				bean.setHiredate(rs.getString(5));
				bean.setSal(rs.getInt(6));
				bean.setComm(rs.getInt(7));
				bean.setDeptno(rs.getInt(8));
				list.add(bean);
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
		return list;
	}
	
	
	public static EmpBean selectEmpInfo(int empno) {
		Connection con = ServiceUtil.getConnection();//¿¬°á°´Ã¼
		PreparedStatement pstmt = null;//¿î¹Ý°´Ã¼
		ResultSet rs=null;
		String sql = "SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'YYYY/MM/DD')HIREDATE,SAL,NVL(COMM,0)COMM,DEPTNO FROM EMP WHERE EMPNO=?";
		EmpBean bean = new EmpBean();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setEmpno(rs.getInt(1));
				bean.setEname(rs.getString(2));
				bean.setJob(rs.getString(3));
				bean.setMgr(rs.getInt(4));
				bean.setHiredate(rs.getString(5));
				bean.setSal(rs.getInt(6));
				bean.setComm(rs.getInt(7));
				bean.setDeptno(rs.getInt(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return bean;
	}
	
	
	
	
}
