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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "IMAGEN_HOSPEDAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenHospedaje.findAll", query = "SELECT i FROM ImagenHospedaje i")
    , @NamedQuery(name = "ImagenHospedaje.findByAllbyHospedaje", query = "SELECT i FROM ImagenHospedaje i WHERE i.idHospedaje.idHospedaje = :idHospedaje")
    , @NamedQuery(name = "ImagenHospedaje.findByIdImagenHospedaje", query = "SELECT i FROM ImagenHospedaje i WHERE i.idImagenHospedaje = :idImagenHospedaje")    
    , @NamedQuery(name = "ImagenHospedaje.findByImagen", query = "SELECT i FROM ImagenHospedaje i WHERE i.imagen = :imagen")
    , @NamedQuery(name = "ImagenHospedaje.findByEsprincipal", query = "SELECT i FROM ImagenHospedaje i WHERE i.esprincipal = :esprincipal")})
public class ImagenHospedaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_IMAGEN_HOSPEDAJE")
    private Long idImagenHospedaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPRINCIPAL")
    private long esprincipal;
    @JoinColumn(name = "ID_HOSPEDAJE", referencedColumnName = "ID_HOSPEDAJE")
    @ManyToOne(optional = false)
    private Hospedaje idHospedaje;

    public ImagenHospedaje() {
    }

    public ImagenHospedaje(Long idImagenHospedaje) {
        this.idImagenHospedaje = idImagenHospedaje;
    }

    public ImagenHospedaje(Long idImagenHospedaje, String imagen, long esprincipal) {
        this.idImagenHospedaje = idImagenHospedaje;
        this.imagen = imagen;
        this.esprincipal = esprincipal;
    }

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

    public long getEsprincipal() {
        return esprincipal;
    }

    public void setEsprincipal(long esprincipal) {
        this.esprincipal = esprincipal;
    }

    public Hospedaje getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Hospedaje idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenHospedaje != null ? idImagenHospedaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenHospedaje)) {
            return false;
        }
        ImagenHospedaje other = (ImagenHospedaje) object;
        if ((this.idImagenHospedaje == null && other.idImagenHospedaje != null) || (this.idImagenHospedaje != null && !this.idImagenHospedaje.equals(other.idImagenHospedaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.ImagenHospedaje[ idImagenHospedaje=" + idImagenHospedaje + " ]";
    }

}
