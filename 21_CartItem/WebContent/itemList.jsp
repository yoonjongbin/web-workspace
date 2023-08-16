<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.img{
		flex-direction : flex;
		justify-content : space-between; 
	}

	div img{
		width : 25%;
		height : 100px;
	}
</style>
</head>
<body>
	<h1>Fruit Total List</h1>
	<div class="img">
		<c:forEach items="${list}" var="item">
			<span><img src="${item.pictureUrl}"></span>
		</c:forEach>
	</div>



</body>
</html>