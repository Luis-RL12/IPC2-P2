<%-- 
    Document   : administradores
    Created on : 3/10/2019, 17:12:54
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="controller.revistaDB"%>
<%@page import="model.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Administradores</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body style="background-image: linear-gradient(to right,darkslategrey,#869399)">
        <%@include file="admin-navBar.jsp" %>
         <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        Revista revista = new Revista();
        revistaDB revistaDB = new revistaDB();
        ArrayList<Revista> listar = revistaDB.getRevistaNoAprobado();
    %>
    <div style="text-align: center;  width: 90%; margin: 30px auto; padding-top: 30px; padding-bottom: 30px;">
        <h1><span class="badge badge-danger" style="text-align: center;">Revistas 'No' Aprobadas</span></h1>
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
                           <th scope="col">'Acciones'</th>
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
                           <td>
                               <a href="adminServlet?revista=<%=revista.getNombreRevista() %>" class="btn btn-success" role='button' >Aprobar</a>
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
                   <c:if test="${requestScope['error'] != null}">
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#InfoModal').modal('show');
                });
            </script>
        </c:if>

        <div class="modal fade" id="InfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Error</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Error al Aprobar la revista
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
