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
public class HospedajeDTO {
    
    private Long idHospedaje;
    private String nombre;
    private long estrellas;
    private CiudadDTO idCiudad;
    private List<ImagenHospedajeDTO> imagenHospedajeList;
    private List<HabitacionDTO> habitacionList;
    

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(long estrellas) {
        this.estrellas = estrellas;
    }

    public CiudadDTO getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(CiudadDTO idCiudad) {
        this.idCiudad = idCiudad;
    }

    public List<ImagenHospedajeDTO> getImagenHospedajeList() {
        return imagenHospedajeList;
    }

    public void setImagenHospedajeList(List<ImagenHospedajeDTO> imagenHospedajeList) {
        this.imagenHospedajeList = imagenHospedajeList;
    }

    public List<HabitacionDTO> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<HabitacionDTO> habitacionList) {
        this.habitacionList = habitacionList;
    }
    
    
    
    
}
