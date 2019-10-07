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
@WebServlet(name = "adminCostosServlet", urlPatterns = {"/adminCostosServlet"})
public class adminCostosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         String revista = request.getParameter("revista");
        revistaDB rDB = new revistaDB();
        Revista revis = new Revista();
        revis = rDB.getRevistaPorNombre(revista);
        request.setAttribute("row", revis);
         User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
        RequestDispatcher dispatcher = request.getRequestDispatcher("modificar-costos.jsp");
            dispatcher.forward(request, response);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        revistaDB revDB = new revistaDB();
        try {
            User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
            String nombreRevista = request.getParameter("name_Revista");
            float costoSuscripcion = Float.parseFloat(request.getParameter("costoSus"));
            float costoDia = Float.parseFloat(request.getParameter("costoDia"));
            if(revDB.modificarCostosRevista(costoDia, costoSuscripcion, nombreRevista)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("revistas-aprobadas.jsp");
            dispatcher.forward(request, response);
            }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("modificar-costos.jsp");
            dispatcher.forward(request, response);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en formato costoSus o costo Dia");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
