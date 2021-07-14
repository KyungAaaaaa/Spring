package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		System.out.println("memberService -> memberRepository1 = " + memberService.getMemberRepository());
		System.out.println("orderService -> memberRepository2 = " + orderService.getMemberRepository());
		System.out.println("memberRepository = " + memberRepository);

		assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
		assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
	}

	@Test
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// AnnotationConfigApplicationContext로 AppConfig를 넘기면 AppConfig도 bean에 등록된다
		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
		//bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$81cf50a8
		//@Configuration을 붙이면 임의의 다른 클래스가 싱글톤이 보장되도록 해준다.
		//이미 등록이 된 빈은 찾아서 반환해주고, 없다면 등록한다.
	}
}
