<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- datepicker -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>
<body>
<div class = "group" id = "popupGroup">   
   <div class = "group-head">
      <h1 class = "zTree-h1"> 일정 추가 </h1>
   </div>
   <div class = "group-body">
   <form id = "scheduleData">
      <div class = "top">
         <input class = "subject" id = "subject" type = "text" name = "subject" placeholder="제목을 입력해주세요">
      </div>
      <div class = "domain">
         <h3 class = "zTree-h3"> 시작 </h3>
      </div>
      <div class = "domain">
         <input class = "date" id = "startDate" type = "text" name = "startDate" id = "startDate">
      </div>
      <div class = "domain">
         <h3 class = "zTree-h3"> 종료 </h3>
      </div>
      <div class = "domain">
         <input class = "date" id = "endDate" type = "text" name = "endDate" id = "endDate">
      </div>
      <script>
        $(function() {
            //모든 datepicker에 대한 공통 옵션 설정
            $.datepicker.setDefaults({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
            });
 
            //input을 datepicker로 선언
            $("#startDate").datepicker();                    
            $("#endDate").datepicker();
            
            //From의 초기값을 오늘 날짜로 설정
            $('#startDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
            //To의 초기값을 내일로 설정
            $('#endDate').datepicker('setDate', '+1D'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
        });
        
        $.fn.serializeObject = function(){
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
               var name = $.trim(this.name),
                  value = $.trim(this.value);
               
                if (o[name]) {
                    if (!o[name].push) {
                        o[name] = [o[name]];
                    }
                    o[name].push(value || '');
                } else {
                    o[name] = value || '';
                }
            });
            return o;
        };
        function click_ok(){

           var scheduleData = JSON.stringify($('form#scheduleData').serializeObject());
           
           $.ajax({
              data : scheduleData,
              url : "addSchedule",
              type : "POST",
              dataType : "json",
              contentType : "application/json; charset=UTF-8",
              success : function(data) {
                 opener.parent.location.reload();
                 window.close();
              }
           });
        };
    </script>
      
      <div class = "domain">
         <h3 class = "zTree-h3"> 메모 </h3>
      </div>
      <div class = "domain">
         <textarea class = "memo" id = "memo" name = "memo" rows = "5" cols = "20" placeholder="100글자까지 입력 가능합니다"></textarea> 
      </div>
   </form>
      <button class = "ok-button" type= "button" onclick="click_ok();">확인</button>
   </div>   
</div>
</body>
</html>