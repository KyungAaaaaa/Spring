package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

	// ����ü�� ���������ʰ� �������̽����� ����. DIP
	private MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;

	// ������ ������ ���� ������ ��, ������������ �ܰ迡�� �߻�
	@Autowired
	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
		System.out.println("discountPolicy = " + discountPolicy);
		this.discountPolicy = discountPolicy;
	}

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		System.out.println("memberRepository = " + memberRepository);
		this.memberRepository = memberRepository;
	}

	// �����ڰ� 1���� @Autowired�� �����ص� �ڵ����Եȴ�.
	// ������ ������ ���� ������ ��,(���� �����Ϸ��� ��ü�� �����ؾ��ϱ� ������ ������ ���ÿ� ������ �Ͼ��.)
	// @Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	// �׽�Ʈ �뵵
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
