package hello.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.AppConfig;

public class BeanDefinitiionTest {

	//factoryMethod
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//	GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
	
	@Test
	@DisplayName("�� ���� ��Ÿ���� Ȯ��")
	void findApplicationBean() {
		String[] beanDifinitionNames = ac.getBeanDefinitionNames();
		for(String beanDifinitionName : beanDifinitionNames) {
			BeanDefinition beanDefinition=ac.getBeanDefinition(beanDifinitionName);
			
			if (beanDefinition.getRole()== BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDifinitionName = "+beanDifinitionName + " / beanDefinition = "+beanDefinition);
				
			}
		}
	}

}
