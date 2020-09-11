<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(function() {
		//초기화
	$("[member=gender]").val(["${member.gender}"]);
	$("[nae=hobby]").val("${member.hobby}").replace("[","").replace("]", "").split(","));
	$("[name=mailyn]").val(["${member.mailyn}"]);
	$("#frm[name=job]").val("${member.job}")
	});
</script>
</head>
<body>
<h3>회원 수정</h3>
	${error }
	<form action="${pageContext.request.contextPath }/memberSearch.do">
		<input type="hidden" name="job" value="update">
		id : <input	name="id">
		<button>검색</button>
	</form>
	<c:if test="${not empty member }">
	<h3>검색결과</h3>
	<form>
	<div class="regist"></div>
	<div>
			<label for="id">ID:</label>
			<input type="text" id="id" name="id" value="${member.id }"><br>
		</div>
		<div>
			<label for="pw">Password:</label>
			<input type="password"id="pw" name="pw"  value="${member.pw }"><br>
		</div>
		<div>
			<label for="gender">성별:</label>
			<input type="radio" id="male"name="gender" value="male">
				<label for="male">남</label>
				<input type="radio" id="female" name="gender" value="female">
				<label for="female">여</label><br>
		</div>
		<div>
			<label for="job">직업:</label> <select id="job" name="job">
				<option value="">선택</option>
				<option value="j1">학생</option>
				<option value="j2">주부</option>
				<option value="j3">군인</option>
				<option value="j4">직장인</option>
				<option value="j5">무직</option>
			</select><br>
		</div>
		<div>
			<label for="text">가입동기:</label><br>
			<textarea id="reason"name="reason">${member.reason }</textarea><br>
		</div>
		<div>
			<label for="vehicle1">메일수신여부:</label>
			<input type="checkbox" id="maileyn" name="maileyn" value="${member.maileyn }"><br>
		</div>
		<div>
			<label for="vehicle1">취미:</label>
			<input type="checkbox" id="hobby" name="hobby" value="read">독서
			<input type="checkbox" id="hobby" name="hobby" value="game">게임
			<input type="checkbox" id="hobby" name="hobby" value="ski">스키<br>
		</div>
처리건수 : ${cnt}<br>
id : ${param.id}<br>
	</form>
	</c:if>
</body>
</html>