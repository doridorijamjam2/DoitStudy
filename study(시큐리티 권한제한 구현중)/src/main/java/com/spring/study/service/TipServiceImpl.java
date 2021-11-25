package com.spring.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.study.dao.TipDAO;
import com.spring.study.vo.TipVO;
import com.spring.study.vo.Criteria;
import com.spring.study.vo.SearchCriteria;

@Service
public class TipServiceImpl implements TipService {

	@Inject
	private TipDAO dao;
	
	// 게시글 작성
	@Override
	public void write(TipVO tipVO) throws Exception {
		dao.write(tipVO);
	}
	
	// 게시물 목록 조회
	@Override
	public List<TipVO> list(SearchCriteria scri) throws Exception {

		return dao.list(scri);
	}
	
			
	// 게시물 총 갯수
	@Override
		public int listCount(SearchCriteria scri) throws Exception {
					
			return dao.listCount(scri);
		}
	
	// 게시물 조회
		@Transactional(isolation = Isolation.READ_COMMITTED)
		@Override
		public TipVO read(int bno) throws Exception {
				dao.tipHit(bno);
			return dao.read(bno);
		}
	
	//	게시물 수정
	@Override
	public void update(TipVO tipVO) throws Exception {

		dao.update(tipVO);
	}
	//게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		
		dao.delete(bno);
	}
	
	

}