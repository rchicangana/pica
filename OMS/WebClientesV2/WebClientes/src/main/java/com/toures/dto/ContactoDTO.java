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
public class ContactoDTO implements Serializable {


    private Integer idContacto;
    private String destinatario;
    private String tipoDireccion;
    private String direccion;
    private String telefono;
    private String celular;
    private int idCiudad;
    private String fechaCreacion;    
    private String fechaUltModificacion;
    private int idCliente;

    public ContactoDTO() {
    }

    public ContactoDTO(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public ContactoDTO(Integer idContacto, String destinatario, String tipoDireccion, String direccion, String telefono, String celular, int idCiudad, String fechaCreacion, String fechaUltModificacion, int idCliente) {
        this.idContacto = idContacto;
        this.destinatario = destinatario;
        this.tipoDireccion = tipoDireccion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.idCiudad = idCiudad;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltModificacion = fechaUltModificacion;
        this.idCliente = idCliente;
    }
    
    
    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDTO)) {
            return false;
        }
        ContactoDTO other = (ContactoDTO) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.toures.entidades.Contacto[ idContacto=" + idContacto + " ]";
    }


    
}
