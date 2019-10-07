/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.revistaDB;
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
import model.Pago;
import model.Revista;
import model.Suscripcion;
import model.User;

/**
 *
 * @author RODRIGUEZ
 */
@WebServlet(name = "suscripcionServlet", urlPatterns = {"/suscripcionServlet"})
public class suscripcionServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       
        revistaDB revistaD = new revistaDB();
        Revista revistaObtenida = null;
        String nombreRevista = request.getParameter("nombreRevista");
        try {
             User recibido = (User) request.getSession().getAttribute("usuarioA");
                 request.setAttribute("usuarioA", recibido);
            revistaObtenida = revistaD.getRevistaPorNombre(nombreRevista);
            request.setAttribute("revistaObtenida", revistaObtenida);
            RequestDispatcher dispatcher = request.getRequestDispatcher("suscribirse.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error al obtener revista");
            e.printStackTrace();
            User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
            request.setAttribute("error", "No se pudo obtener la revista deseada");
            RequestDispatcher dispatcher = request.getRequestDispatcher("errores");
            dispatcher.forward(request, response);
        }
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
        Suscripcion nuevaSuscripcion = new Suscripcion();
        Pago nuevoPago = new Pago();
        suscripcionDB susDB = new suscripcionDB();
        User recibido = (User) request.getSession().getAttribute("usuarioA");
        request.setAttribute("usuarioA", recibido);
        try {
             String nombreSuscripcion = request.getParameter("nombreSuscripcion");
             String usuario = request.getParameter("usuario");
             float costoSuscripcion = Float.parseFloat(request.getParameter("costoSuscripcion"));
             String fechaSuscripcion = request.getParameter("fechaSuscripcion");
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha = formato.parse(fechaSuscripcion);
             java.sql.Date fechaActual = new java.sql.Date(fecha.getTime());
             nuevaSuscripcion.setCodigoRevista(nombreSuscripcion);
             nuevaSuscripcion.setCodigoSuscriptor(usuario);
             nuevaSuscripcion.setFecha(fechaActual);
             nuevoPago.setCodigoRevista(nombreSuscripcion);
             nuevoPago.setCodigoSuscriptor(usuario);
             nuevoPago.setPagoSuscripcion(costoSuscripcion);
             nuevoPago.setFecha(fechaActual);
             if(susDB.suscribirse(nuevaSuscripcion, nuevoPago)){
                 System.out.println("Suscripcion y Pago realizado con exito");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("revistas-por-suscribir.jsp");
                    dispatcher.forward(request, response);
             }else{
                 System.out.println("No se pudo realizar la suscripcion");
                 request.setAttribute("error", "No se pudo realizar la suscripcion");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("errores.jsp");
                 dispatcher.forward(request, response);
             }
        } catch (NumberFormatException e) {
             request.setAttribute("error", "Error en el formato de pago");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("errores.jsp");
                 dispatcher.forward(request, response);
        } catch (ParseException ex){
             request.setAttribute("error", "Error en fecha: Vacia o formato invalido");
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
