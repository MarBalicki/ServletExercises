<%--
  Created by IntelliJ IDEA.
  User: mbali
  Date: 25.06.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div><h3>Formularz rejestracyjny</h3></div>
<form action="/register" method="post">
<div>
    <div>
        <label>username</label>
        <input name="username" type="text">

    </div>
    <div>
        <label>password</label>
        <input name="password" type="password">

    </div>
    <div>
        <label>gender</label>
        <select name="gender">
            <option>Female</option>
            <option>MALE</option>
        </select>

    </div>
    <div>
        <label>email</label>
        <input name="email" type="email">

    </div>
    <div>
        <label>phone</label>
        <input name="phone" type="tel">

    </div>
    <div>
        <button type="submit" formmethod="post">Send</button>
    </div>
</div>
</form>

</body>
</html>
