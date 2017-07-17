<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/7/11
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index page</title>
    <script>
        function del() {
            return confirm("是否确定删除？");
        }
    </script>
</head>
<body>
<h1>主页</h1>
${sessionScope.user.username}
<p><a href="/user/signOut">注销</a></p>
<hr>
<form action="/book/create" method="post">
    <input type="text" name="title" placeholder="书名"><br>
    <input type="text" name="author" placeholder="作者"><br>
    <input type="date" name="date" placeholder="出版日期"><br>
    <input type="text" name="price" placeholder="定价"><br>
    <input type="submit" value="添加">
</form>
<hr>
<table border="2">
    <tr>
        <th>序号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版日期</th>
        <th>定价</th>
        <th colspan="2">操作</th>
    </tr>
<c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
    <tr>
        <td>${vs.count}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.date}</td>
        <td>${book.price}</td>
        <td><a href="/book/queryById/${book.id}">编辑</a></td>
        <td><a href="/book/remove/${book.id}" onclick="return del()">删除</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
