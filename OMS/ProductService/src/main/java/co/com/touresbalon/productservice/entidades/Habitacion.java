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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h")
    , @NamedQuery(name = "Habitacion.findByIdHabitacion", query = "SELECT h FROM Habitacion h WHERE h.idHabitacion = :idHabitacion")
    , @NamedQuery(name = "Habitacion.findByIdHospedaje", query = "SELECT h FROM Habitacion h WHERE h.idHospedaje = :idHospedaje")
    , @NamedQuery(name = "Habitacion.findByNumero", query = "SELECT h FROM Habitacion h WHERE h.numero = :numero")})
public class Habitacion implements Serializable {

    
   

    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_HABITACION")
    private Long idHabitacion;
    @JoinColumn(name = "ID_HOSPEDAJE", referencedColumnName = "ID_HOSPEDAJE")
    @ManyToOne(optional = false)
    private Hospedaje idHospedaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private long numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabitacion")
    private List<ImagenHabitacion> imagenHabitacionList;
    @JoinColumn(name = "ID_TIPO_HABITACION", referencedColumnName = "ID_TIPO_HABITACION")
    @ManyToOne(optional = false)
    private TipoHabitacion idTipoHabitacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabitacion")
    private List<TarifaHospedaje> tarifaHospedajeList;

    public Habitacion() {
    }

    public Habitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }


    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<ImagenHabitacion> getImagenHabitacionList() {
        return imagenHabitacionList;
    }

    public void setImagenHabitacionList(List<ImagenHabitacion> imagenHabitacionList) {
        this.imagenHabitacionList = imagenHabitacionList;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
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
        hash += (idHabitacion != null ? idHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.idHabitacion == null && other.idHabitacion != null) || (this.idHabitacion != null && !this.idHabitacion.equals(other.idHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Habitacion[ idHabitacion=" + idHabitacion + " ]";
    }

    @XmlTransient
    public List<TarifaHospedaje> getTarifaHospedajeList() {
        return tarifaHospedajeList;
    }

    public void setTarifaHospedajeList(List<TarifaHospedaje> tarifaHospedajeList) {
        this.tarifaHospedajeList = tarifaHospedajeList;
    }

   
    
}
