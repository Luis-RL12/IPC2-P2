<%-- 
    Document   : revistas
    Created on : 30/09/2019, 19:06:47
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Revista"%>
<%@page import="controller.revistaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Revistas</title>
    </head>
    <body style="background-image: linear-gradient(to right,#3498db,darkslategray)">
         <%@include file="navBar.jsp"%>
        <%
            User user = (User) request.getSession().getAttribute("usuarioA");
            revistaDB revistaDB = new revistaDB();
            Revista revista = new Revista();
            ArrayList<Revista> listarRevista = revistaDB.getRevistaPorAutor(user.getUser_name());
        %>
        <div style="text-align: center;  width: 100%; margin: 30px auto; padding-top: 30px; padding-bottom: 30px;">
        <h1><span class="badge badge-secondary" style="text-align: center;">Tus Revistas</span></h1>
      <!-- <a id="mostrar" href="pdfController?action=insert" class="btn btn-primary" role="button" style="float: right; margin-right: 60px;"> Subir Edicion de Revista</a> -->
        <div style="float: right; margin-right: 60px;"><%@include file="nuevaRevistaModel.jsp"%></div> 
       <br><br>
            <div class="datagrid" style="width: 90%; margin: auto">
               <table class="table">
                   <thead class="thead-light">
                       <tr>
                           <th>Nombre</th>
                           <th>Autor</th>
                           <th>Descripcion</th>
                           <th>Costo Subs</th>
                           <th>Categoria</th>
                           <th>Fecha</th>
                           <th>Likes?</th>
                           <th>Comentarios?</th>
                           <th>Subs?</th>
                           <th>Aprobado?</th>
                           <th>Costo Sistema</th>
                       </tr>
                   </thead>
                   <tbody style="background-color: white">
                       <%if (listarRevista.size() > 0) {
                               for (Revista listar2 : listarRevista) {
                                   revista = listar2;
                       %>
                       <tr>
                           <td><%=revista.getNombreRevista()%></td>
                           <td><%=revista.getAutor() %></td>
                           <td><%=revista.getDescripcion() %></td>
                           <td><%=revista.getCosto() %></td>
                           <td><%=revista.getCategoria() %></td>
                           <td><%=revista.getFecha() %></td>
                           <td><%=revista.isLikes() %></td>
                           <td><%=revista.isComentarios() %></td>
                           <td><%=revista.isIsSuscribable() %></td>
                           <td><%=revista.isIsAprovado() %></td>
                           <td><%=revista.getCostoDia() %></td>
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
