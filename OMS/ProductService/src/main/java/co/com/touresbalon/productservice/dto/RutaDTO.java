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
public class RutaDTO {
    
    private Long idRuta;
    private String descripcion;
    private CiudadDTO idCiudadDestino;
    private CiudadDTO idCiudadOrigen;
    private EmpresaDTO idEmpresa;
    private TarifaTransporteDTO traifaTransporteDTO;

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CiudadDTO getIdCiudadDestino() {
        return idCiudadDestino;
    }

    public void setIdCiudadDestino(CiudadDTO idCiudadDestino) {
        this.idCiudadDestino = idCiudadDestino;
    }

    public CiudadDTO getIdCiudadOrigen() {
        return idCiudadOrigen;
    }

    public void setIdCiudadOrigen(CiudadDTO idCiudadOrigen) {
        this.idCiudadOrigen = idCiudadOrigen;
    }

    

    public EmpresaDTO getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaDTO idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TarifaTransporteDTO getTraifaTransporteDTO() {
        return traifaTransporteDTO;
    }

    public void setTraifaTransporteDTO(TarifaTransporteDTO traifaTransporteDTO) {
        this.traifaTransporteDTO = traifaTransporteDTO;
    }
    
    
    
}
