package com.spring.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.study.dao.TipReplyDAO;
import com.spring.study.vo.TipReplyVO;

@Service
public class TipReplyServiceImpl implements TipReplyService{
	
	@Inject
	private TipReplyDAO dao;
	
	@Override
	public List<TipReplyVO> readReply(int bno) throws Exception {
		return dao.readReply(bno);
	}
	
	@Override
	public void writeReply(TipReplyVO vo) throws Exception {
		dao.writeReply(vo);
	}
	
	//댓글 수정
	@Override
	public void updateReply(TipReplyVO vo) throws Exception {
		dao.updateReply(vo);
	}
	
	//댓글 삭제
	@Override
	public void deleteReply(TipReplyVO vo) throws Exception {
		dao.deleteReply(vo);
	}
	
	//선택된 댓글 조회
	@Override
	public TipReplyVO selectReply(int rno) throws Exception {
		return dao.selectReply(rno);
	}
	
	
}
