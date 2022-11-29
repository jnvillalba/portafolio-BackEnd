package com.porfolio.jnv.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String titulo;
    @NotBlank
    private String periodo;
    @NotBlank
    private String img;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String titulo, String periodo, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.titulo = titulo;
        this.periodo = periodo;
        this.img = img;
    }

   

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
