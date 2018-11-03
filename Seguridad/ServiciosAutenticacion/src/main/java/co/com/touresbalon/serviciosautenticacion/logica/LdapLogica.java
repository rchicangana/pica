/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.logica;

import co.com.touresbalon.serviciosautenticacion.comun.ConstantesComunes;
import co.com.touresbalon.serviciosautenticacion.dao.ConstantesDAO;
import co.com.touresbalon.serviciosautenticacion.dto.CambiarPasswordDTO;
import co.com.touresbalon.serviciosautenticacion.dto.LoginDTO;
import co.com.touresbalon.serviciosautenticacion.dto.UsuarioDTO;
import co.com.touresbalon.serviciosautenticacion.entities.Constantes;
import co.com.touresbalon.serviciosautenticacion.utils.LdapUtils;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sun.misc.BASE64Encoder;

/**
 *
 * @author rchic
 */
@Stateless
public class LdapLogica {

    private static final Logger LOGGER = Logger.getLogger(LdapLogica.class.getSimpleName());

    @EJB
    private ConstantesDAO constantesDAO;

    public boolean guardarUsuarioLdap(UsuarioDTO usuario) {
        Constantes server = constantesDAO.findByCodigo(ConstantesComunes.URL_SERVIDOR_LDAP);
        Constantes arbolAdmin = constantesDAO.findByCodigo(ConstantesComunes.ARBOL_ADMIN_LDAP);
        Constantes dn = constantesDAO.findByCodigo(ConstantesComunes.ARBOL_LDAP);
        Constantes password = constantesDAO.findByCodigo(ConstantesComunes.PASSWORD_LDAP);

        LdapUtils ldapAuth = new LdapUtils(server.getValor(), arbolAdmin.getValor(), ConstantesComunes.TIPO_AUTENTICACION_LDAP, password.getValor());
        try {
            if (ldapAuth.isAutenticado()) {

                ldapAuth.insertarNuevoUsuario(
                        "uid=" + usuario.getLogin() + "," + dn.getValor(),
                        usuario.getNombre(), usuario.getLogin(),
                        usuario.getEmail());
                CambiarPasswordDTO cpsswd = new CambiarPasswordDTO();
                cpsswd.setLogin(usuario.getLogin());
                cpsswd.setNuevoPassword(usuario.getLogin());
                actualizarPasswordUsuarioLDAP(cpsswd);
                return true;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al guardar el usuario en el LDAP {0}", e);
        }
        return false;
    }

    public boolean actualizarPasswordUsuarioLDAP(CambiarPasswordDTO usuario) {
        Constantes server = constantesDAO.findByCodigo(ConstantesComunes.URL_SERVIDOR_LDAP);
        Constantes arbolAdmin = constantesDAO.findByCodigo(ConstantesComunes.ARBOL_ADMIN_LDAP);
        Constantes dn = constantesDAO.findByCodigo(ConstantesComunes.ARBOL_LDAP);
        Constantes password = constantesDAO.findByCodigo(ConstantesComunes.PASSWORD_LDAP);

        LdapUtils ldapAuth = new LdapUtils(server.getValor(), arbolAdmin.getValor(), ConstantesComunes.TIPO_AUTENTICACION_LDAP, password.getValor());

        try {
            if (ldapAuth.isAutenticado()) {

                ldapAuth.modificarPassword(
                        "uid=" + usuario.getLogin() + "," + dn.getValor(),
                        encriptarPassword(usuario.getNuevoPassword()));

                return true;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el password el usuario en LDAP {0}", e);
        }
        return false;
    }

    public boolean autenticarUsuarioLdap(LoginDTO login) {
        try {
            Constantes server = constantesDAO.findByCodigo(ConstantesComunes.URL_SERVIDOR_LDAP);
            Constantes dn = constantesDAO.findByCodigo(ConstantesComunes.ARBOL_LDAP);

            LdapUtils ldapAuth = new LdapUtils(server.getValor(),
                    "uid=" + login.getLogin() + "," + dn.getValor(),
                    ConstantesComunes.TIPO_AUTENTICACION_LDAP, login.getPassword());
            // validar si es autenticado
            return ldapAuth.isAutenticado();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al autenticar usuario ", e);
        }
        return false;

    }

    /**
     * La constante LOGGER.
     */
    /**
     * Encriptar password.
     *
     * @param password el password
     * @return retorna string
     */
    @SuppressWarnings("restriction")
    public static String encriptarPassword(final String password) {
        String passwordEncriptado = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(password.getBytes());
            byte raw[] = md.digest();

            BASE64Encoder base64 = new BASE64Encoder();
            passwordEncriptado = "{SHA}" + base64.encode(raw);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error encriptando password {0}", e);
        }

        return passwordEncriptado;
    }

}
