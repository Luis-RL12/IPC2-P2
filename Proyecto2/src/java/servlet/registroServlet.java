/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.LoginDB;
import java.io.IOException;
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
@WebServlet("/registroServlet")
public class registroServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String user = req.getParameter("name");
        String pass = req.getParameter("pass");
        String repeatPass = req.getParameter("confirmarPassword");
        String tipoUser = req.getParameter("tipoUser");
        User regUser = null;
        if(tipoUser.equals("Administrador")){
              regUser = new User(user,pass,1,true);
        }else if(tipoUser.equals("Editor")){
             regUser = new User(user,pass,2,true);
        }else{
             regUser = new User(user,pass,3,true);
        }
        LoginDB login = new LoginDB();
        if(pass.equals(repeatPass)){
             if(login.registrar(regUser, nombre)){
                  req.setAttribute("usuarioA", regUser);
                 System.out.println("Registro exitoso");
                 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, resp);
             }else{
                 System.out.println("No se pudo registrar");
                 RequestDispatcher dispatcher = req.getRequestDispatcher("registrar.jsp");
                dispatcher.forward(req, resp);
             }
        }else{
            System.out.println("Contraseñas distintas");
        }
    }
    
}
