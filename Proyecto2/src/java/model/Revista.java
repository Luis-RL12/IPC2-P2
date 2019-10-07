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
public class Revista {
 
    private String nombreRevista;
    private String autor;
    private String descripcion;
    private float costo;
    private String categoria;
    private Date fecha;
    private boolean likes;
    private boolean comentarios;
    private boolean isSuscribable;
    private boolean isAprovado;
    private float costoDia;
    private String foto;
    private String tags;

    public Revista(String nombreRevista, String autor, String descripcion, float costo, String categoria, Date fecha, boolean likes, boolean comentarios, boolean isSuscribable, boolean isAprovado, float costo_dia, String fotoRevista, String tags) {
        this.nombreRevista = nombreRevista;
        this.autor = autor;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria = categoria;
        this.fecha = fecha;
        this.likes = likes;
        this.comentarios = comentarios;
        this.isSuscribable = isSuscribable;
        this.isAprovado = isAprovado;
        this.costoDia = costo_dia;
        this.foto = fotoRevista;
        this.tags = tags;
    }
    
    public Revista(){
        
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public boolean isComentarios() {
        return comentarios;
    }

    public void setComentarios(boolean comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isIsSuscribable() {
        return isSuscribable;
    }

    public void setIsSuscribable(boolean isSuscribable) {
        this.isSuscribable = isSuscribable;
    }

    public boolean isIsAprovado() {
        return isAprovado;
    }

    public void setIsAprovado(boolean isAprovado) {
        this.isAprovado = isAprovado;
    }

    public float getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(float costoDia) {
        this.costoDia = costoDia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    
    
}
