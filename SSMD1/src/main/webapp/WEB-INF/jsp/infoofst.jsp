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
<c:if test="${! empty requestScope.student }">
		<c:set var="stu" value="${requestScope.student }"></c:set>
<c:out value="${stu.userId }" ></c:out><br>
<c:out value="${stu.name }"></c:out><br>
<c:out value="${stu.sex }"></c:out><br>
<c:out value="${stu.age }"></c:out><br>
<c:out value="${stu.phone }"></c:out><br>
<a href="UpdateInfo/${stu.userId }" >修改信息</a>
</c:if>
<c:if test="${! empty requestScope.teacher }">
		<c:set var="tec" value="${requestScope.teacher }"></c:set>
<c:out value="${tec.userId }" ></c:out><br>
<c:out value="${tec.name }"></c:out><br>
<c:out value="${tec.sex }"></c:out><br>
<c:out value="${tec.cls }"></c:out><br>
<a href="UpdateInfo/${tec.userId }" >修改信息</a>
</c:if>

</body>
</html>