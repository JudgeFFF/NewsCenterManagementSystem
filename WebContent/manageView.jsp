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
		<h1>后台管理系统</h1>
		<a href="mainControl" >新闻首页</a>
		<a href="manageControl" style="margin: 0 50px 0 50px;">管理新闻</a>
		<a href="addView.jsp" >添加新闻</a>
	</div>
	<hr>
	<div align="center">
		<form action="newsControl" method="post">
			<table style="text-align: left;">
				<tr>
					<td>新闻编号</td>
					<td>新闻标题</td>
					<td>新闻类型</td>
					<td>新闻作者</td>
					<td>发布时间</td>
					<td>是否编辑</td>
					<td>是否删除</td>
				</tr>
				<c:forEach items="${list}" var="listItem">
					<tr>
						<td>${listItem.id}</td>
						<td>${listItem.title}</td>
						<td>${listItem.type}</td>
						<td>${listItem.author}</td>
						<td>${listItem.time}</td>
						<td><a href="newsControl?operator=edit&id=${listItem.id}">编辑</a></td>
						<td><a href="newsControl?operator=delete&id=${listItem.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<c:if test="${flag == 1}">
		<script>alert("编辑成功！");</script>
	</c:if>
	<c:if test="${flag == 2}">
		<script>alert("删除成功！");</script>
	</c:if>
</body>
</html>