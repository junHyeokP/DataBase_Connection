package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	public int insertMember(Member member) {
		
		//DB 연결
		JDBConnection jdbc = new JDBConnection();
		int result = 0;
		try {
		// sql문 만들기
		String sql = new StringBuilder()
				.append("insert into member (no, id, password, nickname, regdate)")
			    .append("values (member_seq.nextval, ?, ?, ?, sysdate)") // 물음표는 위에서 받아온 매개변수로 대체됨
			    .toString();
		

			jdbc.pstmt = jdbc.oracle.prepareStatement(sql);
			
			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, member.getId());
			jdbc.pstmt.setString(2, member.getPassword());
			jdbc.pstmt.setString(3, member.getNickname());
			
			// SQL문 실행
			result = jdbc.pstmt.executeUpdate(); // 영향을 받은 행의 수를 반환
			
			if (result == 1) System.out.println(result + "행이 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 객체 닫기
			jdbc.close();
		}
		return result;
		
		
	}
		
	
	public List<Member> selectMemberAll() {
		// DB연결
				JDBConnection jdbc = new JDBConnection();
		
				String sql = "select * from member";
				
				// 결과를 저장할 List 객체 생성
				List<Member> memberList = new ArrayList<>();	
				
				try {
					// PreparedStatement 객체 생성 (명령문 준비)
					jdbc.pstmt = jdbc.oracle.prepareStatement(sql);
					
					// sql문 실행 (쿼리 실행, 실행 결과를 ResultSet에 저장)
					jdbc.rs = jdbc.pstmt.executeQuery();
					
					// 결과값 출력
					System.out.println("<<맴버 상세정보>>");
					while (jdbc.rs.next()) {
						Member member = new Member(
								jdbc.rs.getInt("no"),
								jdbc.rs.getString("id"),
								jdbc.rs.getString("password"),
								jdbc.rs.getString("nickname"),
								jdbc.rs.getDate("regDate")
								);
						memberList.add(member);
						
					}
				} catch (SQLException e) {				
					e.printStackTrace();
					return null;
				} finally {
					jdbc.close();
				}
				
				return memberList;
	}

	public Member SelectMember(int no) {

		JDBConnection jdbc = new JDBConnection();
		
		String sql = "select * from member where no = ?";
		
		Member member = null; // null이라고 지정을 안하면 오류가 출력됨
		
		try {
			jdbc.pstmt = jdbc.oracle.prepareStatement(sql);
			
			jdbc.pstmt.setInt(1, no);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
			member = new Member(
					jdbc.rs.getInt("no")
					,jdbc.rs.getString("id")
					,jdbc.rs.getString("password")
					,jdbc.rs.getString("nickname")
					,jdbc.rs.getDate("regDate")
					);	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			jdbc.close();
		}
		
		return member;
		
	}


	public int updateMember(Member member) {
		
		JDBConnection jdbc = new JDBConnection();
		
		//sql문 적기
		String sql = new StringBuilder()
				.append("update member ") 
				.append("set password = ?, nickname = ? ") //1, 2
				.append("where no = ?")//3
				.toString();
		
		int result = 0;
		
		// sql명령문을 준비할 PreparedStatement 객체 생성
		try {
			jdbc.pstmt = jdbc.oracle.prepareStatement(sql);
			
			jdbc.pstmt.setString(1, member.getPassword());
			jdbc.pstmt.setString(2, member.getNickname());
			jdbc.pstmt.setInt(3, member.getNo());
			
			//sql 실행
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정됨");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}


	public int deleteMember(int no) {
		int result = 0;
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		
		// sql문 생성
		String sql = "delete member where no = ?";
		
		try {
			// sql문을 담을 prepareStatement 객체 생성
			jdbc.pstmt = jdbc.oracle.prepareStatement(sql);
			// ? 부분에 넣을 파라미터 set
			jdbc.pstmt.setInt(1, no);
			// sql문 실행, 영향 받은 행의 갯수를 반환
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행 삭제됨");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
	
}
