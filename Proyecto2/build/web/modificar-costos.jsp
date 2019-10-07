<%-- 
    Document   : modificar-costos
    Created on : 4/10/2019, 01:14:05
    Author     : RODRIGUEZ
--%>

<%@page import="model.Revista"%>
<%@page import="controller.revistaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Modificar Costos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body style="background-image: linear-gradient(to right,#2b2b2b,#4e4e4e)">
        <%@include file="admin-navBar.jsp" %>
         <%
             float costo_suscripcion = 0;
             float costo_dia_revista = 0;
        User user = (User) request.getSession().getAttribute("usuarioA");
        revistaDB rev = new revistaDB();
        float costo_dia = rev.getCosto_dia();
         try {
                Revista revista =  (Revista) request.getAttribute("row");
                 costo_suscripcion = revista.getCosto();
                 costo_dia_revista = revista.getCostoDia();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    %>
    <script languaje="javascript">
           function comprobar(obj)
                {   
                    if (obj.checked)
                      document.getElementById('boton').readOnly = false;

                    else
                      document.getElementById('boton').readOnly = true;

                }
                function comprobar2(obj2)
                {   
                    if (obj2.checked)
                      document.getElementById('boton2').readOnly = false;

                    else
                      document.getElementById('boton2').readOnly = false;

                } 
    </script>
    <div style="width: 50%; margin: auto; margin-top: 20px; color: white">
        <form action="adminCostosServlet" method="post">
        <div class="form-group">
        <h1><span class="badge badge-info"><c:out value="${row.nombreRevista}"/></span></h1>
        <input type="text" name="name_Revista" value="<c:out value="${row.nombreRevista}"/>" hidden="true">
      </div>
      <div class="form-group">
        <h5 for="revista">Costo de Suscripcion</h5>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1"  value="" onChange="comprobar(this);">
        <label class="custom-control-label" for="customCheck1">Modificar Costo Suscripcion</label>
      </div>
        <input type="text" id="boton" class="form-control" readonly="true" placeholder="Costo Suscripcion" name="costoSus" value="<%=costo_suscripcion %>"/>
      </div>
      <div class="form-group">
        <h5 for="revista">Costo Por Día</h5>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck2"  value="" onChange="comprobar2(this);">
        <label class="custom-control-label" for="customCheck2">Modificar Costo Por Día</label>
      </div>
        <input type="text" id="boton2" class="form-control" readonly="true" placeholder="Costo Por Día" name="costoDia" value="<%=costo_dia_revista%>"/>
      </div>
      <input type="submit" value="Modificar Costos" name="submit" id="btn" class="btn btn-primary"/>
    </form>
    </div>
                   
        
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
