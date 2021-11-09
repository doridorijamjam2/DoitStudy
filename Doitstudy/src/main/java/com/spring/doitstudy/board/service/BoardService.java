package com.spring.doitstudy.board.service;

import java.util.List;
import java.util.Map;

import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.board.model.ReplyVO;
import com.spring.doitstudy.common.Pagination;
import com.spring.doitstudy.common.Search;

public interface BoardService {

	
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	public List<BoardVO> getBoardList() throws Exception;
	
	public List<BoardVO> getBoardList(Search search) throws Exception;

	public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception;
	
	public BoardVO getBoardContent(int bid) throws Exception;
	
	public void deleteBoard(int bid) throws Exception;
	
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	public int getBoardListCnt(Search search) throws Exception;
	
	  // 댓글 리스트
		public List<ReplyVO> getReplyList(int bid) throws Exception;
		
		public int saveReply(ReplyVO replyVO) throws Exception;
		
		public int updateReply(ReplyVO replyVO) throws Exception;
		
		public int deleteReply(int rid) throws Exception;
	

}
