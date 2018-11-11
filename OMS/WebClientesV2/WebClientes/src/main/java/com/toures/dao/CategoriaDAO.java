/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dao;

import com.toures.entidades.Categoria;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpabl
 */
@Stateless
public class CategoriaDAO {
    
   
    @PersistenceContext
    private EntityManager em;
    
    public void crearCategoria(Categoria categoria){
            em.persist(categoria);         
    }
    
    public void actualizarCategoria(Categoria categoria){
        try{
            em.merge(categoria);
        }catch(Exception e){
            System.out.println("Error Actualizando categoria ");
            e.printStackTrace();
        }
    }
    
    public Categoria ConsultarCategoriaPorID(int id){
        try{
            return(Categoria)em.createNamedQuery("Categoria.findByIdCategoria")
                    .setParameter("idCategoria", id)
                    .getSingleResult();
        }catch(NoResultException nre){
            
        }
        return null;        
    }
    
    public Categoria ConsultarCategoriasPorNombre(String nombre){
        try{
            return(Categoria)em.createNamedQuery("Categoria.findByNombre")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        }catch(NoResultException nre){
            
        }
        return null;        
    }
    
    public List<Categoria> ListarCategorias(){
        try{
        return(List<Categoria>)em.createNamedQuery("Categoria.findAll")
                .getResultList();
        }catch(NoResultException nre){
            
        }
        return null;          
    }
    
    public List<Categoria> ListarCategoriasActivas(){
        try{
        return(List<Categoria>)em.createNamedQuery("Categoria.findActivas")
                .getResultList();
        }catch(NoResultException nre){
            
        }
        return null;  
    }

    public void EliminarCategoria(Categoria categoria){
        em.remove(categoria);   
    }      
 
    
}
