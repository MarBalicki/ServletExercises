<%--
  Created by IntelliJ IDEA.
  User: mbali
  Date: 26.06.2020
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><h3><%out.println(session.getAttribute("errorStatement"));%></h3></div>
<div>Try again&nbsp&nbsp<a href="/register">register link</a> </div>

</body>
</html>
