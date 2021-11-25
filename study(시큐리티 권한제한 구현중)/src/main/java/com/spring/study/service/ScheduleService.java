package com.spring.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.study.dao.ScheduleDAO;
import com.spring.study.vo.ScheduleVO;

@Service
public class ScheduleService {

   @Inject
   private ScheduleDAO dao;
   
   public List<ScheduleVO> showSchedule() throws Exception {
      return dao.showSchedule();
   }
   
   public void addSchedule(ScheduleVO vo) throws Exception{
      dao.addSchedule(vo);
   }
}
