/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dto;

import java.util.List;

/**
 *
 * @author rchic
 */
public class TarifaProductoDTO {
    
    private Long producto;
    private List<ItinerarioDTO> itinerarioDTOlist;
    private BoleteriaDTO boleteriaDTO;
    private Long total;
    

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public List<ItinerarioDTO> getItinerarioDTOlist() {
        return itinerarioDTOlist;
    }

    public void setItinerarioDTOlist(List<ItinerarioDTO> itinerarioDTOlist) {
        this.itinerarioDTOlist = itinerarioDTOlist;
    }

    public BoleteriaDTO getBoleteriaDTO() {
        return boleteriaDTO;
    }

    public void setBoleteriaDTO(BoleteriaDTO boleteriaDTO) {
        this.boleteriaDTO = boleteriaDTO;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

     
    
    
    
}
