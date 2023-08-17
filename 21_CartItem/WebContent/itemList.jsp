<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	h1{
		text-align: center;
	}
	#container{
		display: flex;
		justify-content: center;
	}
	
	#container img{
		height: 200px;
		width: 200px; 
		object-fit: cover;
	}
	
	h2{
		text-align: center;
	}
	
	table{
		margin: 0 auto;
	}
	
	table img{
		width : 100px;
		height : 100px;
		object-fit: cover;
	}
</style>
</head>
<body>
	<h1>Fruit Total List</h1>
	<div id="container">
		<c:forEach items="${list}" var="fruit">
			<div>
				<a	href="itemView.do?id=${fruit.itemId}">
					<img src="${fruit.pictureUrl}">
				</a>
				<p>상품명 : ${fruit.itemName}</p>
				<p>가격 : ${fruit.price}원</p>
			</div>
		</c:forEach>
	</div>
	
	<!-- 오늘 본 상품 -->
	
	<c:if test="${not empty fruits}">
		<hr>
		<h2>오늘 본 상품들</h2>
		<table>
			<tr>
				<c:forEach items="${fruits}" var="fruit">
					<td>
						<img src="${fruit}">
					</td>
				</c:forEach>
			</tr>
		</table>
	</c:if>



</body>
</html>