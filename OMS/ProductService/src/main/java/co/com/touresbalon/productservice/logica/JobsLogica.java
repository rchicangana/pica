/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.logica;

import co.com.touresbalon.clienteredisservices.api.ClienteRedisService;
import co.com.touresbalon.clienteredisservices.logica.ClienteRedisServiceBuilder;
import co.com.touresbalon.productservice.dao.NativeDAO;
import co.com.touresbalon.productservice.dto.TopFiveDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class JobsLogica {
    
    @EJB
    private NativeDAO nativeDAO;
    
    private static final Logger LOG = Logger.getLogger(JobsLogica.class.getName());
    
    @Asynchronous
    public void crearTop(){
        try {
            Gson g = new Gson();
            final ClienteRedisServiceBuilder builder = new ClienteRedisServiceBuilder();
            ClienteRedisService cliente = builder.servidor("localhost").puerto(8080).build();
            cliente.removeList("TOPFIVE");
            List<TopFiveDTO> tops = nativeDAO.consultarTopFive();
            List<String> datosTop = new ArrayList<>();
            tops.forEach((top) -> {
                datosTop.add(g.toJson(top));
            });
            cliente.putList("TOPFIVE", datosTop);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al llenar top five",e);
        }
    }
    
    
}
