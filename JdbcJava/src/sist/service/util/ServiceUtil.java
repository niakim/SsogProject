package sist.service.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServiceUtil {

	private static Connection con;
	static {
		System.out.println("Connect...");}
	public static Connection getConnection() {
		try {
			//����Ŭ����̹��� �������� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");
			//url�� Quantum DB���� ��� ��. Orange�� Properties���� �����Դ�.
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connect Fail");
			e.printStackTrace();
		}
		return con;
	}
}
