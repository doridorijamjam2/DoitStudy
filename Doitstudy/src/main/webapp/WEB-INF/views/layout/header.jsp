<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- common CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/common/css/common.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--메뉴바 추가 부분-->
<!-- 상단 메뉴바{s} -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">DoitStudy</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExample03">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
        <a class="nav-link" href="/board/getBoardList">메인</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/board/getBoardList">꿀팁게시판</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/board/getBoardList">자유게시판</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/board/getBoardList">꿀팁</a>
      </li>
    </ul>
    		<ul class="nav navbar-nav navbar-right">
				    <li class="nav-item">
        <a class="nav-link" href="/user/loginForm">로그인</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/user/joinForm">회원가입</a>
      </li>
			</ul>
  </div>
</nav>
<!-- 상단 메뉴바{e} -->