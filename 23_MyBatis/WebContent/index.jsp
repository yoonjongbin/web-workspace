<%@page import="model.service.StudentService"%>
<%@page import="model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<StudentVO> list = new StudentService().showAllStudent(null);
request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
<style>
.container .row {
	margin-top: 50px;
	margin-bottom: 30px;
}
</style>
</head>
<body>

	<!-- 
	<form action="find.do" method="post" id="frm">
		<input type="text" name="word" id="word" /> 
		<input type="submit" value="검색" id="submit">
	</form>
	 -->
	<div class="container">
		<div class="row">

			<div class="col">
				<input id="word" type="text" class="form-control">
			</div>

			<div class="col">
				<input id="searchBtn" value="검색" type="button" class="btn btn-dark">
			</div>

		</div>



		<table class="table">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>주소</th>
					<th>전공</th>
					<th>계열</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="student">
					<tr>
						<td>${student.studentNo}</td>
						<td>${student.studentName}</td>
						<td>${student.studentAddr}</td>
						<td>${student.department.deptName}</td>
						<td>${student.department.category}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	<script>
	<!-- 
		$(document).ready(function(){
			$.ajax({
				type : 'post',
				url : 'find.do',
				dataType : $("#frm").serialize(),
				
				success:function(data){
					//console.log(data);
					//const result = eval(`(${data.result})`);
					//console.log(result);
					//$('#resultView').html(`${result.addr}에 사는 ${result.age}살 ${result.name}입니다~~`);
				
				}
			});
		});
	 -->
	 $('#searchBtn').click(function(){
		 const word = $('#word').val();
		 
		 $.ajax({
			type: 'get',
			url: 'find.do',
			data: 'word=' + word,
			dataType: 'json',
			
			success:function(data){
				//console.log(data);
				const result = eval(data.result);
				let resultHtml = '';
				//console.log(result);
				for(let item of result){
					resultHtml += "<tr>" +
								 	"<td>" + item.studentNo + "</td>" +
								  	"<td>" + item.studentName + "</td>" +
								  	"<td>" + item.studentAddr + "</td>" +
								 	"<td>" + item.department.deptName + "</td>" +
								 	"<td>" + item.department.category + "</td>" +
								  "</tr>";
				}
				$('tbody').html(resultHtml);
			}
		 });
	 });
	</script>
</body>
</html>