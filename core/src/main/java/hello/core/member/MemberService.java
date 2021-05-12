package hello.core.member;

public interface MemberService {
	
	// 회원가입
	void join(Member mamber);

	// 회원찾기
	Member findMember(Long memberId);

}
