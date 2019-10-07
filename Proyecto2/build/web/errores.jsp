<%-- 
    Document   : errores
    Created on : 5/10/2019, 23:31:49
    Author     : RODRIGUEZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Errores</title>
    </head>
    <body>
        <h1>Error:</h1>
        <%
            out.print(request.getAttribute("error"));
        %>
        
    </body>
</html>
