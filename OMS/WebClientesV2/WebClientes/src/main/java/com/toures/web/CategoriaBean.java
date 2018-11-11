/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.web;


import com.toures.dto.CategoriaDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxCategorias;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
//import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author jpabl
 */
@ManagedBean
@ViewScoped
public class CategoriaBean {
    
    public CategoriaBean(){
    }
    @PostConstruct
    public void init() {
        row = new CategoriaDTO();
        categ = new CategoriaDTO();
        CatgoriaList =  new HashMap();
        cats2 = new ArrayList();
        listarCategoriasActivas();
        listarCategorias();
        
        
        for(CategoriaDTO idx : cats)
        {
            CatgoriaList.put( idx.getNombre(),idx.getIdCategoria().toString());
        }

       
    }
    
    @Inject
    private TxCategorias tx;
    private CategoriaDTO categ;
    private CategoriaDTO row;
    private List<CategoriaDTO> cats;
    private List<CategoriaDTO> cats2;
    private Map<String,String> CatgoriaList;  


    public CategoriaDTO getRow() {
        return row;
    }
    public void setRow(CategoriaDTO row) {
        this.row = row;
    }    
    public Map<String,String> getCatgoriaList() {
        return CatgoriaList;
    }
    public void setCatgoriaList(Map<String,String> CatgoriaList) {
        this.CatgoriaList = CatgoriaList;
    }
    public CategoriaDTO getCateg() {
        return categ;
    }
    public void setCateg(CategoriaDTO categ) {
        this.categ = categ;
    }
    public List<CategoriaDTO> getCats() {
        return cats;
    }
    public void setCats(List<CategoriaDTO> cats) {
        this.cats = cats;
    }
    
    // Metodos 
    public void crearCategoria(){
        RespuestaRs resp = tx.crearCategoria(categ);
        categ = new CategoriaDTO();
        FacesMessage message;
        if (resp.getEstado().equalsIgnoreCase("ok")){
            listarCategorias();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", resp.getDescripcion());
        }
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<CategoriaDTO> getCats2() {
        return cats2;
    }

    public void setCats2(List<CategoriaDTO> cats2) {
        this.cats2 = cats2;
    }
    
    public void actualizarCategoria(){
        RespuestaRs resp = tx.actualizarCategoria(row);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        PrimeFaces.current().dialog().showMessageDynamic(message);        
    }

    public void eliminarContacto(){
        RespuestaRs resp = tx.eliminarCategoria(row);
        listarCategorias();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }       
    
    public void listarCategoriasActivas(){
        cats = tx.listarCategoriasActivas();
    }
    
    public void listarCategorias(){
        cats2 = tx.listarCategorias();
    }
}
