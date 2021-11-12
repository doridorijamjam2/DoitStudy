<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
<!-- fullcalender -->
<link href='/resources/fullcalendar-5.10.1/lib/main.css' rel='stylesheet' />
<script src='/resources/fullcalendar-5.10.1/lib/main.js'></script>
<script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
       // 이벤트
          events: [
          {
          title: 'All Day Event',
          start: '2021-07-01',
          },
          {
          title: 'Long Event',
          start: '2021-07-07',
          end: '2021-07-10'
          },
          {
          groupId: 999,
          title: 'Repeating Event',
          start: '2021-07-09T16:00:00'
          },
          {
          groupId: 999,
          title: 'Repeating Event',
          start: '2021-07-16T16:00:00'
          },
          {
          title: 'Conference',
          start: '2021-07-11',
          end: '2021-07-13'
          },
          {
          title: 'Meeting',
          start: '2021-07-12T10:30:00',
          end: '2021-07-12T12:30:00'
          },
          {
          title: 'Lunch',
          start: '2021-07-12T12:00:00'
          },
          {
          title: 'Meeting',
          start: '2021-07-12T14:30:00'
          },
          {
          title: 'Happy Hour',
          start: '2021-07-12T17:30:00'
          },
          {
          title: 'Dinner',
          start: '2021-07-12T20:00:00'
          },
          {
          title: 'Birthday Party',
          start: '2021-07-13T07:00:00'
          },
          {
          title: 'Click for Google',
          url: 'http://google.com/', // 클릭시 해당 url로 이동
          start: '2021-07-28'
          }
          ]
        	      });

        	      calendar.render();
        	  });
        	  </script>
    <title>Insert title here</title>
  </head>
  <body>
  	<div>
		<%@include file="header.jsp" %>	</br>
	</div>
    <div id='calendar' style="position : relative;">
   <div>
     <button class = "add-button" type = "button" onclick="click_add();">일정 추가</button>
   </div>
</div>
  </body>
</html>





<!-- let calendar = new Calendar(calendarEl, {
  plugins: [ googleCalendarPlugin ],
  googleCalendarApiKey: '<YOUR API KEY>',
  events: {
    googleCalendarId: 'abcd1234@group.calendar.google.com',
    className: 'gcal-event' // an option!
  }
}); -->