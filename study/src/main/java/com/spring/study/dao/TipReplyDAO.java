package com.spring.study.dao;

import java.util.List;

import com.spring.study.vo.TipReplyVO;

public interface TipReplyDAO {
	
	//댓글 조회
	public List<TipReplyVO> readReply(int bno) throws Exception;
	
	//댓글 작성
	public void writeReply(TipReplyVO vo) throws Exception;
	
	//댓글 수정
	public void updateReply(TipReplyVO vo) throws Exception;
	
	//댓글 삭제
	public void deleteReply(TipReplyVO vo) throws Exception;
	
	//선택된 댓글 조
	public TipReplyVO selectReply(int rno) throws Exception;

}
