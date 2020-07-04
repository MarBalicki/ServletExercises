<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="/">Home</a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/all-products">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/add-product">Add product</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/users">Users</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/shopping-cart">Shopping Cart</a>
        </li>
        <c:if test="${empty user}">
            <li class="nav-item">
                <a class="nav-link" href="/register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
        </c:if>
        <c:if test="${not empty user}">
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </c:if>
    </ul>
</nav>
<div class="container">
    <%--    <c:forEach items="${products}" var="p">--%>
    <%--        ${p.id} ${p.name} ${p.description} ${p.category} ${p.quantity}--%>
    <%--        <br>--%>
    <%--    </c:forEach>--%>
        <form method="post" action="/filter-products">
            <div class="form-group">
                <label for="filter">Filter:</label>
                <input type="text" class="form-control" id="filter" name="filter">
            </div>
        </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Description</th>
            <th scope="col">Category</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.description}</td>
                <td>${p.category}</td>
                <td>${p.quantity}</td>
                <td>
                    <form method="post" action="/product-to-edit">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="Edit product"/>
                    </form>
                    <form method="post" action="/delete-product">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="Delete product"/>
                    </form>
                    <form method="post" action="/add-to-cart">
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="submit" value="Add product"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
