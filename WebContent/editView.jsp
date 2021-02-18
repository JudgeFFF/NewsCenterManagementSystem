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
			<c:forEach items="${list}" var="listItem">
				<h2>编辑新闻</h2>
				<input type="hidden" name="operator" value="editNews"/>		
				<input type="hidden" name="id" value="${listItem.id}"/>	
				<table>
					<col align="center" width="20%"/>
					<tr>
						<th>新闻标题：</th>
						<td><input type="text" name="newsTitle" value="${listItem.title}" style="width:660px"></td>
					</tr>
					<tr>
						<th>新闻类型：</th>
						<td><input type="text" name="newsType" value="${listItem.type}" style="width:660px"></td>
					</tr>
					<tr>
						<th>新闻作者：</th>
						<td><input type="text" name="newsAuthor" value="${listItem.author}" style="width:660px"></td>
					</tr>
					<tr>
						<th>新闻内容：</th>
						<td><textarea rows="20" cols="80" name="newsContent">${listItem.content}</textarea></td>
					</tr>
					<tr>
						<th>发布时间：</th>
						<td>${listItem.time}</td>
					</tr>
				</table><br>
				<input type="submit" value="编辑" >
		</c:forEach>
		</form><br>
		<button onclick="window.location.href='manageControl'">返回</button>
	</div>
</body>
</html>