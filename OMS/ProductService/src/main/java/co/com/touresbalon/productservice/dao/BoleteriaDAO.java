/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Boleteria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class BoleteriaDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Boleteria findByProducto(Long producto) {
        try {
            return (Boleteria) em.createNamedQuery("Boleteria.findByProductoId")
                    .setParameter("productoId", producto)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            return new Boleteria();
        }
        
    }
    
    public Boleteria findById(String id) {
        return em.find(Boleteria.class, id);
    }
    
    public Boleteria guardar(Boleteria entidad) {
        em.persist(entidad);
        return entidad;
    }
    
    public void actualizar(Boleteria entidad) {
        em.merge(entidad);
    }
    
    public void eliminar(Boleteria entidad) {
        em.remove(entidad);
    }
    
}
