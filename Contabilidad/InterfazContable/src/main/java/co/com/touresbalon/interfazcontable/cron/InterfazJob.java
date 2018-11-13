/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.interfazcontable.cron;

import co.com.touresbalon.interfazcontable.logica.InterfazContableLogica;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class InterfazJob {
    
    @EJB
    private InterfazContableLogica interfazContableLogica;
    
    @Schedule(dayOfWeek = "*", hour = "0", minute = "1", second = "0")
    public void generar(){
        SimpleDateFormat formateador = new SimpleDateFormat("ddMMyyyy");
        interfazContableLogica.generarInterfaz(formateador.format(new Date()));
    }
    
}
