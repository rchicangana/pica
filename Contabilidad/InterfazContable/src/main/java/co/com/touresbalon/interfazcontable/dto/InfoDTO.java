/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.interfazcontable.dto;

/**
 *
 * @author rchic
 */
public class InfoDTO {
    
    private Long idProdcuto;
    private String nombre;
    private Long nroOrden;
    private String fecha;
    private Long nroSolicitud;
    private Long valor;

    public Long getIdProdcuto() {
        return idProdcuto;
    }

    public void setIdProdcuto(Long idProdcuto) {
        this.idProdcuto = idProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(Long nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
    
    
    
}
