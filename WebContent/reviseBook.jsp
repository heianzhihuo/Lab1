<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<link rel="stylesheet" type="text/css" href="css/stytles.css" />
<title>图书管理系统</title>
</head>
<style type="text/css">
a.form {
	position: absolute;
	left: 530px;
	top: 550px;
}

a.form1 {
	position: absolute;
	left: 650px;
	top: 550px;
}

a.form2 {
	position: absolute;
	left: 770px;
	top: 550px;
}
</style>
<body>
	<s:form action="reviseBook">
		<table width="300" height="400" border="1" align="center">
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">书籍信息</font>
				</td>
			</tr>
			<tr>
				<td><s:textfield name="book.ISBN" readonly="true" label="ISBN"></s:textfield></td>
			</tr>
			<tr>
				<td><s:textfield name="book.Title" readonly="true" label="书名"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="book.Publisher" label="出版社"
						value="%{book.Publisher}"></s:textfield></td>
			</tr>

			<tr>
				<s:textfield name="book.PublishDate" label="出版日期"
					value="%{book.PublishDate}"></s:textfield>
			</tr>
			<tr>
				<td><s:textfield name="book.Price" label="价格"
						value="%{book.Price}"></s:textfield></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">作者信息</font>
				</td>
			</tr>
			<tr>
				<s:textfield name="author.AuthorID" label="序列号" readonly="true" />
				<s:textfield name="author.Name" label="姓名" readonly="true" />
				<s:textfield name="author.Age" label="年龄" value="%{author.Age}" />
				<s:textfield name="author.Country" label="国籍"
					value="%{author.Country}"></s:textfield>
			</tr>
			<tr>
				<td colspan=3 align="center"><input type="submit"
					value="   保   存   " class="button"><input type="reset"
					value="   重   填   " class="button"></td>
			</tr>
		</table>


	</s:form>
	<a href="http://127.0.0.1:8000/search/" class="form"><font
		color="blue">查询联系人</font></a>
	<a href="/BookLibrary/index.html" class="form1"><font color="red">返回首页</font></a>
	<a href="/BookLibrary/showAll" class="form2"><font color="#FF00FF">预览联系人</font></a>
	<div id="footer">
		Copyright 2016 黄文伟<br />哈尔滨工业大学 计算机科学与技术学院 <br />
	</div>
</body>
</html>