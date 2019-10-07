<%-- 
    Document   : registrar
    Created on : 22-sep-2019, 19:08:36
    Author     : Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body style="background-image: linear-gradient(to top,#1a5377, darkslategrey); min-height: 100vh;">
        <div style="background-color: #f1f1f1; align-content: center; margin: 50px 440px; border: 1px solid black; border-radius: 10px;">
            <h2 style="text-align: center; padding-top: 15px;">Formulario Registro</h2>
            <form class="form-group" action="registroServlet" method="post">
            <div style="margin: 30px;">
                <!--ingreso del Nombre-->
                <div class="form-group" >
                <label>Nombre Completo:</label>
                <input type="text" class="form-control" placeholder="Nombre" style="width: 400px" name="nombre">
                </div>
                <!--ingreso del user-->
                <div class="form-group" >
                <label>User Name:</label>
                <input type="text" class="form-control" placeholder="User" style="width: 400px" name="name">
                </div>
                <!--ingreso del password-->
                <div class="form-group">
                <label>Password:</label>
                <input type="password" class="form-control" placeholder="Password" style="width: 400px" name="pass">
                </div>
                <!--ingreso de confirmar password-->
                <div class="form-group">
                <label>Confirmar Password:</label>
                <input type="password" class="form-control" placeholder="Repetir password" style="width: 400px" name="confirmarPassword">
                </div>
                <div class="form-group">
                <label>Tipo de Usuario:</label>
                <select class="form-control form-control-sm" name="tipoUser">
                <option>Administrador</option>
                <option>Editor</option>
                <option>Suscriptor</option>
                </select>
                </div>
                 <button type="submit" class="btn btn-primary">Registrar</button>
            </div>
        </form>
        </div>
    </body>
</html>
