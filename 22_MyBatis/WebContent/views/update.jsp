<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%-- ${dto.id}--%>
	<form action="/update.do" method="post">
		<%-- ID : <input type="text" value="${dto.id}" name="id" id="id" disabled> <br> --%>
		ID : <input type="text" value="${vo.id}" name="id" id="id" readonly> <br>
		PW : <input type="password" value="${vo.pw}" name="pw" id="pw"> <br>
		이름 : <input type="text" value="${vo.name}" name="name" id="name"> <br>
		주소 : <input type="text" value="${vo.addr}" name="addr" id="addr"> <br>
		
		<input type="submit" value="send">
	</form>
	
	
	<h2>비밀번호만 변경</h2>
	
	<form action="/update.do" method="post">
		ID : <input type="text" value="${vo.id}" name="id" id="id" readonly> <br>
		PW : <input type="password" value="${vo.pw}" name="pw" id="pw"> <br>
		<input type="submit" value="send">
	</form>

</body>
</html>