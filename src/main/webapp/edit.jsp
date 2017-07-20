<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/7/14
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/inc.jsp"%>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<h1>编辑图书</h1>
<form action="${ctx}/book/modify" method="post">
    <input type="hidden" name="id" value="${sessionScope.book.id}">
    <input type="text" name="title" placeholder="书名" value="${sessionScope.book.title}"><br>
    <input type="text" name="author" placeholder="作者" value="${sessionScope.book.author}"><br>
    <input type="date" name="date" placeholder="出版日期" value="${sessionScope.book.date}"><br>
    <input type="text" name="price" placeholder="定价" value="${sessionScope.book.price}"><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
