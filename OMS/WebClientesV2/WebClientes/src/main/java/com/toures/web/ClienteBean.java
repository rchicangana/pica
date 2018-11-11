/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.web;

import com.toures.dto.ClienteDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxClientes;
import java.util.List;
import javax.annotation.PostConstruct;

//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author jpabl
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    /**
     * Creates a new instance of ClienteWeb
     */
    public ClienteBean() {
    }
    @PostConstruct
    public void init() {
        cli = new ClienteDTO();
        tipoID = null;
        NoID = null;
        
    }    
    @Inject
    private TxClientes tx;
    private ClienteDTO cli;
    private String tipoID;
    private String NoID;

    

    public ClienteDTO getCli() {
        return cli;
    }

    public void setCli(ClienteDTO cli) {
        this.cli = cli;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getNoID() {
        return NoID;
    }

    public void setNoID(String NoID) {
        this.NoID = NoID;
    }

    public void CrearCliente(){

          RespuestaRs resp =  tx.CrearCliente(cli);
            cli = new ClienteDTO();
            FacesMessage message;
            if (resp.getEstado().equalsIgnoreCase("ok")){
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
            }else{
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", resp.getDescripcion());
            }
            PrimeFaces.current().dialog().showMessageDynamic(message);

    }
    
    public void ConsultarCliente(){
        cli = new ClienteDTO();
        cli = tx.ConsultarCliente(tipoID, NoID);
        if (cli == null){
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El cliente consultado No Existe");
           PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }
    
    public void ActualizarCliente(){
       RespuestaRs resp = tx.ActualizarCliente(cli);
        tipoID = null;
        NoID = null;
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

 
    
    
}
