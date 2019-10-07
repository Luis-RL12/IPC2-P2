/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditorNavBarServlet", urlPatterns = {"/EditorNavBarServlet"})
public class EditorNavBarServlet extends HttpServlet {

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
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
            String rediccionarPagina = req.getParameter("pagina");
             User recibido = (User) req.getSession().getAttribute("usuarioA");
             req.setAttribute("usuarioA", recibido);
            if(rediccionarPagina.equalsIgnoreCase("ediciones")){
                RequestDispatcher dispatcher = req.getRequestDispatcher("verpdf.jsp");
                dispatcher.forward(req, resp);
            }else if(rediccionarPagina.equalsIgnoreCase("revistas")){
                 RequestDispatcher dispatcher = req.getRequestDispatcher("revistas.jsp");
                 dispatcher.forward(req, resp);
            }else if(rediccionarPagina.equalsIgnoreCase("reportes")){
                RequestDispatcher dispatcher = req.getRequestDispatcher("reportes-editores.jsp");
                dispatcher.forward(req, resp);
            }
            
        }
    

    
}
