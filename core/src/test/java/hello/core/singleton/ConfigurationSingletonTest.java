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

		// AnnotationConfigApplicationContext�� AppConfig�� �ѱ�� AppConfig�� bean�� ��ϵȴ�
		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
		//bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$81cf50a8
		//@Configuration�� ���̸� ������ �ٸ� Ŭ������ �̱����� ����ǵ��� ���ش�.
		//�̹� ����� �� ���� ã�Ƽ� ��ȯ���ְ�, ���ٸ� ����Ѵ�.
	}
}
