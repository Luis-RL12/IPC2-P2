<%-- 
    Document   : reporteEditor2
    Created on : 6/10/2019, 19:12:20
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.ReporteEditor2"%>
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
        <title>Reporte Editor 2</title>
    </head>
    <body>
        <%@include file="navBar.jsp"%>
    <%
        User user = (User) request.getSession().getAttribute("usuarioA");
        String fecha1Reporte2 = (String) request.getAttribute("fecha1Reporte2");
        String fecha2Reporte2 = (String) request.getAttribute("fecha2Reporte2");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha1 = formato.parse(fecha1Reporte2);
             Date fecha2 = formato.parse(fecha2Reporte2);
             java.sql.Date fecha1Reporte = new java.sql.Date(fecha1.getTime());
             java.sql.Date fecha2Reporte = new java.sql.Date(fecha1.getTime());
        ReporteEditorDB reporteDB = new ReporteEditorDB();
        ReporteEditor2 editorReporte2 = new ReporteEditor2();
        ArrayList<ReporteEditor2> listarReporte2 = reporteDB.reporte2(user.getUser_name(), fecha1Reporte, fecha2Reporte);
    %>
        <div class="container">
            
  <h2>Reporte de Suscripciones</h2>
  <p>Reporte de suscripciones en un intervalo de tiempo</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Buscar Por Revista">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Autor</th>
        <th>Revista</th>
        <th>Suscriptor</th>
        <th>Fecha</th>
      </tr>
    </thead>
    <tbody id="myTable">
        <%if(listarReporte2.size()>0){
            for (ReporteEditor2 ReporteEditor3 : listarReporte2) {
                    editorReporte2 = ReporteEditor3;
                    %>
                    <tr>
        <td><%=editorReporte2.getAutor() %></td>
        <td><%=editorReporte2.getCod_revista() %></td>
        <td><%=editorReporte2.getCod_suscriptor() %></td>
        <td><%=editorReporte2.getFecha() %></td>
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
