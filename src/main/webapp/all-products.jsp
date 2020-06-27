<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:forEach items="${products}" var="p">
        ${p.id} ${p.name} ${p.description} ${p.category} ${p.quantity}
        <br>
    </c:forEach>

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
                    <form method="post" action="/delete-product">
                        <input>
                    </form>
                </td>

            </tr>


        </c:forEach>


        </tbody>

    </table>

</div>
</body>
</html>
