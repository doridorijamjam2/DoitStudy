package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlannerController {
   
   @RequestMapping("/planner/planner")
   public String Calendar() {
      return "/planner/planner";
   }
}
