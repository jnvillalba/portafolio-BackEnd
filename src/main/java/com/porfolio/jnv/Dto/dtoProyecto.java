package com.porfolio.jnv.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String nombreP;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String descripcionP;
    
    @NotBlank
    private String link;
    
    
    private String img;

    public dtoProyecto() {
    }
    
    public dtoProyecto(String nombreP, String fecha, String descripcionP, String link, String img) {
        this.nombreP = nombreP;
        this.fecha = fecha;
        this.descripcionP = descripcionP;
        this.link = link;
        this.img = img;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
