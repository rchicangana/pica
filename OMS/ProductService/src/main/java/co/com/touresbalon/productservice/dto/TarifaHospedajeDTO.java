/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dto;

import java.math.BigDecimal;

/**
 *
 * @author rchic
 */
public class TarifaHospedajeDTO {
    
    private Long idTarifaHospedaje;
    private BigDecimal precio;
    private String fechaVigencia;

    public Long getIdTarifaHospedaje() {
        return idTarifaHospedaje;
    }

    public void setIdTarifaHospedaje(Long idTarifaHospedaje) {
        this.idTarifaHospedaje = idTarifaHospedaje;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
    
    
    
    
}
