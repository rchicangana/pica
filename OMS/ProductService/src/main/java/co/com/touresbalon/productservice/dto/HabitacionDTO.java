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
public class HabitacionDTO {
    
    private Long idHabitacion;
    private Long idHospedaje;
    private Long numero;
    private List<ImagenHabitacionDTO> imagenHabitacionList;
    private TipoHabitacionDTO idTipoHabitacion;

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public List<ImagenHabitacionDTO> getImagenHabitacionList() {
        return imagenHabitacionList;
    }

    public void setImagenHabitacionList(List<ImagenHabitacionDTO> imagenHabitacionList) {
        this.imagenHabitacionList = imagenHabitacionList;
    }

    public TipoHabitacionDTO getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacionDTO idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
    
    
    
}
