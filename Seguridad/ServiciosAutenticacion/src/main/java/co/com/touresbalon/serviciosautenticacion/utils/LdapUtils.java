/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author daperador
 * @author ccepeda
 */
public class LdapUtils {

    private static final Logger LOG = Logger.getLogger(LdapUtils.class.getName());
    private static final String FORMATO_FECHA_OID = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String LDAP_SEARCHE_BASE = "cn=People,dc=touresbalon,dc=local";

    private String clave;
    private String servidor;
    private String dn;
    private String tipoAuth;
    private boolean autenticado;

    private DirContext dc;

    /**
     * Constructor de la conexion con el Motor de LDAP
     *
     * @param server Servidor en donde se encuentra el LDAP
     * @param dn Directoria del arbol del LDAP
     * @param ta Tipo de Autenticacion
     * @param clave Clave del usuario
     *
     */
    public LdapUtils(String server, String dn, String ta, String clave) {
        this.servidor = server;
        this.dn = dn;
        this.tipoAuth = ta;
        this.clave = clave;
        inicializarConexion();
    }

    public final void inicializarConexion() {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, servidor);
        env.put(Context.SECURITY_AUTHENTICATION, tipoAuth);
        env.put(Context.SECURITY_PRINCIPAL, dn);
        env.put(Context.SECURITY_CREDENTIALS, clave);

        try {
            LOG.log(Level.INFO, "inicializarConexion: servidor [{0}], tipoAuth [{1}], dn [{2}], clave[{3}] ", new Object[]{servidor, tipoAuth, dn, clave});
            dc = new InitialDirContext(env);
            setAutenticado(true);
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, "NamingException: ERROR, cause [{0}], message [{1}]", new Object[]{ex.getCause(), ex.getLocalizedMessage()});
            setAutenticado(false);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception: ERROR, cause [{0}], message [{1}]", new Object[]{ex.getCause(), ex.getLocalizedMessage()});
            setAutenticado(false);
        }
    }

    /**
     * Inserta un nuevo usuario en el oid
     *
     * @param entryDN Directoria del arbol del LDAP
     * @param sn apellidos del usuario
     * @param cn nombres del usuario
     * @param mail correo del usuario
     */
    public void insertarNuevoUsuario(
            String entryDN,
            String sn,
            String cn,
            String mail) {
        LOG.log(Level.INFO, "insertarNuevoUsuario: cn [{0}], sn [{1}]", new Object[]{cn, sn});
        Attribute cnAtt = new BasicAttribute("cn", cn);
        Attribute snAtt = new BasicAttribute("sn", sn);
        Attribute mailAtt = new BasicAttribute("mail", mail);
        Attribute password = new BasicAttribute("userpassword", "Abcd1234");
        Attribute oc = new BasicAttribute("objectClass");
        oc.add("top");
        oc.add("person");
        oc.add("organizationalPerson");
        oc.add("inetOrgPerson");

        try {
            BasicAttributes entry = new BasicAttributes();
            entry.put(cnAtt);
            entry.put(snAtt);
            entry.put(mailAtt);
            entry.put(oc);
            entry.put(password);
            dc.createSubcontext(entryDN, entry);
            LOG.log(Level.INFO, "LdapUtils: Cración de usuario exitosa");
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, "NamingException: ERROR, cause [{0}], message [{1}]", new Object[]{ex.getCause(), ex.getLocalizedMessage()});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception: ERROR, cause [{0}], message [{1}]", new Object[]{ex.getCause(), ex.getLocalizedMessage()});
        }
    }

    /**
     * Inserta un nuevo usuario en el oid
     *
     * @param entryDN Directoria del arbol del LDAP
     * @param userPassword password a modificar
     */
    public void modificarPassword(
            String entryDN,
            String userPassword) {
        try {
            LOG.log(Level.INFO, "LdapUtils: entro a ->> modificarPassword <<-");
            // build the entry  
            ModificationItem[] mods = new ModificationItem[1];
            Attribute mod0 = new BasicAttribute("userpassword", userPassword);
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            dc.modifyAttributes(entryDN, mods);
        } catch (NamingException e) {
            LOG.log(Level.INFO, "LdapUtils: Update Password: error actualizando password {0}", e);
        }
    }

    /**
     * Modifica la hora de ingreso
     *
     * @param entryDN Directoria del arbol del LDAP
     */
    public void modificarHoraIngreso(
            String entryDN) {
        try {
            LOG.log(Level.INFO, "LdapUtils: entro a ->> modificarHoraIngreso <<-");
            // build the entry  
            ModificationItem[] mods = new ModificationItem[2];
            Calendar c = Calendar.getInstance();
            long tiempo = c.getTimeInMillis() / 1000;

            Attribute mod0 = new BasicAttribute("oblastsuccessfullogin", "" + tiempo);

            SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA_OID);
            Attribute mod1 = new BasicAttribute("oblastloginattemptdate", sdf.format(c.getTime()));
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
            dc.modifyAttributes(entryDN, mods);
        } catch (NamingException e) {
            LOG.log(Level.INFO, "LdapUtils: Update Hora Ingreso: error actualizando hora ingreso y tiempos {0}", e);
        }
    }

    /**
     * Modifica la hora de ingreso
     *
     * @param entryDN Directoria del arbol del LDAP
     */
    public void modificarHoraFallaIngreso(
            String entryDN) {
        try {
            LOG.log(Level.INFO, "LdapUtils: entro a ->> modificarHoraFallaIngreso <<-");
            // build the entry  
            ModificationItem[] mods = new ModificationItem[2];
            Calendar c = Calendar.getInstance();
            long tiempo = c.getTimeInMillis() / 1000;

            Attribute mod0 = new BasicAttribute("oblastfailedlogin", "" + tiempo);

            SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA_OID);
            Attribute mod1 = new BasicAttribute("oblastloginattemptdate", sdf.format(c.getTime()));
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
            dc.modifyAttributes(entryDN, mods);
        } catch (NamingException e) {
            LOG.log(Level.INFO, "LdapUtils: Update Hora Ingreso: error actualizando hora ingreso y tiempos {0}", e);
        }
    }

    /**
     * Modifica la informaci&oacute;n del usuario
     *
     * @param entryDN Directoria del arbol del LDAP
     * @param sn apellidos del usuario
     * @param cn nombres del usuario
     * @param mail correo del usuario
     */
    public void modificarUsuario(
            String entryDN,
            String sn,
            String cn,
            String mail) {
        try {
            // build the entry  
            ModificationItem[] mods = new ModificationItem[3];
            Attribute mod0 = new BasicAttribute("cn", cn);
            Attribute mod1 = new BasicAttribute("sn", sn);
            Attribute mod2 = new BasicAttribute("mail", mail);
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
            mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod2);
            dc.modifyAttributes(entryDN, mods);
        } catch (NamingException e) {
            LOG.log(Level.INFO, "LdapUtils: Update Password: error actualizando password {0}", e);
        }
    }

    /**
     * Retorna el Atributo de la conexion con LDAP actual
     *
     * @param atributo Nombre del Atributo que se desea obtener
     * @return Attribute con la informacion correspondiente
     */
    public Attribute cargarPropiedadConexion(String atributo) {
        Attribute propiedad = null;

        try {
            Attributes attrs = dc.getAttributes(dn);
            System.out.println("Hola");
            if (attrs == null) {
                propiedad = null;
            } else {
                propiedad = attrs.get(atributo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            propiedad = null;
        }
        return propiedad;
    }

    /*Get's y Set's*/
    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getDn() {
        return dn;
    }

    public void closeConnectionToLDAP() {
        try {
            dc.close();
        } catch (NamingException e) {
            //no requiere accion
        }
    }

    
    /**
     * Funcion que permite consultar el listado de usuarios que pertenecen a una entidad
     * @param entidad Identificador 
     * @return Listado de usuarios
     */
    public List<String> listarUsuariosEntidad(String entidad) {
        List<String> listaUsuarios = new ArrayList<>();
        try {
            String searchFilter = "(&(objectClass=person)(o=" + entidad + "))";
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            searchControls.setReturningAttributes(null);
            NamingEnumeration<SearchResult> results = dc.search(LDAP_SEARCHE_BASE, searchFilter, searchControls);
            SearchResult searchResult;
            while (results.hasMoreElements()) {
                searchResult = (SearchResult) results.nextElement();
                listaUsuarios.add(searchResult.getName().substring(4));
            }
        } catch (CommunicationException ex) {
            LOG.log(Level.SEVERE, ">>>> Error {0}", ex);
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, ">>>> Error {0}", ex);
        }
        return listaUsuarios;
    }
    
    /**
     * Modifica la informaci&oacute;n del usuario
     *
     * @param entryDN Directoria del arbol del LDAP
     * @param sn apellidos del usuario
     * @param cn nombres del usuario
     * @param direccion
     * @param telefono
     * @param genero
     * @param fechaNacimiento
     * @param emails correos del usuario
     */
    public boolean modificarUsuario(
            String entryDN,
            String sn,
            String cn,
            String direccion,
            String telefono,
            String genero,
            String fechaNacimiento,
            List<String> emails) {
        try {
            Attributes attrs= new BasicAttributes();
            Attribute attr= new BasicAttribute("mail");
            attrs.put(attr);
            dc.modifyAttributes (entryDN, DirContext.REMOVE_ATTRIBUTE, attrs);
        } catch (NamingException e) {
        }
        try {
            // build the entry  
            ModificationItem[] mods = new ModificationItem[7 + emails.size()];
            Attribute mod0 = new BasicAttribute("cn", cn + " " + sn);
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            Attribute mod1 = new BasicAttribute("givenname", cn);
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
            Attribute mod2 = new BasicAttribute("sn", sn);
            mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod2);
            Attribute mod3 = new BasicAttribute("postaladdress", direccion);
            mods[3] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod3);
            Attribute mod4 = new BasicAttribute("telephonenumber", telefono);
            mods[4] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod4);
            Attribute mod5 = new BasicAttribute("initials", genero);
            mods[5] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod5);
            Attribute mod6 = new BasicAttribute("l", fechaNacimiento);
            mods[6] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod6);
            
            int contador = 7;
            for(String email:emails){
                Attribute mod = new BasicAttribute("mail", email);
                mods[contador] = new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
                contador++;
            }
            
            dc.modifyAttributes(entryDN, mods);
            return true;
        } catch (NamingException e) {
            LOG.log(Level.INFO, "LdapUtils: Update User: error actualizando usuario {0}", e);
        }
        return false;
    }
}
