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
public class ClienteDTO implements Serializable {


    

    private static final long serialVersionUID = 1L;
    private Integer idCliente;
    private String tipoDocumento;
    private String noDocumento;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String razonSocial;
    private String estado;
    private Integer idContactoDef;
    private String fechaCreacion;
    private String fechaUltModificacion;
    private int idCategoria;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteDTO( Integer idCliente, String tipoDocumento, String noDocumento, String nombres, String apellido1, String apellido2, String razonSocial, String estado, Integer idContactoDef, String fechaCreacion, String fechaUltModificacion, int idCategoria) {        
        this.idCliente = idCliente;
        this.tipoDocumento = tipoDocumento;
        this.noDocumento = noDocumento;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.razonSocial = razonSocial;
        this.estado = estado;
        this.idContactoDef = idContactoDef;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltModificacion = fechaUltModificacion;
        this.idCategoria = idCategoria;
    }

    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdContactoDef() {
        return idContactoDef;
    }

    public void setIdContactoDef(Integer idContactoDef) {
        this.idContactoDef = idContactoDef;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "com.toures.entidades.Cliente[ idCliente=" + idCliente + " ]";
    }

    
}
