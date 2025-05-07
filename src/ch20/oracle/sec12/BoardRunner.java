package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BoardRunner {

	private Scanner sc = new Scanner(System.in);
	private Connection conn;

	public BoardRunner() {
		super();
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-------------------------------------------------------");

		try {
			String sql = "" + "select bno, btitle, bcontent, bwriter,bdate " + "from boards " + "order by bno desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("===================================");
				System.out.println("번호 : " + board.getBno());
				System.out.println("제목 : " + board.getBtitle());
				System.out.println("내용 : " + board.getBcontent());
				System.out.println("작성자 : " + board.getBwriter());
				System.out.println("날짜 : " + board.getBdate());
				System.out.println("===================================");
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.println("메인 메뉴 선택 : ");
		String menuNo = sc.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> exit();
		}
	}

	public void create() {
		Board board = new Board();
		System.out.print("제목 : ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용 : ");
		board.setBcontent(sc.nextLine());
		System.out.print("작성자 : ");
		board.setBwriter(sc.nextLine());

		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancle");
		System.out.println("보조 메뉴 선택 : ");
		String menuNo = sc.nextLine();

		if (menuNo.equals("1")) {
			try {
				String sql = "" + "insert into boards (bno,btitle,bcontent,bwriter,bdate)"
						+ " values (seq_bno.nextval, ? ,? ,? ,sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void read() {
		System.out.println("");
		System.out.println("[게시물 읽기]");
		System.out.print("bno : ");
		int bno = Integer.parseInt(sc.nextLine());
		Board board = new Board();
		
		try {
			String sql = "" + "select bno, btitle, bcontent, bwriter,bdate " + "from boards " + "where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("===================================");
				System.out.println("번호 : " + board.getBno());
				System.out.println("제목 : " + board.getBtitle());
				System.out.println("내용 : " + board.getBcontent());
				System.out.println("작성자 : " + board.getBwriter());
				System.out.println("날짜 : " + board.getBdate());
				System.out.println("===================================");
			}

			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
			System.out.println("보조 메뉴 선택 : ");
			String menuNo = sc.nextLine();

			if (menuNo.equals("1")) {
				update(board);
			} else if (menuNo.equals("2")) {
				delete(board);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	public void update(Board board) {
		System.out.println();
		System.out.println("[수정 내용 입력]");
		System.out.print("제목 : ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용 : ");
		board.setBcontent(sc.nextLine());
		System.out.print("작성자 : ");
		board.setBwriter(sc.nextLine());

		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancle");
		System.out.println("보조 메뉴 선택 : ");
		String menuNo = sc.nextLine();

		if (menuNo.equals("1")) {
			try {
				String sql = "" + "update boards set btitle = ?, bcontent = ?, bwriter =?" + " where bno = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void delete(Board board) {
		try {
			String sql = "" + "delete from boards where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	public void clear() {
		System.out.println();
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancle");
		System.out.println("보조 메뉴 선택 : ");
		String menuNo = sc.nextLine();
		
		if (menuNo.equals("1")) {
			try {
				String sql = "" + "truncate table boards";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void exit() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		System.out.println();
		System.out.println("[게시판 종료]");
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardRunner boardRunner = new BoardRunner();
		boardRunner.list();
	}

}
