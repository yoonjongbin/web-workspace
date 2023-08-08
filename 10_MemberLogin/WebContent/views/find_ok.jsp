<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.vo.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<% MemberDTO searchMem = (MemberDTO) session.getAttribute("searchMem"); %>
	
	<p>회원 아이디 : <%= searchMem.getId() %></p>
	<p>회원 이름 : <%= searchMem.getName() %></p>
	<p>회원주소 : <%= searchMem.getAddr() %></p>
	
</body>
</html>