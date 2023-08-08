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
	<form action="/UpdateServlet" method="post">
		ID : <input type="text" value="${dto.id}" name="id" id="id" disabled> <br>
		PW : <input type="password" value="${dto.password}" name="pw" id="pw"> <br>
		이름 : <input type="text" value="${dto.name}" name="name" id="name"> <br>
		주소 : <input type="text" value="${dto.address}" name="addr" id="addr"> <br>
		
		<input type="submit" value="send">
	</form>

</body>
</html>