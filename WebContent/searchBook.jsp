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
	<h1>查找书籍</h1>
	<s:form action="searchBook">
   请输入书名 :<s:textfield name="Title"></s:textfield>
		<s:submit />
	</s:form>
</body>
</html>