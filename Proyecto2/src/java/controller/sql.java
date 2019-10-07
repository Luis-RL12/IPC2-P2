/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author RODRIGUEZ
 */
public class sql {
     public int auto_increm(String sql){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = DBConnection.connection();
        try{    
                System.out.println("entro a clase sql.auto_increm");
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    id = rs.getInt(1)+1;
                }
        }catch(Exception ex){
            System.out.println("Error de exception en clase sql.auto_increment pone idmaximo");
            System.out.println(ex.getMessage());
            id = 1;
        }
        finally{
            try{
                ps.close();
                rs.close();
                con.close();
            }catch(Exception ex){
            System.out.println("Error de finlly en clase sql.auto_i");
                System.out.println(ex.getMessage());}
        }
        return id;
    }
}
