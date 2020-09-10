<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/9/8
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/anno/testRequestParam?uasername=haha">hhhhhhh</a>

<form action="/anno/testRequestBody" method="post">
    姓名：<input type="text" name = "username">
    密码：<input type="text" name = "password">
    <br>
    <input type="submit" value="提交">
</form>

<a href="/anno/testPathVarible">testPathVarible</a>
</body>
</html>
