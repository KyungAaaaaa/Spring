package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		//문자열로 전달될 날짜파라미터를 Date타입으로 바인딩(자동으로 호출)
//		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dataFormat, false));
//
//	}

	@RequestMapping("")
	public void basic() {
		log.info("basic.....");
	}

	@RequestMapping("/ex01")
	public void ex01(SampleDTO dto) {
		log.info("name = " + dto.getName() + " / age = " + dto.getAge());
	}

	@GetMapping("/ex02")
	public String ex02(SampleDTOList dto) {
		// http://localhost:8080/sample/ex02?list%5B0%5D.name=KKA&list%5B0%5D.age=25&list%5B1%5D.name=KWE&list%5B1%5D.age=4
		// http://localhost:8080/sample/ex02?list%[0].name=KKA&list[0].age=25&list[1].name=KWE&list[1].age=4
		log.info("" + dto);
		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03(@RequestParam("dlfma") String name, @RequestParam("skdl") int age) {
		// @RequestParam : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른경우에 유용하게 사용
		log.info("name = " + name);
		log.info("age = " + age);
		return "ex03";
	}

	@GetMapping("/ex04")
	public String ex04List(@RequestParam("ids") ArrayList<String> ids) {
		// sample/ex04?ids=111&ids=222&ids=333&ids=444
		log.info("ids : " + ids);
		return "ex04List";
	}

	@GetMapping("/ex05")
	public String ex05Array(@RequestParam("ids") String[] ids) {
		// sample/ex04?ids=111&ids=222&ids=333&ids=444
		log.info("array ids : " + Arrays.toString(ids));
		return "ex05Array";
	}

	@GetMapping("/ex06")
	public String ex06(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}

	@GetMapping("/ex07")
	public String ex07(SampleDTO dto, @ModelAttribute("page") int page) {
		// 파라미터로 설정한 SampleDTO 타입은 빈의 규칙에 맞기떄문에 자동으로 화면까지 전달(전달될때는 클래스명 앞글자 소문자)
		// page의경우 기본타입은 화면까지 전달되지않는다.
		log.info("dto : " + dto);
		log.info("page : " + page);

		return "/sample/ex07";
	}

	@RequestMapping("/ex08")
	public void ex08() {
		// return 타입을 void로 할경우 url의 경로를 그대로 jsp파일의 이름으로 연결
		log.info("/ex08..............");
	}

	@RequestMapping("/ex09")
	public @ResponseBody SampleDTO ex09() {
		// return 타입이 객체일경우 JSON데이터를 만들어내는 용도로 사용
		log.info("/ex08..............");
		SampleDTO dto = new SampleDTO();
		dto.setAge(5);
		dto.setName("홍길동");

		return dto;
	}

	@RequestMapping("/ex10")
	public ResponseEntity<String> ex10() {
		// HTTP프로토콜의 헤더를 다루는 경우
		log.info("/ex10..............");

		// {"name": "홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}

}
