<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="tip.Tip" %>
<%@ page import="tip.TipDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	int tipID = 0;
	if(request.getParameter("tipID") != null){
		tipID = Integer.parseInt(request.getParameter("tipID"));
	}
	if (tipID == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다..')");
		script.println("location.href = 'tip.jsp'");
		script.println("</script>");
	}
	Tip tip = new TipDAO().getTip(tipID);
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
					<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 20%;"> 글 제목 </td>
					<td colspan="2"><%= tip.getTipTitle() %></td>
				</tr>		
				<tr>
					<td> 작성자 </td>
					<td colspan="2"><%= tip.getUserID() %></td>
				</tr>		
				<tr>
					<td> 작성일자 </td>
					<td colspan="2"><%= tip.getTipDate().substring(0, 11) + tip.getTipDate().substring(11, 13) + "시" + tip.getTipDate().substring(14, 16) + "분" %></td>
				</tr>
				<tr>
					<td> 내용 </td>
				<td colspan="2" style="min-height: 200px; text-align:left;"><%= tip.getTipContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>;") %></td>
				</tr>			
			</tbody>	
			</table>
			<a href="tip.jsp" class="btn btn-primary">목록</a>
			<%
				if(userID != null && userID.equals(tip.getUserID())){
			%>
					<a href="tipupdate.jsp?tipID=<%= tipID %>" class="btn btn-primary"> 수정</a>
					<a href="tipdeleteAction.jsp?tipID=<%= tipID %>" class="btn btn-primary"> 삭제</a>
			<%
				}
			%> 
			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>