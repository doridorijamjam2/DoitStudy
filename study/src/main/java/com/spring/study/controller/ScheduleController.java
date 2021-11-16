package com.spring.study.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.service.ScheduleService;
import com.spring.study.vo.ScheduleVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ScheduleController {
	
	@Inject
	private ScheduleService service;
	
	//일정 관리 페이지
	@RequestMapping(value = "/schedule/schedule")
	public String schedule(Model model)throws Exception {

	   model.addAttribute("showSchedule" , service.showSchedule());
	    
	   return "/schedule/schedule";
	}
	
	//일정 추가 팝업
		@RequestMapping(value = "/schedule/schedulePopup")
		public String test2() throws Exception {
			return "/schedule/schedulePopup";
		}

		//일정 추가 버튼 클릭 Ajax
		@ResponseBody
		@RequestMapping(value = "/schedule/addSchedule", method = RequestMethod.POST)
		public Map<Object,Object> addSchedule(@RequestBody ScheduleVO dto) throws Exception{
			Map<Object,Object>map = new HashMap<Object,Object>();

			service.addSchedule(dto);
		
			return map;
		}

	}
