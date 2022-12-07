package com.porfolio.jnv.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    
    @NotBlank
    private String imgBanner;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcion, String img ,String imgBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
        this.imgBanner = imgBanner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    
    
}
