package com.spring.study.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.study.vo.ScheduleVO;

@Repository
public class ScheduleDAO {

   @Inject
   private SqlSession sqlSession;

   
   public List<ScheduleVO> showSchedule() throws Exception {
      return sqlSession.selectList("scheduleMapper.showSchedule");
   }
   
   public void addSchedule(ScheduleVO vo) throws Exception  {
      sqlSession.insert("scheduleMapper.addSchedule", vo);
   }
}