package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardWithFileInsertRunner {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");

			String sql = "" + "insert into boards (bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledata) "
					+ "values ( seq_bno.nextval , ?, ?, ?,sysdate, ?, ?)"; // ? 포함된
			// preparedstatement 형태. 보안성이 좋고 속도가 빠름

			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
			pstmt.setString(1, "강아지");
			pstmt.setString(2, "강아지입니다");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "test3.jpg");
			pstmt.setBlob(5, new FileInputStream("D:\\Temp\\test3.jpg"));

			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행수 : " + rows);

			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno : " + bno);
				}
				rs.close();
			}

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
