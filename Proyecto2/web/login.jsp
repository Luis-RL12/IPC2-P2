<%-- 
    Document   : login
    Created on : 21/09/2019, 04:59:06 PM
    Author     : RODRIGUEZ
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
         <link rel="stylesheet" href="css/loginStyle.css">
    </head>
    <body>
        <form action="Session" class="login-form" method="post">
        <h2 style="text-align: center">Iniciar Sesión</h2>
        <div class="txtb">
            <h3 style="font-size: 15px; color: gray">User Name:</h3>
            <input type="text" name="name">
        </div>

        <div class="txtb">
            <h3 style="font-size: 15px; color: gray">Password:</h3>
            <input type="password" name="pass">
        </div>

        <input type="submit" class="logbtn" style="font-size: 20px;" value="Login">
        
        <div class="bottom-text">
            <h3>¿No tienes cuenta?</h3><a href="registrar.jsp" style="font-size: 15px;">Registrate</a>
        </div>
      </form>
    </body>
</html>
