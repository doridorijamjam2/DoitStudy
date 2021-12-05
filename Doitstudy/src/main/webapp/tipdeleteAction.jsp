<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tip.TipDAO"%>
<%@ page import="tip.Tip" %>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DO IT! STUDY</title>
</head>
<body>
	<%
	//로그인 된 아이디는 또 로그인을 할수없게 만듬
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	if (userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
	} 
	int tipID = 0;
	if(request.getParameter("tipID") != null){
		tipID = Integer.parseInt(request.getParameter("tipID"));
	}
	
	if(tipID == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다..')");
		script.println("location.href = 'tip.jsp'");
		script.println("</script>");
	}
	Tip tip = new TipDAO().getTip(tipID);
	if(!userID.equals(tip.getUserID())){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다.')");
		script.println("location.href = 'tip.jsp'");
		script.println("</script>");
	} else {
			TipDAO tipDAO = new TipDAO();
			int result = tipDAO.delete(tipID);
			if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글삭제가 실패했습니다.')");
		script.println("history.back()");
		script.println("</script>");
		} 
		else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'tip.jsp'");
		script.println("</script>");
			}
		}
	%>

</body>
</html>