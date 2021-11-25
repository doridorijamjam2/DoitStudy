<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script src="http://code.jquery.com/jquery-latest.min.js"></script> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
.collapse .nav .navs {
	margin-left: 5px
}
</style>

<!--메뉴바 추가 부분-->
<!-- 상단 메뉴바{s} -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark ">
		<a class="navbar-brand" href="/main/main">DO IT! STUDY</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"   ></span>
		</button>
		<div class="collapse navbar-collapse"   id="collapsibleNavbar">
		<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link"  href="/main/main">메인</a></li>
				<li class="nav-item"><a class="nav-link" href="/schedule/schedule">스터디 플래너</a></li>
				<li class="nav-item"><a class="nav-link" href="/tip/list">꿀팁 게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/list">자유 게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="/rank">랭킹</a></li>
			</ul>
			<c:choose>
				<c:when test="${member == null}">
				<div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
				<ul class="navbar-nav float-right" >
						<li class="nav-item"><a class="nav-link"  href="/">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/register">회원가입</a></li>
					</ul>
					</div>
				</c:when>
				<c:otherwise>
				<div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/member/memberUpdateView">회원정보</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a></li>
					</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
<!-- 상단 메뉴바{e} -->