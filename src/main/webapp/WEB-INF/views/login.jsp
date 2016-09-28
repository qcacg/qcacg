<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录 - 轻悦轻小说</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/login_files/moe.f9e95134.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/login_files/login.29a3b59b.css">
		<script src="${pageContext.servletContext.contextPath}/js/jquery-1.9.1.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.12.3.min.js"></script>
		<script src="http://static.geetest.com/static/tools/gt.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/main.css" />
		<link rel="shortcut icon" href="http://www.qcacg.com/favicon.ico" type="image/x-icon" />

	</head>
	<body>

	<%@ include file="public-header.jsp" %>
		 
		<div id="content" class="content" style="min-height: 270px;padding-bottom: 70px;box-sizing: border-box;">
			<div class="container">
				<div class="block-img">
					<div id="bg-login" class="bg-login" style="background-image: url(${pageContext.servletContext.contextPath }/img/login-bg.jpg);">
					</div>
				</div>
				<div class="block-form">
					<div id="starlight-stage" class="form-container">
						<form id="form-login" class="form-login" method="post" action="login.shtml">
							<div class="form-group has-feedback">
								<input style="box-sizing: border-box;"   id="ipt-name-login" type="text" placeholder="手机号码" required="" minlength="11" maxlength="20" autocomplete="off" class="form-control" name="telephone" value="${userEntity.telephone}">
								<label for="ipt-name-login" class="form-control-feedback"><i class="fa fa-user"></i></label>
							</div>
							<div class="form-group has-feedback">
								<input style="box-sizing: border-box;"  id="ipt-pwd-login" type="password" placeholder="请输入您的密码" required="" minlength="6" maxlength="35" class="form-control" name="passWord" value="${userEntity.passWord}">
								<label for="ipt-pwd-login" class="form-control-feedback"><i class="fa fa-lock"></i></label>
							</div>
							<p class="login-error">${LOGIN_ERROR_MESSAGE}</p>
							<div class="form-group">
								<button style="box-sizing: border-box;"  id="btn-login" type="bottom" class="btn btn-primary btn-block">登录</button>
							</div>
							<div id="popup-captcha"></div>
							<div class="form-group clearfix">
								<a id="link-forgot-pwd" class="pull-left form-link" href="toUpdatePassword.shtml">忘记登录密码？</a>
								<a id="link-reg" href="toRegister.shtml" class="pull-right form-link">注册账号<i class="fa fa-angle-right"></i></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	<%@ include file="public-footer.jsp" %>

		<script>
			var handlerPopup = function (captchaObj) {

				$("#btn-login").click(function () {
					var validate = captchaObj.getValidate();
					if (!validate) {
//						alert('请先完成验证！');
//						return;
					}
					$.ajax({
						url: "VerifyLoginServlet", // 进行二次验证
						type: "post",
						dataType: "json",
						data: {
							// 二次验证所需的三个值
							geetest_challenge: validate.geetest_challenge,
							geetest_validate: validate.geetest_validate,
							geetest_seccode: validate.geetest_seccode
						},
						success: function (data) {

							if (data && (data.status === "success")) {

								$("#popup-captcha").html('欢迎回来！页面即将跳转到链接');

							} else {

								$("#popup-captcha").html('登录失败');
							}
						}
					});
				});

				// 弹出式需要绑定触发验证码弹出按钮
				captchaObj.bindOn("#btn-login");

				// 将验证码加到id为captcha的元素里
				captchaObj.appendTo("#popup-captcha");

				// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
			};

			$.ajax({
				// 获取id，challenge，success（是否启用failback）
				url: "StartCaptchaServlet",
				type: "get",
				dataType: "json",
				success: function (data) {

					// 使用initGeetest接口
					// 参数1：配置参数
					// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
					initGeetest({
						gt: data.gt,
						challenge: data.challenge,
						product: "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
						offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
					}, handlerPopup);
				}
			});

		</script>

	</body>

</html>