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
public class Pago {
    private int id;
    private String codigoRevista;
    private String codigoSuscriptor;
    private float pagoSuscripcion;
    private Date fecha;

    public Pago(int id, String codigoRevista, String codigoSuscriptor, float pagoSuscripcion, Date fecha) {
        this.id = id;
        this.codigoRevista = codigoRevista;
        this.codigoSuscriptor = codigoSuscriptor;
        this.pagoSuscripcion = pagoSuscripcion;
        this.fecha = fecha;
    }
    
    public Pago(){
        
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

    public float getPagoSuscripcion() {
        return pagoSuscripcion;
    }

    public void setPagoSuscripcion(float pagoSuscripcion) {
        this.pagoSuscripcion = pagoSuscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
