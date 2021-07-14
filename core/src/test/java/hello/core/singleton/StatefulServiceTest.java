package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefiService1 = ac.getBean(StatefulService.class);
		StatefulService statefiService2 = ac.getBean(StatefulService.class);

		// ThreadA : A����� 10000�� �ֹ�
		int userAPrice = statefiService1.order("userA", 10000);

		// ThreadB : B����� 20000�� �ֹ�
		int userBPrice = statefiService2.order("userB", 20000);

		// ThreadA : A����� �ֹ� �ݾ� ��ȸ
//		int price = statefiService1.getPrice();
		System.out.println("price = " + userAPrice);

	}

	static class TestConfig {

		@Bean
		public StatefulService stateService() {
			return new StatefulService();
		}
	}

}
