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
public class CiudadDTO {
    
    private Long idCiudad;
    private String nombre;
    private PaisDTO idPais;

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PaisDTO getIdPais() {
        return idPais;
    }

    public void setIdPais(PaisDTO idPais) {
        this.idPais = idPais;
    }
    
    
    
}
