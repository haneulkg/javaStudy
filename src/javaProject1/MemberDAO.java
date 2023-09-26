package javaProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	MemberVO vo = null;
	
	// 드라이버 검색 및 데이터베이스 연결
	public MemberDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject1";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 -- " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패 -- " + e.getMessage());
		}
	}
	
	// Connection 닫기
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	// PreparedStatement 닫기
	public void pstmtClose() {
		try {
			if(pstmt!=null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// ResultSet 닫기
	public void rsClose() {
		try {
			if(rs!=null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}
	
	
	
}
