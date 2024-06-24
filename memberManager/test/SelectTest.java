package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		SelectTest test = new SelectTest();
		test.selectAllMember();
	}

	Connection getDBConnection() {
		
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##JAVA";
		final String passwd = "1111";
		
		Connection oracle = null;
		
		try {
			Class.forName(jdbcDriverClassName);
			
			oracle = DriverManager.getConnection(url, userid, passwd);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return oracle;
		
	}
	void selectAllMember() {
		// DB연결
		Connection oracle = getDBConnection();
		
		if (oracle != null) System.out.println("오라클 DB 연결 성공");
		
		else return;
		// PreparedStatement 변수, ResultSet변수 선언
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		try {
			// PreparedStatement 객체 생성 (명령문 준비)
			pstmt = oracle.prepareStatement(sql);
			
			// sql문 실행 (쿼리 실행, 실행 결과를 ResultSet에 저장)
			rs = pstmt.executeQuery();
			
			// 결과값 출력
			System.out.println("<<맴버 상세정보>>");
			while (rs.next()) {
			System.out.println("[no : " 		 + rs.getString(1) + "], "
								+ "[id : " 		 + rs.getString(2) + "], "
								+ "[password : " + rs.getString(3) + "], "
								+ "[nickname : " + rs.getString(4) + "], "
								+ 				   rs.getString(5));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void selectMember(int no) {
		
		Connection conn = getDBConnection();
		
		if (conn != null) System.out.println("연결 성공");
		else return;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("[no : " + rs.getString(1) + "], "
						+ "[id : " 		 + rs.getString(2) + "], "
						+ "[password : " + rs.getString(3) + "], "
						+ "[nickname : " + rs.getString(4) + "], "
						+ 				   rs.getString(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
