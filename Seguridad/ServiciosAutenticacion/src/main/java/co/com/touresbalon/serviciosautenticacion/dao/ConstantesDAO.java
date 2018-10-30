/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.dao;

import co.com.touresbalon.serviciosautenticacion.entities.Constantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */

@Stateless
public class ConstantesDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * 
     * @param codigo
     * @return 
     */
    public Constantes findByCodigo(String codigo){
        return em.find(Constantes.class, codigo);
    }
    
}
