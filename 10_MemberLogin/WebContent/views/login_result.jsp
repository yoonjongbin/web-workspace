<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.vo.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<% MemberDTO dto_login = (MemberDTO) session.getAttribute("dto_login"); %>
	<p>아이디: <%= dto_login.getId() %></p>
	<p>비밀번호: <%= dto_login.getPw() %></p>
</body>
</html>