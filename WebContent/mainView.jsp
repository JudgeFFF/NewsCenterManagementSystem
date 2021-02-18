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
		<table style="text-align: left;">
			<tr>
				<td>新闻标题</td>
				<td>新闻类型</td>
				<td>新闻作者</td>
				<td>发布时间</td>
			</tr>
			<c:forEach items="${list}" var="listItem">
				<tr>
					<td><a href="newsControl?operator=show&id=${listItem.id}">${listItem.title}</a></td>
					<td>${listItem.type}</td>
					<td>${listItem.author}</td>
					<td>${listItem.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>