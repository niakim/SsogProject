package sist.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcTest {
	private static Connection con;
	static {
		System.out.println("Connect...");
		try {
			//����Ŭ����̹��� �������� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");
			//url�� Quantum DB���� ��� ��. Orange�� Properties���� �����Դ�.
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
