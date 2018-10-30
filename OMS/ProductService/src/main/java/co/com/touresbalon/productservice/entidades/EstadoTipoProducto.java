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
@Table(name = "ESTADO_TIPO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoTipoProducto.findAll", query = "SELECT e FROM EstadoTipoProducto e")
    , @NamedQuery(name = "EstadoTipoProducto.findByIdEstadoTipoProducto", query = "SELECT e FROM EstadoTipoProducto e WHERE e.idEstadoTipoProducto = :idEstadoTipoProducto")
    , @NamedQuery(name = "EstadoTipoProducto.findByEstado", query = "SELECT e FROM EstadoTipoProducto e WHERE e.estado = :estado")})
public class EstadoTipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_TIPO_PRODUCTO")
    private Long idEstadoTipoProducto;
    @Size(max = 200)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoTipoProducto")
    private List<TipoProducto> tipoProductoList;

    public EstadoTipoProducto() {
    }

    public EstadoTipoProducto(Long idEstadoTipoProducto) {
        this.idEstadoTipoProducto = idEstadoTipoProducto;
    }

    public Long getIdEstadoTipoProducto() {
        return idEstadoTipoProducto;
    }

    public void setIdEstadoTipoProducto(Long idEstadoTipoProducto) {
        this.idEstadoTipoProducto = idEstadoTipoProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TipoProducto> getTipoProductoList() {
        return tipoProductoList;
    }

    public void setTipoProductoList(List<TipoProducto> tipoProductoList) {
        this.tipoProductoList = tipoProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoTipoProducto != null ? idEstadoTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTipoProducto)) {
            return false;
        }
        EstadoTipoProducto other = (EstadoTipoProducto) object;
        if ((this.idEstadoTipoProducto == null && other.idEstadoTipoProducto != null) || (this.idEstadoTipoProducto != null && !this.idEstadoTipoProducto.equals(other.idEstadoTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.EstadoTipoProducto[ idEstadoTipoProducto=" + idEstadoTipoProducto + " ]";
    }
    
}
