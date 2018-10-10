/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.ImagenProductoDAO;
import co.com.touresbalon.productservice.dao.ProductoDAO;
import co.com.touresbalon.productservice.dto.ImagenProductoDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.ImagenProducto;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import java.util.UUID;
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
    
    
    public List<ImagenProductoDTO> finaAllProducto(Long idProducto){
        return TransformacionDozer.transformar(imagenProductoDAO.findAll(idProducto), ImagenProductoDTO.class);
    }
    
 
    public MensajeDTO guardar(ImagenProductoDTO entrada){
        
        MensajeDTO salida = new MensajeDTO();
        try {
            String nombreImagen = UUID.randomUUID().toString()+"jpg";
            ImagenProducto imagen = new ImagenProducto();
            imagen.setEsprincipal(entrada.getEsprincipal());
            imagen.setIdProducto(entrada.getIdProducto());
            imagen.setImagen(nombreImagen);
            imagenProductoDAO.guardar(imagen);
            //guardamos la Imagen
            fileManagerLogica.guardarArchivo(entrada.getImagen(), nombreImagen);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(imagen, ImagenProductoDTO.class));
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }
    
    public MensajeDTO eliminar(ImagenProductoDTO entrada){
        
        MensajeDTO salida = new MensajeDTO();
        try {
            
            ImagenProducto imagen = imagenProductoDAO.findByID(entrada.getIdImagenProducto());
            //guardamos la Imagen
            fileManagerLogica.borrarArchivo(entrada.getImagen());
            imagenProductoDAO.eliminar(imagen);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        return salida;
        
    }
    
    
    
}
