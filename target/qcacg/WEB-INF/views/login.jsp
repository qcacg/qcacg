﻿<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function ajaxTest(){
			$.ajax({
				data:"telephone="+$("#telephone").val(),
				type:"POST",
				dataType: 'json',
				url:"/login",
				error:function(data){
					alert("出错了！！:"+data.msg);
				},
				success:function(data){
					alert("success:"+data.msg);
					$("#result").html(data.msg) ;
				}
			});
		}
	</script>
</head>
<body>
<input type="text" name="telephone" id="telephone"/>
<input type="text" name="password" id="password"/>
<input type="submit" value="登录" onclick="ajaxTest();"/>
<div id="result"></div>
</body>
</html>
