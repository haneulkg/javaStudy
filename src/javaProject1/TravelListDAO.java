package javaProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class TravelListDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	TravelListVO vo = null;
	
	// 드라이버 검색 및 데이터베이스 연결
	public TravelListDAO() {
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

	public ArrayList<TravelListVO> getSelect(String check) {
		ArrayList<TravelListVO> vos = new ArrayList<TravelListVO>();
		try {
			sql = "select * from travelList where hashTag2 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, check);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new TravelListVO();
				vo.setArea(rs.getString("area"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getNString("address"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 -- " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	public ArrayList<TravelListVO> getTravelListSearch(String area) {
		ArrayList<TravelListVO> vos = new ArrayList<TravelListVO>();
		try {
			sql = "select * from travelList where area = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new TravelListVO();
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getNString("address"));
				vo.setHastTag1(rs.getString("hashTag1"));
				vo.setHastTag2(rs.getString("hashTag2"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 -- " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	




}
