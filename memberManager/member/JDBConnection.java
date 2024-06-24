package member;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {
	
	public Connection oracle;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
	final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String userid = "c##JAVA";
	final String passwd = "1111";
	
	
	public JDBConnection( ) {
		
	try {
		Class.forName(jdbcDriverClassName);
		
		oracle = DriverManager.getConnection(url, userid, passwd);
		System.out.println("오라클 DB 연결성공");
		
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
	}
	
	public void close() {
		
		try {
			if (oracle != null) oracle.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
