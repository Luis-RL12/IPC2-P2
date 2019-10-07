/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.revistaDB;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "adminServlet", urlPatterns = {"/adminServlet"})
public class adminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        String revista = req.getParameter("revista");
        revistaDB rDB = new revistaDB();
        Revista revis = new Revista();
        revis = rDB.getRevistaPorNombre(revista);
        req.setAttribute("row", revis);
         User recibido = (User) req.getSession().getAttribute("usuarioA");
            req.setAttribute("usuarioA", recibido);
        RequestDispatcher dispatcher = req.getRequestDispatcher("aprobar-revista.jsp");
            dispatcher.forward(req, resp);
        
    }
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         revistaDB revistaDB = new revistaDB();
         try { 
             String nombreRevista = req.getParameter("name_Revista");
             float costo_dia_Revista = Float.parseFloat(req.getParameter("costoDia"));
             if(revistaDB.aprobarRevista(costo_dia_Revista, nombreRevista)){
                 User recibido = (User) req.getSession().getAttribute("usuarioA");
                 req.setAttribute("usuarioA", recibido);
                 RequestDispatcher dispatcher = req.getRequestDispatcher("administradores.jsp");
            dispatcher.forward(req, resp);
             }else{
                 req.setAttribute("error", true);
                  RequestDispatcher dispatcher = req.getRequestDispatcher("administradores.jsp");
                  dispatcher.forward(req, resp);
             }
         } catch (NumberFormatException e) {
             System.out.println("Erro en el formato Costo x dia");
             e.printStackTrace();
         }
         
     }
}
