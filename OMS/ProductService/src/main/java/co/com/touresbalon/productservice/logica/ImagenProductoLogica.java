/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.dao.ImagenProductoDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchicangana
 */
@Stateless
public class ImagenProductoLogica {
    
    @EJB
    private ImagenProductoDAO imagenProductoDAO;
    
    @EJB
    private ProductoDAO productoDAO;
    
    @EJB
    private FileManagerLogica fileManagerLogica;
    
    
    
    
    
    
    
}
