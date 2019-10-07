<%-- 
    Document   : revista-especifica
    Created on : 6/10/2019, 03:41:57
    Author     : RODRIGUEZ
--%>

<%@page import="model.Comentario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Edicion"%>
<%@page import="controller.suscripcionDB"%>
<%@page import="model.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Detalles De Revista</title>
    </head>
    <body style="background-color: darkslategray">
        <%@include file="sus-navBar.jsp"%>
        <%
             User user = (User) request.getSession().getAttribute("usuarioA");
             Revista revista = (Revista) request.getAttribute("revistaObtenida");
              suscripcionDB sDB = new suscripcionDB();
                 Edicion pdfvo = new Edicion();
                 Comentario comentarios = new Comentario();
                 ArrayList<Edicion> listar = sDB.pdfRevista(revista.getNombreRevista());
                 ArrayList<Comentario> listarComentario = sDB.comentariosRevistaSuscriptor(revista.getNombreRevista(), user.getUser_name());
                 
        %>
        <br>
        <div style="width: 65%; margin: auto; color: white">
            <h1><span class="badge badge-info"><%=revista.getNombreRevista() %></span></h1>
            <div class="form-group">
                        <label for="autorRevista">Autor:</label>
                        <input type="text" class="form-control" id="autorRevista" readonly="true" name="nameRevista" value="<%=revista.getAutor() %>"/>
            </div>
            <div class="form-group">
                        <label for="categoriaRevista">Categoria:</label>
                        <input type="text" class="form-control" id="categoriaRevista" readonly="true" name="categoriaRevista" value="<%=revista.getCategoria() %>"/>
            </div>
             <div class="form-group">
                        <label for="descripcionRevista">Descripcion:</label>
                        <textarea class="form-control" id="descripcionRevista" name="descripcionRevista" readonly="true" rows="3"><%=revista.getDescripcion()%></textarea>
            </div>
            <div class="form-group">
                        <label for="tagsRevista">Tags:</label>
                        <input type="text" class="form-control" id="tagsRevista" readonly="true" name="tagsRevista" value="<%=revista.getTags() %>"/>
            </div>
            <div class="form-group">
                        <label for="fechaRevisat">Fecha Publicacion:</label>
                        <input type="text" class="form-control" id="fechaRevisat" readonly="true" name="fechaRevisat" value="<%=revista.getFecha() %>"/>
            </div>
            <div class="accordion" id="accordionExample">
                <div class="card">
                  <div class="card-header" id="headingOne">
                    <h2 class="mb-0">
                      <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        EDICIONES:
                      </button>
                    </h2>
                  </div>
                  <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="card-body">
                         <table class="table">
                                <thead class="thead-light">
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Nombre</th>
                                        <th>Revista</th>
                                        <th>Editor</th>
                                        <th>Fecha</th>
                                        <th>Pdf</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if (listar.size() > 0) {
                                            for (Edicion listar2 : listar) {
                                                pdfvo = listar2;
                                    %>
                                    <tr>
                                        <td><%=pdfvo.getCodigopdf()%></td>
                                        <td><%=pdfvo.getNombrepdf()%></td>
                                        <td><%=pdfvo.getCodigoRevista()%></td>
                                        <td><%=pdfvo.getAutor()%></td>
                                        <td><%=pdfvo.getFechaPublicacion()%></td>
                                        <td>
                                            <%
                                                if (pdfvo.getArchivopdf2() != null) {
                                            %>
                                            <a href="pdf?id=<%=pdfvo.getCodigopdf()%>" target="_blank" type="button" class="btn btn-outline-success">Ver PDF</a>
                                                <%
                                                    } else {
                                                        out.print("Vacio");
                                                    }
                                                %>
                                        </td>
                                    </tr>
                                    <%}

                                        }%>

                                </tbody>
                            </table>
                    </div>
                  </div>
                                        <div class="card">
                                        <div class="card-header" id="headingTwo">
                                          <h2 class="mb-0">
                                            <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                              Tus Comentarios
                                            </button>
                                          </h2>
                                        </div>
                                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                          <div class="card-body">
                                                                        <table class="table">
                                                             <thead class="thead-light">
                                                                 <tr>
                                                                     <th>Fecha</th>
                                                                     <th>Comentario</th>
                                                                 </tr>
                                                             </thead>
                                                             <tbody>
                                                                 <%if (listarComentario.size() > 0) {
                                                                         for (Comentario comentarios2 : listarComentario) {
                                                                             comentarios = comentarios2;
                                                                 %>
                                                                 <tr>
                                                                     <td><%=comentarios.getFecha() %></td>
                                                                     <td><%=comentarios.getComentario()%></td>
                                                                 </tr>
                                                                 <%}

                                                                     }else if(listarComentario.isEmpty()){
                                                                        out.print("No tienes comentarios en esta revista");
                                                                      }%>

                                                             </tbody>
                                                         </table>
                                          </div>
                                        </div>
                                      </div>
                </div>
              </div>
            <br>
            <h1>Darle Me Gusta:</h1>
            <%
                if(sDB.meGustaTrue(revista.getNombreRevista(), user.getUser_name())==null){
                    %>
                     <a href="likeComentarioServlet?user=<%=user.getUser_name() %>&revista=<%=revista.getNombreRevista() %>" target="_blank" type="button" class="btn btn-primary">ME GUSTA</a>
                    <%
                        }else if(revista.isLikes()==false){
                        %>
                           <h3><span class="badge badge-danger">Likes Desactivados</span></h3>

                        <%
                    }
                    else{
                    %>
                    <h3><span class="badge badge-info">Te gusta esta revista</span></h3>
                    <%
                }
            %>
            <%
                if(revista.isComentarios()==false){
                    %>
                    <h3><span class="badge badge-danger">Comentarios Desactivados</span></h3>
                    <%
                }else{
                    %>
                    <br>
                    <form action="likeComentarioServlet" method="post">
                        <h1 style="text-align: center">Comentar:</h1>
                        <div class="form-group">
                            <input type="text" class="form-control" name="user" hidden="true" value="<%=user.getUser_name() %>">
                            <input type="text" class="form-control" name="revista" hidden="true" value="<%=revista.getNombreRevista() %>">
                                <label for="fechaComentario">Fecha:</label>
                                <input type="date" class="form-control" name="fechaComentario" required=""/>
                        </div>
                        <div class="form-group">
                                <label for="comentario">Comentario:</label>
                                <textarea class="form-control" id="comentario" name="comentario" rows="3" required="" value=""></textarea>
                        </div>
                        <input type="submit" value="Publicar Comentario" name="submit" id="btn" class="btn btn-primary"/>
                    </form>
                    <%
                }
            %>
            
        </div>
            <br>
            <br>
         <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="js/popper.min.js"></script>
         <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
