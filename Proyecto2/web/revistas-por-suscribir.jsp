<%-- 
    Document   : revistas-por-suscribir
    Created on : 4/10/2019, 12:35:15
    Author     : RODRIGUEZ
--%>

<%@page import="controller.suscripcionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Revista"%>
<%@page import="controller.revistaDB"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
            revistaDB revistaDB = new revistaDB();
            Revista revista = new Revista();
            ArrayList<Revista> listarRevista = revistaDB.getRevistasAprobadas();
            suscripcionDB suscripcionDB = new suscripcionDB();
        %>
        <div style="text-align: center;  width: 100%; margin: 30px auto; padding-top: 30px; padding-bottom: 30px;">
        <h1><span class="badge badge-secondary" style="text-align: center;">Revistas</span></h1>
            <div class="datagrid" style="width: 70%; margin: auto">
               <table>
                   <thead>
                       <tr>
                           
                       </tr>
                   </thead>
                   <tbody>
                       <%if (listarRevista.size() > 0) {
                               for (Revista listar2 : listarRevista) {
                                   revista = listar2;
                                   int cantLikes = revistaDB.cantidadLikes(revista.getNombreRevista());
                       %>
                       <tr>
                           <td>
                                <div class="card bg-light mb-3">
                                <div class="row no-gutters">
                                  <div class="col-md-4">
                                   <%
                                       if(revista.getFoto() == null){
                                           
                                           %>
                                            <img src="files/empty.png" class="card-img-top" alt="Image Not Found">
                                           <%
                                       }else{

                                           %>
                                            <img src="files/revistas/<%=revista.getFoto()%>" class="card-img-top" alt="Image Not Found">
                                           <%
                                       }
                                   %>   
                                  </div>
                                  <div class="col-md-6">
                                      <div class="card-body" style="text-align: left">
                                          <h2 class="card-title" style="text-align: center" id="firstName"><%=revista.getNombreRevista() %></h2>
                                      <p class="card-text" ><b>Autor: </b><%=revista.getAutor() %></p>
                                      <p class="card-text" ><b>Categoria:   </b><%=revista.getCategoria() %></p>
                                      <p class="card-text"><b>Etiquetas:   </b><%=revista.getTags() %></p>
                                      <p class="card-text"><b>Cantidad Likes:   </b><%=cantLikes%></p>
                                      <p class="card-text"><b>Descripcion:   </b><textarea class="form-control" id="descripcion" readonly="true" name="descripcion" rows="1"><%=revista.getDescripcion() %></textarea></p>
                                       <!-- Button trigger modal -->
                                       <% if(suscripcionDB.suscripcionPorUsuarioYRevista(user.getUser_name(), revista.getNombreRevista()) != null){
                                           %><h2><span class="badge badge-secondary" style="text-align: center;">Suscrito</span></h2>
                                           <%
                                       }else if(revista.isIsSuscribable()==false){
                                            %>
                                            <h2><span class="badge badge-danger" style="text-align: center;">Suscripcion Desactivada</span></h2>
                                            <%
                                        }
                                            else{
                                           %><a class="btn btn-primary" href="suscripcionServlet?nombreRevista=<%=revista.getNombreRevista() %>" role="button">Suscribirse</a>
                                           <%
                                       }
                                       %>
                                        
                                    </div>
                                  </div>
                                </div>
                              </div>
                                    
                                   

                                  
                                    
                           </td>
                       </tr>
                       <%}
  
                           }%>

                   </tbody>
               </table>
           </div>
    </div>
         <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>