<%-- 
    Document   : revistas-aprobadas
    Created on : 4/10/2019, 00:50:21
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="controller.revistaDB"%>
<%@page import="model.Revista"%>
<%@page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Revistas Aprobadas</title>
    </head>
    <body style="background-image: linear-gradient(to right,darkslategrey,#869399)">
        <%@include file="admin-navBar.jsp" %>
         <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        Revista revista = new Revista();
        revistaDB revistaDB = new revistaDB();
        ArrayList<Revista> listar = revistaDB.getRevistasAprobadas();
    %>
    <div style="text-align: center;  width: 90%; margin: 30px auto; padding-top: 30px; padding-bottom: 30px;">
        <h1><span class="badge badge-success" style="text-align: center;">Revistas 'Aprobadas'</span></h1>
      <!-- <a id="mostrar" href="pdfController?action=insert" class="btn btn-primary" role="button" style="float: right; margin-right: 60px;"> Subir Edicion de Revista</a> -->
        <br><br>
            <div class="datagrid" style="width: 90%; margin: auto">
               <table class="table table-striped table-dark">
                   <thead>
                       <tr>
                           <th scope="col">Nombre</th>
                           <th scope="col">Autor</th>
                           <th scope="col">Fecha</th>
                           <th scope="col">¿Esta Aprobado?</th>
                           <th scope="col">Costo Por Día</th>
                           <th scope="col">Costo Suscripcion</th>
                           <th scope="col">'Modificar'</th>
                       </tr>
                   </thead>
                   <tbody>
                       <%if (listar.size() > 0) {
                               for (Revista listar2 : listar) {
                                   revista = listar2;
                       %>
                       <tr>
                           <th scope="row"><%=revista.getNombreRevista() %></th>
                           <td><%=revista.getAutor() %></td>
                           <td><%=revista.getFecha() %></td>
                           <td><%=revista.isIsAprovado() %></td>
                           <td><%=revista.getCostoDia() %></td>
                           <td><%=revista.getCosto() %></td>
                           <td>
                               <a href="adminCostosServlet?revista=<%=revista.getNombreRevista() %>" class="btn btn-info" role='button' >Costos</a>
                           </td>
                       </tr>
                       <%}
  
                           }else{
                              out.print("<h1>No hay Revistas por Aprobar</h1>");
                            }%>
                   </tbody>
               </table>
           </div>
    </div>
    </body>
</html>
