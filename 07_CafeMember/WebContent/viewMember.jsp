<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.MemberVO" %>
<%@ page import="java.util.List" %>
<!-- % % :: Script Element -->
<%
	String name = request.getParameter("name");
	//List<MemberVO> list = (List) application.getAttribute("list");
	List<MemberVO> list = (List) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- %= % :: Expression Element -->
	<% for(int i=0; i<list.size(); i++) { %>
	<p> <%= i+1 %> 번째 회원 </p>		
	<p>이름 : <%= list.get(i).getName() %> </p>
	<p>나이 : <%= list.get(i).getAge() %> </p>
	<p>주소 : <%= list.get(i).getAddr() %> </p>
	<% } %>  <!-- 내가 한거 -->
	
	<hr>
	
	<!-- 강사님이 한거 -->
	
	<div class="container">
		<h2>회원조회</h2>
		
		<form action="search">
			검색할 회원 이름을 입력해주세요
			<input type="text" name="name">
			<input type="submit" value="조회">
		</form>
		
		<hr>
		
		<h2>전체 Cafe 명단 리스트</h2>
		
		<table class="table" border="1">
		<tr>
			<th>번호표</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		
		<%	if(list!=null){
			for(int i = 0; i<list.size(); i++){ %>
				<tr>
					<td><%= i + 1 %>번째 손님</td>
					<td><%= list.get(i).getName()%></td>
					<td><%= list.get(i).getAge()%></td>
					<td><%= list.get(i).getAddr()%></td>
				</tr>
			
		<%	
			}}
		%>
		</table>
	</div>
</body>
</html>