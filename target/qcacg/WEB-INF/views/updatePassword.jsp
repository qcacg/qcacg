<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>注册 - 轻悦轻小说</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/register_files/moe.f9e95134.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/register_files/login.29a3b59b.css">
		<script src="${pageContext.servletContext.contextPath }/js/jquery-1.9.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/main.css" />
		<link rel="shortcut icon" href="http://www.qcacg.com/favicon.ico" type="image/x-icon" />
	</head>
	<body>
	<%@ include file="public-header.jsp" %>
		<div id="content" class="content qw" style="min-height: 270px;padding-bottom: 70px;box-sizing: border-box;">
			<div class="container">
				<div class="block-img">
					<div id="bg-login" class="bg-login" style="background-image: url(${pageContext.servletContext.contextPath }img/login-bg.jpg);">
						<div class="bg-border grad-v"></div>
						<div class="bg-border grad-h"></div>
					</div>
				</div>
				<div class="block-form">
					<div id="starlight-stage" class="form-container">
					<form id="form-reg" class="form-reg" action="updatePassword.shtml">
						<div class="form-group">
							<label for="telephone" class="label-login">手机号码：</label>
							<div class="ipt-group">
								<input style="box-sizing: border-box;"  id="telephone" type="text" placeholder="手机号码" required="" minlength="11" maxlength="15" autocomplete="off" class="form-control" name="telephone" value="${userCustom.telephone}"></div>
						</div>
						<div class="form-group"><label for="ipt-code-reg" class="label-login">验证码：</label>
								<div class="ipt-group ipt-group-x">
									<input style="box-sizing: border-box;"    id="ipt-code-reg" placeholder="六位手机验证码" required="" minlength="6" maxlength="6" class="form-control" name="telephoneCode">
									<a id="validationCode" class="btn btn-primary btn-send-code" >发送</a></div>
							</div>
							<p class="telephoneCodeError-error">${telephoneCodeError}</p>
						<div class="form-group"><label for="ipt-pwd-reg1" class="label-login">新密码：</label>
							<div class="ipt-group"><input style="box-sizing: border-box;"  id="ipt-pwd-reg1" type="password" placeholder="密码" required="" minlength="6" maxlength="35" class="form-control" name="passWord" value="${userCustom.passWord}"></div>
						</div>

						<div class="form-group"><label for="ipt-pwd-reg2" class="label-login">确认密码：</label>
							<div class="ipt-group"><input style="box-sizing: border-box;"  id="ipt-pwd-reg2" type="password" placeholder="密码" required="" minlength="6" maxlength="35" class="form-control" name="passWordConfirm" value="${userCustom.passWordConfirm}"></div>
						</div>
						<p class="passWordConfirmError-error">${passWordConfirmError}</p>
						<div class="form-group"><label class="label-login"></label>
							<div class="ipt-group"><button id="btn-reg" class="btn btn-primary btn-block">修改密码</button></div>
						</div>
						<div class="form-group"><a id="link-login" href="toLogin.shtml" class="form-link pull-right link-return"><i class="fa fa-angle-left"></i>返回登录</a></div>
					</form>
				</div>
			</div>
		</div>
		</div>
	<%@ include file="public-footer.jsp" %>
	</body>

</html>

<script type="text/javascript">

	$(function() {
		$('#validationCode').click(function () {
			if ($(this).attr('disabled') === 'disabled') {
				return;
			}
			var telephone = document.getElementById("telephone");
			var value = telephone.value.trim();
			var countdown = 60;
			setTime();
			function setTime() {
				var val = document.getElementById("validationCode");
				if(countdown == 60){
					$.ajax({
						cache: false,
						url: "updatePasswordTelephoneCode.shtml",
						data: {telephone: value},
						success: function (data) {
							if(data.success){
								console.log('updatePasswordTelephoneCode success');
							}else{
								alert(data.msg);
								console.log('registerTelephoneCode fail');
							}
						},
						error: function (data) {

							console.log('updatePasswordTelephoneCode error');
						}
					});}
				if (countdown == 0) {
					val.removeAttribute("disabled");
					val.innerHTML = "发送";
					countdown = 60;
					return;
				} else {
					val.innerHTML = countdown + "秒";
					val.setAttribute("disabled", true);
					countdown--;
				}
				setTimeout(function () {
					setTime(this);
				}, 1000)
			}
		});
	})
</script>