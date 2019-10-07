/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.revistaDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Revista;
import model.User;

/**
 *
 * @author RODRIGUEZ
 */
@WebServlet(name = "revistaServlet", urlPatterns = {"/revistaServlet"})
public class revistaServlet extends HttpServlet {

  @Override  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Revista agregarRevista = new Revista();
           revistaDB revistaDB = new revistaDB();
      try {
          String nombreRevista = req.getParameter("nameRevista");
          String autor = req.getParameter("username");
          String categoria = req.getParameter("categoria");
          float costoSuscripcion = Float.parseFloat(req.getParameter("costoSubscripcion"));
          String descripcion = req.getParameter("descripcion");
          String fechaPublish = req.getParameter("fecha");
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha = formato.parse(fechaPublish);
             java.sql.Date fechaActual = new java.sql.Date(fecha.getTime());
          boolean likes = (req.getParameter("likes")!=null);
          boolean comentarios = (req.getParameter("comentarios")!=null);
          boolean suscripciones = Boolean.parseBoolean(req.getParameter("suscripciones"));
          String tags = req.getParameter("tags");
          String foto = req.getParameter("foto");
           agregarRevista.setNombreRevista(nombreRevista);
           agregarRevista.setAutor(autor);
           agregarRevista.setDescripcion(descripcion);
           agregarRevista.setCosto(costoSuscripcion);
           agregarRevista.setCategoria(categoria);
           agregarRevista.setFecha(fechaActual);
           agregarRevista.setLikes(likes);
           agregarRevista.setComentarios(comentarios);
           agregarRevista.setIsSuscribable(suscripciones);
           agregarRevista.setIsAprovado(false);
           agregarRevista.setFoto(foto);
           agregarRevista.setTags(tags);
           if(revistaDB.crearRevista(agregarRevista)){
               System.out.println("Revista Agregada Con exito");
               User recibido = (User) req.getSession().getAttribute("usuarioA");
               req.setAttribute("usuarioA", recibido);
                RequestDispatcher dispatcher = req.getRequestDispatcher("revistas.jsp");
                 dispatcher.forward(req, resp);
           }else{
               System.out.println("No se pudo agregar la revista");
           }
      } catch (NumberFormatException e) {
          System.out.println("Error en costo Suscripcion o costo x dia");
      } catch (Exception ex ){
          System.out.println("Error en exception:");
          ex.printStackTrace();
      }
  } 

}
