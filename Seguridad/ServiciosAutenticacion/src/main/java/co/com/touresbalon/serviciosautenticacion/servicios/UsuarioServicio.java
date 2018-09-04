/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.servicios;

import co.com.touresbalon.serviciosautenticacion.dto.CambiarPasswordDTO;
import co.com.touresbalon.serviciosautenticacion.dto.MensajeDTO;
import co.com.touresbalon.serviciosautenticacion.dto.UsuarioDTO;
import co.com.touresbalon.serviciosautenticacion.logica.UsuarioLogica;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rchic
 */
@Stateless
@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioServicio {
    
    @EJB
    private UsuarioLogica usuarioLogica;
    
    
    @POST
    @Path("registrar")
    public MensajeDTO registrarUsuario(UsuarioDTO entrada){
        return usuarioLogica.registrarUsuario(entrada);
    }
    
    @PUT
    @Path("actualizar")
    public MensajeDTO actualizar(UsuarioDTO entrada){
        return usuarioLogica.actualizarUsuario(entrada);
    }
        
    @PUT
    @Path("cambiarPassword")
    public MensajeDTO cambiarPassword(CambiarPasswordDTO entrada){
        return usuarioLogica.actualizarClaveUsuario(entrada);
    }
    
    
    
    
    
}
