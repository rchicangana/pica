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
public class ImagenHabitacionDTO {
    
    private Long idImagenHabitacion;
    private String imagen;
    private Long esprincipal;
    private Long idHabitacion;

    public Long getIdImagenHabitacion() {
        return idImagenHabitacion;
    }

    public void setIdImagenHabitacion(Long idImagenHabitacion) {
        this.idImagenHabitacion = idImagenHabitacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getEsprincipal() {
        return esprincipal;
    }

    public void setEsprincipal(Long esprincipal) {
        this.esprincipal = esprincipal;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    
    
    
}
