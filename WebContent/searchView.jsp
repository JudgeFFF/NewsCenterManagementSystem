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
	<div align="center">
		<h1>新闻管理系统</h1>
		<a href="mainControl" >新闻主页</a>
		<a href="searchView.jsp" style="margin: 0 50px 0 50px;">搜索新闻</a>
		<a href="loginView.jsp" >后台管理</a>
	</div>
	<hr>
	<div align="center">
		<h2>搜索新闻</h2>
		<form action="newsControl">
			<input type="hidden" name="operator" value="search"/>
			请输入搜索关键字：<input type="text" name="newsTitle"><br><br>
			<input type="submit" value="搜索"><br><br>
		</form>
	</div>
	<div align="center">
		<table style="text-align: left;">
			<c:forEach items="${list}" var="listItem">
				<tr>
					<td>新闻标题</td>
					<td><a href="newsControl?operator=show&id=${listItem.id}">${listItem.title}</a></td>
				</tr>
				<tr>
					<td>新闻类型</td>
					<td>${listItem.type}</td>
				</tr>
				<tr>
					<td>新闻作者</td>
					<td>${listItem.author}</td>
				</tr>
				<tr>
					<td>发布时间</td>
					<td>${listItem.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:if test="${flag == 0}">
		<script>alert("搜索成功！");</script>
	</c:if>
	<c:if test="${flag == 1}">
		<script>alert("搜索失败！");</script>
	</c:if>
</body>
</html>