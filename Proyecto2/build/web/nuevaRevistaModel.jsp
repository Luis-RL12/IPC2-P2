<%-- 
    Document   : nuevaRevistaModel
    Created on : 2/10/2019, 01:14:45
    Author     : RODRIGUEZ
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<!-- Extra large modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-xl">Nueva Revista</button>

<div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title" id="exampleModalLabel"><span class="badge badge-secondary" style="text-align: center">Nueva Revista</span></h1>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <div class="modal-body" style="text-align: left">
            <%
                 User actual = (User) request.getSession().getAttribute("usuarioA");
                %>
            <form name="formpdf" class="justify-content-center" action="revistaServlet" method="post">
                <div class="form-group" id="izquierda" style="width: 49%; float: left">
                    <div class="form-group">
                        <label for="nombreRevista">Nombre de la Revista</label>
                        <input type="text" class="form-control" id="nombreRevista" placeholder="Nombre" name="nameRevista" value="<c:out value="${row.nombrepdf}" />" />
                        <input type="text" name="username" value="<%=actual.getUser_name()%>" hidden="true">
                    </div>
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
                        <select class="custom-select" id="inputGroupSelect01" name="categoria">
                        <option selected>Ciencia</option>
                        <option selected>Tecnologia</option>
                        <option selected>Medicina</option>
                      </select>
                    </div>
                     <div class="form-group">
                         <div class="custom-control custom-switch">
                                <input type="checkbox" class="custom-control-input" id="customSwitch4" name="likes" value="1">
                                <label class="custom-control-label" for="customSwitch4">Revista Gratuita</label>
                              </div>
                        <label for="costo">Costo Subscripcion</label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                              <span class="input-group-text">Q</span>
                            </div>
                            <input type="text" class="form-control" name="costoSubscripcion" aria-label="Amount (to the nearest dollar)">
                          </div>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <textarea class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
                    </div>
                </div>
                   
                      <div class="form-group" id="derecha" style="width: 49%; float: right">
                         <div class="form-group">
                        <label for="tags">Tags:</label>
                        <textarea class="form-control" id="descripcion" name="tags" rows="1"></textarea>
                          </div>
                          <div class="form-group">
                        <label for="fecha">Fecha</label>
                        <input type="date" class="form-control" name="fecha">
                       </div>
                        <div class="form-group">
                                <div class="custom-control custom-switch">
                                <input type="checkbox" class="custom-control-input" id="customSwitch1" name="likes" value="1">
                                <label class="custom-control-label" for="customSwitch1">Permitir Likes</label>
                              </div>
                       </div>
                          <div class="form-group">
                                <div class="custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="customSwitch2" name="comentarios">
                                <label class="custom-control-label" for="customSwitch2">Permitir Comentarios</label>
                              </div>
                       </div>
                          <div class="form-group">
                                <div class="custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="customSwitch3" name="suscripciones">
                                <label class="custom-control-label" for="customSwitch3">Permitir Suscripciones</label>
                              </div>
                       </div>
                          <div class="form-group">
                            <label for="fotoRevista">Foto de la Revista:</label>
                            <input type="file" id="fotoRevista" value="" name="foto">
                        
                          </div>
                          <div style="text-align: center">
                          <input type="submit" value="Registrar Revista" name="submit" id="btn" class="btn btn-primary"/>
                          </div>
                    </div>
            </form>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

