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
public class ImagenProductoDTO {
    
    private Long idImagenProducto;
    private String imagen;
    private long esprincipal;
    private long idProducto;

    public Long getIdImagenProducto() {
        return idImagenProducto;
    }

    public void setIdImagenProducto(Long idImagenProducto) {
        this.idImagenProducto = idImagenProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getEsprincipal() {
        return esprincipal;
    }

    public void setEsprincipal(long esprincipal) {
        this.esprincipal = esprincipal;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
}
