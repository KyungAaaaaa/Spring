package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ��, �ڽ��� �� �̻� ������, �ߺ� ������ �߻��Ѵ�")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ��, �ڽ��� �� �̻� ������, �� �̸��� �����ϸ� �ȴ�")
	void findBeanByParentTypeBeanname() {
		DiscountPolicy bean = ac.getBean("reteDiscountPolicy", DiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("Ư�� ���� Ÿ������ ��ȸ")
	void findBeanBySubType() {
		RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	} 

	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ�")
	void findAllBeanByParentType() {
		Map<String, DiscountPolicy> beansOfTypeMap= ac.getBeansOfType(DiscountPolicy.class);
		assertThat(beansOfTypeMap.size()).isEqualTo(2);
		for(String key : beansOfTypeMap.keySet()) {
			System.out.println("key = "+key+" value = "+beansOfTypeMap.get(key));
		}
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ� - Object")
	void findallBeanByObjectType() {
		Map<String, Object> beansOfTypeMap= ac.getBeansOfType(Object.class);
		for(String key : beansOfTypeMap.keySet()) {
			System.out.println("key = "+key+" value = "+beansOfTypeMap.get(key));
		}
	}
	
	@Configuration
	static class TestConfig {
		@Bean
		public DiscountPolicy reteDiscountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}

	}

}
