<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
.button1 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.button1 .btn {
  width: 200px;
  height: 200px;
}
h2{
	text-align: center;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			location.href="${pageContext.request.contextPath}/security_logout";
		})
		$("#registerBtn").on("click", function(){
			location.href="member/register";
		})
		
		$("#submit").on("click", function(){
			location.href="board/list";
		})
		
		
		
		$("#memberUpdateBtn").on("click", function(){
			location.href="member/memberUpdateView";
		})
		
		$("#memberDeleteBtn").on("click", function(){
			location.href="member/memberDeleteView";
		})
		
	})
</script>

<body>
<div>
	<%@include file="board/header.jsp" %>
</div>

<div class="container"></br>
  <h2>DO IT STUDY</h2>
	<form action="login_check" method="post">
  <c:if test="${empty pageContext.request.userPrincipal}">
    <div class="form-group">
      <label for="userId">아이디</label>
      <input type="text" class="form-control" id="userId" placeholder="Enter ID" name="userId">
    </div>
    <div class="form-group">
      <label for="userPass">패스워드</label>
      <input type="password" class="form-control" id="userPass" placeholder="Enter password" name="userPass">
    </div>
    <button type="submit" class="btn btn-primary">로그인</button>
    <button id="registerBtn" type="button" class="btn btn-primary">회원가입</button>
    </c:if>
		<c:if test="${not empty pageContext.request.userPrincipal}">
			 <div class = button1>
    <button type="button" id="memberUpdateBtn" class="btn btn-outline-dark">회원정보</button>
    <button type="button" id="memberDeleteBtn" class="btn btn-outline-dark">회원탈퇴</button>
    <button type="button" id="logoutBtn" class="btn btn-outline-dark">로그아웃</button>
    </div>
		</c:if>
		<c:if test="${param.ng == false}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
    
    
  </form>
</div>

</body>
</html>
