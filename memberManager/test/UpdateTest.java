package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {
		UpdateTest test = new UpdateTest(); 
		test.updateMember(3, "qwerty1234", "fromjava");
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
	
	void updateMember(int no, String password, String nickname) {
		//DB 연결
		Connection oracle = getDBConnection();
		
		//PrepareStatement 객체용 변수 선언
		PreparedStatement pstmt = null;
		
		//sql문 적기
		String sql = new StringBuilder()
				.append("update member ") 
				.append("set password = ?, nickname = ? ") //1, 2
				.append("where no = ?")//3
				.toString();
		
		// sql명령문을 준비할 PreparedStatement 객체 생성
		try {
			pstmt = oracle.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setString(2, nickname);
			pstmt.setInt(3, no);
			
			//sql 실행
			
			int num = pstmt.executeUpdate();
			System.out.println(num + "행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null) pstmt.close();
				if (oracle != null) oracle.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
