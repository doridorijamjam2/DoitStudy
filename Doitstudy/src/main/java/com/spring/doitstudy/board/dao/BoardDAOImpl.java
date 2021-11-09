package com.spring.doitstudy.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.board.model.ReplyVO;
import com.spring.doitstudy.common.Pagination;
import com.spring.doitstudy.common.Search;

@Repository

public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return sqlSession.selectList("com.spring.doitstudy.board.boardMapper.getBoardList", pagination);
	}
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return sqlSession.selectList("com.spring.doitstudy.board.boardMapper.getBoardList");
	}
	
	  @Override
		public List<BoardVO> getBoardList(Search search) throws Exception {
			return sqlSession.selectList("com.spring.doitstudy.board.boardMapper.getBoardList", search);
		}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		return sqlSession.selectOne("com.spring.doitstudy.board.boardMapper.getBoardContent", bid);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("com.spring.doitstudy.board.boardMapper.insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("com.spring.doitstudy.board.boardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		return sqlSession.insert("com.spring.doitstudy.board.boardMapper.deleteBoard", bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		return sqlSession.update("com.spring.doitstudy.board.boardMapper.updateViewCnt", bid);
	}
	
	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("com.spring.doitstudy.board.boardMapper.getBoardListCnt", search);
	}
	
	 // 댓글 리스트
		@Override
		public List<ReplyVO> getReplyList(int bid) throws Exception {
			return sqlSession.selectList("com.spring.doitstudy.board.replyMapper.getReplyList", bid);
		}

		@Override
		public int saveReply(ReplyVO replyVO) throws Exception {
			return sqlSession.insert("com.spring.doitstudy.board.replyMapper.saveReply", replyVO);
		}

		@Override
		public int updateReply(ReplyVO replyVO) throws Exception {
			return sqlSession.update("com.spring.doitstudy.board.replyMapper.updateReply", replyVO);
		}

		@Override
		public int deleteReply(int rid) throws Exception {
			return sqlSession.delete("com.spring.doitstudy.board.replyMapper.deleteReply", rid);
		}

}
