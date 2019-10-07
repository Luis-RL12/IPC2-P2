<%-- 
    Document   : suscribirse
    Created on : 5/10/2019, 23:22:01
    Author     : RODRIGUEZ
--%>

<%@page import="model.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Suscribirse</title>
    </head>
    <body background="files/default.jpg" style="background-repeat: repeat; background-size: cover">
        <%@include file="sus-navBar.jsp"%>
         <%
            User user = (User) request.getSession().getAttribute("usuarioA");
            Revista revistaObtenida = (Revista) request.getAttribute("revistaObtenida");
        %>
        <div style="width: 50%; margin: auto; margin-top: 20px; color: white">
        <form action="suscripcionServlet" method="post">
        <div class="form-group">
        <h1><span class="badge badge-info"><%=revistaObtenida.getNombreRevista() %></span></h1>
        <input type="text" name="nombreSuscripcion" value="<%=revistaObtenida.getNombreRevista() %>" hidden="true">
      </div>
      <div class="form-group">
        <h5 for="revista">Usuario a suscribirse:</h5>
        <input type="text" id="usuario" class="form-control" readonly="true" name="usuario" value="<%=user.getUser_name() %>"/>
      </div>
      <div class="form-group">
        <h5 for="revista">Costo de la Revista:</h5>
        <input type="text" id="usuario" class="form-control" readonly="true" name="costoSuscripcion" value="<%=revistaObtenida.getCosto() %>"/>
      </div>
      <div class="form-group">
        <h5 for="revista">Fecha: </h5>
        <input type="date" class="form-control" name="fechaSuscripcion" />
      </div>
      <input type="submit" value="Suscribirse" name="suscribirse" id="btnSuscribirse" class="btn btn-success"/>
    </form>
    </div>
    </body>
</html>
