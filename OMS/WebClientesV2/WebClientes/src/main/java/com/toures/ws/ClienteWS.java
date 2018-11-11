/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.ws;

import com.toures.dto.ClienteDTO;
import com.toures.dto.RespuestaRs;
import com.toures.negocio.TxClientes;
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
@Path("ClientesTx")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteWS {
    
    @EJB
    private TxClientes tx;
    
    @POST
    @Path("Crear")
    public RespuestaRs CrearCliente(ClienteDTO cliente){
        return tx.CrearCliente(cliente);
    }
    
    @POST
    @Path("Actualizar")
    public RespuestaRs ActualizarCliente(ClienteDTO cliente){
        return tx.ActualizarCliente(cliente);
    }
    
    @GET
    @Path("Consultar/{tipoid}/{noid}")
    public ClienteDTO ConsultarCliente(@PathParam("tipoid") String tipoId,@PathParam("noid") String NoId){
        return tx.ConsultarCliente(tipoId, NoId);
    }
    
    @GET
    @Path("ConsultarID/{id}")
    public ClienteDTO ConsultarCliente(@PathParam("id") int id){
        return tx.ConsultarCliente(id);
    }   
    
}
