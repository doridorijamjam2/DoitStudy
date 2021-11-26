package com.spring.study.vo;

public class ScheduleVO {
	   private String userId;
	   private int num;
	   private String subject;
	   private String startDate;
	   private String endDate;
	   
	   
	   
       public String getUserId() {
		return userId;
	   }
	   public void setUserId(String userId) {
		this.userId = userId;
	   }
	   public int getNum() {
		return num;
	   }
       public void setNum(int num) {
		this.num = num;
	   }
	   public String getSubject() {
	      return subject;
	   }
	   public void setSubject(String subject) {
	      this.subject = subject;
	   }
	   public String getStartDate() {
	      return startDate;
	   }
	   public void setStartDate(String startDate) {
	      this.startDate = startDate;
	   }
	   public String getEndDate() {
	      return endDate;
	   }
	   public void setEndDate(String endDate) {
	      this.endDate = endDate;
	   }
	 
	}