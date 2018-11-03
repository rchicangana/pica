/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.clienteredisservices.test;

import co.com.touresbalon.clienteredisservices.api.ClienteRedisService;
import co.com.touresbalon.clienteredisservices.dto.ListDTO;
import co.com.touresbalon.clienteredisservices.dto.MensajeValorDTO;
import co.com.touresbalon.clienteredisservices.exceptions.ErrorConsultaException;
import co.com.touresbalon.clienteredisservices.logica.ClienteRedisServiceBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rchic
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ClienteRedisService cliente = getClienteRedisService();
        //putKV(cliente);
        //getKV(cliente);
        //putList(cliente);
        //getList(cliente);
        removeList(cliente);

    }

    public static ClienteRedisService getClienteRedisService() throws Exception {
        // Llamado del servicio        
        final ClienteRedisServiceBuilder builder = new ClienteRedisServiceBuilder();
        final ClienteRedisService clienteValImp = builder
                .servidor("10.39.1.140")
                .puerto(8080)
                .build();
        return clienteValImp;
    }

    public static void putKV(ClienteRedisService cliente) throws ErrorConsultaException {
        System.out.println("Creando clave TEST");
        cliente.putKV("TEST", "VALOR");
    }

    public static void getKV(ClienteRedisService cliente) throws ErrorConsultaException {
        System.out.println("consultando clave TEST");
        MensajeValorDTO salida = cliente.getKV("TEST");
        System.out.println("Saliuda----->" + salida.getValor());
    }

    public static void putList(ClienteRedisService cliente) throws ErrorConsultaException {
        System.out.println("registrando lista nueva clave TEST");
        List<String> lista = new ArrayList<>();
        lista.add("Ricardo");
        lista.add("Johan");
        lista.add("Juan");
        lista.add("Diego");
        lista.add("Frank");
        boolean salida = cliente.putList("Integrantes", lista);
        System.out.println("Salida----->" + salida);
    }

    public static void getList(ClienteRedisService cliente) throws ErrorConsultaException {
        System.out.println("consultando Lista Integrantes");
        ListDTO salida = cliente.getList("Integrantes", 0, 5);
        for (String dato : salida.getDatos()) {
            System.out.println("Salida----->" + dato);
        }
    }

    public static void removeList(ClienteRedisService cliente) throws ErrorConsultaException {
        System.out.println("removiendo Lista Integrantes");
        boolean salida = cliente.removeList("Integrantes");
        System.out.println("Salida----->" + salida);

    }

}
