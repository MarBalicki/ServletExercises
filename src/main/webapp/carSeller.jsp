<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Car seller</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 align="center">Sprzedaj swojego grata na www.grata.pl</h1>
    <form method="post" action="/carseller">
        <div class="form-group">
            <label for="brand">Select brand:</label>
            <select id="brand" class="form-control" name="brand" size="1">
                <option>OPEL</option>
                <option>AUDI</option>
                <option>FORD</option>
                <option>FIAT</option>
                <option>BMW</option>
                <option>ALFA_ROMEO</option>
                <option>PORSCHE</option>
                <option>TOYOTA</option>
                <option>VW</option>
                <option>VOLVO</option>
                <option>SUZUKI</option>
                <option>HONDA</option>
                <option>SUBARU</option>
                <option>MAZDA</option>
                <option>NISSAN</option>
                <option>LEXUS</option>
                <option>CHEVROLET</option>
                <option>CITROEN</option>
                <option>MITSUBISHI</option>
                <option>RENAULT</option>
                <option>SAAB</option>
                <option>JAGUAR</option>
                <option>KIA</option>
                <option>MERCEDES</option>
                <option>INFINITY</option>
                <option>MINI</option>
                <option>OTHER</option>
            </select>
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" class="form-control" id="model" placeholder="Enter model" name="model">
        </div>
        <div class="form-group">
            <label for="BodyStyle">Select body style:</label>
            <select id="BodyStyle" class="form-control" name="bodyStyle" size="1">
                <option>SEDAN</option>
                <option>COUPE</option>
                <option>HATCHBACK</option>
                <option>SUV</option>
                <option>PICKUP</option>
                <option>COMBI</option>
                <option>CROSSOVER</option>
                <option>MINIVAN</option>
                <option>VAN</option>
                <option>OTHER</option>
            </select>
        </div>
        <div class="form-group">
            <label for="productionYear">Production Year:</label>
            <input type="text" class="form-control" id="productionYear" placeholder="Enter production year"
                   name="productionYear">
        </div>
        <div class="form-group">
            <label for="EngineType">Select engine type:</label>
            <select id="EngineType" class="form-control" name="engineType" size="1">
                <option>PETROL</option>
                <option>DIESEL</option>
                <option>HYBRID</option>
                <option>ELECTRIC</option>
                <option>PETROL_GAS</option>
                <option>DIESEL_GAS</option>
                <option>GAS</option>
            </select>
        </div>
        <div class="form-group">
            <label for="capacity">Capacity:</label>
            <input type="text" class="form-control" id="capacity" placeholder="Enter capacity" name="capacity">
        </div>
        <div class="form-group">
            <label for="mileage">Mileage:</label>
            <input type="text" class="form-control" id="mileage" placeholder="Enter mileage" name="mileage">
        </div>
        <div class="form-group">
            <label for="numberOfDoors">Number of doors:</label>
            <input type="text" class="form-control" id="numberOfDoors" placeholder="Enter number of Doors"
                   name="numberOfDoors">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
