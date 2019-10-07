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

/**
 *
 * @author RODRIGUEZ
 */
public class pdfDB extends DBConnection{
    
    public ArrayList<Edicion> Listar_PdfVO(String autor) {
        ArrayList<Edicion> list = new ArrayList<Edicion>();
        Connection con = DBConnection.connection();
        String sql = "SELECT * FROM pdf WHERE autor=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase pdfDB.listarpdfVO");
            ps = con.prepareStatement(sql);
            ps.setString(1, autor);
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
            System.out.println("Error en clase pdfDB.listar_pdfVO");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de tipo excepcion simple en clase pdfDB.listar_pdfVO");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de tipo excepcion simple en finally de clase pdfDB.listar_pdfVO");
                 System.out.println(ex.getMessage());
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_PdfVO(Edicion vo) {
        Connection con = DBConnection.connection();
        String sql = "INSERT INTO pdf (codigopdf, nombrepdf,codigoRevista,archivopdf,autor,fecha) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase pdfDB.agregar_pdfVO");
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.setString(2, vo.getNombrepdf());
            ps.setString(3, vo.getCodigoRevista());
            ps.setBlob(4, vo.getArchivopdf());
            ps.setString(5, vo.getAutor());
            ps.setDate(6, (Date) vo.getFechaPublicacion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de SQLEx en clase pdfDB.agregar");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
             System.out.println("Error de Exception en clase pdfDB.agregar");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de finally en clase pdfDB.agregar");
                 System.out.println(ex.getMessage());
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_PdfVO(Edicion vo) {
        Connection con = DBConnection.connection();
        String sql = "UPDATE pdf SET nombrepdf = ?, archivopdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase pdfDB.modificar_pdfVo");
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setBlob(2, vo.getArchivopdf());
            ps.setInt(3, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase pdfDB.modificar_pdfVO");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
             System.out.println("Error de Exception en clase pdfDB.modificar");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de finally en clase pdfDB.modificar");
            }
        }
    }

    /*Metodo Modificar*/
    public void Modificar_PdfVO2(Edicion vo) {
        Connection con = DBConnection.connection();
        String sql = "UPDATE pdf SET nombrepdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase pdfDB.modificar2");
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setInt(2, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase pdfDB.modificar2");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
             System.out.println("Error de Exception en clase pdfDB.modificar2");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de finally en clase pdfDB.modificar2");
                 System.out.println(ex.getMessage());
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(int id) {
        Connection con = DBConnection.connection();
        String sql = "DELETE FROM pdf WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            System.out.println("entro a clase pdfDB.eliminar");
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase pdfDB.eliminar");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
             System.out.println("Error de Exception en clase pdfDB.eliminar");
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex) {
                 System.out.println("Error de finally en clase pdfDB.eliminar");
            }
        }
    }


    /*Metodo Consulta id*/
    public Edicion getPdfVOById(int studentId) {
        Edicion vo = new Edicion();
        Connection con = DBConnection.connection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM pdf WHERE codigopdf = ?;";
        try {
            System.out.println("entro a clase pdfDB.getpdfVObyid");
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf2(rs.getBytes(3));
            }
        } catch (SQLException ex) {
             System.out.println("Error de SQLEx en clase pdfDB.agregar");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error de exception en clase pdfDB.agregar");
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("Error de finally en clase pdfDB.agregar");
                System.out.println(ex.getMessage());
            }
        }
        return vo;
    }
}
