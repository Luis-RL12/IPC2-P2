/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RODRIGUEZ
 */
public class ReporteEditor4 {
    
    private String revista;
    private float ganancia;

    public ReporteEditor4(String revista, float ganancia) {
        this.revista = revista;
        this.ganancia = ganancia;
    }
    
    public ReporteEditor4(){
        
    }


    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public float getGanancia() {
        return ganancia;
    }

    public void setGanancia(float ganancia) {
        this.ganancia = ganancia;
    }
    
    
}
