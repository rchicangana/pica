/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "ITINERARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i")
    , @NamedQuery(name = "Itinerario.findByIdItinerario", query = "SELECT i FROM Itinerario i WHERE i.idItinerario = :idItinerario")
    , @NamedQuery(name = "Itinerario.findByIdProducto", query = "SELECT i FROM Itinerario i WHERE i.idProducto = :idProducto")
    , @NamedQuery(name = "Itinerario.findByIdHospedaje", query = "SELECT i FROM Itinerario i WHERE i.idHospedaje = :idHospedaje")})
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ITINERARIO")
    private Long idItinerario;
    @JoinColumn(name = "ID_HOSPEDAJE", referencedColumnName = "ID_HOSPEDAJE")
    @ManyToOne(optional = false)
    private Hospedaje idHospedaje;
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Itinerario() {
    }

    public Itinerario(Long idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Long getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Long idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Hospedaje getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Hospedaje idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItinerario != null ? idItinerario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.idItinerario == null && other.idItinerario != null) || (this.idItinerario != null && !this.idItinerario.equals(other.idItinerario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Itinerario[ idItinerario=" + idItinerario + " ]";
    }

}
