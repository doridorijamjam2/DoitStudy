package com.spring.study.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.study.vo.TipReplyVO;

@Repository
public class TipReplyDAOImpl  implements TipReplyDAO{
	
	@Inject SqlSession sql;
	
	//댓글조회
	@Override
	public List<TipReplyVO> readReply(int bno) throws Exception {
		return sql.selectList("tipreplyMapper.readReply", bno);
	}
	
	//댓글 작성
	@Override
	public void writeReply(TipReplyVO vo) throws Exception {
		sql.insert("tipreplyMapper.writeReply", vo);
	}
	
	//댓글수정
	@Override
	public void updateReply(TipReplyVO vo) throws Exception{
		sql.update("tipreplyMapper.updateReply", vo);
	}
	
	//댓글 삭제
	public void deleteReply(TipReplyVO vo) throws Exception{
		sql.delete("tipreplyMapper.deleteReply", vo);
	}
	
	//선택된 댓글 조회
	public TipReplyVO selectReply(int rno) throws Exception{
		return sql.selectOne("tipreplyMapper.selectReply", rno);
	}

}
