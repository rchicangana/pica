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
public class CategoriaDTO  {


    private String fechaCreacion;
    private Integer idCategoria;
    private String nombre;
    private String estado;
    private String fechaUltModificacion;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaDTO(Integer idCategoria, String nombre, String estado, String fechaCreacion, String fechaUltModificacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaUltModificacion() {
        return fechaUltModificacion;
    }

    public void setFechaUltModificacion(String fechaUltModificacion) {
        this.fechaUltModificacion = fechaUltModificacion;
    }

    @Override
    public String toString() {
        return "com.toures.entidades.Categoria[ idCategoria=" + idCategoria + " ]";
    }

}
