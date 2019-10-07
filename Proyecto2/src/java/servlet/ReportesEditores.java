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
@WebServlet(name = "ReportesEditores", urlPatterns = {"/ReportesEditores"})
public class ReportesEditores extends HttpServlet {

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
        processRequest(request, response);
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
         
           User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
           int reporte = Integer.parseInt(request.getParameter("reporte"));
           switch(reporte){
               case 1:
                    request.setAttribute("usuarioA", recibido);
                   String fecha1Reporte1 = request.getParameter("fecha1Reporte1");
                   String fecha2Reporte1 = request.getParameter("fecha2Reporte1");
                   request.setAttribute("fecha1Reporte1", fecha1Reporte1);
                   request.setAttribute("fecha2Reporte1", fecha2Reporte1);
                   RequestDispatcher dispatcher = request.getRequestDispatcher("reporteEditor1.jsp");
                   dispatcher.forward(request, response);
                   break;
                  
               case 2:
                    request.setAttribute("usuarioA", recibido);
                   String fecha1Reporte2 = request.getParameter("fecha1Reporte2");
                   String fecha2Reporte2 = request.getParameter("fecha2Reporte2");
                   request.setAttribute("fecha1Reporte2", fecha1Reporte2);
                   request.setAttribute("fecha2Reporte2", fecha2Reporte2);
                   RequestDispatcher dispatcher1 = request.getRequestDispatcher("reporteEditor2.jsp");
                   dispatcher1.forward(request, response);
                   break;
               case 3:
                    request.setAttribute("usuarioA", recibido);
                   String fecha1Reporte3 = request.getParameter("fecha1Reporte3");
                   String fecha2Reporte3 = request.getParameter("fecha2Reporte3");
                   request.setAttribute("fecha1Reporte3", fecha1Reporte3);
                   request.setAttribute("fecha2Reporte3", fecha2Reporte3);
                   RequestDispatcher dispatcher3 = request.getRequestDispatcher("ReporteEditor3.jsp");
                   dispatcher3.forward(request, response);
                   break;
               case 4:
                    request.setAttribute("usuarioA", recibido);
                   String fecha1Reporte4 = request.getParameter("fecha1Reporte4");
                   String fecha2Reporte4 = request.getParameter("fecha2Reporte4");
                   request.setAttribute("fecha1Reporte4", fecha1Reporte4);
                   request.setAttribute("fecha2Reporte4", fecha2Reporte4);
                   RequestDispatcher dispatcher4 = request.getRequestDispatcher("reporteEditor4.jsp");
                   dispatcher4.forward(request, response);
                   break;
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
