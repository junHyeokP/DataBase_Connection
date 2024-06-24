package managertest;

import java.util.List;

import member.Member;
import member.MemberDAO;
import member.MemberService;

public class MemberManagerTest  {

	
	public static void main(String[] args) {
		MemberService service = new MemberService(new MemberDAO());
		Member member;
		
		// 회원 등록
				
				member = new Member("yes2213", "1234", "nick1234");
				if (service.regist(member)) {
					System.out.println("회원 등록 성공");
				} else System.out.println("회원 등록 실패");
				
		
		//회원 목록 보기
		
		List<Member> memberList = service.listAll();
		for (Member mem : memberList) {
			System.out.println(mem.toString());
		}
		
		//회원 조회
		/*member = service.read(1);
		if (member != null) {
			System.out.println(member.toString());
		} 
		else System.out.println("member에 저장된 값이 없습니다."); 
		 */
		// 회원 수정
		/*member = new Member(3, null, "4321", "nick2312", null);
		service.edit(member, "qwerty1234");*/
		
		// 회원 삭제
		//service.remove(6);
	}
}
