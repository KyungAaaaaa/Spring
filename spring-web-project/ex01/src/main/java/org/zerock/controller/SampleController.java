package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

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
		//@RequestParam  : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른경우에 유용하게 사용
		log.info("name = "+name);
		log.info("age = "+age);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04List(@RequestParam("ids")ArrayList<String> ids) {
		//sample/ex04?ids=111&ids=222&ids=333&ids=444
		log.info("ids : "+ids);
		return "ex04List";
	}


	@GetMapping("/ex05")
	public String ex05Array(@RequestParam("ids") String[] ids) {
		//sample/ex04?ids=111&ids=222&ids=333&ids=444
		log.info("array ids : "+Arrays.toString(ids));
		return "ex05Array";
	}
	
	// http://localhost:8080/sample/ex02?list%5B0%5D.name=KKA&list%5B0%5D.age=25&list%5B1%5D.name=KWE&list%5B1%5D.age=4
	// http://localhost:8080/sample/ex02?list%[0].name=KKA&list[0].age=25&list[1].name=KWE&list[1].age=4


}
