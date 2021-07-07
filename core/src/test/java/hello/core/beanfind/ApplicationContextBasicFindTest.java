package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;

public class ApplicationContextBasicFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("�� �̸����� ��ȸ")
	public void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		// System.out.println("memberService = "+memberService);
		// System.out.println("memberService.getClass() = "+memberService.getClass());
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("�̸����� Ÿ�����θ� ��ȸ")
	public void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("��ü Ÿ������ ��ȸ")
	public void findBeanByName2() {
		// AppConfig �� returnŸ���� MemberService �������̽�����
		// Bean�� ��ϵ� �ν��Ͻ� Ÿ������ ���� �����ϱ⶧���� ��ü������ ��� ���
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("�� �̸����� ��ȸX")
	public void findBeanByNameX() {
		//�ι�° ���ڷ� �� ������ ����Ǿ�����, ù��° Exception�� ������ �׽�Ʈ ���
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxx", MemberService.class));
	}
}
