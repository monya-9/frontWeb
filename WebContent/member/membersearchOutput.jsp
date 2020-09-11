<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 검색</h3>
<form action="">
	<input type="hidden" name="job" value="search">
	id : <input name="${pageContext.request.contextPath }/memberSearch.do">
	<button>검색</button>
</form>
</body>
</html>