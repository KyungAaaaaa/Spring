package hello.core.member;

public interface MemberRepository {

	// ȸ�����
	void save(Member member);

	// ȸ��ã��
	Member findById(Long memberId);
}
