<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tip.TipDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="tip" class="tip.Tip" scope="page" />
<jsp:setProperty name="tip" property="tipTitle" />
<jsp:setProperty name="tip" property="tipContent" />
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
	} else {

		if (tip.getTipTitle() == null || tip.getTipContent() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {

			TipDAO tipDAO = new TipDAO();
			int result = tipDAO.write(tip.getTipTitle(), userID, tip.getTipContent());
			if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('글쓰기에 실패했습니다.')");
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
	}
	%>

</body>
</html>