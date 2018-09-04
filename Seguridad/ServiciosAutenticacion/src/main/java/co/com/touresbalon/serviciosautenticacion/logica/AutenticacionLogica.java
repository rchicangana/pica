/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.logica;

import co.com.touresbalon.jwtgenerator.cliente.ClienteJWT;
import co.com.touresbalon.jwtgenerator.dto.TokenJwtDTO;
import co.com.touresbalon.jwtgenerator.exception.ErrorJWTException;
import co.com.touresbalon.jwtgenerator.impl.ClienteJWTBuilder;
import co.com.touresbalon.serviciosautenticacion.comun.ConstantesComunes;
import co.com.touresbalon.serviciosautenticacion.dao.ConstantesDAO;
import co.com.touresbalon.serviciosautenticacion.dao.UsuarioDAO;
import co.com.touresbalon.serviciosautenticacion.dto.LoginDTO;
import co.com.touresbalon.serviciosautenticacion.dto.LoginOutDTO;
import co.com.touresbalon.serviciosautenticacion.dto.MensajeDTO;
import co.com.touresbalon.serviciosautenticacion.dto.UsuarioDTO;
import co.com.touresbalon.serviciosautenticacion.entities.Constantes;
import co.com.touresbalon.serviciosautenticacion.entities.EstadoUser;
import co.com.touresbalon.serviciosautenticacion.entities.Usuario;
import co.com.touresbalon.serviciosautenticacion.utils.LdapUtils;
import co.com.touresbalon.serviciosautenticacion.utils.TransformacionDozer;
import java.util.Date;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class AutenticacionLogica {

    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private LdapLogica ldapLogica;

    @EJB
    private ConstantesDAO constantesDAO;

    public MensajeDTO autenticarUsuario(LoginDTO entrada) {
        MensajeDTO salida = new MensajeDTO();
        //verificamos que el usuario exista
        Usuario usuario = usuarioDAO.findByLogin(entrada.getLogin());
        if (usuario == null) {
            salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
            salida.setMensaje(ConstantesComunes.CODIGO_ERROR_LOGIN);
        } else {
            //como el usuario ya existe verificamos en el ldap
            if (usuario.getIdEstadoUser().getIdEstadoUser().compareTo(ConstantesComunes.ESTADO_ACTIVO) == 0) {
                if (ldapLogica.autenticarUsuarioLdap(entrada)) {
                    salida.setCodigo(ConstantesComunes.Resultado.OK.name());
                    //generamos el token
                    Constantes constanteKey = constantesDAO.findByCodigo(ConstantesComunes.CONSTANTE_LLAVE_SIMETRICA_TOKEN);
                    Constantes expiration = constantesDAO.findByCodigo(ConstantesComunes.CONSTANTE_EXPIRATION_TOKEN);
                    try {
                        TokenJwtDTO token = new TokenJwtDTO();
                        token.setId(UUID.randomUUID().toString());
                        token.setSubject(entrada.getLogin());
                        token.setIssuer(usuario.getIdUsuario().toString());
                        token.setIssuedAt(new Date());
                        token.setExpiration(Long.valueOf(expiration.getValor()));
                        token.setIp(usuario.getIdUsuario().toString());
                        token.setNotBefore(new Date());
                        ClienteJWT clienteJwt = new ClienteJWTBuilder().setLlaveSimetrica(constanteKey.getValor()).setToken(token).build();
                        LoginOutDTO loginOutDTO = new LoginOutDTO();
                        loginOutDTO.setTokenJwt(clienteJwt.generarToken());
                        loginOutDTO.setUsuario(TransformacionDozer.transformar(usuario, UsuarioDTO.class));
                        salida.setObject(loginOutDTO);
                    } catch (ErrorJWTException | NumberFormatException e) {
                        salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
                        salida.setMensaje("Error al generar token jwt "+e.getLocalizedMessage());

                    }

                } else {
                    salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
                    salida.setMensaje(ConstantesComunes.CODIGO_ERROR_LOGIN);
                }
            } else {
                salida.setCodigo(ConstantesComunes.Resultado.ERROR.name());
                salida.setMensaje(ConstantesComunes.CODIGO_ERROR_LOGIN);
            }
        }
        return salida;
    }

}
