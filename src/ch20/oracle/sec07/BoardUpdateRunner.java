package ch20.oracle.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardUpdateRunner {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");

			String sql = new StringBuilder().append("update boards set ")
					.append("btitle = ?,").append("bcontent = ?,").append("bfilename = ?,").append("bfiledata = ? ")
					.append("where bno = ?")
					.toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "눈사람");
			pstmt.setString(2, "눈으로 만든 사람");
			pstmt.setString(3, "snowman.jpg");
			pstmt.setBlob(4, new FileInputStream("D:\\Temp\\snowman.jpg"));
			pstmt.setInt(5, 4);

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
