/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.serviciosautenticacion.dao;

import co.com.touresbalon.serviciosautenticacion.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class UsuarioDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     * 
     * @return 
     */
    public List<Usuario> findAll(){
        return em.createNamedQuery("Usuario.findAll")
                .getResultList();
    }
    
    /**
     * 
     * @param login
     * @return 
     */
    public Usuario findByLogin(String login){
        try {
            return (Usuario)em.createNamedQuery("Usuario.findByLogin")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    /**
     * 
     * @param entidad
     * @return 
     */
    public Usuario insert(Usuario entidad){
        em.persist(entidad);
        return entidad;
    }
    /**
     * 
     * @param entidad 
     */
    public void update(Usuario entidad){
        em.merge(entidad);
    }
    /**
     * 
     * @param entidad 
     */
    public void delete(Usuario entidad){
        em.remove(entidad);
    }
    
}
