<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${! empty requestScope.studt }">
	<form:form action="${pageContext.request.contextPath}/operate" method="POST" modelAttribute="studt"> 
		<form:hidden path="id"/>
		<form:hidden path="userId"/>
		<input type="hidden" name="_method" value="PUT">
		name:<form:input path="name"/><br>
		sex:<form:input path="sex"/><br>
		age:<form:input path="age"/><br>
		phone:<form:input path="phone"/><br>
		<input type="submit" value="Submit"> 
	</form:form>
</c:if>
<c:if test="${! empty requestScope.teach }">
	<form:form action="${pageContext.request.contextPath}/operate" method="POST" modelAttribute="teach"> 
		<form:hidden path="id"/>
		<form:hidden path="userId"/>
		<input type="hidden" name="_method" value="PUT">
		name:<form:input path="name"/><br>
		sex:<form:input path="sex"/><br>
		cls:<form:input path="cls"/>
		<input type="submit" value="Submit"> 
	</form:form>
</c:if>
</body>
</html>