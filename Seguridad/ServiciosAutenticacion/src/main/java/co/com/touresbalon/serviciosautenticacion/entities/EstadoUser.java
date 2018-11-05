/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.entities;

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
 * @author rchic
 */
@Entity
@Table(name = "ESTADO_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUser.findAll", query = "SELECT e FROM EstadoUser e")
    , @NamedQuery(name = "EstadoUser.findByIdEstadoUser", query = "SELECT e FROM EstadoUser e WHERE e.idEstadoUser = :idEstadoUser")
    , @NamedQuery(name = "EstadoUser.findByEstado", query = "SELECT e FROM EstadoUser e WHERE e.estado = :estado")})
public class EstadoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_USER")
    private Long idEstadoUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoUser")
    private List<Usuario> usuarioList;

    public EstadoUser() {
    }

    public EstadoUser(Long idEstadoUser) {
        this.idEstadoUser = idEstadoUser;
    }

    public EstadoUser(Long idEstadoUser, String estado) {
        this.idEstadoUser = idEstadoUser;
        this.estado = estado;
    }

    public Long getIdEstadoUser() {
        return idEstadoUser;
    }

    public void setIdEstadoUser(Long idEstadoUser) {
        this.idEstadoUser = idEstadoUser;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoUser != null ? idEstadoUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUser)) {
            return false;
        }
        EstadoUser other = (EstadoUser) object;
        if ((this.idEstadoUser == null && other.idEstadoUser != null) || (this.idEstadoUser != null && !this.idEstadoUser.equals(other.idEstadoUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.serviciosautenticacion.entities.EstadoUser[ idEstadoUser=" + idEstadoUser + " ]";
    }
    
}
