<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="tip.TipDAO"%>
<%@ page import="tip.Tip"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a:hover{
	color: #000000;
	text-decoration: none;
	}
</style>

</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	int pageNumber = 1;
	if(request.getParameter("pageNumber") != null){
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));		
	}
	%>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">DO IT! STUDY</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			<li><a href="main.jsp">메인</a></li>
				<li><a href="planner.jsp">스터디 플래너</a></li>
				<li class="active"><a href="tip.jsp">꿀팁 게시판</a></li>
				<li><a href="bbs.jsp">자유 게시판</a></li>
				<li><a href="rank.jsp">랭킹</a></li>
			</ul>
			<%
			if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">로그인<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
				}else{
			%>
				<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="botton" aria-haspopup="true"
					aria-expanded="false">마이페이지<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			
			<%	
				}
			%>

		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid = #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">번호</th>
					<th style="background-color: #eeeeee; text-align: center;">제목</th>
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>
					<th style="background-color: #eeeeee; text-align: center;">작성일</th>
				</tr>
			</thead>
			<tbody>
			<%
				TipDAO tipDAO = new TipDAO();
				ArrayList<Tip> list = tipDAO.getList(pageNumber);
				for(int i = 0; i < list.size(); i++){
			%>
			<tr>
				<td><%= list.get(i).getTipID() %></td>
				<td><a href="tipview.jsp?tipID=<%= list.get(i).getTipID() %>"><%= list.get(i).getTipTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>;") %></a></td>
				<td><%= list.get(i).getUserID() %></td>
				<td><%= list.get(i).getTipDate().substring(0, 11) + list.get(i).getTipDate().substring(11, 13) + "시" + list.get(i).getTipDate().substring(14, 16) + "분" %></td>
			</tr>
			
			<%
				}
			%>
			</tbody>	
			</table>
			<%
				if(pageNumber != 1){
			%>
				<a href="tip.jsp?pageNumber=<%=pageNumber - 1 %>" class="btn btn-success btn-arrow-letf">이전</a>
			<%
				}if(tipDAO.nextPage(pageNumber + 1)){
			%>
				<a href="tip.jsp?pageNumber=<%=pageNumber + 1 %>" class="btn btn-success btn-arrow-left">다음</a>			
			<%
				}
			%>
			<a href="tipwrite.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>