<%-- 
    Document   : ReporteEditor3
    Created on : 6/10/2019, 20:05:42
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.ReporteEditor3"%>
<%@page import="controller.ReporteEditorDB"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Reporte 3 Editor</title>
    </head>
    <body>
     <%@include file="navBar.jsp"%>
    <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        String fecha1Reporte3 = (String) request.getAttribute("fecha1Reporte3");
        String fecha2Reporte3 = (String) request.getAttribute("fecha2Reporte3");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha1 = formato.parse(fecha1Reporte3);
             Date fecha2 = formato.parse(fecha2Reporte3);
             java.sql.Date fecha1Reporte = new java.sql.Date(fecha1.getTime());
             java.sql.Date fecha2Reporte = new java.sql.Date(fecha1.getTime());
        ReporteEditorDB reporteDB = new ReporteEditorDB();
        ReporteEditor3 editorReporte3 = new ReporteEditor3();
        ArrayList<ReporteEditor3> listarReporte3 = reporteDB.reporte3(user.getUser_name(), fecha1Reporte, fecha2Reporte);
    %>
        <div class="container">
            
  <h2>Reporte de Likes</h2>
  <p>Reporte de Likes en un intervalo de tiempo</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Buscar Por Revista">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Revista</th>
        <th>Autor</th>
        <th>Suscriptor</th>
        <th>Fecha</th>
      </tr>
    </thead>
    <tbody id="myTable">
        <%if(listarReporte3.size()>0){
            for (ReporteEditor3 ReporteEditor4 : listarReporte3) {
                    editorReporte3 = ReporteEditor4;
                    %>
                    <tr>
        <td><%=editorReporte3.getRevista() %></td>
        <td><%=editorReporte3.getAutor() %></td>
        <td><%=editorReporte3.getSuscriptor() %></td>
        <td><%=editorReporte3.getFecha() %></td>
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
