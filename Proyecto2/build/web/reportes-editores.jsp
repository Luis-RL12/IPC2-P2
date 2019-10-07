<%-- 
    Document   : reportes-editores
    Created on : 6/10/2019, 18:18:56
    Author     : RODRIGUEZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Reportes Editores</title>
    </head>
    <body>
         <%@include file="navBar.jsp"%>
    <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        
    %>
    <div class="container">
        <form action="ReportesEditores?reporte=1" method="post">
        <h1>REPORTE 1</h1>
        <label>Fecha 1:</label>
        <input type="date" name="fecha1Reporte1" required="true">
        <label>Fecha 2:</label>
        <input type="date" name="fecha2Reporte1" required="true">
        <button type="submit" class="btn btn-primary">Generar Reporte 1</button>
        </form>
    </div>
    <br>
    <br>
    <div class="container">
        <form action="ReportesEditores?reporte=2" method="post">
        <h1>REPORTE 2</h1>
        <label>Fecha 1:</label>
        <input type="date" name="fecha1Reporte2" required="true">
        <label>Fecha 2:</label>
        <input type="date" name="fecha2Reporte2" required="true">
        <button type="submit" class="btn btn-primary">Generar Reporte 2</button>
        </form>
    </div>
    <br>
    <br>
    <div class="container">
        <form action="ReportesEditores?reporte=3" method="post">
        <h1>REPORTE 3</h1>
        <label>Fecha 1:</label>
        <input type="date" name="fecha1Reporte3" required="true">
        <label>Fecha 2:</label>
        <input type="date" name="fecha2Reporte3" required="true">
        <button type="submit" class="btn btn-primary">Generar Reporte 3</button>
        </form>
    </div>
     <br>
    <br>
    <div class="container">
        <form action="ReportesEditores?reporte=4" method="post">
        <h1>REPORTE 4</h1>
        <label>Fecha 1:</label>
        <input type="date" name="fecha1Reporte4" required="true">
        <label>Fecha 2:</label>
        <input type="date" name="fecha2Reporte4" required="true">
        <button type="submit" class="btn btn-primary">Generar Reporte 4</button>
        </form>
    </div>
    </body>
</html>
