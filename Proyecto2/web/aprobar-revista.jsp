<%@page import="controller.revistaDB"%>
<%@page import="model.Revista"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aprobar Revista</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body style="background-image: linear-gradient(to right,darkslategrey,#869399)">
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
                      document.getElementById('boton').readOnly = true;

                    else
                      document.getElementById('boton').readOnly = false;

                }
    </script>
    <div style="width: 50%; margin: auto; margin-top: 20px; color: white">
        <form action="adminServlet" method="post">
        <div class="form-group">
        <h1><span class="badge badge-info"><c:out value="${row.nombreRevista}"/></span></h1>
        <input type="text" name="name_Revista" value="<c:out value="${row.nombreRevista}"/>" hidden="true">
      </div>
      <div class="form-group">
        <h5 for="revista">Costo Por Día</h5>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1" name="costoDia" value="<%=costo_dia%>" onChange="comprobar(this);">
        <label class="custom-control-label" for="customCheck1">Usar Costo Global</label>
      </div>
        <input type="text" id="boton" class="form-control" placeholder="Costo Por Día" name="costoDia"/>
      </div>
      <input type="submit" value="Aprobar Revista" name="submit" id="btn" class="btn btn-success"/>
    </form>
    </div>
                   
        
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>