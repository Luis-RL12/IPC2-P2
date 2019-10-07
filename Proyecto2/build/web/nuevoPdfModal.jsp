<%@page import="java.util.ArrayList"%>
<%@page import="controller.revistaDB"%>
<%@page import="model.Revista"%>
<%@page import="model.User"%>
<%@page import="model.Edicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Nueva Edicion de Revista</button>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title" id="exampleModalLabel"><span class="badge badge-secondary" style="text-align: center">Nueva Edicion de Revista</span></h1>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <div class="modal-body" style="text-align: left">
         <%
               revistaDB revDB = new revistaDB();
               User actual = (User) request.getSession().getAttribute("usuarioA");
               Revista revista = new Revista();
               ArrayList<Revista> rev = revDB.getRevistaPorAutor(actual.getUser_name());
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
            <form name="formpdf" class="form-group" class="justify-content-center" action="pdfController?estado=insert" method="post" enctype="multipart/form-data">
                <lable>Nombre de la Edicion:</lable>
                <input type="text" class="form-control" placeholder="Nombre" name="txtname" value="<c:out value="${row.nombrepdf}" />" />
                <input type="text" name="username" value="<%=actual.getUser_name()%>" hidden="true">
                <br>
                <label>Revista:</label>
                <select class="form-control" id="exampleFormControlSelect1" name="revistaElegida">
                                    <%
                                        for (int i = 0; i < rev.size(); i++) {
                                                out.print("<option>"+rev.get(i).getNombreRevista()+"</option>");
                                            }
                                            %>
                </select>
                <br>
                <label>Fecha:</label>
                <input type="date" class="form-control" name="fecha">
                <br>
                <label>Archivo PDF:</label>
                <input class="form-control" style="height: 40px; padding-bottom: 50px;" type="file" name="fichero" value=""/>
                <br>
                <input type="submit" value="Publicar Archivo" name="submit" id="btn" class="btn btn-primary"/>
            </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>