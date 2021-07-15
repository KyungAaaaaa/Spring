package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService")
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	// MemoryMemberRepository �� ���� ������ �������� �ʴ´� : *�߻�ȭ���� ����*
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	//�׽�Ʈ �뵵
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
