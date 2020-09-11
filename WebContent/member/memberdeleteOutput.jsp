<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 삭제</h3>
	${error }
	<form action="">
		<form action="${pageContext.request.contextPath }/memberSearch.do">
		<input type="hidden" name="job" value="delete">
		id : <input	name="id">
	</form>
	<!-- 검색 결과 출력 -->
	<c:if test="${not empty member }">
		<h3>검색 결과</h3>
${member.job }<br>
${member.gender }
${member.id }
<form action="${pageCotext.request.contextPath }/memberDelete.do">
			id : <input
				name="id" value="${member.id }" type="hidden">
			<button>삭제</button>
		</form>
	</c:if>
</body>
</html>