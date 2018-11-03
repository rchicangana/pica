/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Empresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchic
 */
@Stateless
public class EmpresaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public List<Empresa> findAll() {
        return em.createNamedQuery("Empresa.findAll")
                .getResultList();
    }

    public Empresa findById(String id) {
        return em.find(Empresa.class, id);
    }

    public Empresa guardar(Empresa entidad) {
        em.persist(entidad);
        return entidad;
    }

    public void actualizar(Empresa entidad) {
        em.merge(entidad);
    }

    public void eliminar(Empresa entidad) {
        em.remove(entidad);
    }
    
}
