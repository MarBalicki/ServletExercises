<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 align="center">Dodaj produkt</h1>
    <c:if test="${not empty error}">
        <h3 style="color: red">Error while submiting form : ${error}</h3><br>
    </c:if>
    <form method="post" action="/add-product">
        <div class="form-group">
            <label for="productName">Product:</label>
            <input type="text" class="form-control" id="productName" placeholder="Enter product name" name="name">
        </div>
        <div class="form-group">
            <label for="price">Product price:</label>
            <input type="number" class="form-control" id="price" placeholder="Enter price" name="price">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" placeholder="Enter description" name="description">
        </div>
        <div class="form-group">
            <label for="category">category:</label>
            <select id="category" class="form-control" name="category" size="1">
                <option>ELECTRONICS</option>
                <option>HEALTH</option>
                <option>SPORT</option>
                <option>FOOD</option>
            </select>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
