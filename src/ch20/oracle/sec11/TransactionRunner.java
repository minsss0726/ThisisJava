package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TransactionRunner {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("Connecting succes");
			
			conn.setAutoCommit(false); // 자동 커밋 종료
			
			String sql1 = "update accounts set balance = balance - ? where ano = ?";

			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int row1 = pstmt1.executeUpdate();
			if(row1 == 0) {
				throw new Exception("출금되지 않음");
			}
			
			String sql2 = "update accounts set balance = balance + ? where ano = ?";

			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int row2 = pstmt2.executeUpdate();
			if(row2 == 0) {
				throw new Exception("출금되지 않음");
			}
			
			conn.commit(); // 계좌 이체 모두 성공시 커밋
			System.out.println("계좌 이체 성공");

		} catch (Exception e) {
			try {
				conn.rollback(); // 예외 발생 시 트랜잭션 롤백
			} catch (Exception e1) {

			}
			System.out.println("계좌 이체 실패");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
				}
			}
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (Exception e) {
				}
			}
			if (conn != null) {
				try {
					conn.setAutoCommit(true); // 자동 커밋 다시 설정

					conn.close();
					System.out.println("Off Connecting");
				} catch (Exception e) {
				}
			}
		}

	}
}
