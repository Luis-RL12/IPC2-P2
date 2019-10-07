/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author RODRIGUEZ
 */
public class LoginDB {
    private Connection con = null;
    
    public User autenticarUser(User user){
        con = DBConnection.connection();
        User usuarioObtenido = null;
          PreparedStatement logStatement = null;
          ResultSet resultLogin = null;
        try {
                System.out.println("DBConnection.autenticarUser");
                logStatement = con.prepareStatement("SELECT * FROM user WHERE user_name = ?");
             logStatement.setString(1, user.getUser_name());
             resultLogin = logStatement.executeQuery();
             if(resultLogin.absolute(1)){
                  usuarioObtenido = new User(resultLogin.getString(1),resultLogin.getString(2),resultLogin.getInt(3),resultLogin.getBoolean(4));
                 return usuarioObtenido;
             }else{
                 return null;
             }
             
        } catch (SQLException e) {
            System.out.println("Error en DBConnection.autenticarUser. Error: "+e);
            return null;
        }finally{
            try {
                if(con!=null){
                con.close();
                 System.out.println("DBConnection.autenticarUser finalizada");
                }
                if(logStatement != null){
                    logStatement.close();
                }
                if(resultLogin != null){
                    resultLogin.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }
            
        }
        
        
    }
    
    public boolean registrar(User registrarUser, String nombre){
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
         con = DBConnection.connection();
        try {
            System.out.println("DBConnection.registrar");
             con.setAutoCommit(false);
             //Ingreso de datos a tabla user
             ps = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
             ps.setString(1, registrarUser.getUser_name());
             ps.setString(2, registrarUser.getPass());
             ps.setInt(3, registrarUser.getType());
             ps.setBoolean(4, true);
             //Ingreso de Datos a Perfil
             ps2 = con.prepareStatement("INSERT INTO perfil (userName,Nombre) VALUES(?,?)");
             ps2.setString(1, registrarUser.getUser_name());
             ps2.setString(2, nombre);
             if(ps.executeUpdate()==1 && ps2.executeUpdate()==1){
                 System.out.println("Insert realizado con exito");
                 con.commit();
                 con.setAutoCommit(true);
                 return true;
             }
             con.setAutoCommit(true);
            return false;
        } catch (SQLException e) {
            System.out.println("Error en DBConnection.registrar. Error: ");
            e.printStackTrace();
            try {
                System.out.println("haciendo el rollback en metodo DBConnection.registrar");
                con.rollback();
            } catch (SQLException es) {
                System.out.println("Error haciendo el rollback en metodo DBConnection.registrar. Error: ");
                es.printStackTrace();
            }
            return false;
        }finally{
            try {
                if(con!= null){
                    con.close();
                    System.out.println("DBConnection.registro finalizada");
                }
                if(ps != null){
                    ps.close();
                }
                if(ps2 != null){
                    ps2.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: "+e);
            }
            
        }
    }
    
    
}
