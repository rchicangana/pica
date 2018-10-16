/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchic
 */
@Entity
@Table(name = "BOLETERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleteria.findAll", query = "SELECT b FROM Boleteria b")
    , @NamedQuery(name = "Boleteria.findById", query = "SELECT b FROM Boleteria b WHERE b.id = :id")
    , @NamedQuery(name = "Boleteria.findByProductoId", query = "SELECT b FROM Boleteria b WHERE b.productoId = :productoId")
    , @NamedQuery(name = "Boleteria.findByTiquetes", query = "SELECT b FROM Boleteria b WHERE b.tiquetes = :tiquetes")
    , @NamedQuery(name = "Boleteria.findByLocalidad", query = "SELECT b FROM Boleteria b WHERE b.localidad = :localidad")
    , @NamedQuery(name = "Boleteria.findByFecha", query = "SELECT b FROM Boleteria b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Boleteria.findByValor", query = "SELECT b FROM Boleteria b WHERE b.valor = :valor")
    , @NamedQuery(name = "Boleteria.findByMoneda", query = "SELECT b FROM Boleteria b WHERE b.moneda = :moneda")})
public class Boleteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCTO_ID")
    private Long productoId;
    @Column(name = "TIQUETES")
    private BigInteger tiquetes;
    @Size(max = 50)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "VALOR")
    private Long valor;
    @Size(max = 20)
    @Column(name = "MONEDA")
    private String moneda;
    

    public Boleteria() {
    }

    public Boleteria(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public BigInteger getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(BigInteger tiquetes) {
        this.tiquetes = tiquetes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleteria)) {
            return false;
        }
        Boleteria other = (Boleteria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Boleteria[ id=" + id + " ]";
    }
    
}
