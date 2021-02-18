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
		<h2>添加新闻</h2>
		<form action="newsControl" method="post">
			<input type="hidden" name="operator" value="add"/>
			<table>
				<col align="center" width="20%"/>
				<tr>
					<th>新闻标题：</th>
					<td><input type="text" name="newsTitle" style="width:660px"></td>
				</tr>
				<tr>
					<th>新闻类型：</th>
					<td><input type="text" name="newsType" style="width:660px"></td>
				</tr>
				<tr>
					<th>新闻作者：</th>
					<td><input type="text" name="newsAuthor" style="width:660px"></td>
				</tr>
				<tr>
					<th>新闻内容：</th>
					<td><textarea rows="20" cols="80" name="newsContent"></textarea></td>
				</tr>
			</table><br>
			<input type="submit" value="添加">
		</form><br>
		<button onclick="window.location.href='manageControl'">返回</button>
	</div>
	<c:if test="${flag == 0}">
		<script>alert("添加成功！");</script>
	</c:if>
</body>
</html>