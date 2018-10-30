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
public class TarifaTransporteDTO {
    
    private Long idTarifaTransporte;
    private BigDecimal precio;
    private String fechaVigencia;

    public Long getIdTarifaTransporte() {
        return idTarifaTransporte;
    }

    public void setIdTarifaTransporte(Long idTarifaTransporte) {
        this.idTarifaTransporte = idTarifaTransporte;
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
