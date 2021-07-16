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
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	//생성자가 1개면 @Autowired를 생략해도 자동주입된다.
	//@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		System.out.println("memberRepository = "+memberRepository);
		System.out.println("discountPolicy = "+discountPolicy);
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}


	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
	
		return new Order(memberId,itemName,itemPrice,discountPrice);
	}
	
	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
 