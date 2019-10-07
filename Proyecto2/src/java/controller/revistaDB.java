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
import model.Edicion;
import model.Revista;

/**
 *
 * @author RODRIGUEZ
 */
public class revistaDB {
     public ArrayList<Revista> getRevistaPorAutor(String autor) {
         ArrayList<Revista> list = new ArrayList<Revista>();
        Connection con = DBConnection.connection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM revista WHERE autor = ?;";
        try {
            System.out.println("entro a clase revistaDB.getRevistaPorAutor");
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, autor);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Revista(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7),rs.getBoolean(8),rs.getBoolean(9),rs.getBoolean(10),rs.getFloat(11),rs.getString(12),rs.getString(13)));
            }
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase revistaDB.getRevistaPorAutor");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de exception en clase revistaDB.getRevistaPorAutor");
            System.out.println(ex.getMessage());
        } finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.getRevistaPorAutor");
                rs.close();
                preparedStatement.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.getRevistaPorAutor");
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
     
     public Revista getRevistaPorNombre(String revista){
         Revista rev = new Revista();
         Connection con = DBConnection.connection();
         PreparedStatement preparedS = null;
         ResultSet rs = null;
         String query = "SELECT * FROM revista WHERE nombre=?";
         try {
              System.out.println("entro a clase revistaDB.getRevistaPorNombre");
              preparedS = con.prepareStatement(query);
              preparedS.setString(1, revista);
              rs = preparedS.executeQuery();
              while(rs.next()){
                  rev.setNombreRevista(rs.getString(1));
                  rev.setAutor(rs.getString(2));
                  rev.setDescripcion(rs.getString(3));
                  rev.setCosto(rs.getFloat(4));
                  rev.setCategoria(rs.getString(5));
                  rev.setFecha(rs.getDate(6));
                  rev.setLikes(rs.getBoolean(7));
                  rev.setComentarios(rs.getBoolean(8));
                  rev.setIsSuscribable(rs.getBoolean(9));
                  rev.setIsAprovado(rs.getBoolean(10));
                  rev.setCostoDia(rs.getFloat(11));
                  rev.setFoto(rs.getString(12));
                  rev.setTags(rs.getString(13));
              }
         } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase revistaDB.getRevistaPorNombre");
            System.out.println(e.getMessage());
         }catch (Exception ex) {
            System.out.println("Error de exception en clase revistaDB.getRevistaPorNombre");
            System.out.println(ex.getMessage());
        } finally {
            try {
                System.out.println("Se cerro la conexion con exito en la base de datos a traves de revistaDB.getRevistaPorNombre");
                rs.close();
                preparedS.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.getRevistaPorNombre");
                System.out.println(ex.getMessage());
            }
        }
         return rev;
     }
     
     public ArrayList<Revista> getRevistaNoAprobado() {
         ArrayList<Revista> list = new ArrayList<Revista>();
        Connection con = DBConnection.connection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM revista WHERE isAprobado = false;";
        try {
            System.out.println("entro a clase revistaDB.getRevistaNoAprobado");
            preparedStatement = con.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Revista(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7),rs.getBoolean(8),rs.getBoolean(9),rs.getBoolean(10),rs.getFloat(11),rs.getString(12),rs.getString(13)));
            }
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase revistaDB.getRevistaNoAprobado");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de exception en clase revistaDB.getRevistaNoAprobado");
            System.out.println(ex.getMessage());
        } finally {
            try {
                System.out.println("Se cerro la conexion con exito en la base de datos a traves de revistaDB.getRevistaNoAprobado");
                rs.close();
                preparedStatement.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.getRevistaNoAprobado");
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
     public ArrayList<Revista> getRevistasAprobadas() {
         ArrayList<Revista> list = new ArrayList<Revista>();
        Connection con = DBConnection.connection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM revista WHERE isAprobado = true;";
        try {
            System.out.println("entro a clase revistaDB.getRevistasAprobadas");
            preparedStatement = con.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Revista(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getDate(6),rs.getBoolean(7),rs.getBoolean(8),rs.getBoolean(9),rs.getBoolean(10),rs.getFloat(11),rs.getString(12),rs.getString(13)));
            }
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase revistaDB.getRevistasAprobadas");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de exception en clase revistaDB.getRevistasAprobadas");
            System.out.println(ex.getMessage());
        } finally {
            try {
                System.out.println("Se cerro la conexion con exito en la base de datos a traves de revistaDB.getRevistasAprobadas");
                rs.close();
                preparedStatement.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.getRevistasAprobadas");
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
     public boolean modificarCostosRevista (float costoDia,float costoSuscripcion, String revista){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         String query = "UPDATE revista SET costo_dia=?, costo=? WHERE nombre=?";
         try {
             System.out.println("Entro a clase revistaDBmodificarCostosRevista");
             ps = con.prepareStatement(query);
             ps.setFloat(1, costoDia);
             ps.setFloat(2, costoSuscripcion);
             ps.setString(3, revista);
             ps.executeUpdate();
             return true;
         } catch (SQLException e) {
            System.out.println("Error de SQLEx en clase revistaDB.revistaDBmodificarCostosRevista");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.revistaDBmodificarCostosRevista");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.revistaDBmodificarCostosRevista");
                System.out.println(ex.getMessage());
                return false;
            }
        }
     }
     
     public boolean aprobarRevista(float costo, String nombreR){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         String query = "UPDATE revista set isAprobado=true, costo_dia=? WHERE nombre=?";
         try {
             System.out.println("entro a clase revistaDB.aprobarRevista");
             ps = con.prepareStatement(query);
             ps.setFloat(1, costo);
             ps.setString(2, nombreR);
             ps.executeUpdate();
             return true;
         } catch (SQLException e) {
             System.out.println("Error de SQLEx en clase revistaDB.aprobarRevista");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.aprobarRevista");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.aprobarRevista");
                System.out.println(ex.getMessage());
                return false;
            }
        }
     }
     
     public boolean crearRevista(Revista revista){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         String query = "INSERT INTO revista (nombre,autor,descripcion,costo,categoria,fecha,likes,comentarios,isSubs,isAprovado,foto,tags) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
             System.out.println("entro a clase revistaDB.crearRevista");
             ps = con.prepareStatement(query);
             ps.setString(1, revista.getNombreRevista());
             ps.setString(2, revista.getAutor());
             ps.setString(3, revista.getDescripcion());
             ps.setFloat(4,  revista.getCosto());
             ps.setString(5, revista.getCategoria());
             ps.setDate(6, (Date) revista.getFecha());
             ps.setBoolean(7, revista.isLikes());
             ps.setBoolean(8, revista.isComentarios());
             ps.setBoolean(9, revista.isIsSuscribable());
             ps.setBoolean(10, revista.isIsAprovado());
             ps.setString(11, revista.getFoto());
             ps.setString(12, revista.getTags());
             ps.executeUpdate();
             return true;
         } catch (SQLException e) {
            System.out.println("Error de SQLEx en clase revistaDB.crearRevista");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.crearRevista");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.crearRevista");
                System.out.println(ex.getMessage());
                return false;
            }
        }
     }
     public boolean modificarCosto_dia(float costoDia,Date fecha){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         String query = "INSERT INTO costo_dia (costo,fecha) VALUES (?,?)";
         try {
              System.out.println("Entro a clase revistaDB.modificarCosto_dia");
              ps = con.prepareStatement(query);
              ps.setFloat(1, costoDia);
              ps.setDate(2, (Date) fecha);
              ps.executeUpdate();
              return true;
         }catch (SQLException e) {
              System.out.println("Error de SQLEx en clase revistaDB.modificarCosto_dia");
            System.out.println(e.getMessage());
            return false;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.modificarCosto_dia");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.modificarCosto_dia");
                System.out.println(ex.getMessage());
                return false;
            }
        }
     }
     
     public float getCosto_dia(){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         ResultSet rs = null;
         float costo = 0;
         String query = "Select costo from costo_dia order by id desc limit 1";
         try {
             System.out.println("Entro a clase revistaDB.getCosto_dia");
             ps = con.prepareStatement(query);
             rs = ps.executeQuery();
             while(rs.next()){
                 costo = rs.getFloat(1);
             }
             return costo;
         } catch (SQLException e) {
              System.out.println("Error de SQLEx en clase revistaDB.getCosto_dia");
            System.out.println(e.getMessage());
            return 0;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.getCosto_dia");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.getCosto_dia");
                System.out.println(ex.getMessage());
                return 0;
            }
        }
     }
     
     public int cantidadLikes(String nombreRevista){
         Connection con = DBConnection.connection();
         PreparedStatement ps = null;
         ResultSet rs = null;
         int cantLikes = 0;
         String query = "Select COUNT(*) from likes WHERE revista=?";
         try {
             System.out.println("Entro a clase revistaDB.cantLikes");
             ps = con.prepareStatement(query);
             ps.setString(1, nombreRevista);
             rs = ps.executeQuery();
             while(rs.next()){
                 cantLikes = rs.getInt(1);
             }
             return cantLikes;
         } catch (SQLException e) {
              System.out.println("Error de SQLEx en clase revistaDB.cantLikes");
            System.out.println(e.getMessage());
            return cantLikes;
         }finally {
            try {
                System.out.println("Se cerro la conexion con la base de datos a traves de revistaDB.cantLikes");
                ps.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase revistaDB.cantLikes");
                System.out.println(ex.getMessage());
                return cantLikes;
            }
        }
     }
     
     
     
}
