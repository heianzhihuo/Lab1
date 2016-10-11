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
	<table class=form1 width="1000" align="center">
		<tr>
			<th class=form1 colspan="4" align="center">书籍信息</th>
		</tr>
		<tr>
			<th>ISBN:</th>
			<td class=form1><s:property value="book.ISBN" /></td>
			<th>书名：</th>
			<td class=form2><s:property value="book.Title" /></td>
		</tr>
		<tr>
			<th>出版社：</th>
			<td class=form2><s:property value="book.Publisher" /></td>
			<th>出版日期：</th>
			<td class=form1><s:property value="book.PublishDate" /></td>
		</tr>
		<tr>
			<th>价格：</th>
			<td class=form1><s:property value="book.Price" /></td>
		</tr>
	</table>

	<table class=form1 width="1000" align="center">
		<tr>
			<th class=form1 colspan="4" align="center">作者信息</th>
		</tr>
		<tr>
			<th>姓名：</th>
			<td class=form1><s:property value="author.Name" /></td>
			<th>序列号：</th>
			<td class=form2><s:property value="author.AuthorID" /></td>
		</tr>
		<tr>
			<th>年龄：</th>
			<td class=form2><s:property value="author.Age" /></td>
			<th>国籍：</th>
			<td class=form1><s:property value="author.Country" /></td>
		</tr>
	</table>
	<br />
	<a href="searchBook.jsp" class=form1><font color="#FF0000"
		face="楷体" size=4>查找书籍</font></a>
	<br />
	<a href="searchAuthor.jsp" class="form2"><font color="#FF0000"
		face="楷体" size=4>查询作者</font></a>
	<br />
	<a href="showAll" class="form3"><font color="#FF0000" face="楷体"
		size=4>预览书籍</font></a>
	<br />
	<a href="index.html" class="form4"><font color="#FF0000" face="楷体"
		size=4>返回主页</font></a>
</body>
</html>