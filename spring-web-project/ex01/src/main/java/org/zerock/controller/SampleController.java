package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic.....");
	}

	@RequestMapping("/ex01")
	public void ex01(SampleDTO dto) {
		log.info("name = " + dto.getName() + " / age = " + dto.getAge());
	}

	@GetMapping("/ex02")
	public String ex02(SampleDTO dto) {
		log.info("" + dto);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("dlfma") String name,@RequestParam("skdl") int age) {
		//@RequestParam  : �Ķ���ͷ� ���� ������ �̸��� ���޵Ǵ� �Ķ������ �̸��� �ٸ���쿡 �����ϰ� ���
		log.info("name = "+name);
		log.info("age = "+age);
		return "ex03";
	}

	// http://localhost:8080/sample/ex02?list%5B0%5D.name=KKA&list%5B0%5D.age=25&list%5B1%5D.name=KWE&list%5B1%5D.age=4
	// http://localhost:8080/sample/ex02?list%[0].name=KKA&list[0].age=25&list[1].name=KWE&list[1].age=4
	@RequestMapping("/ex02")
	public void ex02(SampleDTOList dto) {
		log.info(dto);
	}

}
