<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
	<title>회원가입 페이지</title>
</head>
<body>
<form action="/join" method="post">
	<sec:csrfInput/>
	<input type="text" name="id" placeholder="아이디" />
	<input type="password" name="password" placeholder="비밀번호" />
	<input type="password" name="confirmPassword" placeholder="비밀번호 확인" />
	<input type="email" name="email" placeholder="이메일" />
	<input type="text" name="phone" placeholder="전화번호(-없이)" />
	<button>회원가입</button>
</form>
</body>
</html>
