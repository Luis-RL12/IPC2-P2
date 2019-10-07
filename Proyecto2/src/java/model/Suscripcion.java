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
public class Suscripcion {
    private String codigoRevista;
    private String codigoSuscriptor;
    private Date fecha;

    public Suscripcion(String codigoRevista, String codigoSuscriptor, Date fecha) {
        this.codigoRevista = codigoRevista;
        this.codigoSuscriptor = codigoSuscriptor;
        this.fecha = fecha;
    }
    
    public Suscripcion(){
        
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
