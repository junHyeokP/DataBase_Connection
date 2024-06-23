package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {
	
	Connection connector;
	PreparedStatement pstmt;
	ResultSet rs;
	
	Connection callJDBConnection() {
		
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##JAVA";
		final String passwd = "1111";
				
		// DB 연결 객체 생성하여 반환
		connector = null;
				
		try {
			// JDBC 드라이버 loading
			Class.forName(jdbcDriverClassName);
			
			// Connection 객체 생성
			connector = DriverManager.getConnection(url, userid, passwd);
			System.out.println("오라클 DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}			

		return connector;
			
	}
	
	void close() {
		
		try {
			connector.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
