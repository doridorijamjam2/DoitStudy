package com.spring.doitstudy.board.service;

import java.util.List;
import java.util.Map;

import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.common.Pagination;

public interface BoardService {

	
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	public List<BoardVO> getBoardList() throws Exception;

	public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception;
	
	public BoardVO getBoardContent(int bid) throws Exception;
	
	public void deleteBoard(int bid) throws Exception;
	
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	public int getBoardListCnt() throws Exception;
	

}

