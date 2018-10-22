/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.clienteredisservices.logica;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import co.com.touresbalon.clienteredisservices.api.ClienteRedisService;
import co.com.touresbalon.clienteredisservices.dto.ListDTO;
import co.com.touresbalon.clienteredisservices.dto.MensajeValorDTO;
import co.com.touresbalon.clienteredisservices.exceptions.ErrorConsultaException;
import co.com.touresbalon.clienteredisservices.util.JsonBodyManager;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author rchic
 */
public class ClienteRedisServiceImpl implements ClienteRedisService {

    private final static Logger LOG = Logger.getLogger(ClienteRedisServiceImpl.class.getName());
    private final Client client;
    private final WebTarget target;
    private static final String URL_BASE_KV = "/kv";
    private static final String URL_BASE_LISTAS = "/listas";

    public ClienteRedisServiceImpl(final String url, final int port, final String contexo) {

        HostnameVerifier hv = (String hostname, SSLSession session) -> true;

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException ex) {
            Logger.getLogger(ClienteRedisServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        client = ClientBuilder.newBuilder().hostnameVerifier(hv).sslContext(sc).build();
        //client = ClientBuilder.newClient();

        //Descomentar esta lineas para realizar las pruebas
        client.register(JsonBodyManager.class);//Comentariar esta linea antes de la integación y eliminar clase JsonBodyManager
        if (port == 443) {
            target = client.target("https://" + url + ":" + port + "/" + contexo + "/");
        } else {
            target = client.target("http://" + url + ":" + port + "/" + contexo + "/");
        }
    }

    @Override
    public boolean putKV(String key, String value) throws ErrorConsultaException {
        try {
            final Invocation.Builder requestBuilder = target.path(URL_BASE_KV + "/" + key).request();
            MensajeValorDTO mensajeValorDTO = new MensajeValorDTO();
            mensajeValorDTO.setValor(value);
            final Response resp = requestBuilder.post(Entity.json(mensajeValorDTO));
            resp.readEntity(String.class);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al crear llave valor ", e);
            return false;
        }

    }

    @Override
    public MensajeValorDTO getKV(String key) throws ErrorConsultaException {
        try {
            Gson g = new Gson();
            final Invocation.Builder requestBuilder = target.path(URL_BASE_KV + "/" + key).request();
            final Response resp = requestBuilder.get();
            String response = resp.readEntity(String.class);
            return g.fromJson(response, MensajeValorDTO.class);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar klave valor ", e);
            return null;
        }
    }

    @Override
    public boolean putList(String listName, List<String> data) throws ErrorConsultaException {
        try {
            final Invocation.Builder requestBuilder = target.path(URL_BASE_LISTAS + "/" + listName).request();
            ListDTO lista = new ListDTO();
            lista.setDatos(data);
            final Response resp = requestBuilder.post(Entity.json(lista));
            resp.readEntity(String.class);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al crear lista ", e);
            return false;
        }
    }

    @Override
    public ListDTO getList(String listName, int firstResult, int lastResult) throws ErrorConsultaException {
        try {
            Gson g = new Gson();
            final Invocation.Builder requestBuilder = target.path(URL_BASE_LISTAS + "/" + listName+"/"+firstResult+"/"+lastResult).request();
            final Response resp = requestBuilder.get();
            String response = resp.readEntity(String.class);
            return g.fromJson(response, ListDTO.class);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar lista ", e);
            return null;
        }
    }

    @Override
    public boolean removeList(String listName) throws ErrorConsultaException {
        try {
            Gson g = new Gson();
            final Invocation.Builder requestBuilder = target.path(URL_BASE_LISTAS + "/" + listName).request();
            final Response resp = requestBuilder.delete();
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al borrar lista ", e);
            return false;
        }
    }

}
