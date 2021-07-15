package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
		//Ž�������� ������������ (default:@ComponentScan�� ���� �������� Ŭ������ ���� ��Ű���� ������ �˻�)
		//������� : ��Ű�� ��ġ�� ���������ʰ�, ���� ���� Ŭ������ ��ġ�� ������Ʈ �ֻ�ܿ� �δ°�.
		
		//Ž���� ��Ű�� ����.�������������� ��~~~�� �ڹ� �ڵ带 ��~~~�˻�
		basePackages = "hello.core", 
		//�ش� Ŭ������ ���� ��Ű���� �˻�
		basePackageClasses = AutoAppConfig.class,
		//@ComponentScan�� ����ϸ� @Configuration�� ���� ���� ������ �� ��ϵǱ� ������ ���� ����.(�ǹ����x)
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
public class AutoAppConfig {

	//�������� �� �̸��� ���� �����ϸ� �������� �ڵ����� �������̵��Ѵ�.
	//������ ��Ʈ�� ���� �����ϸ� �����߻�.
	//�ǵ��ؼ� �������� �������̵��ϴ� ��캸�� �Ǽ��� ��찡 �� ���⶧����..�ֽ� ��Ʈ������ �ش� �ߺ������� ������ �����س�
	@Bean(name = "memoryMemberRepository")
	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
