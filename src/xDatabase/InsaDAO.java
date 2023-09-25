package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	InsaVO vo = null;
	
	public InsaDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
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
	
	// conn객체 Close
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// pstmt객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}
	
	// 회원명 검색(회원 중복처리에서 사용)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		try {
			sql = "select * from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	// 회원 가입처리 
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "insert into insa value (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 회원 정보 수정하기
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "update insa set age=?, gender=?, ipsail=? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 회원 삭제하기
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "delete from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 전체 리스트 가져오기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getInsaList() {
		Vector vData = new Vector<>(); 
		try {
			sql = "select * from insa order by idx desc";
//			sql = "select * from insa order by age";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 하위타입도 Vector타입으로 받아야함
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}
	
	// 조건별 정렬처리하기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getNameAscList(String str, String flag) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("name")) {
				if(flag.equals("a")) sql = "select * from insa order by name";
				else sql = "select * from insa order by name desc";
			}
			else if(str.equals("ipsail")) {
				if(flag.equals("a")) sql = "select * from insa order by ipsail";
				else sql = "select * from insa order by ipsail desc";
			}
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	/*
	// 남자라디오 버튼 선택시 남자만 출력
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getGenderMale() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender='남자' order by name ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	// 여자라디오 버튼 선택시 여자만 출력
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getGenderFemale() {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender='여자' order by name ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	*/
	// 남자,여자 중 버튼에 해당하는 자료만 검색하기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getGender(String gender) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender=? order by name ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	/*
	// 성명 조건 검색하기(포함된 글자는 모두 다 검색할 수 있도록 처리하기)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getConditionNameSearch(String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where name like ? order by name ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	*/
	
	// 다양한 조건을 선택 -> 검색 문자열 입력 -> '조건검색'버튼을 누를경우 수행하기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where "+fieldName+" like ? order by name ";
			pstmt = conn.prepareStatement(sql);
			
			if(fieldName.equals("age")) pstmt.setInt(1, Integer.parseInt(txtCondi));
			else pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
}
