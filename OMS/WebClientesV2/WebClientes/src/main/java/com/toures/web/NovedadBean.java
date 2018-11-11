/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.web;


import com.toures.dto.NovedadDTO;
import com.toures.negocio.TxNovedades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
//import javax.inject.Named;

/**
 *
 * @author jpabl
 */
@ManagedBean
@ViewScoped
public class NovedadBean {

    public NovedadBean() {
    }
    
    @PostConstruct
    public void init() {
        row = new NovedadDTO();
        novs = new ArrayList();
        fechaIni = null;
        fechaFin = null;       
        entidad  = null;         
    }   
    @Inject
    private TxNovedades tx;
    
    private NovedadDTO row;
    private List<NovedadDTO> novs;
    private Date fechaIni;
    private Date fechaFin;
    private String entidad;
    
    
    public Date getFechaIni() {
        return fechaIni;
    }
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public NovedadDTO getRow() {
        return row;
    }
    public void setRow(NovedadDTO row) {
        this.row = row;
    }
    public List<NovedadDTO> getNovs() {
        return novs;
    }
    public void setNovs(List<NovedadDTO> novs) {
        this.novs = novs;
    }
    public String getEntidad() {
        return entidad;
    }
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
 
    
    public void consultarPorFecha(){
        novs = tx.consultarNovedadesPorFecha(fechaIni, fechaFin);
    }
    
    public void consultarPorEntidad(){
        novs = tx.consultarNovedadesPorEntidad(entidad);
    }

    public void consultarPorTodo(){
        novs = tx.consultarNovedadesPorFiltro(entidad,fechaIni, fechaFin);
    }    
    
    public void consultar(){
        FacesMessage message;
        if (entidad == null && fechaIni == null && fechaFin == null){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe diligenciar un rango de fechas o una entidad o ambas");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }else if ((fechaIni == null && fechaFin != null) ||(fechaIni != null && fechaFin == null) ){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe diligenciar un rango de fechas completo");
            PrimeFaces.current().dialog().showMessageDynamic(message); 
        }else if (entidad != null && fechaIni == null && fechaFin == null){
            consultarPorEntidad();
        }else if (entidad == null && fechaIni != null && fechaFin != null){
            consultarPorFecha();
        }else if (entidad != null && fechaIni != null && fechaFin != null){
            consultarPorTodo();
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El filtro no se llenó debidamente");
            PrimeFaces.current().dialog().showMessageDynamic(message); 
        }
    }
    
}
