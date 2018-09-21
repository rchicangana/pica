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
public class ImagenHospedajeDTO {
    
    private Long idImagenHospedaje;
    private String imagen;
    private Long esprincipal;
    private Long idHospedaje;

    public Long getIdImagenHospedaje() {
        return idImagenHospedaje;
    }

    public void setIdImagenHospedaje(Long idImagenHospedaje) {
        this.idImagenHospedaje = idImagenHospedaje;
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

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }
    
    
    
}
