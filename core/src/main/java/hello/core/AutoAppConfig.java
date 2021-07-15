package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = Configuration.class))
//@ComponentScan�� ����ϸ� @Configuration�� ���� ���� ������ �� ��ϵǱ� ������ ���� ����.(�ǹ����x)
public class AutoAppConfig {
	
	

}
