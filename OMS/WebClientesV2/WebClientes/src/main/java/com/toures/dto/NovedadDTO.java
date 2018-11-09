/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dto;


import java.io.Serializable;



/**
 *
 * @author jpabl
 */
public class NovedadDTO implements Serializable {



    private Integer idNovedad;
    private String entidad;    
    private String fechaNovedad;
    private String estadoInicial;
    private String estadoFinal;

    public NovedadDTO() {
    }

    public NovedadDTO(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public NovedadDTO(Integer idNovedad, String fechaNovedad, String estadoInicial, String estadoFinal) {
        this.idNovedad = idNovedad;
        this.fechaNovedad = fechaNovedad;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(String fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NovedadDTO)) {
            return false;
        }
        NovedadDTO other = (NovedadDTO) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.toures.entidades.Novedad[ idNovedad=" + idNovedad + " ]";
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
}
