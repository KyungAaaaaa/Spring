package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	//���� �Ķ���� ex)name,age,name,age,name,age ...
	private List<SampleDTO> list;

	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}
}
