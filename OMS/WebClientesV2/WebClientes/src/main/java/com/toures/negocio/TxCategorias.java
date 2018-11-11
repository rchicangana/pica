/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.negocio;

import com.toures.dto.CategoriaDTO;
import com.toures.dto.RespuestaRs;
import com.toures.dao.CategoriaDAO;
import com.toures.entidades.Categoria;
import com.toures.util.FechasUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jpabl
 */
@Stateless
public class TxCategorias {
    
    @EJB
    private CategoriaDAO cat;
    
    public RespuestaRs crearCategoria(CategoriaDTO categoria ){
        Categoria existe = cat.ConsultarCategoriasPorNombre(categoria.getNombre().toUpperCase());
        if ( existe != null)
            return new RespuestaRs("Error","Ya existe una categoria con ese nombre"); 
        else{        
            Date now = new Date();
            Categoria obj = new Categoria(categoria.getNombre().toUpperCase(), 
                                          categoria.getEstado(), 
                                          now, 
                                          now);
            cat.crearCategoria(obj);
            return new RespuestaRs ("ok","Categoria creada exitosamente");
        }
    }
    
    public CategoriaDTO consultarCategoria (String nombre){
        Categoria obj = cat.ConsultarCategoriasPorNombre(nombre);
        return new CategoriaDTO(obj.getIdCategoria(), 
                                obj.getNombre().toUpperCase(), 
                                obj.getEstado(), 
                                FechasUtil.dateToString(obj.getFechaCreacion()), 
                                FechasUtil.dateToString(obj.getFechaUltModificacion()));
    }
    
    public CategoriaDTO consultarCategoria (int id){
        Categoria obj = cat.ConsultarCategoriaPorID(id);
        return new CategoriaDTO(obj.getIdCategoria(), 
                                obj.getNombre(), 
                                obj.getEstado(), 
                                FechasUtil.dateToString(obj.getFechaCreacion()), 
                                FechasUtil.dateToString(obj.getFechaUltModificacion()));
    }
    
    public List<CategoriaDTO> listarCategorias (){
        List<Categoria> lista = cat.ListarCategorias();
        List<CategoriaDTO> objs = new ArrayList();
        for(Categoria obj: lista){
            objs.add(new CategoriaDTO(obj.getIdCategoria(), 
                                obj.getNombre(), 
                                obj.getEstado(), 
                                FechasUtil.dateToString(obj.getFechaCreacion()), 
                                FechasUtil.dateToString(obj.getFechaUltModificacion()))
            );
        }
        
        return objs;
    }

    public List<CategoriaDTO> listarCategoriasActivas (){
        List<Categoria> lista = cat.ListarCategorias();
        List<CategoriaDTO> objs = new ArrayList();
        for(Categoria obj: lista){
            objs.add(new CategoriaDTO(obj.getIdCategoria(), 
                                obj.getNombre(), 
                                obj.getEstado(), 
                                FechasUtil.dateToString(obj.getFechaCreacion()), 
                                FechasUtil.dateToString(obj.getFechaUltModificacion()))
            );
        }
        
        return objs;
    }    
    
    
    public RespuestaRs actualizarCategoria(CategoriaDTO categoria ){
         Categoria obj = cat.ConsultarCategoriaPorID(categoria.getIdCategoria());
         obj.setNombre(categoria.getNombre()); 
         obj.setEstado(categoria.getEstado());
         obj.setFechaCreacion(FechasUtil.convertStringToDate(categoria.getFechaCreacion())); 
         obj.setFechaUltModificacion(new Date());
        cat.actualizarCategoria(obj);
        return new RespuestaRs ("ok","Categoria Actualizada exitosamente");
    }
    
    public RespuestaRs eliminarCategoria(CategoriaDTO categoria ){
         Categoria obj = cat.ConsultarCategoriaPorID(categoria.getIdCategoria());
         obj.setNombre(categoria.getNombre()); 
         obj.setEstado(categoria.getEstado());
         obj.setFechaCreacion(FechasUtil.convertStringToDate(categoria.getFechaCreacion())); 
         obj.setFechaUltModificacion(new Date());
        cat.EliminarCategoria(obj);
        return new RespuestaRs ("ok","Categoria Eliminada exitosamente");
    }
}
