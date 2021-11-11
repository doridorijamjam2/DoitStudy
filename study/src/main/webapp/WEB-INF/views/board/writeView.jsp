<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='writeForm']");
		$(".write_btn").on("click", function() {
			if (fn_valiChk()) {
				return false;
			}
			formObj.attr("action", "/board/write");
			formObj.attr("method", "post");
			formObj.submit();
		});
	})
	function fn_valiChk() {
		var regForm = $("form[name='writeForm'] .chk").length;
		for (var i = 0; i < regForm; i++) {
			if ($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null) {
				alert($(".chk").eq(i).attr("title"));
				return true;
			}
		}
	}
</script>
<body>
	<div>
		<%@include file="header.jsp"%>
	</div>

	<section id="container">
		<form name="writeForm" method="post" action="/board/write">
			<table>
				<tbody>
					<c:if test="${member.userId != null}">
						<div class="mb-3">
							<label for="title">제목</label> <input id="title" name="title"
								class="form-control chk" placeholder="제목을 입력해 주세요" />
						</div>
						<div class="mb-3">
							<label for="content">내용</label> <input id="content" name="content"
								class="form-control chk" rows="5" placeholder="내용을 입력해 주세요" />
						</div>
						<div class="mb-3">
							<label for="writer">작성자</label> <input id="writer" name="writer"
								class="form-control chk" placeholder="작성자를 입력해 주세요"
								value="${member.userId}" />
						</div>

						<div>
							<button type="submit" class="write_btn btn-sm btn-primary">저장</button>
		
						</div>

					</c:if>
					<c:if test="${member.userId == null}">
						<p>로그인 후에 작성하실 수 있습니다.</p>
					</c:if>

				</tbody>
			</table>
		</form>

	</section>
</body>
</html>