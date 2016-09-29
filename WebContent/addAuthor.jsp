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
	<s:form action="addAuthor">
		<table width="300" height="400" border="1" align="center">
			<tr>
				<td colspan="3" style="background-color: #99bbbb;" align="center">
					<font size="5px">作者信息</font>
				</td>
			</tr>
				<s:textfield name="author.Name" label="姓名" required="true" />
				<s:textfield name="author.Age" label="年龄" />
				<s:textfield name="author.Country" label="国籍" ></s:textfield>
			<tr>
				<td colspan=3 align="center"><input type="submit"
					value="   保   存   " class="button"><input type="reset"
					value="   重   填   " class="button"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>