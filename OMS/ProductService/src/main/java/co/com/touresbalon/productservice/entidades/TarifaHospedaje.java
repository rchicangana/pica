/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author rchic
 */
@Entity
@Table(name = "TARIFA_HOSPEDAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaHospedaje.findAll", query = "SELECT t FROM TarifaHospedaje t")
    , @NamedQuery(name = "TarifaHospedaje.findByIdHabitacion", query = "SELECT t FROM TarifaHospedaje t WHERE t.idHabitacion.idHabitacion = :idHabitacion")
    , @NamedQuery(name = "TarifaHospedaje.findByIdTarifaHospedaje", query = "SELECT t FROM TarifaHospedaje t WHERE t.idTarifaHospedaje = :idTarifaHospedaje")
    , @NamedQuery(name = "TarifaHospedaje.findByPrecio", query = "SELECT t FROM TarifaHospedaje t WHERE t.precio = :precio")
    , @NamedQuery(name = "TarifaHospedaje.findByFechaVigencia", query = "SELECT t FROM TarifaHospedaje t WHERE t.fechaVigencia = :fechaVigencia")})
public class TarifaHospedaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARIFA_HOSPEDAJE")
    private Long idTarifaHospedaje;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @JoinColumn(name = "ID_HABITACION", referencedColumnName = "ID_HABITACION")
    @ManyToOne(optional = false)
    private Habitacion idHabitacion;

    public TarifaHospedaje() {
    }

    public TarifaHospedaje(Long idTarifaHospedaje) {
        this.idTarifaHospedaje = idTarifaHospedaje;
    }

    public TarifaHospedaje(Long idTarifaHospedaje, BigDecimal precio, Date fechaVigencia) {
        this.idTarifaHospedaje = idTarifaHospedaje;
        this.precio = precio;
        this.fechaVigencia = fechaVigencia;
    }

    public Long getIdTarifaHospedaje() {
        return idTarifaHospedaje;
    }

    public void setIdTarifaHospedaje(Long idTarifaHospedaje) {
        this.idTarifaHospedaje = idTarifaHospedaje;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
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
        hash += (idTarifaHospedaje != null ? idTarifaHospedaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaHospedaje)) {
            return false;
        }
        TarifaHospedaje other = (TarifaHospedaje) object;
        if ((this.idTarifaHospedaje == null && other.idTarifaHospedaje != null) || (this.idTarifaHospedaje != null && !this.idTarifaHospedaje.equals(other.idTarifaHospedaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.TarifaHospedaje[ idTarifaHospedaje=" + idTarifaHospedaje + " ]";
    }
    
}
