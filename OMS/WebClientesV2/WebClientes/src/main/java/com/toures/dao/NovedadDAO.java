/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.dao;

import com.toures.entidades.Novedad;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author jpabl
 */
@Stateless
public class NovedadDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void crearNovedad(Novedad novedad){
        try{
            em.persist(novedad);
        }catch(Exception e){
            System.out.println("Error Creando novedad ");
            e.printStackTrace();
        }
            
    }
    
    public void actualizarNovedad(Novedad novedad){
        try{
            em.merge(novedad);
        }catch(Exception e){
            System.out.println("Error Actualizando novedad ");
            e.printStackTrace();
        }
    }
    
    public Novedad ConsultarNovedadPorID(int id){
        try{
        return(Novedad)em.createNamedQuery("Novedad.findByIdNovedad")
                .setParameter("idNovedad", id)
                .getSingleResult();
                }catch(NoResultException nre){
            
        }
        return null;
    }
    
    public List<Novedad> ConsultarNovedadesPorFecha(Date fechaIni,Date fechaFin ){
        try{
        return(List<Novedad>)em.createNamedQuery("Novedad.findByFechaNovedad")
                .setParameter("fechaIni", fechaIni)
                .setParameter("fechaFin", fechaFin)
              //  .setFirstResult(ini)
             //   .setMaxResults(cant)
                .getResultList();
        }catch(NoResultException nre){
            
        }
        return null;
    }

    public List<Novedad> ConsultarNovedadesPorEntidad(String entidad){
       try{ 
        return(List<Novedad>)em.createNamedQuery("Novedad.findByEntidad")
                .setParameter("entidad", entidad)
             //   .setFirstResult(ini)
             //   .setMaxResults(cant)                
                .getResultList();
                }catch(NoResultException nre){
            
        }
        return null;
    }
    
    public List<Novedad> ConsultarNovedadesPorFiltro(String entidad,Date fechaIni,Date fechaFin){
       try{ 
        return(List<Novedad>)em.createNamedQuery("Novedad.findByFiltro")
                .setParameter("entidad", entidad)
                .setParameter("fechaIni", fechaIni)
                .setParameter("fechaFin", fechaFin)   
            //    .setFirstResult(ini)
            //    .setMaxResults(cant)                
                .getResultList();
                }catch(NoResultException nre){
            
        }
        return null;
    } 
    
}
