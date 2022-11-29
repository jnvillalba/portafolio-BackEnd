package com.porfolio.jnv.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String puesto;
    @NotBlank
    private String periodo;
    @NotBlank
    private String img;
    
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String puesto, String periodo, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.puesto = puesto;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
