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
@Table(name = "IMAGEN_HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenHabitacion.findAll", query = "SELECT i FROM ImagenHabitacion i")
    , @NamedQuery(name = "ImagenHabitacion.findByIdHabitacion", query = "SELECT i FROM ImagenHabitacion i WHERE i.idHabitacion.idHabitacion = :idHabitacion")
    , @NamedQuery(name = "ImagenHabitacion.findByIdImagenHabitacion", query = "SELECT i FROM ImagenHabitacion i WHERE i.idImagenHabitacion = :idImagenHabitacion")
    , @NamedQuery(name = "ImagenHabitacion.findByImagen", query = "SELECT i FROM ImagenHabitacion i WHERE i.imagen = :imagen")
    , @NamedQuery(name = "ImagenHabitacion.findByEsprincipal", query = "SELECT i FROM ImagenHabitacion i WHERE i.esprincipal = :esprincipal")})
public class ImagenHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_IMAGEN_HABITACION")
    private Long idImagenHabitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPRINCIPAL")
    private long esprincipal;
    @JoinColumn(name = "ID_HABITACION", referencedColumnName = "ID_HABITACION")
    @ManyToOne(optional = false)
    private Habitacion idHabitacion;

    public ImagenHabitacion() {
    }

    public ImagenHabitacion(Long idImagenHabitacion) {
        this.idImagenHabitacion = idImagenHabitacion;
    }

    public ImagenHabitacion(Long idImagenHabitacion, String imagen, long esprincipal) {
        this.idImagenHabitacion = idImagenHabitacion;
        this.imagen = imagen;
        this.esprincipal = esprincipal;
    }

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

    public long getEsprincipal() {
        return esprincipal;
    }

    public void setEsprincipal(long esprincipal) {
        this.esprincipal = esprincipal;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenHabitacion != null ? idImagenHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenHabitacion)) {
            return false;
        }
        ImagenHabitacion other = (ImagenHabitacion) object;
        if ((this.idImagenHabitacion == null && other.idImagenHabitacion != null) || (this.idImagenHabitacion != null && !this.idImagenHabitacion.equals(other.idImagenHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.ImagenHabitacion[ idImagenHabitacion=" + idImagenHabitacion + " ]";
    }
    
}
