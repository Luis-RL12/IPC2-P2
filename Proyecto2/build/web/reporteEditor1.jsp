<%-- 
    Document   : reporteEditor1
    Created on : 6/10/2019, 17:29:03
    Author     : RODRIGUEZ
--%>

<%@page import="model.ReporteEditor1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controller.ReporteEditorDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Reporte Editor 1</title>
    </head>
    <body>
        <%@include file="navBar.jsp"%>
    <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        String fecha1Reporte1 = (String) request.getAttribute("fecha1Reporte1");
        String fecha2Reporte1 = (String) request.getAttribute("fecha2Reporte1");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha1 = formato.parse(fecha1Reporte1);
             Date fecha2 = formato.parse(fecha2Reporte1);
             java.sql.Date fecha1Reporte = new java.sql.Date(fecha1.getTime());
             java.sql.Date fecha2Reporte = new java.sql.Date(fecha1.getTime());
        ReporteEditorDB reporteDB = new ReporteEditorDB();
        ReporteEditor1 editorReporte1 = new ReporteEditor1();
        ArrayList<ReporteEditor1> listarReporte1 = reporteDB.reporte1(user.getUser_name(), fecha1Reporte, fecha2Reporte);
    %>
        <div class="container">
            
  <h2>Reporte de Comentarios</h2>
  <p>Reporte de comentarios en un intervalo de tiempo</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Buscar Por Revista">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>id</th>
        <th>Revista</th>
        <th>Autor</th>
        <th>Suscriptor</th>
        <th>Comentario</th>
        <th>Fecha</th>
      </tr>
    </thead>
    <tbody id="myTable">
        <%if(listarReporte1.size()>0){
            for (ReporteEditor1 ReporteEditor2 : listarReporte1) {
                    editorReporte1 = ReporteEditor2;
                    %>
                    <tr>
        <td><%=editorReporte1.getId() %></td>
        <td><%=editorReporte1.getCodigoRevista() %></td>
        <td><%=editorReporte1.getAutor() %></td>
        <td><%=editorReporte1.getSuscriptor() %></td>
        <td><%=editorReporte1.getComentario() %></td>
        <td><%=editorReporte1.getFecha() %></td>
      </tr>
                    <%
                }
        }
        
        %>
    </tbody>
  </table>
</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
