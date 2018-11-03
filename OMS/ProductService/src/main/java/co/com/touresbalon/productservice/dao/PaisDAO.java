/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;


import co.com.touresbalon.productservice.entidades.Pais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class PaisDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     * 
     * @return 
     */
    public List<Pais> findAll(){
        return em.createNamedQuery("Pais.findAll")
                .getResultList();
    }
    
    /**
     * 
     * @param idPais
     * @return 
     */
    public Pais findByid(Long idPais){
        return em.find(Pais.class, idPais);
    }
    
    /**
     * 
     * @param entidad
     * @return 
     */
    public Pais guardar(Pais entidad){
       em.persist(entidad);
       return entidad;
    }
    
    /**
     * 
     * @param entidad 
     */
    public void editar(Pais entidad){
       em.merge(entidad);
    }
    
}
