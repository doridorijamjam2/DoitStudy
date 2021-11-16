<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "com.spring.study.vo.ScheduleVO" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>

<%
	@SuppressWarnings("unchecked")
	List<ScheduleVO> list = (ArrayList<ScheduleVO>)request.getAttribute("showSchedule");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset='utf-8' />
<link href='/resources/fullcalendar-5.10.1/lib/main.css' rel='stylesheet' />
<script src='/resources/fullcalendar-5.10.1/lib/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	
          initialView: 'dayGridMonth', 
          events: [
        	  <% 
        	         for (int i = 0; i < list.size(); i++) {
        	            ScheduleVO vo = (ScheduleVO)list.get(i);
        	  %>   
        	         {
        	          title : '<%= vo.getSubject() %>',
        	          start : '<%= vo.getStartDate() %>',
        	          end : '<%= vo.getEndDate() %>'
        	          },
        	  <%
        	     }
        	  %>
        	        {
        	           title : 'default',
        	           start : "2019-01-01",
        	           end : "2019-01-01"
        	          }
        	        ]
        	      });

        calendar.render();
      });
      
      function click_add() {
    	   var url = "schedulePopup";
    	   var name = "schedulePopup";
    	   var option = "width = 600, height = 600 left = 100, top=50,location=no";
    	   window.open(url,name,option)
    	};
    	

    </script>
 <style>
.add-button {
    position: absolute;
    top: 1px;
    right: 230px;
    background: #2C3E50;
    border: 0;
    color: white;
    height: 35px;
    border-radius: 3px;
    width: 157px;
}
</style>
  </head>
  <div>
		<%@include file="header.jsp" %>	
	</div>
  <body>
	 <div id='calendar' style="position : relative;">
      <button class = "add-button" type = "button" 
           onclick="click_add();">일정 추가</button>
</div>
  </body>
</html>