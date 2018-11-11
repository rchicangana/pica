/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.ws;

import com.toures.dto.ContactoDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxContactos;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jpabl
 */
@Path("ContactosTx")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactosWS {
    
    @EJB
    private TxContactos tx;
    
    @POST
    @Path("Crear")
    public RespuestaRs CrearContacto(ContactoDTO contacto){
        return tx.CrearContacto(contacto);
    }
    
    @POST
    @Path("Actualizar")
    public RespuestaRs ActualizarContacto(ContactoDTO contacto){
        return tx.ActualizarContacto(contacto);
    }
    
    @GET
    @Path("ConsultarPorCliente/{id}")
    public List<ContactoDTO> ConsultarContactosCliente(@PathParam("id") int id){
        return tx.ConsultarContactosPorCliente(id);
    }

    @GET
    @Path("ConsultarPorID/{id}")
    public ContactoDTO ConsultarContacto(@PathParam("id") int id){
        return tx.ConsultarContacto(id);
    }    
    
}
