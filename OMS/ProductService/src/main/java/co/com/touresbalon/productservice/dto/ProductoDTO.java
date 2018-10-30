/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dto;

import java.util.List;

/**
 *
 * @author rchicangana
 */
public class ProductoDTO {
    
    private Long idProducto;
    private String nombreProducto;
    private String fechaSalida;
    private String fechaLlegada;
    private String descripcion;
    private TipoProductoDTO idTipoProducto;
    private List<ImagenProductoDTO> imagenProductoList;
    private List<ItinerarioDTO> itinerarioList;


    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public TipoProductoDTO getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProductoDTO idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public List<ItinerarioDTO> getItinerarioList() {
        return itinerarioList;
    }

    public void setItinerarioList(List<ItinerarioDTO> itinerarioList) {
        this.itinerarioList = itinerarioList;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ImagenProductoDTO> getImagenProductoList() {
        return imagenProductoList;
    }

    public void setImagenProductoList(List<ImagenProductoDTO> imagenProductoList) {
        this.imagenProductoList = imagenProductoList;
    }
    
    
    
    
    
    
}
