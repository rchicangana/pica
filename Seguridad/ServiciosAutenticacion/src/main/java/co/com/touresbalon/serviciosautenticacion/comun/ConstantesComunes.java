/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.comun;

/**
 *
 * @author rchic
 */
public class ConstantesComunes {
    
    public enum Resultado {
        OK,
        ERROR
    }
    
   public static final Long ESTADO_ACTIVO = 1L;
    
    /**
     * Usuario ya existe
     */
    public static final String CODIGO_ERROR_USUARIO_EXISTE="El usuario que intenta crear ya existe";
    public static final String CODIGO_ERROR_USUARIO_NO_EXISTE="El usuario que intenta actualizar no existe";
    public static final String CODIGO_ERROR_LOGIN="El usuario o contraseña no validas";
    public static final String CODIGO_ERROR_LOGIN_INACTIVO="El usuario se eneucntra inactivo o bloqueado";
    
    
    //Constantes LDAP
    public static final String URL_SERVIDOR_LDAP = "URL_SERVIDOR_LDAP";
    public static final String ARBOL_ADMIN_LDAP = "ARBOL_ADMIN_LDAP";
    public static final String ARBOL_LDAP = "ARBOL_LDAP";
    public static final String PASSWORD_LDAP = "PASSWORD_LDAP";
    public static final String TIPO_AUTENTICACION_LDAP = "simple";
    
    public static final String CONSTANTE_EXPIRATION_TOKEN = "CONSTANTE_EXPIRATION_TOKEN";
    public static final String CONSTANTE_LLAVE_SIMETRICA_TOKEN = "CONSTANTE_LLAVE_SIMETRICA_TOKEN";
    
}
