package sist.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import sist.service.util.ServiceUtil;

public class JdbcProcessEx1 {
	Scanner scanner = new Scanner(System.in);
	Connection connection=ServiceUtil.getConnection();
	
	
	public void createProcess() {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("CREATE TABLE NAKYUNG( ")
			.append("NO NUMBER(5),")
			.append("Message VARCHAR2(20))"); //DB의 refresh 해준뒤...//DB의 ORANGE의 Tables에 NAKYUNG테이블 생김
			PreparedStatement preparedStatement=connection.prepareStatement(sb.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(connection);l
	}
	public void addProcess() {
		LoginMember loginMember = new LoginMember();
		System.out.println("ID");
		loginMember.setId(scanner.next());
		System.out.println("PASS");
		loginMember.setPass(scanner.next());
		System.out.println("NAME");
		loginMember.setName(scanner.next());
		System.out.println("Addr");
		loginMember.setAddr(scanner.next());
		System.out.println(loginMember);
		LoginMemberDao.getInstance().addMember(loginMember);
	}
	public void listMember() {
		for(LoginMember i:LoginMemberDao.getInstance().selectMember()) {
		System.out.println(i);}
	}
	public void deleteMember() {
		System.out.println("Insert DeleteID : ");
		String id=scanner.next().trim();
		int rs=LoginMemberDao.getInstance().memberDelete(id);
		System.out.println(rs>0?"DeleteSuccess":"NotFound");		
	}
	public void modifyMember() {
		LoginMember loginMember = new LoginMember();
		System.out.println("SEARCH ID");
		loginMember.setId(scanner.next());
		System.out.println("MODIFY PASS");
		loginMember.setPass(scanner.next());
		System.out.println("MODIFY NAME");
		loginMember.setName(scanner.next());
		System.out.println("MODIFY Addr"); //띄어쓰기하면 nono
		loginMember.setAddr(scanner.next());
		System.out.println(loginMember);
		int rs=LoginMemberDao.getInstance().memberModify(loginMember);
		System.out.println(rs>0?loginMember.getId()+"님 수정 완료되었습니다.":"NOT FOUND");
	}
	public void infoMember() {
		System.out.println("비밀번호를 찾으실 아이디를 입력해주세요.");
		String id=scanner.next().trim();
		LoginMember m=LoginMemberDao.getInstance().memberInfo(id);
		System.out.println(m==null?"NOT FOUND ELEMENT":m);
	}
	public void loginCheck() {
		System.out.println("ID:");
		String id = scanner.next().trim();
		System.out.println("PASSWORD:");
		String pass = scanner.next().trim();
		
		HashMap<String, String>map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pass",pass);
		
		System.out.println(LoginMemberDao.getInstance().loginMemberCheck(map)?"로그인 성공 :)":"로그인 실패!!!!!!!!!!!! 아이디 혹은 비밀번호를 제대로 입력해주세요!!!!!!!");
		
	}
	public void printDb() {
		while(true) {
			System.out.println("1.CREATE TABLE 2.ADD 3.LIST 4.Delete 5.Modify 6.Info 7.LOGIN");
			switch (scanner.nextInt()) {
			case 1:
				createProcess();
				break;
			case 2:
				addProcess();
				break;
			case 3:
				listMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				modifyMember();
				break;
			case 6:
				infoMember();
				break;
			case 7:
				loginCheck();
				break;
			default:
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new JdbcProcessEx1().printDb();
	}
}
