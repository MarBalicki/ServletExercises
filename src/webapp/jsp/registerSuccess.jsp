<%--
  Created by IntelliJ IDEA.
  User: mbali
  Date: 25.06.2020
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer registered</title>
</head>
<body>
<% Customer customer = (Customer) session.getAttribute("customer"); %>

<div>
    <div>
        <ul>
            <li>username<%=customer.getUsername()%></li>
            <li>email<%=customer.getEmail()%></li>
            <li>gender<%=customer.getGender().name()%></li>
            <li>phone<%=customer.getPhone()%></li>
        </ul>
    </div>
</div>
</body>
</html>

