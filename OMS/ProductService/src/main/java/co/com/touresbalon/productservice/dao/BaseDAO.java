/* 
 *  Copyright (c) 2016 - Concesion RUNT S.A, Todos los derechos reservados.
 *  Proyecto: runt-consulta-aseguradora
 *  Servicios de consulta de informacion de automotores
 *  para aseguradoras
 */
package co.com.touresbalon.productservice.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Camilo Alvarez Duran <camilo.alvarez at runt.com.co>
 */
public abstract class BaseDAO {

    private final static String DATSOURCE_JNDI_NAME = "java:/jboss/datasources/picaOMS";

    /**
     *
     * @return
     * @throws NamingException
     * @throws SQLException
     */
    public static Connection getConnection() throws NamingException, SQLException {
        return getDS().getConnection();
    }
    /**
     * 
     * @return
     * @throws NamingException 
     */
    private static DataSource getDS() throws NamingException {
        final InitialContext iContext = new InitialContext();
        return (DataSource) iContext.lookup(DATSOURCE_JNDI_NAME);
    }
}
