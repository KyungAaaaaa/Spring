package hello.core.member;

public interface MemberService {
	
	// ȸ������
	void join(Member mamber);

	// ȸ��ã��
	Member findMember(Long memberId);

}
