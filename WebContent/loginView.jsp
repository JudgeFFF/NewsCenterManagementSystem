<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻中心系统</title>
</head>
<body>
	<div align = "center">
		<h1>新闻管理系统</h1>
		<a href="mainControl" >新闻主页</a>
		<a href="searchView.jsp" style="margin: 0 50px 0 50px;">搜索新闻</a>
		<a href="loginView.jsp" >后台管理</a>
	</div>
	<hr>
	<div align="center">
		<h2>管理员登录</h2>
		<form action="newsControl">
			<input type="hidden" name="operator" value="login"/>
			<table>
				<tr>
					<td>管理员账号：</td>
					<td><input type="text" name="adminName"></td>
				</tr>
				<tr>
					<td>管理员密码：</td>
					<td><input type="password" name="adminPwd"></td>
				</tr>
			</table><br>
			<input type="submit" value="登录">
			<input type="reset" value="重置">
		</form>
	</div>
	<c:if test="${flag == 1}">
		<script>alert("登录失败！");</script>
	</c:if>
</body>
</html>