package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	// ���� Ÿ���� �� ã��
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻� ������, �ߺ� ������ �߻��Ѵ�")
	void findBeanByTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻� ������, �� �̸��� �����ϸ� �ȴ�")
	void findBeanByName() {
		MemberRepository memberRepository=ac.getBean("memberRepository1",MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("Ư�� Ÿ���� ��� ��ȸ�ϱ�")
	void findAllBeanByType() {
		Map<String,MemberRepository> beansOfTypeMap=ac.getBeansOfType(MemberRepository.class);
		for(String key:beansOfTypeMap.keySet()) {
			System.out.println("key = "+key + " value = "+beansOfTypeMap.get(key));
		}
	}
	

	@Configuration
	static class SameBeanConfig {

		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
	}
}
