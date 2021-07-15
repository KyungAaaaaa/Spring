package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = Configuration.class))
//@ComponentScan을 사용하면 @Configuration가 붙은 설정 정보도 빈에 등록되기 때문에 필터 설정.(실무사용x)
public class AutoAppConfig {
	
	

}
