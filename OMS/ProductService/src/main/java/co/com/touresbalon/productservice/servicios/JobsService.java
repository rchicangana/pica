/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.servicios;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.logica.JobsLogica;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("jobs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JobsService {
    
    @EJB
    private JobsLogica jobsLogica;
    
    
    @GET
    @Path("topFive")
    public MensajeDTO generarTopFive(){
        MensajeDTO salida = new MensajeDTO();
        try {
            jobsLogica.crearTop();
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
        } catch (Exception e) {
            Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, "Error al calcular top five", e);
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
                    
        }
        return salida;
    } 
    
}
