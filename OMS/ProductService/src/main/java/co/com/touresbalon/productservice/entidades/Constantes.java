/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rchicangana
 */
@Entity
@Table(name = "CONSTANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constantes.findAll", query = "SELECT c FROM Constantes c")
    , @NamedQuery(name = "Constantes.findByNombre", query = "SELECT c FROM Constantes c WHERE c.constantesPK.nombre = :nombre")
    , @NamedQuery(name = "Constantes.findByValor", query = "SELECT c FROM Constantes c WHERE c.constantesPK.valor = :valor")
    , @NamedQuery(name = "Constantes.findByEstado", query = "SELECT c FROM Constantes c WHERE c.constantesPK.estado = :estado")})
public class Constantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConstantesPK constantesPK;

    public Constantes() {
    }

    public Constantes(ConstantesPK constantesPK) {
        this.constantesPK = constantesPK;
    }

    public Constantes(String nombre, String valor, long estado) {
        this.constantesPK = new ConstantesPK(nombre, valor, estado);
    }

    public ConstantesPK getConstantesPK() {
        return constantesPK;
    }

    public void setConstantesPK(ConstantesPK constantesPK) {
        this.constantesPK = constantesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constantesPK != null ? constantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constantes)) {
            return false;
        }
        Constantes other = (Constantes) object;
        if ((this.constantesPK == null && other.constantesPK != null) || (this.constantesPK != null && !this.constantesPK.equals(other.constantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.productservice.entidades.Constantes[ constantesPK=" + constantesPK + " ]";
    }
    
}
