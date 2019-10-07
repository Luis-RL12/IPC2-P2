/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.suscripcionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comentario;
import model.Like;
import model.User;

/**
 *
 * @author RODRIGUEZ
 */
@WebServlet(name = "likeComentarioServlet", urlPatterns = {"/likeComentarioServlet"})
public class likeComentarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         User recibido = (User) request.getSession().getAttribute("usuarioA");
         request.setAttribute("usuarioA", recibido);
        suscripcionDB susDB = new suscripcionDB();
        String usuario = request.getParameter("user");
        String revista = request.getParameter("revista");
             Date fecha = new Date();
             java.sql.Date fechaActual = new java.sql.Date(fecha.getTime());
        Like like = new Like();     
        like.setRevista(revista);
        like.setSuscriptor(usuario);
        like.setFecha(fechaActual);
        if(susDB.meGusta(like)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("revistas-suscritas.jsp");
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("error", "no se pudo dar MeGusta a la revista");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("errores.jsp");
                  dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Comentario comen = new Comentario();
        suscripcionDB susDB = new suscripcionDB();
        try {
            User recibido = (User) request.getSession().getAttribute("usuarioA");
                 request.setAttribute("usuarioA", recibido);
            String suscriptor = request.getParameter("user");
            String fechaComentario = request.getParameter("fechaComentario");
            String comentarioObtenido = request.getParameter("comentario");
            String revista = request.getParameter("revista");
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha = formato.parse(fechaComentario);
             java.sql.Date fechaActual = new java.sql.Date(fecha.getTime());
            comen.setCodigoRevista(revista);
            comen.setCodigoSuscriptor(suscriptor);
            comen.setComentario(comentarioObtenido);
             comen.setFecha(fechaActual);
             if(susDB.comentar(comen)){
                  RequestDispatcher dispatcher = request.getRequestDispatcher("revistas-suscritas.jsp");
                  dispatcher.forward(request, response);
             }else{
                 request.setAttribute("error", "no se pudo agregar el comentario a la base de datos");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("errores.jsp");
                  dispatcher.forward(request, response);
             }
            
        } catch (IOException | ParseException | ServletException e) {
            request.setAttribute("error", "error al parsear el objeto comentario");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("errores.jsp");
                  dispatcher.forward(request, response);
        }
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
