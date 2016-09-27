<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/stytles3.css" />
<title>图书管理系统</title>
</head>
<body>
	<h1>Success</h1>
	<table width="1000" height="200" border="1" align="center">
		<tr>
			<th bgcolor="white">ISBN</th>
			<th bgcolor="white">书名</th>
			<th bgcolor="white">作者</th>
			<th bgcolor="white">出版社</th>
			<th bgcolor="white">出版日期</th>
			<th bgcolor="white">价格</th>
			<th bgcolor="white" colspan=2>操作</th>
		</tr>
		<s:iterator value="books" status="st">
			<tr>

				<td bgcolor="white"><s:property value="ISBN" /></td>
				<td bgcolor="white"><s:property value="Title" /></td>
				<td bgcolor="white"><s:property value="AuthorID" /></td>
				<td bgcolor="white"><s:property value="Publisher" /></td>
				<td bgcolor="white"><s:property value="PublishDate" /></td>
				<td bgcolor="white"><s:property value="Price" /></td>

				<td >
				<a href="<s:url action="deleteBook">
				<s:param name="index" value="%{#st.index}"></s:param>
			</s:url>">删除</a>
				<!--<s:a href="deleteBook?id=%{index}"
						color="black">删除
</s:a> <s:form action="HelloWorld">
				
				<s:a href="/delete/?id=%{ids}"><font
						color="black">删除</font></s:a>
				</s:form>
					  a href="/delete/?id=ISBN"><font
						color="black">删除</font></a>--></td>
				<td bgcolor="white"><a href="/change/?id={{ISBN}}"><font
						color="black">修改</font></a></td>
			</tr>
		</s:iterator>
	</table>
	</table>
	<div id="footer">
		Copyright 2016黄文伟<br />哈尔滨工业大学 计算机科学与技术学院<br />

	</div>
</body>
</html>