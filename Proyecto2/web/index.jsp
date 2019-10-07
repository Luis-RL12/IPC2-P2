<%-- 
    Document   : index
    Created on : 23/09/2019, 10:07:52
    Author     : RODRIGUEZ
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Index</title>
    </head>
    <body background="files/img1.png" style="opacity: 70px">
        
        <div style="width: 80%; margin: 150px;">
            <div style="color: white;">
                <h1 class="display-1">Magazine S.A.</h1>
                <h1 class="lead">Magazine S.A es un sitema de Revistas Online, con un sin fin de elecciones ¡Como te gusta!</h1>
                <hr class="my-4" style="background-color: white">
                <p>Logueate o Registrate para disfrutar del mejor Servicio Online.</p>
                <% 
                    User actual = (User) session.getAttribute("usuarioA");
                    if(actual==null){
                        %>
                        <div class="form-inline">
                        <a class="btn btn-primary" href="login.jsp" role="button">Iniciar Sesión</a>
                        <p style="margin-left: 10px; margin-right: 10px;">o</p>
                        <a class="btn btn-light" href="registrar.jsp" role="button">Registrarse</a>
                        </div>
                        <br>
                        <%
                    }else{
                        out.print("<h4>Usuario Actual:</h4><p>"+actual.getUser_name());
                        %>
                        <br>
                        <a class="btn btn-danger btn-lg" href="#" role="button">Cierra Sesion</a>
                        <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
