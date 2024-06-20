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

	Connection getDBconnection() {
		
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
		
		Connection oracle = getDBconnection();
		
		if (oracle != null) System.out.println("오라클 DB 연결 성공");
		
		else return;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = new StringBuilder()
						.append("select * from member")
						.toString();
		
		try {
			// PreparedStatement 객체 생성
			pstmt = oracle.prepareStatement(sql);
			// sql문 매개변수에 값 추가
			pstmt.getResultSet();
			// sql문 실행
			rs = pstmt.executeQuery();
			
			// 결과값 출력
			System.out.println("<<맴버 상세정보>>");
			while (rs.next())
			System.out.println("no : " + rs.getString(1) + " "
								+ "id : " + rs.getString(2) + " "
								+ "password : " +rs.getString(3) + " "
								+ "nickname" + rs.getString(4));
			
			
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
}
