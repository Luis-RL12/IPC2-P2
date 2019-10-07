/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Edicion;
import model.Revista;
import model.User;
import sun.plugin.com.Dispatcher;

/**
 *
 * @author RODRIGUEZ
 */
@WebServlet(name = "pdfController", urlPatterns = {"/pdfController"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class pdfController extends HttpServlet {
 public static final String lIST_STUDENT = "/verpdf.jsp";
 public static final String INSERT_OR_EDIT = "/subirpdf.jsp";

    String estado = null;
    pdfDB pdfdao;
    revistaDB revistaDB;
    int id_pdf = -1;

    public pdfController() {
        pdfdao = new pdfDB();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = lIST_STUDENT;
            int studentId = Integer.parseInt(request.getParameter("id"));
            pdfdao.Eliminar_PdfVO(studentId);
        }
        else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentIdM = Integer.parseInt(request.getParameter("id"));
            id_pdf = studentIdM;
            Edicion pdfvo = pdfdao.getPdfVOById(studentIdM);
            request.setAttribute("row", pdfvo);
            boolean boo = false;
            if (pdfvo.getArchivopdf2() != null) {
                boo = true;
            }
            request.setAttribute("row2", boo);
            estado = "edit";
        } else if (action.equalsIgnoreCase("insert")) {
            
            forward = INSERT_OR_EDIT;
            estado = "insert";
            
        }
       User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
            RequestDispatcher dispatcher = request.getRequestDispatcher("subirpdf.jsp");
            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        estado = request.getParameter("estado");
        
        Edicion pdfvo = new Edicion();
        sql auto = new sql();
        int nuevoid = auto.auto_increm("SELECT MAX(codigopdf) FROM pdf;");
        System.out.println("nuevo id: "+nuevoid);
        try{
             String obtenido = request.getParameter("username");
             String revistaObtenida = request.getParameter("revistaElegida");
             String fechaPublish = request.getParameter("fecha");
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
             Date fecha = formato.parse(fechaPublish);
             java.sql.Date fechaActual = new java.sql.Date(fecha.getTime());
             System.out.println("obtendio user: "+obtenido);
             System.out.println("Revista Obtenida: "+revistaObtenida);
             System.out.println("Fecha ingresada: "+fechaPublish);
            String name = request.getParameter("txtname");
            pdfvo.setCodigopdf(nuevoid);
            pdfvo.setNombrepdf(name);
            pdfvo.setCodigoRevista(revistaObtenida);
            pdfvo.setAutor(obtenido);
            pdfvo.setFechaPublicacion(fechaActual);
        }catch(Exception ex){
            System.out.println("Exception nombre: "+ex.getMessage());
        }

        InputStream inputStream = null;
        try {
            Part filePart = request.getPart("fichero");
            if (filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
            }
        } catch (Exception ex) {
            System.out.println("Exception fichero: "+ex.getMessage());
        }

        try {
            if (estado.equalsIgnoreCase("insert")) {
                pdfvo.setCodigopdf(nuevoid);
                if (inputStream != null) {
                    pdfvo.setArchivopdf(inputStream);
                }
                pdfdao.Agregar_PdfVO(pdfvo);
            } else {
                pdfvo.setCodigopdf(id_pdf);
                if (inputStream != null) {
                    pdfvo.setArchivopdf(inputStream);
                    pdfdao.Modificar_PdfVO(pdfvo);
                } else {
                    pdfdao.Modificar_PdfVO2(pdfvo);
                }
            }
        } catch (Exception ex) {
            System.out.println("pdfController Exception textos: "+ex.getMessage());
            ex.printStackTrace();
        }
       User recibido = (User) request.getSession().getAttribute("usuarioA");
            request.setAttribute("usuarioA", recibido);
            RequestDispatcher dispatcher = request.getRequestDispatcher("verpdf.jsp");
            dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
