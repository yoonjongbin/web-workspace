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
	<h1>회원 검색 결과</h1>
	<ul>
		<li>아이디 : ${vo.id}</li>
		<li>이름 : ${vo.name}</li>
		<li>주소 : ${vo.address}</li>
	</ul>
	
	
	<% MemberVO vo = (MemberVO) request.getAttribute("vo"); %>
	<ul>
		<li>아이디 : <%= vo.getId() %></li>
		<li>이름 : <%= vo.getName() %></li>
		<li>주소 : <%= vo.getAddress() %></li>
	</ul>
</body>
</html>






