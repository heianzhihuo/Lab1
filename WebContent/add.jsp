<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
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
	top: 350px;
}

a.form1 {
	position: absolute;
	left: 650px;
	top: 350px;
}

a.form2 {
	position: absolute;
	left: 770px;
	top: 350px;
}
</style>
<body>
	<table width="300" height="300" border="1" align="center">
		<form action="addBook">
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">书籍信息</font>
				</td>
			</tr>
		<tr>
			<td height="30" width='100' align="center">ISBN：</td>
			<td><input name="ISBN" type="text" required="required"></input>
			</td>

			<td><font color='#99bbbb'>必填</font></td>
		</tr>
		<tr>
			<td height="30" width='100' align="center">书名：</td>
			<td><input name="Title" type="text" required="required"></input></td>
			<td><font color='#99bbbb'>必填</font></td>
		</tr>
		<tr>
			<td height="30" width='100' align="center">作者：</td>
			<td><input name="Author" type="text"></input></td>
			<td><font color='#99bbbb'>选填</font></td>
		</tr>
		<tr>
			<td height="30" width='100' align="center">出版社:</td>
			<td><input name="Publisher" type="text"></input></td>
			<td><font color='#99bbbb'>选填</font></td>
		</tr>

		<tr>
			<td height="30" width='100' align="center">出版日期：</td>
			<td><input name="PublishDate" type="text"></input></td>
			<td><font color='#99bbbb'>xxxx-xx-xx</font></td>
		</tr>
		<tr>
			<td height="30" width='100' align="center">价格：</td>
			<td><input name="Price" type="text"></input></td>
			<td><font color='#99bbbb'>选填</font></td>
		</tr>
		<tr>
			<td colspan=3 align="center"><input type="submit"
				value="   保   存   " class="button"><input type="reset"
				value="   重   填   " class="button"></td>
		</tr>

		<a href="http://127.0.0.1:8000/search/" class="form"><font
			color="blue">查询联系人</font></a>
		<a href="/BookLibrary/index.html" class="form1"><font color="red">返回首页</font></a>
		<a href="/BookLibrary/showAll" class="form2"><font
			color="#FF00FF">预览联系人</font></a>
		</form>
	</table>
	</br>
	<div id="footer">
		Copyright 2016 黄文伟<br />哈尔滨工业大学 计算机科学与技术学院 <br />
	</div>
</body>
</html>