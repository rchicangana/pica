/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.interfazcontable.services;

import co.com.touresbalon.interfazcontable.logica.InterfazContableLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("Interfaz")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InterfazServices {
    
    @EJB
    private InterfazContableLogica interfazContableLogica;
    
    @GET
    @Path("generar/{fecha}")
    public String generar(@PathParam("fecha") String fecha){
        interfazContableLogica.generarInterfaz(fecha);
        return "OK";
    }
    
}
