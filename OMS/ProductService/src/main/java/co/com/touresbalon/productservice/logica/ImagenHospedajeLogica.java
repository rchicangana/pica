/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.HospedajeDAO;
import co.com.touresbalon.productservice.dao.ImagenHospedajeDAO;
import co.com.touresbalon.productservice.dto.ImagenHospedajeDTO;
import co.com.touresbalon.productservice.dto.MensajeDTO;
import co.com.touresbalon.productservice.entidades.Hospedaje;
import co.com.touresbalon.productservice.entidades.ImagenHospedaje;
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
public class ImagenHospedajeLogica {
    
    @EJB
    private ImagenHospedajeDAO imagenHospedajeDAO;
    
    @EJB
    private HospedajeDAO hospedajeDAO;
    
    @EJB
    private FileManagerLogica fileManagerLogica;
    
    
    
    
    public List<ImagenHospedajeDTO> consultar(Long idHospedaje){
        return TransformacionDozer.transformar(imagenHospedajeDAO.findAllByHospedaje(idHospedaje), ImagenHospedajeDTO.class);
    }
    
    public MensajeDTO guardar(ImagenHospedajeDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            String nombreImagen = UUID.randomUUID().toString()+".jpg";
            ImagenHospedaje imagen = new ImagenHospedaje();
            imagen.setEsprincipal(entrada.getEsprincipal());
            Hospedaje hospedaje = hospedajeDAO.findByID(entrada.getIdHospedaje());
            imagen.setIdHospedaje(hospedaje);
            imagen.setImagen(nombreImagen);
            imagenHospedajeDAO.guardar(imagen);
            //guardamos en disco el archivo imagen
            fileManagerLogica.guardarArchivo(entrada.getImagen(), nombreImagen);
            
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            salida.setObject(TransformacionDozer.transformar(imagen, ImagenHospedajeDTO.class));
            
            
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
    
    public MensajeDTO eliminar(ImagenHospedajeDTO entrada){
        MensajeDTO salida = new MensajeDTO();
        
        try {
            ImagenHospedaje imagen = imagenHospedajeDAO.findbyID(entrada.getIdImagenHospedaje());
            //eliminamos en disco el archivo imagen
            fileManagerLogica.borrarArchivo(imagen.getImagen());
            imagenHospedajeDAO.delete(imagen);
            salida.setCodigo(ConstantesComunes.CodigoResultado.OK.name());
            
        } catch (Exception e) {
            salida.setCodigo(ConstantesComunes.CodigoResultado.ERROR.name());
            salida.setMensaje(e.getLocalizedMessage());
        }
        
        return salida;
    }
    
}
