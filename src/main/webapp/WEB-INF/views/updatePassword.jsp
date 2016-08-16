<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>注册 - 轻文轻小说</title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/register_files/moe.f9e95134.css">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/register_files/login.29a3b59b.css">
		<script src="${pageContext.servletContext.contextPath }/js/jquery-1.9.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/main.css" />
	</head>
	<body>
		<section class="navbar">
				<nav class="nav">
					<h1 class="logo"><a href="index.shtml">轻创轻小说</a></h1>
					<ul class="clearfloat pull-left">
						<li><a href="index.shtml">首页</a></li>
						<li>分类</li>
						<li>画师</li>
						<li>周边</li>
						<li>福利</li>
					</ul>
					<a class="publish pull-right">投稿</a>
					<a class="login pull-right" href="toLogin.shtml">登入/注册</a>
				</nav>
			</section>
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
							<label for="ipt-nname-reg" class="label-login">手机号码：</label>
							<div class="ipt-group">
								<input style="box-sizing: border-box;"  id="ipt-nname-reg" type="text" placeholder="手机号码" required="" minlength="11" maxlength="15" autocomplete="off" class="form-control" name="telephone"></div>
						</div>
						<div class="form-group"><label for="ipt-pwd-reg" class="label-login">旧密码：</label>
							<div class="ipt-group"><input style="box-sizing: border-box;"  id="ipt-pwd-reg" type="password" placeholder="密码" required="" minlength="6" maxlength="35" class="form-control" name="oldPassWord"></div>
						</div>
						<p class="passWordError-error">${passWordError}</p>
						<div class="form-group"><label for="ipt-pwd-reg" class="label-login">新密码：</label>
							<div class="ipt-group"><input style="box-sizing: border-box;"  id="ipt-pwd-reg" type="password" placeholder="密码" required="" minlength="6" maxlength="35" class="form-control" name="newPassWord"></div>
						</div>
						<p class="samePassWord-error">${samePassWord}</p>
						<div class="form-group"><label for="ipt-pwd-reg" class="label-login">确认密码：</label>
							<div class="ipt-group"><input style="box-sizing: border-box;"  id="ipt-pwd-reg" type="password" placeholder="密码" required="" minlength="6" maxlength="35" class="form-control" name="passWordConfirm"></div>
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
		<footer class="footer clearfloat" style="border: 0px;">
			<div class="tar">
				<ul class="gy">
					<li class="title">关于</li>
					<li><a href="javascript:;">关于我们</a></li>
					<li><a href="javascript:;">公司信息</a></li>
					<li><a href="javascript:;">免责声明</a></li>
				</ul>
			</div>
			<div class="tar">
				<ul class="gy">
					<li class="title">联系方式</li>
					<li><a href="javascript:;">微博</a></li>
					<li><a href="javascript:;">电子邮件</a></li>
				</ul>
			</div>
			<div class="tar">
				<ul class="gy">
					<li class="title">投稿</li>
					<li><a href="javascript:;">签约制度</a></li>
					<li><a href="javascript:;">作者福利</a></li>
					<li><a href="javascript:;">签约流程</a></li>
					<li><a href="javascript:;">约稿函</a></li>
					<li><a href="javascript:;">投稿流程</a></li>
				</ul>
			</div>
			<div class="tar">
				<ul class="gy gy_over">
					<li class="title">友情链接</li>
				</ul>
			</div>
		</footer>
	</body>
</html>