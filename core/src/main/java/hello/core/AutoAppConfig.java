package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
		//탐색범위를 정하지않으면 (default:@ComponentScan이 붙은 성정정보 클래스가 속한 패키지를 범위로 검색)
		//권장사항 : 패키지 위치를 지정하지않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는것.
		
		//탐색할 패키지 지정.지정하지않을시 모~~~든 자바 코드를 다~~~검색
		basePackages = "hello.core", 
		//해당 클래스가 속한 패키지를 검색
		basePackageClasses = AutoAppConfig.class,
		//@ComponentScan을 사용하면 @Configuration가 붙은 설정 정보도 빈에 등록되기 때문에 필터 설정.(실무사용x)
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
public class AutoAppConfig {

	//수동으로 빈 이름을 같게 생성하면 수동빈이 자동빈을 오버라이딩한다.
	//스프링 부트를 통해 실행하면 오류발생.
	//의도해서 수동빈을 오버라이딩하는 경우보다 실수인 경우가 더 많기때문에..최신 부트에서는 해당 중복생성을 오류로 지정해놈
	@Bean(name = "memoryMemberRepository")
	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
