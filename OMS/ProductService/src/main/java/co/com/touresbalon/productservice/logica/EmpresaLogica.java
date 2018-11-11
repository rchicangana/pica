/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.productservice.dao.EmpresaDAO;
import co.com.touresbalon.productservice.dto.EmpresaDTO;
import co.com.touresbalon.productservice.util.TransformacionDozer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class EmpresaLogica {
    
    @EJB
    private EmpresaDAO empresaDAO;
    
    public List<EmpresaDTO> consultar(){
        return TransformacionDozer.transformar(empresaDAO.findAll(), EmpresaDTO.class);
    }
    
}
