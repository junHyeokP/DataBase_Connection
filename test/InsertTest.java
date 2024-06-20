package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		InsertTest test = new InsertTest();
		test.insertMember("helloworld", "qwerty1234", "fromjava");
	}
	
	void insertMember(String id, String pwd, String nickname) {
		
		//DB 연결
		Connection conn = getDBConnection();
		
		if(conn != null) {
				System.out.println("오라클 DB 연결 성공");
		} else return;
		
		// PreparedStatement 변수 생성
		PreparedStatement pstmt = null;
		
		// sql문 만들기
		String sql = new StringBuilder()
				.append("insert into member (no, id, password, nickname, regdate)")
			    .append("values (member_seq.nextval, ?, ?, ?, sysdate)") // 물음표는 위에서 받아온 매개변수로 대체됨
			    .toString();
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문 매개변수에 값 추가
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, nickname);
			
			// SQL문 실행
			int result = pstmt.executeUpdate(); // 영향을 받은 행의 수를 반환
			
			if (result > 0) System.out.println(result + "행이 추가되었습니다.");
			
			// 자원 객체 닫기
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
		Connection getDBConnection() {
		// DB 연결을 위한 정보
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##JAVA";
		final String passwd = "1111";
				
		// DB 연결 객체 생성하여 반환
		Connection conn = null;
				
		try {
			// JDBC 드라이버 loading
			Class.forName(jdbcDriverClassName);
			
			// Connection 객체 생성
			conn = DriverManager.getConnection(url, userid, passwd);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
								

		return conn;
			
	}

}
