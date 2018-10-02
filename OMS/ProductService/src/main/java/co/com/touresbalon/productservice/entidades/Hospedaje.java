/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "HOSPEDAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospedaje.findAll", query = "SELECT h FROM Hospedaje h")
    , @NamedQuery(name = "Hospedaje.findByIdHospedaje", query = "SELECT h FROM Hospedaje h WHERE h.idHospedaje = :idHospedaje")
    , @NamedQuery(name = "Hospedaje.findByNombre", query = "SELECT h FROM Hospedaje h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hospedaje.findByEstrellas", query = "SELECT h FROM Hospedaje h WHERE h.estrellas = :estrellas")})
public class Hospedaje implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_HOSPEDAJE")
    private Long idHospedaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTRELLAS")
    private long estrellas;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHospedaje")
    private List<ImagenHospedaje> imagenHospedajeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabitacion")
    private List<Habitacion> habitacionList;

    public Hospedaje() {
    }

    public Hospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public Hospedaje(Long idHospedaje, String nombre, long estrellas) {
        this.idHospedaje = idHospedaje;
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

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

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @XmlTransient
    public List<ImagenHospedaje> getImagenHospedajeList() {
        return imagenHospedajeList;
    }

    public void setImagenHospedajeList(List<ImagenHospedaje> imagenHospedajeList) {
        this.imagenHospedajeList = imagenHospedajeList;
    }
    
    @XmlTransient
    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospedaje != null ? idHospedaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospedaje)) {
            return false;
        }
        Hospedaje other = (Hospedaje) object;
        if ((this.idHospedaje == null && other.idHospedaje != null) || (this.idHospedaje != null && !this.idHospedaje.equals(other.idHospedaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Hospedaje[ idHospedaje=" + idHospedaje + " ]";
    }

    
    
}
