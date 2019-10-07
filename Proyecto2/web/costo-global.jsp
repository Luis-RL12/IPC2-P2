<%-- 
    Document   : costo-global
    Created on : 4/10/2019, 02:14:46
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
    <body style="background-image: linear-gradient(to right,darkslategray,darkslategrey)">
        <%@include file="admin-navBar.jsp" %>
         <%
            
        User user = (User) request.getSession().getAttribute("usuarioA");
        revistaDB rev = new revistaDB();
        float costo_dia = rev.getCosto_dia();
         try {
                Revista revista =  (Revista) request.getAttribute("row");
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
c    </script>
    <div style="width: 50%; margin: auto; margin-top: 20px; color: white">
        <form action="adminPages" method="post">
        <div class="form-group">
        <h1><span class="badge badge-success">Costo por Dia Global </span></h1>
      </div>
      <div class="form-group">
        <h5 for="revista">Costo por Dia Global</h5>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1"  value="" onChange="comprobar(this);">
        <label class="custom-control-label" for="customCheck1">Modificar Costo por Dia Global</label>
      </div>
        <input type="text" id="boton" class="form-control" readonly="true" placeholder="Costo Suscripcion" name="cGlobal" value="<%=costo_dia %>"/>
      </div>
      <input type="submit" value="Modificar Costo por dia Global" name="submit" id="btn" class="btn btn-primary"/>
    </form>
    </div>
                   
        
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
