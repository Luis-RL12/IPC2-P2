/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author RODRIGUEZ
 */
public class Edicion {
    
    int codigopdf;
    String nombrepdf;
    String codigoRevista;
    String autor;
    InputStream archivopdf;
    Date fechaPublicacion;
    private byte[] archivopdf2;

    public Edicion(int id, String name, String codigoRevista, String autor,Date fecha, byte[] archivo) {
        this.codigopdf = id;
        this.nombrepdf = name;
        this.codigoRevista = codigoRevista;
        this.autor = autor;
        this.fechaPublicacion = fecha;
        this.archivopdf2 = archivo;
    }

    public Edicion() {
    }

    /*Todo los codigos get*/
    public int getCodigopdf() {
        return codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }


    /*Todo los codigos set*/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    /**
     * @return the archivopdf2
     */
    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    /**
     * @param archivopdf2 the archivopdf2 to set
     */
    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
