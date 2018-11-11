/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dto;

/**
 *
 * @author jpabl
 */
public class RespuestaRs {
    
    private String estado;
    private String Descripcion;

    public RespuestaRs(String estado, String Descripcion) {
        this.estado = estado;
        this.Descripcion = Descripcion;
    }
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
