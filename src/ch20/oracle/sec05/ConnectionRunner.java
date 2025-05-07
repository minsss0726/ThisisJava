package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionRunner {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");

			// String sql = "" + "insert into user (aaa,bbb) values ( ? , ?)"; // ? 포함된
			// preparedstatement 형태. 보안성이 좋고 속도가 빠름

		} catch (Exception e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Off Connecting");
				} catch (Exception e) {

				}
			}
		}
	}
}
