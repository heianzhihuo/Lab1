<%@ page language="java" import="java.util.*" 
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/stytles3.css" />
<title>图书管理系统</title>
</head>
<body>
	<table width="1000" border="1" align="center">
		<tr>
			<th bgcolor="white" height=30>ISBN</th>
			<th bgcolor="white">书名</th>
			<th bgcolor="white">出版社</th>
			<th bgcolor="white">出版日期</th>
			<th bgcolor="white">价格</th>
			<th bgcolor="white" colspan=2>操作</th>
		</tr>
		<s:iterator value="books" status="st">
			<tr>
				<s:param name="ISBN">
					<s:property value="ISBN" />
				</s:param>
				
				<td bgcolor="white" height=30><s:property value="ISBN" /></td>
				<td bgcolor="white">
				<s:url var="sun" value="/searchBook">
				<s:param name="Title">
					<s:property value="Title" />
				</s:param>
				</s:url>
				<s:a href="%{sun}"><font color="black"><s:property value="Title" /></font></s:a>
				</td>
				<td bgcolor="white"><s:property value="Publisher" /></td>
				<td bgcolor="white"><s:property value="PublishDate"/></td>
				<td bgcolor="white"><s:property value="Price" /></td>
				
				<td bgcolor="white"><s:a href="/BookLibrary/deleteBook?ISBN=%{ISBN}">
						<font color="black">删除</font>
					</s:a></td>
				<td bgcolor="white"><s:a
						href="/BookLibrary/reviseBook?ISBN=%{ISBN}">
						<font color="black">修改</font>
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
	<div id="footer">
		Copyright 2016黄文伟<br />哈尔滨工业大学 计算机科学与技术学院<br />

	</div>
</body>
</html>