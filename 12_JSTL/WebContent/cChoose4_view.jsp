<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${param.num eq '1'}">	<%-- if --%>
			안녕하세요.
		</c:when>	
		<c:when test="${param.num eq '2'}">	<%-- else if --%>
			처음 뵙겠습니다.
		</c:when>	
		
		<c:otherwise>						<%-- else --%>
			모르는 사람입니다.
		</c:otherwise>
	</c:choose>

</body>
</html>