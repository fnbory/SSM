<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript" src="scripts/jquery.cookie.js"></script>
<script type="text/javascript"> 
$(document).ready(function() {
	var person1=$.cookie("isstu");
	var person2=$.cookie("istec");
	var person=person1==null?person2:person1;
	if(person=="teacher"){
		
		document.getElementById('stu').classList.add('hide');
		document.getElementById('tec').classList.remove('hide');
	}
	else{
		document.getElementById('tec').classList.add('hide');
		document.getElementById('stu').classList.remove('hide');
	}
	
});
</script>
<style>
	.hide{
		display:none
	}
</style>
</head>
<body >
<h2>武汉理工大学教务处</h2><br><br>
<div id="tec">
	<c:if test="${sessionScope.account.ismanager==0 }">
		<a href="listallclass">查看班级名单</a>
		<a href="tecinfo">查看我的信息</a>
	</c:if>
	<c:if test="${sessionScope.account.ismanager==1 }">
		<a href="listtecs">查看老师名单</a>
		<a href="liststus">查看学生名单</a>
	</c:if>
</div >
<div id="stu">
	<a href="listallscore">查看我的成绩</a>
	<a href="stuinfo">查看我的信息</a>
</div>

</body>
</html>