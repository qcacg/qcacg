<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/10
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
    <title>小说审核</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/moe.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/member.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/user-info/user-info.css">
    <script src="${pageContext.servletContext.contextPath }/user-info/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/user-info-B.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/main.css" />
</head>
<body>
<%@ include file="public-header.jsp" %>
<div id="book-check" class="book check">
    <button id="btn-book-check" class="btn book check" type="submit">查看提交审核</button>
</div>
<%@ include file="public-footer.jsp" %>
</body>

</html>
