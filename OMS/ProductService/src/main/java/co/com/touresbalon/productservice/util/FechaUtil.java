/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.productservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ccepeda
 * @version 27-04-2015
 */
public final class FechaUtil {

    private final static Logger LOGGER
            = Logger.getLogger(FechaUtil.class.getName());

    /**
     * La constante FORMATO_FECHA.
     */
    private static final String FORMATO_FECHA = "dd/MM/yyyy";

    /**
     * La constante MENSAJE_ERROR.
     */
    private static final String MENSAJE_ERROR = "Error al castear la fecha";

    /**
     * Constructor.
     */
    private FechaUtil() {
    }

    /**
     * Función que permite formatear una fecha en texto claro. Ejemplo
     * 06/01/2016 a 06 de Enero de 2016
     *
     * @param fecha Fecha a convertir
     * @return Fecha en texto claro
     */
    public static String obtenerFechaEnTexto(final Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaSistemaSolicitud = formateador.format(fecha);
        return fechaSistemaSolicitud;
    }

    /**
     * Función que permite comparar dos fechas en formato string dd/MM/yyyy.
     *
     * @param fecha1 Fecha Uno
     * @param fecha2 Fecha Dos
     * @return Resultado comparación
     */
    public static String compararFechasString(
            final String fecha1,
            final String fecha2) {
        String resultado = "";
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate1 = formateador.parse(fecha1);
            Date fechaDate2 = formateador.parse(fecha2);

            LOGGER.info("Parametro Date Fecha 1 = " + fechaDate1 + "\n"
                    + "Parametro Date fechaActual = " + fechaDate2 + "\n");

            if (fechaDate1.before(fechaDate2)) {
                resultado = "La Fecha 1 es menor ";
            } else {
                if (fechaDate2.before(fechaDate1)) {
                    resultado = "La Fecha 1 es Mayor ";
                } else {
                    resultado = "Las Fechas Son iguales ";
                }
            }
        } catch (ParseException e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return resultado;
    }

    /**
     * Función que permite comparar dos fechas.
     *
     * @param fechaDate1 Fecha 1
     * @param fechaDate2 Fecha 2
     * @return (-1) si la fecha 1 es menor, (1) si la fecha 1 es mayor, (0) si
     * ambas fechas son iguales.
     */
    public static int compararFechasDate(
            Date fechaDate1,
            Date fechaDate2) {
        int resultado;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(fechaDate1);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MILLISECOND, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(fechaDate2);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MILLISECOND, 0);

        Date f1 = c1.getTime();
        Date f2 = c2.getTime();

        if (f1.before(f2)) {
            LOGGER.info(">>> La Fecha 1 es Menor ");
            resultado = -1;
        } else {
            if (f2.before(f1)) {
                LOGGER.info(">>> La Fecha 1 es Mayor ");
                resultado = 1;
            } else {
                LOGGER.info(">>> Las Fechas Son iguales ");
                resultado = 0;
            }
        }
        return resultado;
    }

    /**
     * Función que permite sumarle dias a la fecha.
     *
     * @param date Fecha a modificar.
     * @param numDias Dias a sumar.
     * @return Date modificado.
     */
    public static Date sumarDiasAFecha(
            final Date date,
            final int numDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, numDias);
        return cal.getTime();
    }
    
    /**
     * 
     * @param date
     * @param numAnios
     * @return 
     */
    public static Date sumarAniosAFecha(
            final Date date,
            final int numAnios) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, numAnios);
        return cal.getTime();
    }

    /**
     * Función que permite sumarle dias a la fecha.
     *
     * @param date Fecha a modificar.
     * @param numDias Dias a sumar.
     * @return Date modificado.
     */
    public static Date restarDiasAFecha(
            final Date date,
            final int numDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, -numDias);
        return cal.getTime();
    }

    /**
     * Función que permite obtener la diferencia en dias de dos fechas.
     *
     * @param fechaMayor Fecha mayor
     * @param fechaMenor Fecha menor
     * @return int, Diferencia en dias
     */
    public static int diferenciaDeDosFechasEnDias(
            final Date fechaMayor,
            final Date fechaMenor) {
        long diferenciaEn_ms
                = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    /**
     * Función que permite sumarle horas a la fecha.
     *
     * @param date Fecha a modificar.
     * @param horas Horas a sumar.
     * @return Date modificado.
     */
    public static Date sumarHorasFecha(
            final Date date,
            final int horas) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, horas);
        return cal.getTime();
    }

    public static Date stringToDate(final String fecha, final String formato) {
        Date fechaDate = null;
        try {
            final SimpleDateFormat formatoFecha = new SimpleDateFormat(formato, Locale.getDefault());
            fechaDate = formatoFecha.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(FechaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaDate;
    }

    /**
     * Función que sirve para castear un string a Date 12/31/2014 to 31/12/2014.
     *
     * @param fecha String que contiene la fecha.
     * @return Date
     */
    public static Date convertStringToDate(final String fecha) {
        String fechaP = fecha.replaceAll("/", "");
        String mes = fechaP.substring(0, 2);
        String dia = fechaP.substring(2, 4);
        String anio = fechaP.substring(4, 8);
        StringBuilder fechaF = new StringBuilder();
        fechaF.append(dia).append("/").append(mes).append("/").append(anio);
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA, Locale.ROOT);
        Date date = null;
        try {
            date = formatter.parse(fechaF.toString());
        } catch (ParseException e) {
            Logger.getLogger(FechaUtil.class.getName())
                    .log(Level.INFO, MENSAJE_ERROR);
        }
        return date;
    }
}
