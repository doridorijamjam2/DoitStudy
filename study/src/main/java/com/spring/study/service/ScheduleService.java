package com.spring.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.spring.study.dao.ScheduleDAO;
import com.spring.study.vo.ScheduleVO;

@Service
public class ScheduleService {

   @Inject
   private ScheduleDAO dao;
   
   public List<ScheduleVO> showSchedule() throws Exception {
	   
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
      return dao.showSchedule(id);
   }
   
   public void addSchedule(ScheduleVO vo) throws Exception{
	   
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		vo.setUserId(id);
		
      dao.addSchedule(vo);
   }
}
