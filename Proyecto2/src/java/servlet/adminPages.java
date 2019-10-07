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
import model.User;

/**
 *
 * @author RODRIGUEZ
 */
@WebServlet(name = "adminPages", urlPatterns = {"/adminPages"})
public class adminPages extends HttpServlet {

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
    String opcoin;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String pagina = request.getParameter("pagina");
          User recibido = (User) request.getSession().getAttribute("usuarioA");
                 request.setAttribute("usuarioA", recibido);
                
         if(pagina.equalsIgnoreCase("aprobar")){
              RequestDispatcher dispatcher = request.getRequestDispatcher("administradores.jsp");
            dispatcher.forward(request, response);
         }else if(pagina.equalsIgnoreCase("costo")){
             RequestDispatcher dispatcher = request.getRequestDispatcher("revistas-aprobadas.jsp");
            dispatcher.forward(request, response);
         }else{
             opcoin="global";
             RequestDispatcher dispatcher = request.getRequestDispatcher("costo-global.jsp");
            dispatcher.forward(request, response);
         }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        revistaDB revDB = new revistaDB();
        if(opcoin.equalsIgnoreCase("global")){
            try {
                float costoGlobal = Float.parseFloat(request.getParameter("cGlobal"));
                Date fecha1 = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date fechaActual = new java.sql.Date(fecha1.getTime());
                if(revDB.modificarCosto_dia(costoGlobal, fechaActual)){
                    User recibido = (User) request.getSession().getAttribute("usuarioA");
                 request.setAttribute("usuarioA", recibido);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("administradores.jsp");
                 dispatcher.forward(request, response);
                }else{
                     User recibido = (User) request.getSession().getAttribute("usuarioA");
                 request.setAttribute("usuarioA", recibido);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("costo-global.jsp");
                 dispatcher.forward(request, response);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
