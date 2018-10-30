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
@Table(name = "TIPO_TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransporte.findAll", query = "SELECT t FROM TipoTransporte t")
    , @NamedQuery(name = "TipoTransporte.findByIdTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.idTipoTransporte = :idTipoTransporte")
    , @NamedQuery(name = "TipoTransporte.findByNombre", query = "SELECT t FROM TipoTransporte t WHERE t.nombre = :nombre")})
public class TipoTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_TRANSPORTE")
    private Long idTipoTransporte;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransporte")
    private List<Transporte> transporteList;

    public TipoTransporte() {
    }

    public TipoTransporte(Long idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Long getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Long idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransporte)) {
            return false;
        }
        TipoTransporte other = (TipoTransporte) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.TipoTransporte[ idTipoTransporte=" + idTipoTransporte + " ]";
    }
    
}
