<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$('#insert').click(function() {
		pwd=$("<input type='text'>");
	});
	function delRow(obj){
	    //获取当前对象的父元素，在其下寻找id为“id”的元素的值
	    var userid=$(obj).parents("tr").find("#userid").val();
	   // var id1=$(obj).parents("tr").find("#id").val();
	   //alert(id1)
	    var res=confirm("确定要删除么？");
	    if(res){
	        //删除界面元素，当前行
	        $(obj).parents("tr").remove();
	    }
	    //若有id就表示该数据是界面原本就有的，需要删除数据库数据
	    //若无id表示为界面动态添加的，删除时只需要删除界面元素
	//    if(id1!=null){
	        //ajax删除数据
	        if(userid!=null){
	        $.ajax({
	        	type : "POST",
	            url : "delete_tec_act",
	            data :{"userid":userid}
	        });
	    }
	}
</script>
</head>
<body>
<c:if test="${!empty requestScope.tecs }">
	
	<table border="1">
		<tr>
			<th>工号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>班级</th>
			<th>操作</th>
			<th>删除</th>
		</tr>
		
		<c:forEach items="${requestScope.tecs }" var="t">
			<tr id="id">
				<form action="update_tec_act" method="post" >
					<th>
							${t.userId }
							<input type="hidden" name="_method" value="PUT">
							<input type="hidden" name="userId" value="${t.userId }" id="userid">
					</th>
					<th>
						<input type="text" value="${t.teacher.name }"  name="name" size="2">
					</th>
					<th>
						<input type="text" value="${t.password }"  name="password" size="2">
					</th>
					<th>
						<input type="text" value="${t.teacher.cls }"  name="cls" size="2">
					</th>
					<th>
						<input type="submit" value="保存修改" size="2">
					</th>
					<th>

						<input type="button" onclick="delRow(this)" value="删除" class="dede">
					</th>
				</form>
			</tr>
		</c:forEach>
		<tr>
			<form action="inserttec" method="post">
				<th>
					<input type="text" name="userid" size="2">
				</th>
				<th>
					<input type="text" name="name" size="2">
				</th>
				<th>
					<input type="text" name="password" size="2">
				</th>
				<th>
					<input type="text" name="cls" size="2">
				</th>
				<th>
					<input id="inserttec" type="submit" value="增加" size="2">
				</th>
			</form>
		</tr>
	</table>
</c:if>
<c:if test="${empty requestScope.tecs }">
	<h3>啊哦。。。还没有老师信息哦</h3>
</c:if>

</body>
</html>