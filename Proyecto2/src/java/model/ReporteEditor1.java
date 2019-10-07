/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author RODRIGUEZ
 */
public class ReporteEditor1 {
    
    private int id;
    private String codigoRevista;
    private String autor;
    private String comentario;
    private String suscriptor;
    private Date fecha;

    public ReporteEditor1(int id, String codigoRevista, String autor, String comentario, String suscriptor, Date fecha) {
        this.id = id;
        this.codigoRevista = codigoRevista;
        this.autor = autor;
        this.comentario = comentario;
        this.suscriptor = suscriptor;
        this.fecha = fecha;
    }
    
    public ReporteEditor1(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoRevista() {
        return codigoRevista;
    }

    public void setCodigoRevista(String codigoRevista) {
        this.codigoRevista = codigoRevista;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(String suscriptor) {
        this.suscriptor = suscriptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
