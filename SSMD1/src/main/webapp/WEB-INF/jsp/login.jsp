<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript" src="scripts/jquery.cookie.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var a= "${msg}";
	if(a!=null){
		alert(a);
	}
	var userid = $.cookie("userid");
	alert(userid);
	var password = $.cookie("password");
	if(userid!= null && userid != '' && password != null && password != ''){
	    $("#userId").val(userid);
		$("#password").val(password); 
		$("#rememberMe").attr('checked',true);
		if($.cookie("isstu")!=null){
			$("#isstu").attr('checked',true);
		}
		else{
			$("#istec").attr('checked',true);
		}
}
});
function Show(){
    document.getElementById('shade').classList.remove('hide');
    document.getElementById('modal').classList.remove('hide'); 
}
function Hide(){
    document.getElementById('shade').classList.add('hide');
    document.getElementById('modal').classList.add('hide');
}

function  suu(){
	alert($('#rememberMe').prop('checked'));
	if ($('#rememberMe').prop('checked')) {
		$.cookie("rmbUser", "true", { expires: 7,path: '/',secure:false }); //存储一个带7天期限的cookie
		$.cookie("userid", $('#userId').val(), { expires: 7,path: '/',secure:false });
		$.cookie("password", $('#password').val(), { expires: 7 ,path: '/',secure:false});
		if($('#isstu').prop('checked')&&!$('#istec').prop('checked')){
			$.cookie("isstu", "student", { expires: 7 ,path: '/',secure:false});
			$.cookie("istec", "", { expires: -1, path: '/',secure:false});
			return true;
		}
		else if($('#istec').prop('checked')&&!$('#isstu').prop('checked')){
			$.cookie("istec", "teacher", { expires: 7 ,path: '/',secure:false});
			$.cookie("isstu", "", { expires: -1, path: '/',secure:false});
			return true;
		}
		else{
			alert("请选择您的身份：老师或者学生");
			return false;
		}
		}
	else{
		$.cookie("rmbUser", "false", { expire: -1 ,path: '/',secure:false});
		$.cookie("userid", "", { expires: -1 ,path: '/',secure:false});
		$.cookie("password", "", { expires: -1,path: '/',secure:false });
		$.cookie("istec", "", { expires: -1, path: '/',secure:false});
		$.cookie("isstu", "", { expires: -1, path: '/',secure:false});
	}
	return true;

}
</script>
<style>
        .hide{
            display: none;
        }
        .c1{
            position: fixed;
            top:0;
            bottom: 0;
            left:0;
            right: 0;
            background: rgba(0,0,0,.5);
            z-index: 2;
        }
        .c2{
            background-color:infotext;
            position: fixed;
            width: 400px;
            height: 300px;
            top:50%;
            left: 50%;
            z-index: 3;
            margin-top: -150px;
            margin-left: -200px;
        }
		#modal p {
			margin-left:80px;
		}
    </style>
</head>
<body background="imgs/login.jpg">

<div>
    <table>
        <tr>
            <td><input type="button" value="登陆" onclick="Show();"></td>
        </tr>
    </table>
</div>
<div id="shade" class="c1 hide"></div>
<div id="modal" class="c2 hide">
	<form:form action="${ pageContext.request.contextPath }/login" method="post" onsubmit="return suu()">
    <p>用户：<input type="text" name="userId" id="userId"/></p>
    <p>密码：<input type="password"  name="password" id="password"/></p>
  
<p>
    <input id="sub" type="submit" value="确定" >
    <input type="button" value="取消" onclick="Hide();">
</p>
	  </form:form>
	 <p>
        <label class="checkbox-inline"> 
        <input type="checkbox" name="rememberMe" id="rememberMe" />
                              	Remember me
        </label> <span class="pull-right"> <br>
         <input type="checkbox" id="isstu" name="isstu"/><br>
         <input type="checkbox" id="istec" name="istec"/>

	</p>
</div>
 


</body>
</html>