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
public class Comentario {
    private int id;
    private String codigoRevista;
    private String codigoSuscriptor;
    private String comentario;
    private Date fecha;

    public Comentario(int id, String codigoRevista, String codigoSuscriptor, String comentario, Date fecha) {
        this.id = id;
        this.codigoRevista = codigoRevista;
        this.codigoSuscriptor = codigoSuscriptor;
        this.comentario = comentario;
        this.fecha = fecha;
    }
    
    public Comentario(){
        
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

    public String getCodigoSuscriptor() {
        return codigoSuscriptor;
    }

    public void setCodigoSuscriptor(String codigoSuscriptor) {
        this.codigoSuscriptor = codigoSuscriptor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
