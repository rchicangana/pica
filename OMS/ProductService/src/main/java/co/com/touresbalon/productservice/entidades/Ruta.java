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
@Table(name = "RUTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByIdRuta", query = "SELECT r FROM Ruta r WHERE r.idRuta = :idRuta")
    , @NamedQuery(name = "Ruta.findByDescripcion", query = "SELECT r FROM Ruta r WHERE r.descripcion = :descripcion")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RUTA")
    private Long idRuta;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_CIUDAD_DESTINO", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudadDestino;
    @JoinColumn(name = "ID_CIUDAD_ORIGEN", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudadOrigen;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public Ruta() {
    }

    public Ruta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad getIdCiudadDestino() {
        return idCiudadDestino;
    }

    public void setIdCiudadDestino(Ciudad idCiudadDestino) {
        this.idCiudadDestino = idCiudadDestino;
    }

    public Ciudad getIdCiudadOrigen() {
        return idCiudadOrigen;
    }

    public void setIdCiudadOrigen(Ciudad idCiudadOrigen) {
        this.idCiudadOrigen = idCiudadOrigen;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Ruta[ idRuta=" + idRuta + " ]";
    }
    
}
