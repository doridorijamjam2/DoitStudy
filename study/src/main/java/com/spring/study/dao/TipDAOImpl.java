package com.spring.study.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.study.vo.TipVO;
import com.spring.study.vo.Criteria;
import com.spring.study.vo.SearchCriteria;

@Repository
public class TipDAOImpl implements TipDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 게시글 작성
	@Override
	public void write(TipVO tipVO) throws Exception {
		sqlSession.insert("tipMapper.insert", tipVO);
		
	}
	// 게시물 목록 조회
		@Override
		public List<TipVO> list(SearchCriteria scri) throws Exception {
		
			return sqlSession.selectList("tipMapper.listPage" , scri);
		}
		
		// 게시물 총 갯수
		@Override
		public int listCount(SearchCriteria scri) throws Exception {
			
			return sqlSession.selectOne("tipMapper.listCount", scri);
		}
		
		
		// 게시물 조회
		@Override
		public TipVO read(int bno) throws Exception {
				
			return sqlSession.selectOne("tipMapper.read", bno);
		}
		
		// 게시물 수정
		@Override
		public void update(TipVO tipVO) throws Exception {
			
			sqlSession.update("tipMapper.update", tipVO);
		}

		// 게시물 삭제
		@Override
		public void delete(int bno) throws Exception {
			
			sqlSession.delete("tipMapper.delete", bno);
		}
		
		@Override
		public void tipHit(int bno) throws Exception {
			// TODO Auto-generated method stub
			sqlSession.update("tipMapper.tipHit", bno);
		}

}