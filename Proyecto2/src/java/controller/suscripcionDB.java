/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Comentario;
import model.Edicion;
import model.Like;
import model.Pago;
import model.Suscripcion;

/**
 *
 * @author RODRIGUEZ
 */
public class suscripcionDB {
    
    public ArrayList<Edicion> pdfRevista(String revista) {
        ArrayList<Edicion> list = new ArrayList<Edicion>();
        Connection con = DBConnection.connection();
        String sql = "SELECT * FROM pdf WHERE codigoRevista=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase suscripcionDB.pdfRevista");
            ps = con.prepareStatement(sql);
            ps.setString(1, revista);
            rs = ps.executeQuery();
            while (rs.next()) {
                Edicion vo = new Edicion();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setCodigoRevista(rs.getString(3));
                vo.setArchivopdf2(rs.getBytes(4));
                vo.setAutor(rs.getString(5));
                vo.setFechaPublicacion(rs.getDate(6));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println("Error en clase suscripcionDB.pdfRevista");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de tipo excepcion simple en clase suscripcionDB.pdfRevista");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de tipo excepcion simple en finally de clase suscripcionDB.pdfRevista");
                 System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    
    public ArrayList<Comentario> comentariosRevistaSuscriptor(String revista, String suscriptor){
        Connection con = DBConnection.connection();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        PreparedStatement psComentario = null;
        ResultSet rsComentario = null;
        String query = "SELECT * FROM comentarios WHERE revista_codigo=? AND suscriptor_codigo=?";
        try {
            System.out.println("Entro a clase suscripcionDB.comentariosRevistaSuscriptor");
            psComentario = con.prepareStatement(query);
            psComentario.setString(1, revista);
            psComentario.setString(2, suscriptor);
            rsComentario = psComentario.executeQuery();
            while(rsComentario.next()){
                comentarios.add(new Comentario(rsComentario.getInt(1),rsComentario.getString(2),rsComentario.getString(3),rsComentario.getString(4),rsComentario.getDate(5)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.comentariosRevistaSuscriptor");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.comentariosRevistaSuscriptor");
                psComentario.close();
                con.close();
                rsComentario.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.comentariosRevistaSuscriptor");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return comentarios;
    }
    
    public ArrayList<Suscripcion> suscripcionesPorUser(String suscriptor){
        Connection con = DBConnection.connection();
        ArrayList<Suscripcion> suscripciones = new ArrayList<>();
        PreparedStatement psSuscripcion = null;
        ResultSet rsSuscripcion = null;
        String query = "SELECT * FROM suscripcion WHERE cod_suscriptor=?";
        try {
            System.out.println("Entro a clase suscripcionDB.suscripcionesPorUser");
            psSuscripcion = con.prepareStatement(query);
            psSuscripcion.setString(1, suscriptor);
            rsSuscripcion = psSuscripcion.executeQuery();
            while(rsSuscripcion.next()){
                suscripciones.add(new Suscripcion(rsSuscripcion.getString(1),rsSuscripcion.getString(2),rsSuscripcion.getDate(3)));
            }
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.suscripcionesPorUser");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.suscripcionesPorUser");
                psSuscripcion.close();
                con.close();
                rsSuscripcion.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.suscripcionesPorUser");
                System.out.println(ex.getMessage());
                return null;
            }
        }
          return suscripciones;
    }
    
    public Like meGustaTrue(String revista, String user){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Like like = null;
        String query = "SELECT * FROM likes WHERE revista=? AND suscriptor=?";
        try {
            System.out.println("Entro a la clase suscripcionDB.meGustaTrue");
            ps = con.prepareStatement(query);
            ps.setString(1, revista);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while(rs.next()){
                like = new Like(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
            }
            return like;
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.meGustaTrue");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.meGustaTrue");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.meGustaTrue");
                System.out.println(ex.getMessage());
                return null;
            }
        }
    }
    
    public boolean meGusta (Like like){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        String query ="INSERT INTO likes (revista,suscriptor,fecha) VALUES(?,?,?)";
        try {
            System.out.println("Entro a clase suscripcionDB.meGusta");
            ps = con.prepareStatement(query);
            ps.setString(1, like.getRevista());
            ps.setString(2, like.getSuscriptor());
            ps.setDate(3, (Date) like.getFecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.meGusta");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.meGusta");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.meGusta");
                System.out.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public boolean comentar (Comentario comentario){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        String query = "INSERT INTO comentarios (revista_codigo,suscriptor_codigo,comentario,fecha) VALUES(?,?,?,?)";
        try {
            System.out.println("Entro a la clase suscripcionDB.comentar");
            ps = con.prepareStatement(query);
            ps.setString(1, comentario.getCodigoRevista());
            ps.setString(2, comentario.getCodigoSuscriptor());
            ps.setString(3, comentario.getComentario());
            ps.setDate(4, (Date) comentario.getFecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.comentar");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.comentar");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.comentar");
                System.out.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public boolean suscribirse(Suscripcion suscripcion, Pago pago){
        Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        PreparedStatement psPago = null;
        String query1 = "INSERT INTO suscripcion VALUES(?,?,?)";
        String query2 = "INSERT INTO pago (codigo_revista,codigo_suscriptor,pago,fecha) VALUES(?,?,?,?)";
        try {
             con.setAutoCommit(false);
             System.out.println("Entro a la clase suscripcionDB.suscribirse");
             ps = con.prepareStatement(query1);
             ps.setString(1, suscripcion.getCodigoRevista());
             ps.setString(2, suscripcion.getCodigoSuscriptor());
             ps.setDate(3, (Date) suscripcion.getFecha());
             ps.executeUpdate();
             psPago = con.prepareStatement(query2);
             psPago.setString(1, pago.getCodigoRevista());
             psPago.setString(2, pago.getCodigoSuscriptor());
             psPago.setFloat(3, pago.getPagoSuscripcion());
             psPago.setDate(4, (Date) pago.getFecha());
             psPago.executeUpdate();
             con.commit();
             con.setAutoCommit(true);
             return true;
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.suscribirse");
            System.out.println(e.getMessage());
             try {
                                System.out.println("haciendo el rollback en metodo suscripcionDB.suscribirse");
                                con.rollback();
                            } catch (SQLException ex) {
                                System.out.println("Error haciendo el rollback en metodo suscripcionDB.suscribirse");
                            }
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.suscribirse");
                ps.close();
                psPago.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.suscribirse");
                System.out.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public Suscripcion suscripcionPorUsuarioYRevista(String suscriptor,String revista){
         Connection con = DBConnection.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Suscripcion sus = null;
        String query1 = "SELECT *FROM suscripcion where cod_revista=? AND cod_suscriptor=?";
        try {
            ps = con.prepareStatement(query1);
            ps.setString(1, revista);
            ps.setString(2, suscriptor);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("si encontro la suscripcion de: "+suscriptor +" y la revista: "+revista);
                sus = new Suscripcion(rs.getString(1),rs.getString(2),rs.getDate(3));
            }
            return sus;
        } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase suscripcionDB.suscripcionPorUsuarioYRevista");
            System.out.println(e.getMessage());
            return null;
         }finally {
            try {
                System.out.println("Se cerro la conexion exitosamente con la base de datos a traves de suscripcionDB.suscripcionPorUsuarioYRevista");
                ps.close();
                con.close();
                rs.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase suscripcionDB.suscripcionPorUsuarioYRevista");
                System.out.println(ex.getMessage());
                return null;
            }
       }
    }
}
