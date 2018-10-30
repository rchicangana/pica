/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.cron;

import co.com.touresbalon.productservice.logica.JobsLogica;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author rchic
 */
@Stateless
public class TopFiveJob {
    
    @EJB
    private JobsLogica jobsLogica;
    
    @Schedule(dayOfWeek = "*", hour = "0", minute = "30", second = "0")
    public void CalularTopFive(){
        jobsLogica.crearTop();
    }
    
}
