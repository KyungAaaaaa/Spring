package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//해당 클래스는 스프링 부트 프로젝트 생성시 자동으로 만들어지는 클래스.
//@ComponentScan가 속해있기때문에 자동으로 빈을 등록해주는것 
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
