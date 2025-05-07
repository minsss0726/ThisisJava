package ch20.oracle.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDeleteRunner {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");

			String sql = "delete from boards where bwriter = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");

			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행수 : " + rows);

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
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
