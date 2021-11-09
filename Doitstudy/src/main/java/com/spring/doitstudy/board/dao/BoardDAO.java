package com.spring.doitstudy.board.dao;

import java.util.List;



import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.board.model.ReplyVO;
import com.spring.doitstudy.common.Pagination;
import com.spring.doitstudy.common.Search;

public interface BoardDAO {


	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	public List<BoardVO> getBoardList() throws Exception;
	
	public List<BoardVO> getBoardList(Search search) throws Exception;

	
	public BoardVO getBoardContent(int bid) throws Exception;

	
	public int insertBoard(BoardVO boardVO) throws Exception;

	
	public int updateBoard(BoardVO boardVO) throws Exception;

	
	public int deleteBoard(int bid) throws Exception;

	
	public int updateViewCnt(int bid) throws Exception;
	
	
	public int getBoardListCnt(Search search) throws Exception;
	
	// 댓글 리스트
		public List<ReplyVO> getReplyList(int bid) throws Exception;
		
		public int saveReply(ReplyVO replyVO) throws Exception;
		
		public int updateReply(ReplyVO replyVO) throws Exception;
		
		public int deleteReply(int rid) throws Exception;




}

