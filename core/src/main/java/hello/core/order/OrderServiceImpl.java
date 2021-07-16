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

	// 구현체에 의존하지않고 인터페이스에만 의존. DIP
	private MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;

	// 수정자 주입은 빈이 생성된 뒤, 의존관졔주입 단계에서 발생
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

	// 생성자가 1개면 @Autowired를 생략해도 자동주입된다.
	// 생성자 주입은 빈이 생성될 때,(빈을 생성하려면 객체를 생성해야하기 때문에 생성과 동시에 주입이 일어난다.)
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

	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
