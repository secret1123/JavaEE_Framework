<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/7/10
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc.jsp"%>
<html>
<head>
    <title>sign up page</title>
</head>
<body>
<form action="${ctx}/user/signUp" method="post">
    <input type="text" name="username" placeholder="USERNAME"><br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="SIGN UP">
</form>
<p>${requestScope.message}</p>
</body>
</html>
