<%@page import="model.User"%>
<nav class="navbar navbar-expand-lg navbar navbar-dark  bg-dark">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto" style="font-size: 20px;">
         <li class="nav-item active">
             <a class="nav-link" href="suscriptorServlet?pagina=1">MAGAZINE S.A.<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="suscriptorServlet?pagina=2">Tus Suscripciones<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="adminPages?pagina=costo">s<span class="sr-only">(current)</span></a>
      </li>
    </ul>
      <div class="btn-group" style="margin-right: 70px;">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      <% 
            if(request.getAttribute("usuarioA")==null){
                out.print("Sign In");
            }else{
                User actual = (User) request.getAttribute("usuarioA");
                session.setAttribute("usuarioA", actual);
                out.print(actual.getUser_name());
            }
        %>
      </button>
      <div class="dropdown-menu" >
          <a class="dropdown-item" href="#">Perfil</a>
        <a class="dropdown-item" href="#" class="text-dark">Cerrar Sesion</a>
      </div>
    </div>
  </div>
</nav>