package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	public void findAllBean() {
		String[] beanDifinitionNames = ac.getBeanDefinitionNames();

		for (String beanDifinitionName : beanDifinitionNames) {
			Object bean = ac.getBean(beanDifinitionName);
			System.out.println("name = " + beanDifinitionName + " / object = " + bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	public void findApplicationBean() {
		String[] beanDifinitionNames = ac.getBeanDefinitionNames();

		for (String beanDifinitionName : beanDifinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDifinitionName);
			
			//ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
			//ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDifinitionName);
				System.out.println("name = " + beanDifinitionName + " / object = " + bean);
				
			}
		}
	}
}
