package sist.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sist.service.util.ServiceUtil;

public class LoginMemberDao {
	
	private Connection con = ServiceUtil.getConnection();
	private PreparedStatement pst;
	private static LoginMemberDao dao;
	public static LoginMemberDao getInstance() {
		if(dao==null)
			dao=new LoginMemberDao();
		return dao;
	}
	
	public List<LoginMember>selectMember(){
		ArrayList<LoginMember>list=new ArrayList<>();
		String sql="SELECT id,pass,name,addr FROM LOGINTEST";
		ResultSet rs=null;
		try {
			pst=con.prepareStatement(sql);//운반객체생성
			rs=pst.executeQuery();
			while(rs.next()) {
				LoginMember m = new LoginMember(); //얘는 반드시 while안에 넣어줘야함. 왜냐하면 하나밖에 안만들어지니깐.
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("ADDR")); //대문자 -> 에러는 안나지만
				list.add(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int memberDelete(String id) {
		int rs=0;
			String sql = "DELETE FROM LOGINTEST WHERE ID=?";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, id);
				rs=pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
		
	}
	
	public int memberModify(LoginMember member) {
		int rs=0;
		try {
			String sql = "UPDATE LOGINTEST SET PASS=?,NAME=?,ADDR=? WHERE ID=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, member.getPass());
			pst.setString(2, member.getName());
			pst.setString(3, member.getAddr());
			pst.setString(4, member.getId());
			rs=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public LoginMember memberInfo(String id) {
			String sql="SELECT * FROM LOGINTEST WHERE ID=?";
			ResultSet rs=null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				LoginMember m=new LoginMember();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("ADDR"));
				return m;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public boolean loginMemberCheck(HashMap<String, String>map) {
		String sql="SELECT PASS FROM LOGINTEST WHERE ID = ?";//PASS가 틀리면 NULL이 될 것
		ResultSet rs = null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, map.get("id"));
			rs=pst.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(map.get("pass").toString().trim())) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public void addMember(LoginMember login) {
		String sql="INSERT INTO LOGINTEST VALUES(?,?,?,?)"; //값을 모를 때는 물음표
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, login.getId());
			pst.setString(2, login.getPass());
			pst.setString(3, login.getName());
			pst.setString(4, login.getAddr());
			pst.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
