/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "IMAGEN_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenProducto.findAll", query = "SELECT i FROM ImagenProducto i")
    , @NamedQuery(name = "ImagenProducto.findByAllbyIdProducto", query = "SELECT i FROM ImagenProducto i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "ImagenProducto.findByAllbyIdProductoPrincipal", query = "SELECT i FROM ImagenProducto i WHERE i.idProducto = :idProducto and i.esprincipal=1")
    , @NamedQuery(name = "ImagenProducto.findByIdImagenProducto", query = "SELECT i FROM ImagenProducto i WHERE i.idImagenProducto = :idImagenProducto")
    , @NamedQuery(name = "ImagenProducto.findByImagen", query = "SELECT i FROM ImagenProducto i WHERE i.imagen = :imagen")
    , @NamedQuery(name = "ImagenProducto.findByEsprincipal", query = "SELECT i FROM ImagenProducto i WHERE i.esprincipal = :esprincipal")
    , @NamedQuery(name = "ImagenProducto.findByIdProducto", query = "SELECT i FROM ImagenProducto i WHERE i.idProducto = :idProducto")})
public class ImagenProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_IMAGENPRODCUTO_ID_GET", sequenceName="SEQ_IMAGEN_PRODUCTO_ID_IMAGEN_PRODUCTO", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_IMAGENPRODCUTO_ID_GET") 
    @Column(name = "ID_IMAGEN_PRODUCTO")
    private Long idImagenProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPRINCIPAL")
    private long esprincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private long idProducto;

    public ImagenProducto() {
    }

    public ImagenProducto(Long idImagenProducto) {
        this.idImagenProducto = idImagenProducto;
    }

    public ImagenProducto(Long idImagenProducto, String imagen, long esprincipal, long idProducto) {
        this.idImagenProducto = idImagenProducto;
        this.imagen = imagen;
        this.esprincipal = esprincipal;
        this.idProducto = idProducto;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenProducto != null ? idImagenProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenProducto)) {
            return false;
        }
        ImagenProducto other = (ImagenProducto) object;
        if ((this.idImagenProducto == null && other.idImagenProducto != null) || (this.idImagenProducto != null && !this.idImagenProducto.equals(other.idImagenProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.ImagenProducto[ idImagenProducto=" + idImagenProducto + " ]";
    }
    
}
