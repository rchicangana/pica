/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author jpabl
 */
@Entity
@Table(name = "Novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByIdNovedad", query = "SELECT n FROM Novedad n WHERE n.idNovedad = :idNovedad")
    , @NamedQuery(name = "Novedad.findByFechaNovedad", query = "SELECT n FROM Novedad n WHERE n.fechaNovedad >= :fechaIni and n.fechaNovedad <= :fechaFin")
    , @NamedQuery(name = "Novedad.findByFiltro", query = "SELECT n FROM Novedad n WHERE n.entidad = :entidad and n.fechaNovedad >= :fechaIni and n.fechaNovedad <= :fechaFin")    
    , @NamedQuery(name = "Novedad.findByEntidad", query = "SELECT n FROM Novedad n WHERE n.entidad = :entidad")
    , })
public class Novedad implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_novedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "entidad")
    private String entidad;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_novedad")
    @Temporal(TemporalType.DATE)
    private Date fechaNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado_inicial")
    private String estadoInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado_final")
    private String estadoFinal;

    public Novedad() {
    }

    public Novedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedad(Integer idNovedad, Date fechaNovedad,String entidad, String estadoInicial, String estadoFinal) {
        this.idNovedad = idNovedad;
        this.fechaNovedad = fechaNovedad;
        this.entidad = entidad;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Date getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(Date fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.toures.entidades.Novedad[ idNovedad=" + idNovedad + " ]";
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
}
