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
	<h1 align="center">查找成功</h1>
	<table class=form1 width="1000" border="1" align="center">
		<tr>
			<th class=form1 colspan="4" align="center">作者信息</th>
		</tr>
		<tr>
			<th>姓名：</th>
			<td class=form><s:property value="author.Name" /></td>
			<th>序列号：</th>
			<td class=form><s:property value="author.AuthorID" /></td>
		</tr>
		<tr>
			<th>年龄：</th>
			<td class=form><s:property value="author.Age" /></td>
			<th>国籍：</th>
			<td class=form><s:property value="author.Country" /></td>
		</tr>
	</table>

	<table width="1000" border="1" align="center">
		<tr>
			<th class=form1 colspan="7" align="center">书籍信息</th>
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


				<s:if test="#st.odd==true">
					<td class=form1>
				</s:if>
				<s:else>
					<td class=form2>
				</s:else>
				<s:property value="ISBN" />
				</td>
				<s:if test="#st.odd==true">
					<td class=form2>
				</s:if>
				<s:else>
					<td class=form1>
				</s:else>
				<s:url var="sun" value="/searchBook">
					<s:param name="Title">
						<s:property value="Title" />
					</s:param>
				</s:url>
				<s:a href="%{sun}">
					<font color="black"><s:property value="Title" /></font>
				</s:a>
				</td>
				<s:if test="#st.odd==true">
					<td class=form1>
				</s:if>
				<s:else>
					<td class=form2>
				</s:else>
				<s:property value="Publisher" />
				</td>
				<s:if test="#st.odd==true">
					<td class=form2>
				</s:if>
				<s:else>
					<td class=form1>
				</s:else>
				<s:property value="PublishDate" />
				</td>
				<s:if test="#st.odd==true">
					<td class=form1>
				</s:if>
				<s:else>
					<td class=form2>
				</s:else>
				<s:property value="Price" />
				</td>
				<s:param name="ISBN">
					<s:property value="ISBN" />
				</s:param>
				<s:if test="#st.odd==true">
					<td class=form2>
				</s:if>
				<s:else>
					<td class=form1>
				</s:else>
				<s:a href="/BookLibrary/deleteBook?ISBN=%{ISBN}">
					<font color="black">删除</font>
				</s:a>
				</td>
				<s:if test="#st.odd==true">
					<td class=form1>
				</s:if>
				<s:else>
					<td class=form2>
				</s:else>
				<s:a href="/BookLibrary/reviseBook?ISBN=%{ISBN}">
					<font color="black">修改</font>
				</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<br />
	<a href="searchBook.jsp" class=form1><font color="#FF0000"
		face="楷体" size=4>查找书籍</font></a>
	<br />
	<a href="searchAuthor.jsp" class="form2"><font color="#FF0000"
		face="楷体" size=4>查询作者</font></a>
	<br />
	<a href="addBook.jsp" class="form3"><font color="#FF0000" face="楷体"
		size=4>添加书籍</font></a>
	<br />
	<a href="index.html" class="form4"><font color="#FF0000" face="楷体"
		size=4>返回主页</font></a>
</body>
</html>