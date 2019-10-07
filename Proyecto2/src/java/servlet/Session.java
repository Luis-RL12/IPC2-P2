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
@WebServlet("/Session")
public class Session extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("el nombre recibido es: "+req.getParameter("name"));
        System.out.println("la contra recibida es: "+req.getParameter("pass"));
        try {
            User user = new User(req);
        LoginDB login = new LoginDB();
        User usuarioObtenidoDB = login.autenticarUser(user);
        System.out.println(user.getUser_name()+ " + "+user.getPass());
        if(usuarioObtenidoDB.getPass().equals(req.getParameter("pass"))){
            req.setAttribute("usuarioA", usuarioObtenidoDB);
            if(usuarioObtenidoDB.getType() == 1){
                RequestDispatcher dispatcher = req.getRequestDispatcher("administradores.jsp");
                dispatcher.forward(req, resp);
            }else if(usuarioObtenidoDB.getType() == 2){
                RequestDispatcher dispatcher = req.getRequestDispatcher("verpdf.jsp");
                dispatcher.forward(req, resp);
            }else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("revistas-por-suscribir.jsp");
                dispatcher.forward(req, resp);
            }
            System.out.println("La contraseña es correcta, bienvenido");
        }
        } catch (Exception e) {
            req.setAttribute("error", true);
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        
        }
        
    }
}
