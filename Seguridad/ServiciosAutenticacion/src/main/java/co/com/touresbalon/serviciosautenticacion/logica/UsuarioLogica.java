/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.logica;

import co.com.touresbalon.serviciosautenticacion.comun.ConstantesComunes;
import co.com.touresbalon.serviciosautenticacion.dao.UsuarioDAO;
import co.com.touresbalon.serviciosautenticacion.dto.CambiarPasswordDTO;
import co.com.touresbalon.serviciosautenticacion.dto.LoginDTO;
import co.com.touresbalon.serviciosautenticacion.dto.MensajeDTO;
import co.com.touresbalon.serviciosautenticacion.dto.UsuarioDTO;
import co.com.touresbalon.serviciosautenticacion.entities.EstadoUser;
import co.com.touresbalon.serviciosautenticacion.entities.Usuario;
import co.com.touresbalon.serviciosautenticacion.utils.TransformacionDozer;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class UsuarioLogica {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private LdapLogica ldapLogica;
    
    
    
    public MensajeDTO registrarUsuario(UsuarioDTO entrada){
        
        MensajeDTO salida = new MensajeDTO();
        //verificamos si el usuario a crear ya existe
        Usuario usuario = usuarioDAO.findByLogin(entrada.getLogin());
        if(usuario!=null){
            salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
            salida.setMensaje(ConstantesComunes.CODIGO_ERROR_USUARIO_EXISTE);
        } else {
            try {
                usuario = TransformacionDozer.transformar(entrada, Usuario.class);
                usuarioDAO.insert(usuario);
                //creamos el usuario en ldap
                if(ldapLogica.guardarUsuarioLdap(entrada)){
                    salida.setCodigo(ConstantesComunes.Resultado.OK.name());
                } else {
                    throw  new RuntimeException("Error al Crear usuario en ldap");
                } 
                
            } catch (Exception e) {
                salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
                salida.setMensaje(e.getLocalizedMessage());
            }
            
        }
        
        return salida;
        
    }
    
    public MensajeDTO actualizarUsuario(UsuarioDTO entrada){
        
        MensajeDTO salida = new MensajeDTO();
        //verificamos si el usuario a crear ya existe
        Usuario usuario = usuarioDAO.findByLogin(entrada.getLogin());
        if(usuario==null){
            salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
            salida.setMensaje(ConstantesComunes.CODIGO_ERROR_USUARIO_NO_EXISTE);
        } else {
            try {
                usuario.setEmail(entrada.getEmail());
                usuario.setIdEstadoUser(TransformacionDozer.transformar(entrada.getIdEstadoUser(), EstadoUser.class));
                usuario.setNombre(entrada.getNombre());
                usuarioDAO.update(usuario);
                //creamos el usuario en ldap
                salida.setCodigo(ConstantesComunes.Resultado.OK.name());
                
            } catch (Exception e) {
                salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
                salida.setMensaje(e.getLocalizedMessage());
            }
            
        }
        
        return salida;
        
    }
    
    public MensajeDTO actualizarClaveUsuario(CambiarPasswordDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            LoginDTO login = new LoginDTO();
            login.setLogin(entrada.getLogin());
            login.setPassword(entrada.getPasswordAnterior());
            if(ldapLogica.autenticarUsuarioLdap(login)){
                ldapLogica.actualizarPasswordUsuarioLDAP(entrada);
                salida.setCodigo(ConstantesComunes.Resultado.OK.name());
            }
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
