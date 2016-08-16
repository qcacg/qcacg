<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>qcacg - 登录</title>
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>
	<style type="text/css">
	.login-error{font-size: 12px;color:red;}
	</style>
</head>

<body class="signin">
 <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <strong>还没有账号？ <a href="register.html">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="login.shtml">
                    <input type="text" class="form-control uname" name="telephone" value="15067171806" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" name="passWord" value="123456" placeholder="密码" />
                    <p class="login-error">${LOGIN_ERROR_CODE}&nbsp;&nbsp;${LOGIN_ERROR_MESSAGE}</p>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>

    </div>
</body>

</html>