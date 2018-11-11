/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toures.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author rchic
 */
public class FechasUtil {
    
    private static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss";
    
     public static Date convertStringToDate(final String fecha) {
        String fechaP = fecha.replaceAll("/", "");
        fechaP = fechaP.replaceAll(" ", "");
        fechaP = fechaP.replaceAll(":", "");
        String mes = fechaP.substring(0, 2);
        String dia = fechaP.substring(2, 4);
        String anio = fechaP.substring(4, 8);
        String hora = fechaP.substring(8, 10);
        String min = fechaP.substring(10,12);
        String seg = fechaP.substring(12,14);
        StringBuilder fechaF = new StringBuilder();
        fechaF.append(dia).append("/").append(mes).append("/").append(anio).append(" ").append(hora).append(":").append(min).append(":").append(seg);
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA, Locale.ROOT);
        Date date = null;
        try {
            date = formatter.parse(fechaF.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
     
    public static String dateToString (Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA, Locale.ROOT);
        return formatter.format(fecha);
    } 
    
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
        }
        return xmlCalendar;
    }
  
    /*
     * Converts XMLGregorianCalendar to java.util.Date in Java
     */
    public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


}
