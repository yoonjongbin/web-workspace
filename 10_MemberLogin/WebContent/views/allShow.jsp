<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.vo.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저들 출력</title>
</head>
<body>
	<% ArrayList<MemberDTO> list = (ArrayList) session.getAttribute("memList"); %>
	<h1>현재 유저현황</h1>
	
	<hr>
	
	<% for(MemberDTO member : list) {%>
	<p>이름 : <%= member.getName() %></p>
	<p>주소 : <%= member.getAddr() %></p>
	<% } %>

</body>
</html>