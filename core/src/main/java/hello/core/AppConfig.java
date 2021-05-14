package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
	// 다형성을 활용해 인터페이스로 받음. 저장소를 바꾸려면 이 코드만 바꾸면됌!!
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public DiscountPolicy dicountPolicy() {
		return new FixDiscountPolicy();
	}

	
	// 생성자 주입
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), dicountPolicy());
	}

}
