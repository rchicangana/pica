/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.comun.ConstantesComunes;
import co.com.touresbalon.productservice.dao.ConstantesDAO;
import co.com.touresbalon.productservice.entidades.Constantes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rchicangana
 */
@Stateless
public class FileManagerLogica {
    
    @EJB
    private ConstantesDAO constantesDAO;
    
    public void guardarArchivo(String b64File, String nombreArchivo){
        
        FileOutputStream osf = null;
        try {
            Constantes path = constantesDAO.findById(ConstantesComunes.CONSTANTE_PATH_IMAGES);
            File file = new File(path+nombreArchivo);
            byte[] imgBytes = Base64.decodeBase64(b64File);
            osf = new FileOutputStream(file);
            osf.write(imgBytes);
            osf.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagerLogica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagerLogica.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                osf.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManagerLogica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void borrarArchivo(String nombreArchivo){
        
        FileOutputStream osf = null;
        Constantes path = constantesDAO.findById(ConstantesComunes.CONSTANTE_PATH_IMAGES);
        File file = new File(path+nombreArchivo);
        file.delete();
        
    }
    
}
