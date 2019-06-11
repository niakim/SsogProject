package sist.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcTest {
	private static Connection con;
	static {
		System.out.println("Connect...");
		try {
			//오라클드라이버를 동적으로 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");
			//url은 Quantum DB에서 들고 옴. Orange의 Properties에서 가져왔다.
			System.out.println("Connect Success");
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connect Fail");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
	
	
	
}
