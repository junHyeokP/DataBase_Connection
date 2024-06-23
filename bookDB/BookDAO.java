package book;

import java.sql.Connection;
import java.sql.SQLException;

public class BookDAO {
	
	public static void main(String[] args) {
		
	}
	
	int deleteBook(int bookID) {
		
			JDBConnection oracle = new JDBConnection();
			Connection jdbconn = oracle.callJDBConnection();
			
			if (jdbconn != null) {
				System.out.println("ORACLE DATABASE 연결에 성공");
			}
			
			else return -1;
			
			oracle.pstmt = null;
			
			String sql = "delete book where bookID = ?";
			
			// if bookID == Book.bookID 
			// else return -1;
			
			try {
				oracle.pstmt = jdbconn.prepareStatement(sql); // PrepareStatment 객체 생성, sql 명령문 준비
				
				oracle.pstmt.setInt(0, bookID); // ? 부분에 매개변수 넣기
				
				int result = oracle.pstmt.executeUpdate();
				// 여기서 반환된 result값은 영향을 받은 행의 갯수를 출력했다는 메세지와 함께 출력할 것임, 아닐 시 -1반환
				return result > 0? result : -1;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
	}
}


