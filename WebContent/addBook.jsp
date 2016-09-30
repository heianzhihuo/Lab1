<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stytles.css" />
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />
<title>图书管理系统</title>
</head>

<body>
	<s:form action="addBook">
		<table width="300" height="400" border="1" align="center">
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">书籍信息</font>
				</td>
			</tr>
			<s:param name="ISBN">
				<s:property value="Title" />
			</s:param>
			<tr>
				<td><s:textfield name="book.ISBN" required="true" label="ISBN"></s:textfield></td>
			</tr>
			<tr>
				<td><s:textfield name="book.Title" required="true" label="书名"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="book.Publisher" label="出版社"></s:textfield></td>
			</tr>

			<tr>
				<s:textfield name="book.PublishDate" label="出版日期"></s:textfield>
			</tr>
			<tr>
				<td><s:textfield name="book.Price" label="价格"></s:textfield></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">作者信息</font>
				</td>
			</tr>
			<tr>
				<s:textfield name="author.Name" label="姓名" required="true" />
				<s:textfield name="author.Age" label="年龄" />
				<s:textfield name="author.Country" label="国籍"></s:textfield>
			</tr>
			<tr>
				<td colspan=3 align="center"><input type="submit"
					value="   保   存   " class="button"><input type="reset"
					value="   重   填   " class="button"></td>
			</tr>
		</table>


	</s:form>
	<div>
		<a href="/BookLibrary/index.html" class="form1"><font color="red">返回首页</font></a>
		<a href="/BookLibrary/showAll" class="form2"><font color="#FF00FF">预览书籍</font></a>
	</div>
	<div id="footer">
		Copyright 2016 黄文伟<br />哈尔滨工业大学 计算机科学与技术学院 <br />
	</div>
</body>
</html>