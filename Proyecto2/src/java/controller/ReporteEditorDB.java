/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ReporteEditor1;
import model.ReporteEditor2;
import model.ReporteEditor3;
import model.ReporteEditor4;

/**
 *
 * @author RODRIGUEZ
 */
public class ReporteEditorDB {
    
    public ArrayList<ReporteEditor1> reporte1(String autor,Date fecha1,Date fecha2){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReporteEditor1 report = null;
        ArrayList<ReporteEditor1> reporte1 = new ArrayList<>();
        String query = "SELECT c.id,c.revista_codigo,c.suscriptor_codigo,c.comentario,c.fecha, r.autor FROM comentarios c INNER JOIN revista r  ON c.revista_codigo = r.nombre WHERE r.autor=? AND c.fecha BETWEEN ? AND ?";
        try {
            System.out.println("Entro a la clase ReporteEditorDB.reporte1");
            ps = con.prepareStatement(query);
            ps.setString(1, autor);
            ps.setDate(2,  fecha1);
            ps.setDate(3, fecha2);
            rs = ps.executeQuery();
            while(rs.next()){
              reporte1.add(new ReporteEditor1(rs.getInt(1),rs.getString(2),rs.getString(6),rs.getString(4),rs.getString(3),rs.getDate(5)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase ReporteEditorDB.reporte1");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de ReporteEditorDB.reporte1");
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase ReporteEditorDB.reporte1");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return reporte1;
    }
    
    public ArrayList<ReporteEditor2> reporte2(String autor,Date fecha1,Date fecha2){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReporteEditor2 reporte = new ReporteEditor2();
        ArrayList<ReporteEditor2> reporte2 = new ArrayList<>();
        String query = "SELECT r.autor, s.cod_revista,s.cod_suscriptor,s.fecha FROM suscripcion s INNER JOIN revista r ON s.cod_revista = r.nombre WHERE r.autor = ? AND s.fecha BETWEEN ? AND ?";
        try {
            System.out.println("Entro a la clase ReporteEditorDB.reporte2");
            ps = con.prepareStatement(query);
            ps.setString(1, autor);
            ps.setDate(2, fecha1);
            ps.setDate(3, fecha2);
            rs = ps.executeQuery();
            while(rs.next()){
              reporte2.add(new ReporteEditor2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase ReporteEditorDB.reporte2");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de ReporteEditorDB.reporte2");
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase ReporteEditorDB.reporte2");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return reporte2;
    }
    
    public ArrayList<ReporteEditor3> reporte3(String autor,Date fecha1,Date fecha2){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReporteEditor3 reporte = new ReporteEditor3();
        ArrayList<ReporteEditor3> reporte3 = new ArrayList<>();
        String query = "SELECT l.revista, r.autor, l.suscriptor, l.fecha FROM likes l INNER JOIN revista r ON l.revista = r.nombre WHERE r.autor=? AND l.fecha BETWEEN ? AND ?";
        try {
            System.out.println("Entro a la clase ReporteEditorDB.reporte3");
            ps = con.prepareStatement(query);
            ps.setString(1, autor);
            ps.setDate(2, fecha1);
            ps.setDate(3, fecha2);
            rs = ps.executeQuery();
            while(rs.next()){
              reporte3.add(new ReporteEditor3(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase ReporteEditorDB.reporte3");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de ReporteEditorDB.reporte3");
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase ReporteEditorDB.reporte3");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return reporte3;
    }
    
    
    public ArrayList<ReporteEditor4> reporte4(String revista,Date fecha1,Date fecha2){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ReporteEditor4 reporte = new ReporteEditor4();
        ArrayList<ReporteEditor4> reporte4 = new ArrayList<>();
        String query = "SELECT codigo_revista, SUM(pago) Ganancia FROM pago where codigo_revista=? AND fecha BETWEEN ? AND ?";
        try {
            System.out.println("Entro a la clase ReporteEditorDB.reporte4");
            ps = con.prepareStatement(query);
            ps.setString(1, revista);
            ps.setDate(2, fecha1);
            ps.setDate(3, fecha2);
            rs = ps.executeQuery();
            while(rs.next()){
              reporte4.add(new ReporteEditor4(rs.getString(1),rs.getFloat(2)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase ReporteEditorDB.reporte4");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de ReporteEditorDB.reporte4");
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase ReporteEditorDB.reporte4");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return reporte4;
    }
}
