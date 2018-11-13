/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.interfazcontable.logica;

import co.com.touresbalon.interfazcontable.dao.ConstantesDAO;
import co.com.touresbalon.interfazcontable.dao.NativasDAO;
import co.com.touresbalon.interfazcontable.dto.InfoDTO;
import co.com.touresbalon.interfazcontable.entidades.Constantes;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class InterfazContableLogica {
    
    @EJB
    private NativasDAO nativasDAO;
    
    @EJB
    private ConstantesDAO constantesDAO;
    
    private static final String SEPARADOR=",";
    
    @Asynchronous
    public void generarInterfaz(String fecha){
        
        Constantes constante = constantesDAO.findById("PATH_CONTABLE");
        List<InfoDTO> info = nativasDAO.consultarInfo(fecha);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(constante.getValor()+"contabilidad"+fecha+".txt");
            pw = new PrintWriter(fichero);
            for (InfoDTO infoDTO : info) {
                    pw.println(infoDTO.getIdProdcuto()+SEPARADOR+
                               infoDTO.getNombre()+SEPARADOR+
                               infoDTO.getNroOrden()+SEPARADOR+
                               infoDTO.getNroSolicitud()+SEPARADOR+
                               infoDTO.getFecha()+SEPARADOR+
                               infoDTO.getValor()
                    );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
        
}
