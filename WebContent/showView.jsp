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
		<table style="width:50%">
			<col align="center" width="20%"/>
  			<col align="left"/>
			<c:forEach items="${list}" var="listItem">
				<tr>
					<th>新闻标题</th>
					<td>${listItem.title}</td>
				</tr>
				<tr>
					<th>新闻类型</th>
					<td>${listItem.type}</td>
				</tr>
				<tr>
					<th>新闻作者</th>
					<td>${listItem.author}</td>
				</tr>
				<tr>
					<th>新闻内容</th>
					<td style="height:500px">${listItem.content}</td>
				</tr>
				<tr>
					<th>发布时间</th>
					<td>${listItem.time}</td>
				</tr>
				<tr >
					<th colspan="2">
						<a href="newsControl?operator=show&id=1">首页</a>
						<a href="newsControl?operator=pageDel&id=${listItem.id}">上一页</a>
						当前${listItem.id}页/共${count}页
						<a href="newsControl?operator=pageAdd&id=${listItem.id}">下一页</a>
						<a href="newsControl?operator=show&id=${count}">尾页</a>
					</th>
				</tr>
			</c:forEach>
		</table><br>		
	</div>
</body>
</html>