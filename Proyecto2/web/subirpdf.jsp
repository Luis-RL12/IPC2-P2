<%-- 
    Document   : subirpdf
    Created on : 25/09/2019, 17:24:54
    Author     : RODRIGUEZ
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.revistaDB"%>
<%@page import="model.Revista"%>
<%@page import="model.User"%>
<%@page import="model.Edicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Subir PDF</title>
    </head>
    <body style="background-image: linear-gradient(to left,#3498db,#8e44ad)">
         <%@include file="navBar.jsp"%>
        <%
               revistaDB revDB = new revistaDB();
               User user = (User) request.getSession().getAttribute("usuarioA");
               Revista revista = new Revista();
               ArrayList<Revista> rev = revDB.getRevistaPorAutor(user.getUser_name());
        %>
        <%
            Integer dato = 0;
            try {
                Edicion pdf = (Edicion) request.getAttribute("row");
                dato = pdf.getCodigopdf();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            boolean icono = false;
            try {
                icono = (Boolean) request.getAttribute("row2");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        %>
        <div style="width:600px; align-content: center; margin: auto; color: white;">
            <h1 style="text-align: center"><span class="badge badge-secondary" style="text-align: center">Nueva Edicion de Revista</span></h1>
            <form name="formpdf" class="form-group" class="justify-content-center" action="pdfController" method="post" enctype="multipart/form-data">
                <h5>Nombre de la Edicion:</h5>
                <input type="text" class="form-control" placeholder="Nombre" name="txtname" value="<c:out value="${row.nombrepdf}" />" />
                <input type="text" name="username" value="<%=user.getUser_name()%>" hidden="true">
                <br>
                <h5>Revista:</h5>
                <select class="form-control" id="exampleFormControlSelect1" name="revistaElegida">
                                    <%
                                        for (int i = 0; i < rev.size(); i++) {
                                                out.print("<option>"+rev.get(i).getNombreRevista()+"</option>");
                                            }
                                            %>
                </select>
                <br>
                <h5>Fecha:</h5>
                <input type="date" class="form-control" name="fecha">
                <br>
                <h5>Archivo PDF:</h5>
                <input class="form-control" style="height: 40px; padding-bottom: 50px;" type="file" name="fichero" value=""/>
                <br>
                <input type="submit" value="Publicar Archivo" name="submit" id="btn" class="btn btn-primary"/>
            </form>
                 <a href="verpdf.jsp">Regresar</a>
        </div>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/wwazbootstrap.min.js"></script>
    </body>
</html>
