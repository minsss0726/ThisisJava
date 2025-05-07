package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSelectRunner {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");

			String sql = "select userid, username, userpassword, userage, useremail" +
					" from users" +
					" where userid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserage(rs.getInt("userage"));
				user.setUserEmail(rs.getString("useremail"));
				System.out.println(user);
			} else {
				System.out.println("no userId");
			}
			rs.close();

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
