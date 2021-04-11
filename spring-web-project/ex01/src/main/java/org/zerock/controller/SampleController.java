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
//		//���ڿ��� ���޵� ��¥�Ķ���͸� DateŸ������ ���ε�(�ڵ����� ȣ��)
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
		// @RequestParam : �Ķ���ͷ� ���� ������ �̸��� ���޵Ǵ� �Ķ������ �̸��� �ٸ���쿡 �����ϰ� ���
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
		// �Ķ���ͷ� ������ SampleDTO Ÿ���� ���� ��Ģ�� �±⋚���� �ڵ����� ȭ����� ����(���޵ɶ��� Ŭ������ �ձ��� �ҹ���)
		// page�ǰ�� �⺻Ÿ���� ȭ����� ���޵����ʴ´�.
		log.info("dto : " + dto);
		log.info("page : " + page);

		return "/sample/ex07";
	}

	@RequestMapping("/ex08")
	public void ex08() {
		// return Ÿ���� void�� �Ұ�� url�� ��θ� �״�� jsp������ �̸����� ����
		log.info("/ex08..............");
	}

	@RequestMapping("/ex09")
	public @ResponseBody SampleDTO ex09() {
		// return Ÿ���� ��ü�ϰ�� JSON�����͸� ������ �뵵�� ���
		log.info("/ex08..............");
		SampleDTO dto = new SampleDTO();
		dto.setAge(5);
		dto.setName("ȫ�浿");

		return dto;
	}

	@RequestMapping("/ex10")
	public ResponseEntity<String> ex10() {
		// HTTP���������� ����� �ٷ�� ���
		log.info("/ex10..............");

		// {"name": "ȫ�浿"}
		String msg = "{\"name\" : \"ȫ�浿\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}

}
