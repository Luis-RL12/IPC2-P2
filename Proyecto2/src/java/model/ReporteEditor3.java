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
public class ReporteEditor3 {
    
    private String revista;
    private String autor;
    private String suscriptor;
    private Date fecha;

    public ReporteEditor3(String revista, String autor, String suscriptor, Date fecha) {
        this.revista = revista;
        this.autor = autor;
        this.suscriptor = suscriptor;
        this.fecha = fecha;
    }
    
    public ReporteEditor3(){
        
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
