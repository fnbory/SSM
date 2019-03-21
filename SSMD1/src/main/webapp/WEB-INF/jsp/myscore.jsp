<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${! empty requestScope.score }">
		<c:set var="sco" value="${requestScope.score }"></c:set>
	</c:if>
	数学：<c:out value="${sco.mathScore }"></c:out><br>
	java：<c:out value="${sco.javaScore }"></c:out><br>
	html：<c:out value="${sco.htmlScore }"></c:out><br>
</body>
</html>