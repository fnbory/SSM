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
<c:if test="${! empty requestScope.stuoftec }">
		<c:set var="sss" value="${requestScope.stuoftec }"></c:set>
老师：<c:out value="${sss.name }" ></c:out><br>
班内学生名单：
<c:set var="stus" value="${sss.students }"></c:set>
<table border="1">
	<tr>
		<th>姓名</th>
		<th>班级</th>
		<th>学号</th>
		<th>java</th>
		<th>数学</th>
		<th>html</th>
		<th>确认修改</th>
	</tr>
	<c:forEach items="${sss.students }" var="scostu">
		<tr>
			<form action="updateScore/${scostu.userId}" method="post">
				<th>${scostu.name }</th>
				<th>${scostu.cls }</th>
				<th>${scostu.userId }
					<input type="hidden" name="_method" value="PUT">
					<input type="hidden" value="${scostu.userId }" name="tec_stu_userid" >
					
				</th>
				
				<th>
					<input type="text" value="${scostu.score.javaScore}"  name="javaScore" size="2">
				</th>
				<th>
					<input type="text" value="${scostu.score.mathScore}" name="mathScore" size="2">
				</th>
				<th>
					<input type="text" value="${scostu.score.htmlScore}" name="htmlScore" size="2">
				</th>
				<th>
					<input type="submit" value="保存修改" size="2">
				</th>
			</form>
		</tr>
	</c:forEach>
</table>
</c:if>
</body>
</html>