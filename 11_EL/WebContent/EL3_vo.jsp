<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberVO" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO vo = new MemberVO("user1", "pass1", "유저", "강남");
		request.setAttribute("vo", vo);
		
		ArrayList<MemberVO> list =new ArrayList<>();
		MemberVO vo2 = new MemberVO("user2", "pass2", "유저2", "강남2");
		
		
		list.add(vo);
		list.add(vo2);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("EL3_view.jsp").forward(request, response);
	%>
</body>
</html>