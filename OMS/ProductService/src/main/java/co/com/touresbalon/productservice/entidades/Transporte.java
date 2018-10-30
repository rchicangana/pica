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
@Table(name = "TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t")
    , @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte")
    , @NamedQuery(name = "Transporte.findByNombre", query = "SELECT t FROM Transporte t WHERE t.nombre = :nombre")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRANSPORTE")
    private Long idTransporte;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "ID_ESTADO_TRANSPORTE", referencedColumnName = "ID_ESTADO_TRANSPORTE")
    @ManyToOne(optional = false)
    private EstadoTransporte idEstadoTransporte;
    @JoinColumn(name = "ID_TIPO_TRANSPORTE", referencedColumnName = "ID_TIPO_TRANSPORTE")
    @ManyToOne(optional = false)
    private TipoTransporte idTipoTransporte;

    public Transporte() {
    }

    public Transporte(Long idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Long getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Long idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public EstadoTransporte getIdEstadoTransporte() {
        return idEstadoTransporte;
    }

    public void setIdEstadoTransporte(EstadoTransporte idEstadoTransporte) {
        this.idEstadoTransporte = idEstadoTransporte;
    }

    public TipoTransporte getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(TipoTransporte idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
