package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;

public class ApplicationContextBasicFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	public void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		// System.out.println("memberService = "+memberService);
		// System.out.println("memberService.getClass() = "+memberService.getClass());
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("이름없이 타입으로만 조회")
	public void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회")
	public void findBeanByName2() {
		// AppConfig 에 return타입이 MemberService 인터페이스지만
		// Bean에 등록된 인스턴스 타입으로 보고 결정하기때문에 구체적으로 적어도 통과
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 이름으로 조회X")
	public void findBeanByNameX() {
		//두번째 인자로 들어간 로직이 실행되었을때, 첫번째 Exception이 터지면 테스트 통과
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxx", MemberService.class));
	}
}
