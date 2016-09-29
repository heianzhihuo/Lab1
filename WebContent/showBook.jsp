<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/stytles3.css" />
<title>图书管理系统</title>
</head>
<body>
	<table width="1000" align="center">
		<tr>
			<td colspan="4" align="center">书籍信息</td>
		</tr>
		<tr>
			<th>ISBN:</th>
			<td><s:property value="book.ISBN" /></td>
			<th>书名：</th>
			<td><s:property value="book.Title" /></td>
		</tr>
		<tr>
			<th>出版社：</th>
			<td><s:property value="book.Publisher" /></td>
			<th>出版日期：</th>
			<td><s:property value="book.PublishDate" /></td>
		</tr>
		<tr>
			<th>价格：</th>
			<td><s:property value="book.Price" /></td>
		</tr>
	</table>

	<table width="1000" border="1" align="center">
		<tr>
			<td colspan="4" style="background-color: #99bbbb;" align="center">作者信息</td>
		</tr>
		<tr>
			<th>姓名：</th>
			<td><s:property value="author.Name" /></td>
			<th>序列号：</th>
			<td><s:property value="author.AuthorID" /></td>
		</tr>
		<tr>
			<th>年龄：</th>
			<td><s:property value="author.Age" /></td>
			<th>国籍：</th>
			<td><s:property value="author.Country" /></td>
		</tr>
	</table>

</body>
</html>