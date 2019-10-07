<%-- 
    Document   : reporteEditor4
    Created on : 6/10/2019, 21:52:16
    Author     : RODRIGUEZ
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.ReporteEditor4"%>
<%@page import="controller.ReporteEditorDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Revista"%>
<%@page import="controller.revistaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Reporte 4</title>
    </head>
    <body>
        <%@include file="navBar.jsp"%>
        <%
            User user = (User) request.getSession().getAttribute("usuarioA");
            revistaDB revistaDB = new revistaDB();
            Revista revista = new Revista();
            ReporteEditorDB reportDB = new ReporteEditorDB();
             String fecha1Reporte4 = (String) request.getAttribute("fecha1Reporte4");
        String fecha2Reporte4 = (String) request.getAttribute("fecha2Reporte4");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha1 = formato.parse(fecha1Reporte4);
             Date fecha2 = formato.parse(fecha2Reporte4);
             java.sql.Date fecha1Reporte = new java.sql.Date(fecha1.getTime());
             java.sql.Date fecha2Reporte = new java.sql.Date(fecha1.getTime());
             ReporteEditor4 editor4 = new ReporteEditor4();
            ArrayList<Revista> listarRevista = revistaDB.getRevistaPorAutor(user.getUser_name());
            
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
        <th>Suscripciones</th>
      </tr>
    </thead>
    <tbody id="myTable">
        <%if(listarRevista.size()>0){
            for (Revista revista2 : listarRevista) {
                    revista = revista2;
                    
                    %>
                    <tr>
        <td><%=revista.getNombreRevista() %></td>
        <td><%=revista.getAutor() %></td>
        <td>
            
            <table class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>Revista</th>
                    <th>Ganancia</th>
                  </tr>
                </thead>
                <tbody id="myTable">
                    <%
                        ArrayList<ReporteEditor4> reporte4 = reportDB.reporte4(revista.getNombreRevista(), fecha1Reporte, fecha2Reporte);
                        if(reporte4.size()>0){
                        for (ReporteEditor4 ReporteEditor5 : reporte4) {
                                editor4 = ReporteEditor5;
                                %>
                                <tr>
                    <td><%=editor4.getRevista() %></td>
                    <td><%=editor4.getGanancia() %></td>
                  </tr>
                                <%
                            }
                    }

                    %>
                </tbody>
              </table>
        </td>
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
