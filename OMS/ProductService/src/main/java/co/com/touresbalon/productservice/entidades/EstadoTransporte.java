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
import javax.persistence.Id;
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
@Table(name = "ESTADO_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoTransporte.findAll", query = "SELECT e FROM EstadoTransporte e")
    , @NamedQuery(name = "EstadoTransporte.findByIdEstadoTransporte", query = "SELECT e FROM EstadoTransporte e WHERE e.idEstadoTransporte = :idEstadoTransporte")
    , @NamedQuery(name = "EstadoTransporte.findByEstado", query = "SELECT e FROM EstadoTransporte e WHERE e.estado = :estado")})
public class EstadoTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_TRANSPORTE")
    private Long idEstadoTransporte;
    @Size(max = 90)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoTransporte")
    private List<Transporte> transporteList;

    public EstadoTransporte() {
    }

    public EstadoTransporte(Long idEstadoTransporte) {
        this.idEstadoTransporte = idEstadoTransporte;
    }

    public Long getIdEstadoTransporte() {
        return idEstadoTransporte;
    }

    public void setIdEstadoTransporte(Long idEstadoTransporte) {
        this.idEstadoTransporte = idEstadoTransporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoTransporte != null ? idEstadoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTransporte)) {
            return false;
        }
        EstadoTransporte other = (EstadoTransporte) object;
        if ((this.idEstadoTransporte == null && other.idEstadoTransporte != null) || (this.idEstadoTransporte != null && !this.idEstadoTransporte.equals(other.idEstadoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.EstadoTransporte[ idEstadoTransporte=" + idEstadoTransporte + " ]";
    }
    
}
