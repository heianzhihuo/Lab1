<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />

<title>图书管理系统</title>
</head>
<body>
	<h1 align="center">查找成功</h1>
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

	<table width="1000" border="1" align="center">
		<tr>
			<td colspan="7" style="background-color: #99bbbb;" align="center">书籍信息</td>
		</tr>
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

				<td bgcolor="white" height=30><s:property value="ISBN" /></td>
				<td bgcolor="white"><s:property value="Title" /></td>
				<td bgcolor="white"><s:property value="Publisher" /></td>
				<td bgcolor="white"><s:property value="PublishDate" /></td>
				<td bgcolor="white"><s:property value="Price" /></td>
				<s:param name="ISBN">
					<s:property value="ISBN" />
				</s:param>
				<td bgcolor="white"><s:a
						href="/BookLibrary/deleteBook?ISBN=%{ISBN}">
						<font color="black">删除</font>
					</s:a></td>
				<td bgcolor="white"><s:a
						href="/BookLibrary/revise?ISBN=%{ISBN}">
						<font color="black">修改</font>
					</s:a></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>