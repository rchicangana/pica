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
@Table(name = "TARIFA_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaTransporte.findAll", query = "SELECT t FROM TarifaTransporte t")
    , @NamedQuery(name = "TarifaTransporte.findByIdRuta", query = "SELECT t FROM TarifaTransporte t WHERE t.idRuta.idRuta = :idRuta")
    , @NamedQuery(name = "TarifaTransporte.findByIdTarifaTransporte", query = "SELECT t FROM TarifaTransporte t WHERE t.idTarifaTransporte = :idTarifaTransporte")
    , @NamedQuery(name = "TarifaTransporte.findByPrecio", query = "SELECT t FROM TarifaTransporte t WHERE t.precio = :precio")
    , @NamedQuery(name = "TarifaTransporte.findByFechaVigencia", query = "SELECT t FROM TarifaTransporte t WHERE t.fechaVigencia = :fechaVigencia")})
public class TarifaTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARIFA_TRANSPORTE")
    private Long idTarifaTransporte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA")
    @ManyToOne(optional = false)
    private Ruta idRuta;

    public TarifaTransporte() {
    }

    public TarifaTransporte(Long idTarifaTransporte) {
        this.idTarifaTransporte = idTarifaTransporte;
    }

    public TarifaTransporte(Long idTarifaTransporte, BigDecimal precio) {
        this.idTarifaTransporte = idTarifaTransporte;
        this.precio = precio;
    }

    public Long getIdTarifaTransporte() {
        return idTarifaTransporte;
    }

    public void setIdTarifaTransporte(Long idTarifaTransporte) {
        this.idTarifaTransporte = idTarifaTransporte;
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

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifaTransporte != null ? idTarifaTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaTransporte)) {
            return false;
        }
        TarifaTransporte other = (TarifaTransporte) object;
        if ((this.idTarifaTransporte == null && other.idTarifaTransporte != null) || (this.idTarifaTransporte != null && !this.idTarifaTransporte.equals(other.idTarifaTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.TarifaTransporte[ idTarifaTransporte=" + idTarifaTransporte + " ]";
    }
    
}
