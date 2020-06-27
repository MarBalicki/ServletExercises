<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: mbali
  Date: 25.06.2020
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<div><h3>My table with random numbers</h3></div>
<div>
    <%--<%out.print(request.getAttribute("table"));%>--%>
    <%
        String rows = request.getParameter("rows");
        String cols = request.getParameter("cols");
        Random random = new Random();
        int rowsNo = 0;
        int colsNo = 0;
        if (rows != null) {
            rowsNo = Integer.parseInt(rows);
        }
        if (cols != null) {
            colsNo = Integer.parseInt(cols);
        }
    %>
    <table>
        <%for (int i = 0; i < rowsNo; i++) {%>
        <tr>
            <%for (int j = 0; j < colsNo; j++) {%>
            <td><%=random.nextInt(186) + 20%>
            </td>
            <%}%>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>
