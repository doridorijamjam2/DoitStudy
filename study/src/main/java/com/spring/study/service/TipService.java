package com.spring.study.service;

import java.util.List;

import com.spring.study.vo.TipVO;
import com.spring.study.vo.Criteria;
import com.spring.study.vo.SearchCriteria;

public interface TipService {

	// 게시글 작성
	public void write(TipVO tipVO) throws Exception;
	
	// 게시물 목록 조회
		public List<TipVO> list(SearchCriteria scri) throws Exception;
		
		//게시물 총 갯수
		public int listCount(SearchCriteria scri) throws Exception;
		
		// 게시물 조회
		public TipVO read(int bno) throws Exception;
		
		// 게시물 수정
		public void update(TipVO tipVO) throws Exception;
		
		// 게시물 삭제
		public void delete(int bno) throws Exception;
		
	
}
