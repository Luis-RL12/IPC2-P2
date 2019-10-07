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
public class ReporteEditor2 {
    
    private String autor;
    private String cod_revista;
    private String cod_suscriptor;
    private Date fecha;

    public ReporteEditor2(String autor, String cod_revista, String cod_suscriptor, Date fecha) {
        this.autor = autor;
        this.cod_revista = cod_revista;
        this.cod_suscriptor = cod_suscriptor;
        this.fecha = fecha;
    }
    public ReporteEditor2(){
        
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCod_revista() {
        return cod_revista;
    }

    public void setCod_revista(String cod_revista) {
        this.cod_revista = cod_revista;
    }

    public String getCod_suscriptor() {
        return cod_suscriptor;
    }

    public void setCod_suscriptor(String cod_suscriptor) {
        this.cod_suscriptor = cod_suscriptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
