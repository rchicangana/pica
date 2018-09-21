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
public class ItinerarioDTO {
    
    private Long idItinerario;
    private long idProducto;
    private HospedajeDTO idHospedaje;
    private CiudadDTO idCiudad;

    public Long getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Long idItinerario) {
        this.idItinerario = idItinerario;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public HospedajeDTO getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(HospedajeDTO idHospedaje) {
        this.idHospedaje = idHospedaje;
    }


    public CiudadDTO getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(CiudadDTO idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
    
}
