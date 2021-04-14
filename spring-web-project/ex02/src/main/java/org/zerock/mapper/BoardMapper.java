package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	//등록
	public void insert(BoardVO boardVO);
	
	//등록과 동시에 시퀀스값 알아오기
	public void insertSelectKey(BoardVO boardVO);
}
