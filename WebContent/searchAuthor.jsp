<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="picture/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/stytles1.css" />
<title>图书管理系统</title>
</head>
<body>
	<h1>查找作者</h1>
	<div id="form">
		<s:form action="searchAuthor">
   请输入作者名字 :<s:textfield id="form1" name="Name"></s:textfield>
			<s:submit id="form2" />
		</s:form>
	</div>
	<br />
	<a href="/BookLibrary/searchBook.jsp" class=form1><font
		color="white" face="楷体" size=4>查找书籍</font></a>
	<br />
	<a href="/BookLibrary/index.html" class="form2"><font
		color="white" face="楷体" size=4>返回主页</font></a>
	<br />
	<a href="/BookLibrary/addBook.jsp" class="form3"><font
		color="white" face="楷体" size=4>添加书籍</font></a>
	<br />
	<a href="showAll" class="form4"><font color="white" face="楷体"
		size=4>预览所有书籍</font></a>
</body>
</html>