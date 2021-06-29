package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("��� �� ����ϱ�")
	public void findAllBean() {
		String[] beanDifinitionNames = ac.getBeanDefinitionNames();

		for (String beanDifinitionName : beanDifinitionNames) {
			Object bean = ac.getBean(beanDifinitionName);
			System.out.println("name = " + beanDifinitionName + " / object = " + bean);
		}
	}

	@Test
	@DisplayName("���ø����̼� �� ����ϱ�")
	public void findApplicationBean() {
		String[] beanDifinitionNames = ac.getBeanDefinitionNames();

		for (String beanDifinitionName : beanDifinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDifinitionName);
			
			//ROLE_APPLICATION : ���� ����� ���ø����̼� ��
			//ROLE_INFRASTRUCTURE : �������� ���ο��� ����ϴ� ��
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDifinitionName);
				System.out.println("name = " + beanDifinitionName + " / object = " + bean);
				
			}
		}
	}
}
