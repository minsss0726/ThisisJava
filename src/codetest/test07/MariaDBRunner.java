package codetest.test07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaDBRunner {

	private Connection conn;


	public MariaDBRunner() {
		super();
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/study", "testuser", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void list() {
		
		try {
			PreparedStatement pstmt;
		
			String sql = "" + "SELECT S.NAME AS NAME, S.TEL AS TEL, M.NAME AS MAJOR, P.NAME AS PROFESSOR"
					+ " FROM STUDENT S" + " LEFT OUTER JOIN professor p ON (s.profno = p.no)"
					+ " LEFT OUTER JOIN major M ON (S.MAJOR1 = M.code)";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student st = new Student();
				Professor pf = new Professor();
				Major mj = new Major();
				st.setName(rs.getString("NAME"));
				st.setTel(rs.getString("TEL"));
				mj.setName(rs.getString("MAJOR"));
				pf.setName(rs.getString("PROFESSOR"));
				System.out.printf("%s %s %s %s", st.getName(), st.getTel(), mj.getName(), pf.getName());
				System.out.println();
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		exit();
	}

	public void exit() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		System.exit(0);
	}

	public static void main(String[] args) {

		MariaDBRunner mr = new MariaDBRunner();
		
		mr.list();
		
	}

}
