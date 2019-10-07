<%-- 
    Document   : revistas-suscritas
    Created on : 6/10/2019, 02:39:37
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Suscripcion"%>
<%@page import="controller.suscripcionDB"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Suscripciones</title>
    </head>
      <body background="files/default.jpg" style="background-repeat: repeat; background-size: cover">
          <%@include file="sus-navBar.jsp"%>
        <%
            User user = (User) request.getSession().getAttribute("usuarioA");
            suscripcionDB susDB = new suscripcionDB();
            Suscripcion nuevaSuscripcion = new Suscripcion();
            ArrayList<Suscripcion> suscripciones = susDB.suscripcionesPorUser(user.getUser_name());
        %>
        
        <table class="table table-striped" style="background-color: window; width: 70%; margin: auto; margin-top: 30px;">
  <thead>
    <tr>
      <th scope="col">Revista</th>
      <th scope="col">Suscriptor</th>
      <th scope="col">Fecha</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
      <%if(suscripciones.size()>0){
          for (Suscripcion suscrip1 : suscripciones) {
                  nuevaSuscripcion = suscrip1;
                  
                  %>
                  <tr>
                    <td><%=nuevaSuscripcion.getCodigoRevista() %></td>
                    <td><%=nuevaSuscripcion.getCodigoSuscriptor() %></td>
                    <td><%=nuevaSuscripcion.getFecha() %></td>
                    <td>
                        <a class="btn btn-primary" href="revistaEspecificaServlet?revista=<%=nuevaSuscripcion.getCodigoRevista() %>" role="button">Ver Revista</a>
                    </td>
                  </tr>
                  <%
              }
      }else{
                out.print("Aun no tienes Suscripciones");
        }
          
      %>
  </tbody>
</table>
         <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
