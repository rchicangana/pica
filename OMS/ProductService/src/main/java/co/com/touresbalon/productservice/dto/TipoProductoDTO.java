/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dto;

/**
 *
 * @author rchicangana
 */
public class TipoProductoDTO {
    
    private Long idTipoProducto;
    private String nombre;
    private EstadoTipoProductoDTO idEstadoTipoProducto;

    public Long getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Long idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoTipoProductoDTO getIdEstadoTipoProducto() {
        return idEstadoTipoProducto;
    }

    public void setIdEstadoTipoProducto(EstadoTipoProductoDTO idEstadoTipoProducto) {
        this.idEstadoTipoProducto = idEstadoTipoProducto;
    }
    
    
    
}
