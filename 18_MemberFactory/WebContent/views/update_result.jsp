<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty vo}">
			<h3>${vo.name}님의정보를 수정했습니다.</h3>
			<a href="../index.jsp">메인화면으로 돌아가기</a>
		</c:when>

		<c:otherwise>
			<h3>수정실패!</h3>
			<a href="../index.jsp">메인화면으로 돌아가기</a>
		</c:otherwise>

	</c:choose>

	
</body>
</html>