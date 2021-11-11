<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
<link href='${pageContext.request.contextPath}/resources/fullcalendar-5/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5/lib/main.js'></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type='text/javascript'>

document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
    googleCalendarApiKey: AIzaSyBQrh6-_Lfl2KJ73AqOI52T89gi-nTT6yo,
    eventSources: [
    {
          googleCalendarId:ik69gl60m4ejh02h2a9q24q31c@group.calendar.google.com,
          className: '웹디자인기능사',
          color: '#be5683', //rgb,#ffffff 등의 형식으로 할 수 있어요.
          //textColor: 'black' 
        },
      {
          googleCalendarId:ik69gl60m4ejh02h2a9q24q31c@group.calendar.google.com,
          className: '정보처리기능사',
            color: '#204051',
            //textColor: 'black' 
        },
      {
          googleCalendarId:ik69gl60m4ejh02h2a9q24q31c@group.calendar.google.com,
          className: '정보처리기사',
            color: '#3b6978',
            //textColor: 'black' 
        }
    ]
  });
  calendar.render();
});
</script>
<style>
#calendar{
   width:60%;
   margin:20px auto;
}
</style>
  </head>
  <title>게시판</title>
  <body>
  <header>
				<h1>꿀팁게시판</h1>
			</header>
    <div id='calendar'></div>
  </body>
</html>