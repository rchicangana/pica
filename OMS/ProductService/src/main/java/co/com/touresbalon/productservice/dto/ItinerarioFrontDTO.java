/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dto;

/**
 *
 * @author rchic
 */
public class ItinerarioFrontDTO {
    
    private Long idItinerario;
    private long idProducto;
    private HospedajeDTO idHospedaje;
    private CiudadDTO idCiudadOrigen;
    private CiudadDTO idCiudad;
    private String descripcion;
    private EmpresaDTO idEmpresa;
    private Long tarifaTransporte;
    private Long tarifaHospedaje;

    public Long getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Long idItinerario) {
        this.idItinerario = idItinerario;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public CiudadDTO getIdCiudadOrigen() {
        return idCiudadOrigen;
    }

    public void setIdCiudadOrigen(CiudadDTO idCiudadOrigen) {
        this.idCiudadOrigen = idCiudadOrigen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EmpresaDTO getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaDTO idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getTarifaTransporte() {
        return tarifaTransporte;
    }

    public void setTarifaTransporte(Long tarifaTransporte) {
        this.tarifaTransporte = tarifaTransporte;
    }

    public Long getTarifaHospedaje() {
        return tarifaHospedaje;
    }

    public void setTarifaHospedaje(Long tarifaHospedaje) {
        this.tarifaHospedaje = tarifaHospedaje;
    }
    
    
    
    
}
