package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data	//Lombok을 이용해서 getter/setter/toString 생성
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

}
