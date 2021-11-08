package com.spring.doitstudy.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.doitstudy.board.dao.BoardDAO;
import com.spring.doitstudy.board.model.BoardVO;
import com.spring.doitstudy.common.Pagination;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return boardDAO.getBoardList(pagination);
	}
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	
	@Override
	public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
		return null;
	}
	
	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception{
		BoardVO boardVO = new BoardVO();
		 
		boardDAO.updateViewCnt(bid);
		boardVO = boardDAO.getBoardContent(bid);        //주석을 풀어 줍니다.
  //   예외처리 테스트가 끝났으므로 아래 구문은 삭제 하거나 주석 처리 합니다.
	//    try {
	//		boardVO.setBid(bid);
	//		boardVO.setCate_cd("1111111111111111111111111111111111111");
	//		boardDAO.updateBoard(boardVO);
	//	} catch (RuntimeException e) {
	//		throw new NotFoundException();
	//	}

		return boardVO;
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		 boardDAO.deleteBoard(bid);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
	boardDAO.updateBoard(boardVO);
	}
	
	  //총 게시글 개수 확인
		@Override
		public int getBoardListCnt() throws Exception {
			return boardDAO.getBoardListCnt();
		}
		
	
}
