<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/7/4
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc.jsp"%>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h1>首页</h1>
  <form action="${ctx}/user/signIn" method="post">
    <input type="text" name="username" placeholder="USERNAME"><br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="SIGN IN">
  </form>
  <p>${requestScope.message}</p>
  <a href="${ctx}/sign_up.jsp">SIGN UP</a>
  </body>
</html>
