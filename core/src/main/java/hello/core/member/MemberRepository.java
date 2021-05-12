package hello.core.member;

public interface MemberRepository {

	// 회원등록
	void save(Member member);

	// 회원찾기
	Member findById(Long memberId);
}
