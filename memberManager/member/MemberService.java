package member;

import java.util.List;

public class MemberService {
	
		private MemberDAO memberDao;
		
		public MemberService(MemberDAO memberDao2) {
			this.memberDao = memberDao2;
		}
		
		public boolean regist(Member member) {
			int result = memberDao.insertMember(member);
			
			return true;
		}
		
		public Member read(int no) {
			Member member = memberDao.SelectMember(no);
			return member;
		}
		
		public List<Member> listAll() {
			List<Member> memberList = memberDao.selectMemberAll();
			return memberList;
		}
		
		public boolean edit(Member member, String oldPassword) {
			
			if (member == null) return false;
			if (oldPassword == null) return false;
			
			int result = 0;
			
			Member memInfo = memberDao.SelectMember(member.getNo());
			if (oldPassword.equals(memInfo.getPassword())) {
				result = memberDao.updateMember(member);
				}	
		
			return result == 1 ? true : false;
			
		}
		public boolean remove(int no) {
			
			if (memberDao.SelectMember(no) == null) {
				System.out.println("지정된 행이 없습니다.");
				return false;
			}
			
			int result = memberDao.deleteMember(no);
			
			return (result == 1) ? true : false;
		}
}
