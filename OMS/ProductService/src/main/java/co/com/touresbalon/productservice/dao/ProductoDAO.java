/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.dao;

import co.com.touresbalon.productservice.entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ProductoDAO {

    @PersistenceContext(unitName = "ProductPU")
    private EntityManager em;

    /**
     * 
     * @param codigo
     * @return 
     */
    public Producto findByCodigo(Long codigo) {
        try {
            return (Producto) em.createNamedQuery("Producto.findByIdProducto")
                    .setParameter("idProducto", codigo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * 
     * @param descripcion
     * @param inicio
     * @param fin
     * @return 
     */
    public List<Producto> finByDesProductos(String descripcion, Integer inicio, Integer fin) {
        return em.createNamedQuery("Producto.findByNombreProducto")
                .setParameter("nombreProducto", descripcion)
                .setFirstResult(inicio)
                .setMaxResults(fin)
                .getResultList();
    }
    
    public List<Producto> finByProductos(Integer inicio, Integer fin) {
        return em.createNamedQuery("Producto.findAll")
                .setFirstResult(inicio)
                .setMaxResults(fin)
                .getResultList();
    }
    
    public Long countAll() {
        return (Long)em.createNamedQuery("Producto.countAll")
                .getSingleResult();
    }
    
    public Long countAllComodin(String nombre) {
        return (Long)em.createNamedQuery("Producto.countAllByComodin")
                .setParameter("nombreProducto", nombre)
                .getSingleResult();
    }
    
    /**
     * 
     * @param entidad
     * @return 
     */
    public Producto guardar(Producto entidad){
        em.persist(entidad);
        return entidad;
    }
    
    /**
     * 
     * @param entidad 
     */
    public void actualizar(Producto entidad){
        em.merge(entidad);
        
    }
    
    /**
     * 
     * @param entidad 
     */
    public void borrar(Producto entidad){
        em.remove(entidad);
        
    }

}
