<%-- 
    Document   : verpdf
    Created on : 26/09/2019, 00:16:01
    Author     : RODRIGUEZ
--%>

<%@page import="model.User"%>
<%@page import="model.Edicion"%>
<%@page import="controller.pdfDB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Tus PDF</title>
    </head>
    <body style="background-image: linear-gradient(to right,#3498db,#8e44ad)">
        <%@include file="navBar.jsp"%>
    <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        pdfDB emp = new pdfDB();
        Edicion pdfvo = new Edicion();
        ArrayList<Edicion> listar = emp.Listar_PdfVO(user.getUser_name());
    %>

    <div style="text-align: center;  width: 90%; margin: 30px auto; padding-top: 30px; padding-bottom: 30px;">
        <h1><span class="badge badge-secondary" style="text-align: center;">Tus ediciones de revista</span></h1>
        <div style="float: right; margin-right: 60px;"><%@include file="nuevoPdfModal.jsp"%></div> 
      <!-- <a id="mostrar" href="pdfController?action=insert" class="btn btn-primary" role="button" style="float: right; margin-right: 60px;"> Subir Edicion de Revista</a> -->
        <br><br>
            <div class="datagrid" style="width: 90%; margin: auto">
               <table class="table">
                   <thead class="thead-light">
                       <tr>
                           <th>Codigo</th>
                           <th>Nombre</th>
                           <th>Revista</th>
                           <th>Editor</th>
                           <th>Fecha</th>
                           <th>Pdf</th>
                           <th>Acciones</th>
                       </tr>
                   </thead>
                   <tbody style="background-color: white">
                       <%if (listar.size() > 0) {
                               for (Edicion listar2 : listar) {
                                   pdfvo = listar2;
                       %>
                       <tr>
                           <td><%=pdfvo.getCodigopdf()%></td>
                           <td><%=pdfvo.getNombrepdf()%></td>
                           <td><%=pdfvo.getCodigoRevista()%></td>
                           <td><%=pdfvo.getAutor()%></td>
                           <td><%=pdfvo.getFechaPublicacion()%></td>
                           <td>
                               <%
                                   if (pdfvo.getArchivopdf2() != null) {
                               %>
                               <a href="pdf?id=<%=pdfvo.getCodigopdf()%>" target="_blank" type="button" class="btn btn-outline-success">Ver PDF</a>
                                   <%
                                       } else {
                                           out.print("Vacio");
                                       }
                                   %>
                           </td>
                           <td>

                               <a href="pdfController?action=edit&id=<%=pdfvo.getCodigopdf()%>" type="button" class="btn btn-outline-info">Modificar</a>
                               <a href="pdfController?action=delete&id=<%=pdfvo.getCodigopdf()%>" type="button" class="btn btn-outline-danger">Eliminar</a>
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
