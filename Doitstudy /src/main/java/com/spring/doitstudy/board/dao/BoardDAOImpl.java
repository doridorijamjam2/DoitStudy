package com.spring.doitstudy.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.common.Pagination;

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
		public int getBoardListCnt() throws Exception {
			return sqlSession.selectOne("com.spring.doitstudy.board.boardMapper.getBoardListCnt");
		}

}
