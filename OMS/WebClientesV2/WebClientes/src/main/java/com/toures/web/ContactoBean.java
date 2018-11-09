/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.web;


import com.toures.dto.ClienteDTO;
import com.toures.dto.ContactoDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxClientes;
import com.toures.negocio.TxContactos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Asesoftware
 */
@ManagedBean
@ViewScoped
public class ContactoBean {

    @PostConstruct
    public void init() {
        cont = new ContactoDTO();
        cli = new ClienteDTO();
        conts = new ArrayList();
        nombreCompleto = null;
        tipoID = null;
        NoID = null;
    }
    
    
    @Inject
    private TxContactos tx;
    @Inject
    private TxClientes tx2;
    private ClienteDTO cli;
    private String tipoID;
    private String NoID;    
    private ContactoDTO cont;
    private List<ContactoDTO> conts;
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
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
    public ContactoDTO getCont() {
        return cont;
    }
    public void setCont(ContactoDTO cont) {
        this.cont = cont;
    }
    public List<ContactoDTO> getConts() {
        return conts;
    }
    public void setConts(List<ContactoDTO> conts) {
        this.conts = conts;
    }
    
    public void crearContacto(){
        cont.setIdCliente(cli.getIdCliente());
        FacesMessage message;
        if (cli.getIdCliente()==null){
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha consultado el cliente");
        }else{
            RespuestaRs resp =  tx.CrearContacto(cont);
            cont = new ContactoDTO();
            if (resp.getEstado().equalsIgnoreCase("ok")){
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
            }else{
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", resp.getDescripcion());
            }
        }
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }
    
    public void consultarHead(){
        cli = new ClienteDTO();
        cont = new ContactoDTO();
        cli = tx2.ConsultarCliente(tipoID, NoID);
        if (cli == null){
           nombreCompleto = null;
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El cliente consultado No Existe");
           PrimeFaces.current().dialog().showMessageDynamic(message);
        }else{        
            if (cli.getTipoDocumento().equalsIgnoreCase("NIT"))
                    nombreCompleto = cli.getRazonSocial();
            else
                 nombreCompleto = cli.getNombres()+" "+cli.getApellido1()+" "+cli.getApellido2();

            System.out.println("Lei Nombre Copmpleto "+ nombreCompleto);
            if (cli == null){
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El cliente consultado No Existe");
               PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }
    } 

    public void consultarContactosPorCliente(){
        cli = new ClienteDTO();
        cli = tx2.ConsultarCliente(tipoID, NoID);
            if (cli.getTipoDocumento().equalsIgnoreCase("NIT"))
                    nombreCompleto = cli.getRazonSocial();
            else
                 nombreCompleto = cli.getNombres()+" "+cli.getApellido1()+" "+cli.getApellido2();

        if (cli == null){
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El cliente consultado No Existe");
           PrimeFaces.current().dialog().showMessageDynamic(message);
        }else{
        conts = new ArrayList();    
        conts = tx.ConsultarContactosPorCliente(cli.getIdCliente());
        }
    } 
    public void actualizarContacto(){
       RespuestaRs resp = tx.ActualizarContacto(cont);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    public void eliminarContacto(){
        RespuestaRs resp = tx.EliminarContacto(cont);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion", resp.getDescripcion());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }    
    
}
