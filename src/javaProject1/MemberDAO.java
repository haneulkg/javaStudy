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
	
	// 닉네임 중복 처리하기
	public MemberVO getNickNameSearch(String nickName) {
		vo = new MemberVO();
		try {
			sql = "select * from member where nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("age"));
				vo.setPassword(rs.getInt("password"));
				vo.setPhoneNum(rs.getString("phoneNum"));
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 -- " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	// 회원 가입 처리하기
	public int setMemberInput(MemberVO vo) {
		int res = 0;
		try {
			sql = "insert into member value (default, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getAge());
			pstmt.setInt(5, vo.getPassword());
			pstmt.setString(6, vo.getPhoneNum());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL오류 -- " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public MemberVO getLogin(String nickName) {
		vo = new MemberVO();
		try {
			sql = "select * from member where nickName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setNickName(rs.getString("nickName"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("Age"));
				vo.setPassword(rs.getInt("password"));
				vo.setPhoneNum(rs.getString("phoneNum"));
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 -- " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	
	
}
