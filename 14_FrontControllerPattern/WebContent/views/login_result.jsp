<%@page import="servlet.model.vo.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty vo}">
		<h1>로그인 정보</h1>
		<ul>
			<li>아이디 : ${vo.id}</li>
			<li>이름 : ${vo.name}</li>
			<li>주소 : ${vo.address}</li>
		</ul>
		<a href="/index.jsp">첫 페이지로 이동</a>
		</c:when>
		
		<c:otherwise>
		<h3>로그인 실패..! 로그인부터 하고 오세요</h3>
		<a href="login.html">login.html</a>
		</c:otherwise>
	
	</c:choose>
	
	
	
	<% 
	MemberVO vo = (MemberVO) session.getAttribute("vo"); 
		if(vo!=null) {
	%>
		<h1>로그인 정보</h1>
		<ul>
			<li>아이디 : <%= vo.getId() %></li>
			<li>이름 : <%= vo.getName() %></li>
			<li>주소 : <%= vo.getAddress() %></li>
		</ul>
		<a href="/index.jsp">첫 페이지로 이동</a>
	<% } else { %>
		<h3>로그인 실패..! 로그인부터 하고 오세요</h3>
		<a href="login.html">login.html</a>
	<% } %>
</body>
</html>