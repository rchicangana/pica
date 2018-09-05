/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.servicios;

import co.com.touresbalon.serviciosautenticacion.dto.LoginDTO;
import co.com.touresbalon.serviciosautenticacion.dto.MensajeDTO;
import co.com.touresbalon.serviciosautenticacion.dto.ValidarTokenDTO;
import co.com.touresbalon.serviciosautenticacion.logica.AutenticacionLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("autenticacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutenticacionServicio {
    
    @EJB
    private AutenticacionLogica autenticacionLogica;
    
    @POST
    public MensajeDTO login(LoginDTO entrada){
        return autenticacionLogica.autenticarUsuario(entrada);
    }
    
    @POST
    @Path("validar")
    public MensajeDTO validarToken(ValidarTokenDTO entrada){
        return autenticacionLogica.validarToken(entrada);
    }
    
    
}
